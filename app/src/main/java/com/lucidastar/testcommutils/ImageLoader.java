package com.lucidastar.testcommutils;

import android.graphics.Bitmap;
import android.util.LruCache;

/**
 * Created by qiuyouzone on 2018/11/23.
 */

public class ImageLoader {
    private LruCache<String,Bitmap> mLruCache ;
    private static ImageLoader mInstance;

    public ImageLoader() {
        long maxMemory = Runtime.getRuntime().maxMemory();
        int cacheSize = (int) (maxMemory / 8);
        mLruCache = new LruCache<String, Bitmap>(cacheSize){
            @Override
            protected int sizeOf(String key, Bitmap value) {
                return value.getByteCount();
            }
        };
    }

    public static ImageLoader getInstance(){
        if (mInstance == null){
            mInstance = new ImageLoader();
        }
        return mInstance;
    }

    public void addImageToMemory(String key,Bitmap bitmap){
        if (getImageFromMemory(key) == null) {
            mLruCache.put(key, bitmap);
        }
    }

    public Bitmap getImageFromMemory(String key){
        return mLruCache.get(key);
    }

    public void remoteImageFromMemory(String key){
        mLruCache.remove(key);
    }

}
