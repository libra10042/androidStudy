package com.example.intentexample02_java;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SubActivity extends AppCompatActivity {

    private TextView textView1;
    private TextView textView2;
    private TextView textView3;
    private TextView textView4;
    private TextView textView5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);


        textView1 = (TextView)findViewById(R.id.textView1); /*TextView선언*/
        textView2 = (TextView)findViewById(R.id.textView2);
        textView3 = (TextView)findViewById(R.id.textView3);
        textView4 = (TextView)findViewById(R.id.textView4);
        textView5 = (TextView)findViewById(R.id.textView5);

        Intent intent = getIntent(); /*데이터 수신*/

        String name = intent.getExtras().getString("name"); /*String형*/
        textView1.setText(name);

        int age = intent.getExtras().getInt("age"); /*int형*/
        textView2.setText(String.valueOf(age));

        String array[] = intent.getExtras().getStringArray("array"); /*배열*/
        String add_array="";
        for(int i=0;i<array.length;i++){
            add_array+=array[i]+",";
        }
        textView3.setText(add_array);

        Option option = (Option)intent.getSerializableExtra("class"); /*클래스*/
        textView4.setText(option.getPhone());
        textView5.setText(option.getAddr());


    }
}
