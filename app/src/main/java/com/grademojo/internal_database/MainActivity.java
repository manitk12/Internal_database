package com.grademojo.internal_database;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {

   private EditText editText_File_Name ,editText_Text_data;

    private Button save_Button ,read_Button;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        editText_File_Name = (EditText) findViewById(R.id.editText1);
        editText_Text_data = (EditText) findViewById(R.id.editText2);
        save_Button = (Button) findViewById(R.id.button1);
        read_Button = (Button) findViewById(R.id.button2);


        save_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String file_name = editText_File_Name.getText().toString();
                String data = editText_Text_data.getText().toString();

                FileOutputStream fileOutputStream;

                try{

                    fileOutputStream = openFileOutput(file_name, Context.MODE_PRIVATE);
                    fileOutputStream.write(file_name.getBytes());
                    fileOutputStream.write(data.getBytes());
                    fileOutputStream.close();

                    Toast.makeText(getApplicationContext(),file_name+ "saved", Toast.LENGTH_SHORT).show();

                }
                catch (Exception e)


                {

                    e.printStackTrace();
                }


            }
        });




        read_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String file_name = editText_File_Name.getText().toString();
                String data = editText_Text_data.getText().toString();

                StringBuffer stringBuffer = new StringBuffer();


                try{

                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(openFileInput(file_name)));
                    BufferedReader bufferedReader1= new BufferedReader(new InputStreamReader(openFileInput(data)));

                    String input_String;

                    while ((input_String = bufferedReader.readLine())!=null){

                        stringBuffer.append(input_String+"\n");



                    }

                    while ((input_String = bufferedReader1.readLine())!= null){



                    }



                }

                catch (Exception e){



                }


                Toast.makeText(getApplicationContext(), stringBuffer.toString(), Toast.LENGTH_SHORT).show();


            }
        });



    }
}
