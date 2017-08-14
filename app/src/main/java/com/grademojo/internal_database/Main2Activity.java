package com.grademojo.internal_database;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class Main2Activity extends AppCompatActivity {

    private EditText editText_file_name , editText_text_data;
    private Button save_Button ,read_Button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        editText_file_name = (EditText) findViewById(R.id.editText1);
        editText_text_data = (EditText) findViewById(R.id.editText2);

        save_Button = (Button) findViewById(R.id.button1);
        read_Button = (Button) findViewById(R.id.button2);

        save_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String filename = editText_file_name.getText().toString();
                String data = editText_text_data.getText().toString();

                FileOutputStream fileOutputStream;


                try {

                    File file = new File("/sdcard"+filename);

                    file.createNewFile();

                    fileOutputStream = new FileOutputStream(file);

                    OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream);

                    outputStreamWriter.append(data);
                    outputStreamWriter.close();
                    fileOutputStream.close();


                    Toast.makeText(getApplicationContext(),filename+ "saved", Toast.LENGTH_SHORT).show();


                }

                catch (Exception e){


                }

            }
        });


        read_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String filename = editText_file_name.getText().toString();
                StringBuffer stringBuffer= new StringBuffer();
                String a_Data_Row = "";
                String a_Buffer = "";



                try {



                    File file = new File("/sdcard"+filename);
                    FileInputStream fileInputStream = new FileInputStream(file);
                    BufferedReader bufferedReader= new BufferedReader(new InputStreamReader(fileInputStream));

                    while ((a_Data_Row = bufferedReader.readLine()) !=null){


                        a_Buffer += a_Data_Row+ "\n";
                    }

                    bufferedReader.close();



                }catch (Exception e){




                }


                Toast.makeText(getApplicationContext(), a_Buffer, Toast.LENGTH_SHORT).show();



            }
        });


    }
}
