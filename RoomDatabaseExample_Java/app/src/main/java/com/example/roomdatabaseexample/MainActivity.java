package com.example.roomdatabaseexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import android.os.Bundle;
import android.util.Log;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private UserDao mUserDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // DB 삽입
        UserDatabase database = Room.databaseBuilder(getApplicationContext(), UserDatabase.class, "roomdatebase_test")
                .fallbackToDestructiveMigration() // 스키마(Database) 버전 변경 가능
                .allowMainThreadQueries() // Main Thread에서 DB에 io(입출력)를 가능하게 함.
                .build();

        mUserDao = database.userDao(); // 인터페이스 객체 할당.
        // 데이터 삽입
//        User user = new User();
//        user.setName("안드로이드");
//        user.setAge("29");
//        user.setPhoneNumber("010123412314");
//
//        mUserDao.setInsertUser(user);



        // 데이터 조회
        List<User> userList = mUserDao.getUserAll();
        for(int i=0; i<userList.size(); i++){
            Log.d("TEST", userList.get(i).getName() +
                    " " + userList.get(i).getAge() +
                    " " + userList.get(i).getPhoneNumber());
        }


        // 데이터 수정
//        User user2 = new User();
//        user2.setId(1);
//        user2.setName("IOS");
//        user2.setAge("3");
//        user2.setPhoneNumber("01033333333");
//        mUserDao.setUpdateUser(user2);

        // 데이터 삭제
        User user3 = new User();
        user3.setId(3);
        mUserDao.setDeleteUser(user3);

    }
}