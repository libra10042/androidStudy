package com.example.roomdatabaseexample;

import androidx.room.Database;
import androidx.room.RoomDatabase;
// 변경사항을 관리하기 위해서는 version을 써야 한다.
@Database(entities = {User.class}, version = 1)
public abstract class UserDatabase extends RoomDatabase {

    public abstract UserDao userDao();

}
