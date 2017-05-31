package com.android.core.control;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PixelFormat;
import android.graphics.drawable.Drawable;
import android.view.animation.Animation;
import android.widget.ImageView;

import com.android.core.R;
import com.android.core.widget.glide.GlideCircleCornersTransform;
import com.android.core.widget.glide.GlideCircleTransform;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.GlideDrawableImageViewTarget;

/**
 * @author: 蜡笔小新
 * @date: 2016-06-14 16:02
 * @GitHub: https://github.com/meikoz
 */
public class Glides {

    public static Glides instance = new Glides();

    public Glides() {
    }

    public static Glides getInstance() {
        return instance;
    }


    LoadingReadListener loadingReadListener;
    LoadingFailedListener loadingFailedListener;

    // 加载网络图片
    public void load(Context context, String url, ImageView imageView,int default_img) {
        Glide.with(context)
                .load(url)
                .placeholder(default_img)
                .error(default_img)
                .crossFade()
                .diskCacheStrategy(DiskCacheStrategy.ALL)//缓存全尺寸
                .into(imageView);
    }


    /**
     * 加载圆角网络图片
     * @param context
     * @param url 图片路径
     * @param imageView 控件
     * @param radius 圆角半径
     * @param default_img 默认图片
     */
    public void loadCircularBead(Context context, String url, ImageView imageView,int radius, int default_img) {
        Glide.with(context)
                .load(url)
                .placeholder(default_img)
                .error(default_img)
                .transform(new GlideCircleCornersTransform(context,radius))
                .crossFade()
                .diskCacheStrategy(DiskCacheStrategy.ALL)//缓存全尺寸
                .into(imageView);
    }

    // 加载圆型网络图片
    public void loadCircle(Context context, String url, ImageView imageView) {
        Glide.with(context)
                .load(url)
                .placeholder(R.color.abc_tab_text_normal)
                .error(R.color.abc_tab_text_normal)
                .transform(new GlideCircleTransform(context))
                .crossFade()
                .diskCacheStrategy(DiskCacheStrategy.ALL)//缓存全尺寸
                .into(imageView);
    }





    // 加载圆型网络图片
    public void loadCircle(Context context, String url, ImageView imageView,int default_img) {
        Glide.with(context)
                .load(url)
                .placeholder(default_img)
                .error(default_img)
                .transform(new GlideCircleTransform(context))
                .crossFade()
                .diskCacheStrategy(DiskCacheStrategy.ALL)//缓存全尺寸
                .into(imageView);
    }

    // 加载本地图片
    public void load(Context context, int resid, ImageView imageView) {
        Glide.with(context)
                .load(resid)
                .placeholder(R.color.abc_tab_text_normal)
                .error(R.color.abc_tab_text_normal)
                .crossFade()
                .diskCacheStrategy(DiskCacheStrategy.ALL)//缓存全尺寸
                .into(imageView);
    }

    // 加载圆型本地图片
    public void loadCircle(Context context, int resId, ImageView imageView) {
        Glide.with(context)
                .load(resId)
                .placeholder(R.color.abc_tab_text_normal)
                .error(R.color.abc_tab_text_normal)
                .transform(new GlideCircleTransform(context))
                .crossFade()
                .diskCacheStrategy(DiskCacheStrategy.ALL)//缓存全尺寸
                .into(imageView);
    }
    // 加载网络图片动画
    public void loadAnima(Context context, String url, Animation animation, ImageView imageView,int default_img) {
        Glide.with(context)
                .load(url)
                .placeholder(default_img)
                .error(default_img)
                .animate(animation)
                .crossFade()
                .diskCacheStrategy(DiskCacheStrategy.ALL)//缓存全尺寸
                .into(imageView);
    }

    // 加载网络图片动画
    public void loadAnima(Context context, String url, int animationId, ImageView imageView) {
        Glide.with(context)
                .load(url)
                .placeholder(R.color.abc_tab_text_normal)
                .error(R.color.abc_tab_text_normal)
                .animate(animationId)
                .crossFade()
                .diskCacheStrategy(DiskCacheStrategy.ALL)//缓存全尺寸
                .into(imageView);
    }

    // 加载本地图片动画
    public void loadAnima(Context context, int resId, Animation animation, ImageView imageView) {
        Glide.with(context)
                .load(resId)
                .placeholder(R.color.abc_tab_text_normal)
                .error(R.color.abc_tab_text_normal)
                .animate(animation)
                .crossFade()
                .into(imageView);
    }


    // 加载drawable图片
    public void loadAnima(Context context, int resId, int animationId, ImageView imageView) {
        Glide.with(context)
                .load(resId)
                .placeholder(R.color.abc_tab_text_normal)
                .error(R.color.abc_tab_text_normal)
                .animate(animationId)
                .crossFade()
                .into(imageView);
    }


    // 加载网络图片
    public void load(final Context context, String url, ImageView imageView, int default_img, final LoadingReadListener v) {

        Glide.with(context)
                .load(url)
                .centerCrop()
                .error(default_img)
                .crossFade()
                .into(new GlideDrawableImageViewTarget(imageView) {
                          @Override
                          public void onResourceReady(GlideDrawable drawable, GlideAnimation anim) {
                              super.onResourceReady(drawable, anim);
                              //在这里添加一些图片加载完成的操作

                              if (v != null){
                                  v.onLoadingReadClick(drawableToBitmap(drawable,context));
                              }
                          }
                      }
                    );
    }

    // 加载圆型网络图片
    public void loadCircle(final Context context, String url, ImageView imageView, int default_img, final LoadingReadListener v) {
        Glide.with(context)
                .load(url)
                .placeholder(default_img)
                .error(default_img)
                .transform(new GlideCircleTransform(context))
                .crossFade()
                .into(new GlideDrawableImageViewTarget(imageView) {
                          @Override
                          public void onResourceReady(GlideDrawable drawable, GlideAnimation anim) {
                              super.onResourceReady(drawable, anim);
                              //在这里添加一些图片加载完成的操作

                              if (v != null){
                                  v.onLoadingReadClick(drawableToBitmap(drawable,context));
                              }
                          }
                      }
                );
    }

    // 加载圆型网络图片
    public void loadCircle(final Context context, String url, ImageView imageView, int default_img, final LoadingReadListener v, final LoadingFailedListener f) {
        Glide.with(context)
                .load(url)
                .placeholder(default_img)
                .error(default_img)
                .transform(new GlideCircleTransform(context))
                .crossFade()
                .into(new GlideDrawableImageViewTarget(imageView) {
                          @Override
                          public void onResourceReady(GlideDrawable drawable, GlideAnimation anim) {
                              super.onResourceReady(drawable, anim);
                              //在这里添加一些图片加载完成的操作

                              if (v != null){
                                  v.onLoadingReadClick(drawableToBitmap(drawable,context));
                              }
                          }

                          @Override
                          public void onLoadFailed(Exception e, Drawable errorDrawable) {
                              super.onLoadFailed(e, errorDrawable);

                              if (f != null){
                                  f.onLoadingFailedClick();
                              }

                          }

                      }
                );
    }


    public interface LoadingReadListener {
        public void onLoadingReadClick(Bitmap bitmap);
    }

    public LoadingReadListener getLoadingReadListener() {
        return loadingReadListener;
    }

    public void setLoadingReadListener(LoadingReadListener loadingReadListener) {
        this.loadingReadListener = loadingReadListener;
    }

    public interface LoadingFailedListener {
        public void onLoadingFailedClick();
    }

    public LoadingFailedListener getLoadingFailedListener() {
        return loadingFailedListener;
    }

    public void setLoadingFailedListener(LoadingFailedListener loadingFailedListener) {
        this.loadingFailedListener = loadingFailedListener;
    }

   private Bitmap drawableToBitmap(GlideDrawable drawable,Context context)
    {
        int width = drawable.getIntrinsicWidth();
//        int width = (int)(ScreenUtil.getScreenWidth(context)*1.3f);
//        int height = width;
        int height = drawable.getIntrinsicHeight();

        Bitmap bitmap = Bitmap.createBitmap(width, height,drawable.getOpacity() != PixelFormat.OPAQUE ? Bitmap.Config.ARGB_8888: Bitmap.Config.RGB_565);
        Canvas canvas = new Canvas(bitmap);
        //canvas.drawColor(0xff33B5E5);
        drawable.setBounds(0,0,width,height);
        drawable.draw(canvas);

        return bitmap;
    }
}
