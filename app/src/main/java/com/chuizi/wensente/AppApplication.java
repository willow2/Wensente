package com.chuizi.wensente;

import android.content.Context;
import android.os.Environment;
import android.support.multidex.MultiDex;

import com.android.core.MainApp;
import com.android.core.control.crash.AndroidCrash;
import com.android.core.control.crash.HttpReportCallback;
import com.android.core.control.logcat.Logcat;
import com.android.core.model.LogicProxy;
import com.chuizi.wensente.util.FileUtils;
import com.chuizi.wensente.util.LocationUtil;
import com.chuizi.wensente.util.StorageUtil;
import com.chuizi.wensente.util.UserUtil;
import com.chuizi.wensente.widget.PicassoImageLoade;
import com.lzy.imagepicker.ImagePicker;
import com.lzy.imagepicker.view.CropImageView;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.cache.CacheEntity;
import com.lzy.okgo.cache.CacheMode;
import com.lzy.okgo.cookie.store.PersistentCookieStore;
import com.lzy.okgo.model.HttpHeaders;
import com.lzy.okgo.model.HttpParams;
import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.cache.memory.impl.LRULimitedMemoryCache;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;
import com.umeng.analytics.MobclickAgent;

import java.io.File;

import cn.jpush.android.api.JPushInterface;


/**
 * author miekoz on 2016/3/17.
 * email  meikoz@126.com
 */
public class AppApplication extends MainApp {

    @Override
    public void onCreate() {
        super.onCreate();


        //Android crash 上传服务器回掉
        HttpReportCallback report = new HttpReportCallback() {
            @Override
            public void uploadException2remote(File file) {
                //可以直接上传文件
            }
        };
        AndroidCrash.getInstance().setCrashReporter(report).init(this);
        if (BuildConfig.DEBUG)
            Logcat.init("com.android.racofix").hideThreadInfo().methodCount(3);

        initokgo();
        ImagePicker();



        // 初始化 极光 SDK
        JPushInterface.setDebugMode(true);
        JPushInterface.init(this);
        UserUtil.inintJiPush(this);

        // 初始化 友盟统计 SDK
        MobclickAgent.setScenarioType(this, MobclickAgent.EScenarioType.E_UM_NORMAL);
        /** 设置是否对日志信息进行加密, 默认false(不加密). */
        MobclickAgent.enableEncrypt(false);//6.0.0版本及以后


        initDir();

        LocationUtil.startBaiduLocation(this);
        LocationUtil.getBaiduLocationResult(this);


    }

    public void initDir() {
        if (StorageUtil.externalMemoryAvailable()) {
            Contents.ROOT_PATH = Environment.getExternalStorageDirectory()
                    .getAbsolutePath() + "/healthJS/";

            Contents.TEMP_PIC_PATH = Contents.ROOT_PATH + "temp_pic/";
            Contents.TEMP_FILE_PATH = Contents.ROOT_PATH + "temp_file/";

        } else {
            Contents.ROOT_PATH = getApplicationContext().getFilesDir()
                    .getAbsolutePath() + "/";

            Contents.TEMP_PIC_PATH = Contents.ROOT_PATH + "temp_pic/";
            Contents.TEMP_FILE_PATH = Contents.ROOT_PATH + "temp_file/";

        }
        FileUtils.createPath(Contents.ROOT_PATH);
        FileUtils.createPath(Contents.TEMP_PIC_PATH);
        FileUtils.createPath(Contents.TEMP_FILE_PATH);

    }


    public void ImagePicker() {
        ImagePicker imagePicker = ImagePicker.getInstance();
        imagePicker.setImageLoader(new PicassoImageLoade());   //设置图片加载器
        imagePicker.setShowCamera(true);  //显示拍照按钮
        imagePicker.setCrop(true);        //允许裁剪（单选才有效）
        imagePicker.setSaveRectangle(true); //是否按矩形区域保存
        imagePicker.setSelectLimit(9);    //选中数量限制
        imagePicker.setStyle(CropImageView.Style.RECTANGLE);  //裁剪框的形状
        imagePicker.setFocusWidth(800);   //裁剪框的宽度。单位像素（圆形自动取宽高最小值）
        imagePicker.setFocusHeight(800);  //裁剪框的高度。单位像素（圆形自动取宽高最小值）
        imagePicker.setOutPutX(1000);//保存文件的宽度。单位像素
        imagePicker.setOutPutY(1000);//保存文件的高度。单位像素

    }

    private void initokgo() {
        HttpHeaders headers = new HttpHeaders();
        headers.put("commonHeaderKey1", "commonHeaderValue1");    //header不支持中文
        headers.put("commonHeaderKey2", "commonHeaderValue2");
        HttpParams params = new HttpParams();
//        params.put("commonParamsKey1", "commonParamsValue1");     //param支持中文,直接传,不要自己编码
//        params.put("commonParamsKey2", "这里支持中文参数");
        //-----------------------------------------------------------------------------------//

        //必须调用初始化
        OkGo.init(this);

        //以下设置的所有参数是全局参数,同样的参数可以在请求的时候再设置一遍,那么对于该请求来讲,请求中的参数会覆盖全局参数
        //好处是全局参数统一,特定请求可以特别定制参数
        try {
            //以下都不是必须的，根据需要自行选择,一般来说只需要 debug,缓存相关,cookie相关的 就可以了
            OkGo.getInstance()

                    //打开该调试开关,控制台会使用 红色error 级别打印log,并不是错误,是为了显眼,不需要就不要加入该行
                    .debug("OkGo")

                    //如果使用默认的 60秒,以下三行也不需要传

                    .setConnectTimeout(60000*10)  //全局的连接超时时间
                    .setReadTimeOut(60000*10)     //全局的读取超时时间
                    .setWriteTimeOut(60000*10)    //全局的写入超时时间

                    //可以全局统一设置缓存模式,默认是不使用缓存,可以不传,具体其他模式看 github 介绍 https://github.com/jeasonlzy/
                    .setCacheMode(CacheMode.NO_CACHE)

                    //可以全局统一设置缓存时间,默认永不过期,具体使用方法看 github 介绍
                    .setCacheTime(CacheEntity.CACHE_NEVER_EXPIRE)

                    //如果不想让框架管理cookie,以下不需要
//                .setCookieStore(new MemoryCookieStore())                //cookie使用内存缓存（app退出后，cookie消失）
                    .setCookieStore(new PersistentCookieStore())          //cookie持久化存储，如果cookie不过期，则一直有效

                    //可以设置https的证书,以下几种方案根据需要自己设置,不需要不用设置
//                    .setCertificates()                                  //方法一：信任所有证书
//                    .setCertificates(getAssets().open("srca.cer"))      //方法二：也可以自己设置https证书
//                    .setCertificates(getAssets().open("aaaa.bks"), "123456", getAssets().open("srca.cer"))//方法三：传入bks证书,密码,和cer证书,支持双向加密

                    //可以添加全局拦截器,不会用的千万不要传,错误写法直接导致任何回调不执行
//                .addInterceptor(new Interceptor() {
//                    @Override
//                    public Response intercept(Chain chain) throws IOException {
//                        return chain.proceed(chain.request());
//                    }
//                })

                    //这两行同上,不需要就不要传
                    .addCommonHeaders(headers)                                         //设置全局公共头
                    .addCommonParams(params);                                          //设置全局公共参数
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 视频初始化
     * @param context
     */
    public static void initImageLoader(Context context) {
        int memoryCacheSize = (int) (Runtime.getRuntime().maxMemory() / 10);
        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(context)
                .memoryCache(new LRULimitedMemoryCache(memoryCacheSize))
                .diskCacheFileNameGenerator(new Md5FileNameGenerator())
                .tasksProcessingOrder(QueueProcessingType.LIFO)
                .build();
        // Initialize ImageLoader with configuration.
        ImageLoader.getInstance().init(config);
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }


}
