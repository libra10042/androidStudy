package com.example.qrcodeexample_java;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

public class ScanQR extends AppCompatActivity {
    private IntentIntegrator qrScan;
    private EditText editText;
    private Button button;
    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scan_q_r);

        new IntentIntegrator(this).initiateScan();

        // JS를 사용할 수 있도록 한다.

        qrScan = new IntentIntegrator(this);
        qrScan.setOrientationLocked(true); // default가 세로모드인데 휴대폰 방향에 따라 가로, 세로로 자동 변경됩니다.
        qrScan.setPrompt("QR코드를 사각형 안에 넣어주세요.");
        qrScan.initiateScan();


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if(result != null) {
            if(result.getContents() == null) {
                Toast.makeText(this, "Cancelled", Toast.LENGTH_LONG).show();
                Log.e("this", "잘못된 QR 코드입니다.");
                // todo
            } else {
                Toast.makeText(this, "Scanned: " + result.getContents(), Toast.LENGTH_LONG).show();
                // todo
                Log.e("this", result.getContents().toString());
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data);
            Log.e("this", "### 정상 실행 ###");
        }
    }





}