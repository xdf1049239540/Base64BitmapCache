package com.base64bitmapcache.xdf.base64bitmapcachelib;

/**
 * @author xdf
 * @time 2017/10/9
 */

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.widget.ImageView;

/**
 * 自定义的BImageCacheManager,实现base64图片三级缓存
 */
public class ImageCacheManager {

    private NetCacheUtils mNetCacheUtils;
    private LocalCacheUtils mLocalCacheUtils;
    private MemoryCacheUtils mMemoryCacheUtils;

    public ImageCacheManager(){
        mMemoryCacheUtils=new MemoryCacheUtils();
        mLocalCacheUtils=new LocalCacheUtils();
        mNetCacheUtils=new NetCacheUtils(mLocalCacheUtils,mMemoryCacheUtils);
    }

    public void disPlay(ImageView ivPic, String url) {
        if(TextUtils.isEmpty(url)){
            ivPic.setImageResource(R.drawable.icon_defult_head);
            return;
        }
        ivPic.setImageResource(R.drawable.icon_defult_head);
        Bitmap bitmap;
        //内存缓存
        bitmap=mMemoryCacheUtils.getBitmapFromMemory(url);
        if (bitmap!=null){
            ivPic.setImageBitmap(bitmap);
            System.out.println("从内存获取图片啦.....");
            return;
        }

        //本地缓存
        bitmap = mLocalCacheUtils.getBitmapFromLocal(url);
        if(bitmap !=null){
            ivPic.setImageBitmap(bitmap);
            System.out.println("从本地获取图片啦.....");
            //从本地获取图片后,保存至内存中
            mMemoryCacheUtils.setBitmapToMemory(url,bitmap);
            return;
        }
        //网络缓存
        mNetCacheUtils.getBitmapFromNet(ivPic,url);
    }
}
