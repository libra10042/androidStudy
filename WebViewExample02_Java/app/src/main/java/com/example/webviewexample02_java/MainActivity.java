package com.example.webviewexample02_java;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText et;
    private WebView wv;
    private Button bt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et = findViewById(R.id.et);
        wv = findViewById(R.id.wv);
        bt = findViewById(R.id.bt);

        WebSettings webSettings = wv.getSettings();

        //자바 스크립트 사용을 할 수 있도록 합니다.
        webSettings.setJavaScriptEnabled(true);


        wv.setWebViewClient(new WebViewClient(){
            //페이지 로딩이 끝나면 호출됩니다.
            @Override
            public void onPageFinished(WebView view,String url){
                Toast.makeText(MainActivity.this,"로딩 끝", Toast.LENGTH_SHORT).show();
            }
        });

        //
        et.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if(actionId == EditorInfo.IME_ACTION_SEARCH){
                    //bt의 onClick을 실행
                    bt.callOnClick();

                    //키보드 숨기기
                    InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(v.getWindowToken(),0);
                    return true;
                }
                return false;
            }
        });

    }

    public void onClick(View view) {
        String address = et.getText().toString();

        //http://를 넣지 않고 웹주소를 입력했을 경우 http://를 추가해줍니다.
        //예를 들어 naver.com을 검색했을때 http://naver.com이 입력되도록 해줍니다.
        if(!address.startsWith("http://")){
            address = "http://" + address;
        }

        //웹뷰 로드
        wv.loadUrl(address);
    }

    @Override
    public void onBackPressed() {
        //뒤로가기 버튼을 눌렀을때 웹뷰가 뒤로가기가 가능하다면 뒤로가기를 해줍니다.
        if(wv.canGoBack()){
            wv.goBack();
        }else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            //뒤로가기가 가능할때 뒤로가기
            case  R.id.action_back:
                if(wv.canGoBack()){
                    wv.goBack();
                }
                return true;

            //앞으로가기가 가능할때 앞으로가기
            case R.id.action_forward:
                if(wv.canGoForward()){
                    wv.goForward();
                }
                return true;

            //새로고침
            case R.id.action_refresh:
                wv.reload();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
}