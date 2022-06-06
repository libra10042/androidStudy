package com.example.intentexample02_java;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    public static final int sub = 1001; // 다른 액티비티 띄우기 위한 요청코드 (상수)

    private Button subBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        subBtn = (Button)findViewById(R.id.btn_sub);

        subBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] array = {"홍길순", "김춘추", "김유신"}; // 송신할 배열
                Option option = new Option("01012313", "의왕"); // 송신할 클래스

                Intent intent = new Intent(getApplicationContext(), SubActivity.class);


                intent.putExtra("name", "홍길동"); //송신
                intent.putExtra("age", 20);
                intent.putExtra("array", array);
                intent.putExtra("class", option);

                startActivity(intent);
            }
        });
    }
}