package com.base64bitmapcache.xdf.base64bitmapcache;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.base64bitmapcache.xdf.base64bitmapcachelib.ImageCacheManager;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //显示图片
        //new ImageCacheManager().disPlay(iv,url);
    }
}
