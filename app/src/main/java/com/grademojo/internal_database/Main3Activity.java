package com.grademojo.internal_database;

import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Main3Activity extends AppCompatActivity {

    private Button button;
    private TextView textView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

       button = (Button) findViewById(R.id.getSystemInfo);

        textView = (TextView) findViewById(R.id.info_display);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                textView.setText("serial" + Build.SERIAL+ "\n"+
                        "model" + Build.MODEL+"\n"+

                        "id:" + Build.ID +"\n"+
                        "manufactures" + Build.MANUFACTURER +"\n"+
                        "brand" + Build.BRAND +"\n"+
                        "type" +Build.TYPE+"\n"+
                        "user" + Build.USER+"\n"+
                        "base" + Build.VERSION_CODES.BASE +"\n"+
                        "incremental" + Build.VERSION.INCREMENTAL+"\n"+
                        "sdk" + Build.VERSION.SDK+"\n"+
                        "board" +Build.BOARD +"\n"+
                        "brand" + Build.BRAND+"\n"+
                        "host"  + Build.HOST+"\n"+
                        "fingerprint" + Build.FINGERPRINT+"\n"+
                        "version code" + Build.VERSION.RELEASE

                );


            }
        });



    }
}
