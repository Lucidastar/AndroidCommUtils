package com.lucidastar.testcommutils;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.LruCache;

import com.mine.lucidastarutils.log.KLog;

import java.util.Map;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        KLog.i("测试一下");
        LruCache<String,String> lruCache = new LruCache<>(4);
        lruCache.put("aa","cshi");
        lruCache.put("bb","cshi");
        lruCache.put("cc","cshi");
        lruCache.put("dd","cshi");
        test(lruCache);
        lruCache.put("ee","ceses");
        test(lruCache);
    }

    private void test(LruCache<String,String> lruCache){
        for (Map.Entry<String,String> map : lruCache.snapshot().entrySet()) {
            KLog.i(map.getKey());
        }
    }

}
