package com.chuizi.wensente.util;

/**
 * ================================================
 * 作    者：jeasonlzy（廖子尧）
 * 版    本：1.0
 * 创建日期：2016/4/6
 * 描    述：我的Github地址  https://github.com/jeasonlzy0216
 * 修订历史：
 * ================================================
 */
public class Urls {
    //106.14.41.63:8080
    //114.55.4.234
    //public static String HOST = "114.55.4.234";//主要
       public static String HOST = "47.94.17.244";//主要
    //	public static String HOST = "192.168.1.122";//主要

    public static final String PORT = "";
//    public static final String PORT = ":8080";
    public static final String SERVICENAME = "jkdw";


    // 1.获取公共参数接口
    public static final String GET_PARAM = "http://" + HOST + PORT + "/"
            + SERVICENAME + "/" + "system/phone/syssysparam/list/json";
    // 2.app配置接口
    public static final String APP_PARAM = "http://" + HOST + PORT + "/"
            + SERVICENAME + "/" + "system/configuration/list/json";
    //1.获取验证码接口
    public static final String URL_GETRANDOM = "http://" + HOST + PORT + "/"
            + SERVICENAME + "/" + "system/phone/sms/getCode/json";
    // 8.找回密码接口
    public static final String FORGET_PWD = "http://" + HOST + PORT + "/"
            + SERVICENAME + "/" + "system/phone/technician/selectPassword/json";
    //10 意见反馈
    public static final String SAVE_FEEDBACK = "http://" + HOST + PORT + "/"
            + SERVICENAME + "/" + "system/phone/feedback/update/json";
    // 11.	获取开通城市列表
    public static final String GET_CITY = "http://" + HOST + PORT + "/"
            + SERVICENAME + "/" + "system/phone/city/openList/json";
    //12.	轮播图列表
    public static final String HOME_LUNBO = "http://" + HOST + PORT + "/"
            + SERVICENAME + "/" + "system/phone/lunbopic/list/json";
    //13.	所有分类列表
    public static final String GET_CATEGORY_ALL = "http://" + HOST + PORT + "/"
            + SERVICENAME + "/" + "system/phone/category/listAll/json";
    //14.商品列表接口
    public static final String GET_GOODS_LIST = "http://" + HOST + PORT + "/"
            + SERVICENAME + "/" + "system/phone/good/list/json";
    //21.注册接口
    public static final String REGISTER = "http://" + HOST + PORT + "/"
            + SERVICENAME + "/" + "system/phone/technician/register/json";
    // 22.获取技师详情接口
    public static final String USER_INFO = "http://" + HOST + PORT + "/"
            + SERVICENAME + "/" + "system/phone/technician/look/json";
    //查看个人资料接口
    public static final String APPUSER_INFO = "http://" + HOST + PORT + "/"
            + SERVICENAME + "/" + "system/phone/appuser/look/json";

    //23.登录接口
    public static final String LOGIN = "http://" + HOST + PORT + "/"
            + SERVICENAME + "/" + "system/phone/technician/login/json";
    //23.上传资料
    public static final String CHECK = "http://" + HOST + PORT + "/"
            + SERVICENAME + "/" + "system/phone/technician/check/json";
    // 4.修改资料接口
    public static final String USER_UPDATE = "http://" + HOST + PORT + "/"
            + SERVICENAME + "/" + "system/phone/technician/update/json";
    // 发布优惠券
    public static final String COUPON_UPDATE = "http://" + HOST + PORT + "/"
            + SERVICENAME + "/" + "system/phone/coupon/update/json";

    // 发布商品
    public static final String GOOD_UPDATE = "http://" + HOST + PORT + "/"
            + SERVICENAME + "/" + "system/phone/good/update/json";

    // 修改手机号绑定原手机接口
    public static final String UPDATE_PHONE_OLD = "http://" + HOST + PORT + "/"
            + SERVICENAME + "/" + "system/phone/technician/selectPhone/json";

    // 13.修改手机号填写新手机号接口
    public static final String UPDATE_PHONE_NEW = "http://" + HOST + PORT + "/"
            + SERVICENAME + "/" + "system/phone/technician/updatePhone/json";
    //商品详情
    public static final String GET_GOODS_DETAILS = "http://" + HOST + PORT + "/"
            + SERVICENAME + "/" + "system/phone/good/look/json";

    //评价列表
    public static final String GET_COMMENT_LIST = "http://" + HOST + PORT + "/"
            + SERVICENAME + "/" + "system/phone/comment/list/json";

    //优惠券列表  GET_WORK_TIME
    public static final String GET_COUPON_LIST = "http://" + HOST + PORT + "/"
            + SERVICENAME + "/" + "system/phone/coupon/getlist/json";

    //获取下班时间列表
    public static final String GET_WORK_TIME = "http://" + HOST + PORT + "/"
            + SERVICENAME + "/" + "system/phone/tecwork/list/json";

    //设置上下班日期
    public static final String UPDATE_WORK_TIME = "http://" + HOST + PORT + "/"
            + SERVICENAME + "/" + "system/phone/tecwork/update/json";

    //获取订单列表
    public static final String GET_ORDER_LIST = "http://" + HOST + PORT + "/"
            + SERVICENAME + "/" + "system/phone/order/list/json";
    //获取订单详情
    public static final String GET_ORDER = "http://" + HOST + PORT + "/"
            + SERVICENAME + "/" + "system/phone/order/look/json";

    //自由抢单订单列表接口
    public static final String FREELIST = "http://" + HOST + PORT + "/"
            + SERVICENAME + "/" + "system/phone/order/freeList/json";

    //获取系统时间
    public static final String GET_TIME = "http://" + HOST + PORT + "/"
            + SERVICENAME + "/" +  "system/phone/appuser/getTime/json";

    //邀请分红金额排行
    public static final String GET_AWARD_RANK_LIST = "http://" + HOST + PORT + "/"
            + SERVICENAME + "/" + "system/phone/place/countMoney/json";

    //人物排行
    public static final String GET_PERSOMAGE_RANK_LIST = "http://" + HOST + PORT + "/"
            + SERVICENAME + "/" + "system/phone/place/countPeo/json";

    // 资金记录
    public static final String MONEY_DETAIL = "http://" + HOST + PORT + "/"
            + SERVICENAME + "/" + "system/phone/moneydetail/list/json";

    //提现接口
    public static final String MONEY_SAVE = "http://" + HOST + PORT + "/"
            + SERVICENAME + "/" + "system/phone/withdraw/save/json";

    //订单操作
    public static final String OPERATE_ORDER = "http://" + HOST + PORT + "/"
            + SERVICENAME + "/" + "system/phone/order/order/json";

    //退款订单列表接口
    public static final String RETURNLIST = "http://" + HOST + PORT + "/"
            + SERVICENAME + "/" + "system/phone/order/returnlist/json";

    //订单退款按钮接口
    public static final String REMOVEORDER = "http://" + HOST + PORT + "/"
            + SERVICENAME + "/" + "system/phone/order/return/json";

    //技师审核退款按钮接口
    public static final String TECRETURN = "http://" + HOST + PORT + "/"
            + SERVICENAME + "/" + "system/phone/order/tecReturn/json";

    //技师投标接口
    public static final String UPDATEBID = "http://" + HOST + PORT + "/"
            + SERVICENAME + "/" + "system/phone/tecorder/update/json";

    //删除商品
    public static final String DELETEGOOD = "http://" + HOST + PORT + "/"
            + SERVICENAME + "/" + "system/phone/good/delete/json";

    //系统下拉单列表接口
    public static final String SYSTEMTYPE = "http://" + HOST + PORT + "/"
            + SERVICENAME + "/" + "system/phone/systemtype/list/json";

    //消息列表
    public static final String GET_MY_MSG_LIST = "http://" + HOST + PORT + "/"
            + SERVICENAME + "/" + "system/phone/message/list/json";
    //删除消息
    public static final String DEL_MESS = "http://" + HOST + PORT + "/"
            + SERVICENAME + "/" + "/system/phone/message/delete/json";





















    // 7.第三方登录接口
    public static final String LOGIN_UMENG = "http://" + HOST + PORT + "/"
            + SERVICENAME + "/" + "system/appuser/loginS/json";




    // 38.提现接口
    public static final String WITH_DRAW = "http://" + HOST + PORT + "/"
            + SERVICENAME + "/" + "system/withdraw/update/json";
    // 38.绑定手机号接口
    public static final String BIND_PHONE = "http://" + HOST + PORT + "/"
            + SERVICENAME + "/" + "system/appuser/bindphone/json";
// 28.发布/修改海报红包
    public static final String PUBLISH_POSTER = "http://" + HOST + PORT + "/"
            + SERVICENAME + "/" + "system/posterpackage/update/json";
// 29.发布/修改视频红包
    public static final String PUBLISH_VEDIO = "http://" + HOST + PORT + "/"
            + SERVICENAME + "/" + "system/mediapackage/update/json";
// 30.发布/修改卡券红包
    public static final String PUBLISH_CARD = "http://" + HOST + PORT + "/"
            + SERVICENAME + "/" + "system/card/update/json";
// 39.余额支付接口
    public static final String PAY = "http://" + HOST + PORT + "/"
            + SERVICENAME + "/" + "system/appuser/pay/json";
// .微信回调接口
    public static final String PAY_WX_PAY = "http://" + HOST + PORT + "/"
            + SERVICENAME + "/" + "system/wx/getwx/json";
// 4支付宝回调接口
    public static final String PAY_ZFB_PAY = "http://" + HOST + PORT + "/"
            + SERVICENAME + "/" + "system/zfb/getzfb/json";
// 49.银行卡列表接口
    public static final String BANK_LIST = "http://" + HOST + PORT + "/"
            + SERVICENAME + "/" + "system/bank/list/json";

// 48.个人统计接口
    public static final String PERSON_CENTER_NUMBER = "http://" + HOST + PORT + "/"
            + SERVICENAME + "/" + "system/appuser/statics/json";
// 51.用户购买的卡券列表
    public static final String BUY_CARD_LIST = "http://" + HOST + PORT + "/"
            + SERVICENAME + "/" + "system/usercard/list/json";
// 51.用户购买的卡券列表
    public static final String CARD_DUIHUAN = "http://" + HOST + PORT + "/"
            + SERVICENAME + "/" + "system/card/changeCardjson/json";
// 51.获取系统时间
    public static final String SYS_TIME = "http://" + HOST + PORT + "/"
            + SERVICENAME + "/" + "system/appuser/getTime/json";


    // 2.	上传
    public static final String SAVE_IMG = "http://" + HOST + PORT + "/"
            + SERVICENAME + "/" + "fileupload";
    // 21.省市接口wml
    public static final String GET_AREA = "http://" + HOST + PORT + "/"
            + SERVICENAME + "/" + "system/city/getArea/json";


    //4.	海报列表
    public static final String GET_POSTER_LIST = "http://" + HOST + PORT + "/"
            + SERVICENAME + "/" + "system/posterpackage/list/json";
    //5.	海报详情
    public static final String GET_POSTER_DETAILS = "http://" + HOST + PORT + "/"
            + SERVICENAME + "/" + "system/posterpackage/look/json";
    //6.	视频列表
    public static final String GET_VIDEO_LIST = "http://" + HOST + PORT + "/"
            + SERVICENAME + "/" + "system/mediapackage/list/json";

    //7.	是否收藏
    public static final String IS_COLLECT = "http://" + HOST + PORT + "/"
            + SERVICENAME + "/" + "system/collect/coll/json";
    //8.	收藏
    public static final String USER_COLLECT = "http://" + HOST + PORT + "/"
            + SERVICENAME + "/" + "system/collect/update/json";

    //9	卡券列表
    public static final String GET_CARDVOLUME_LIST = "http://" + HOST + PORT + "/"
            + SERVICENAME + "/" + "system/card/list/json";
    //10	卡券详情
    public static final String GET_CARDVOLUME_DETAILS = "http://" + HOST + PORT + "/"
            + SERVICENAME + "/" + "system/card/look/json";

    //11	海报详情
    public static final String GET_VIDEO_DETAILS = "http://" + HOST + PORT + "/"
            + SERVICENAME + "/" + "system/mediapackage/look/json";

    //12 关注列表
    public static final String GET_MY_ATTENTION_LIST = "http://" + HOST + PORT + "/"
            + SERVICENAME + "/" + "system/attention/list/json";

    //13.	是否关注
    public static final String IS_ATTENTION = "http://" + HOST + PORT + "/"
            + SERVICENAME + "/" + "system/attention/atten/json";
    //14.	关注
    public static final String USER_ATTENTION = "http://" + HOST + PORT + "/"
            + SERVICENAME + "/" + "system/attention/update/json";

    //15 收藏列表
    public static final String GET_MY_COLLECT_LIST = "http://" + HOST + PORT + "/"
            + SERVICENAME + "/" + "system/collect/list/json";

    //16 所有勋章列表
    public static final String GET_ALL_MEDAL_LIST = "http://" + HOST + PORT + "/"
            + SERVICENAME + "/" + "system/medal/all/json";

    //17 收藏数量统计
    public static final String GET_COLLECT_COUNT = "http://" + HOST + PORT + "/"
            + SERVICENAME + "/" + "system/collect/statics/json";

    //18 申请勋章
    public static final String APPLY_MEDAL = "http://" + HOST + PORT + "/"
            + SERVICENAME + "/" + "system/applymedal/update/json";

    //19 发布数量统计
    public static final String GET_PUBLISH_COUNT = "http://" + HOST + PORT + "/"
            + SERVICENAME + "/" + "system/appuser/publish/json";





    //22 修改密码
    public static final String USER_ALTER_PWD = "http://" + HOST + PORT + "/"
            + SERVICENAME + "/" + "system/appuser/changepwd/json";



    // 24.	兑换卡券
    public static final String EXCHANGE_CARD = "http://" + HOST + PORT + "/"
            + SERVICENAME + "/" + "system/card/payCard/json";

    // 25.	抢红包统计
    public static final String QIANG_PACKAGE_COUNT = "http://" + HOST + PORT + "/"
            + SERVICENAME + "/" + "system/moneydetail/statics/json";

    // 26.	抢红包列表
    public static final String QIANG_PACKAGE_LIST= "http://" + HOST + PORT + "/"
            + SERVICENAME + "/" + "system/moneydetail/list/json";

    //27.	抢海报红包
    public static final String GET_POSTER_PACKAGE = "http://" + HOST + PORT + "/"
            + SERVICENAME + "/" + "system/posterpackage/snatch/json";

    // 28.	抢红包列表
    public static final String EXCHANGE_CARD_LIST= "http://" + HOST + PORT + "/"
            + SERVICENAME + "/" + "system/moneydetail/listuser/json";

    //29.	抢视频红包
    public static final String GET_VIDEO_PACKAGE = "http://" + HOST + PORT + "/"
            + SERVICENAME + "/" + "system/mediapackage/snatch/json";

    //30.	消息置为已读
    public static final String SET_READ_MSG = "http://" + HOST + PORT + "/"
            + SERVICENAME + "/" + "system/message/updatestatus/json";
    //30.	消息置为已读


    //31.	分享
    public static final String USER_FX = "http://" + HOST + PORT + "/"
            + SERVICENAME + "/" + "system/share/update/json";


//    //-----------------------------------------------------------------------------------
//    public static final String SERVER = "http://server.jeasonlzy.com/OkHttpUtils/";
//    //    public static final String SERVER = "http://192.168.1.121:8080/OkHttpUtils/";
//    public static final String URL_METHOD = SERVER + "method";
//    public static final String URL_CACHE = SERVER + "cache";
//    public static final String URL_IMAGE = SERVER + "image";
//    public static final String URL_JSONOBJECT = SERVER + "jsonObject";
//    public static final String URL_JSONARRAY = SERVER + "jsonArray";
//    public static final String URL_FORM_UPLOAD = SERVER + "upload";
//    public static final String URL_TEXT_UPLOAD = SERVER + "uploadString";
//    public static final String URL_DOWNLOAD = SERVER + "download";
//    public static final String URL_REDIRECT = SERVER + "redirect";

//    public static final String NEWS = "http://114.55.4.234/dingke/phone/uploadImage/uploadImage_saveImages.action";
    public static final String APIKEY = "593e074aa96b18276fbe1aec8992f398";



}
