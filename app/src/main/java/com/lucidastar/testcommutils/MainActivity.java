package com.lucidastar.testcommutils;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.mine.lucidastarutils.log.KLog;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        KLog.i("测试一下");
    }
}
