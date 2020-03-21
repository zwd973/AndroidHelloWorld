package com.bytedance.helloworld;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private static final String strShow = "Welcome!";
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button bn1 = findViewById(R.id.bn1);
        final SeekBar txSize = findViewById(R.id.txSize);
        final TextView tv1 = findViewById(R.id.tv1);

        tv1.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        bn1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                tv1.setText(strShow);
            }
        });
        txSize.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int newTextSize = seekBar.getProgress();
                tv1.setTextSize((float)(newTextSize / 3.0 * 20));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


        final Button bn2 = findViewById(R.id.bn2);
        final ImageView imgLogo = findViewById(R.id.imgLogo);
        bn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(imgLogo.getVisibility()==View.VISIBLE){
                    imgLogo.setVisibility(View.INVISIBLE);
                    bn2.setText("ShowLogo");
                }else{
                    imgLogo.setVisibility(View.VISIBLE);
                    bn2.setText("CloseLogo");
                }
            }
        });


        Log.d(TAG, "MainActivity");
    }
}
