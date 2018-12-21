package com.bawei.ws12listdome.view;

import android.graphics.Color;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.bawei.ws12listdome.R;
import com.czp.library.ArcProgress;
import com.czp.library.OnTextCenter;


public class Main2Activity extends AppCompatActivity {

    private ArcProgress bar;
    private Handler mHandler = new Handler(new Handler.Callback(){
        @Override
        public boolean handleMessage(Message msg) {
            ArcProgress progressBar = (ArcProgress)msg.obj;
            progressBar.setProgress(msg.what);
            return true;
        }
    });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        bar = findViewById(R.id.crilebar);

        bar.setOnCenterDraw(new OnTextCenter(Color.BLUE, 30));

        new Thread(new Runnable() {

            @Override
            public void run() {
                for (int i = 0; i <= 100; i++) {
                    //判断结束
                    if (isFinishing()) {
                        break;
                    }
                    //系统时钟 睡 100 毫秒
                    SystemClock.sleep(100);
                    mHandler.sendMessage(mHandler.obtainMessage(i, bar));
                }
            }
        }).start();



    }
}
