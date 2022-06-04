package com.example.roomdatabaseexample;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

/*
* Data Access Object
*/
@Dao
public interface UserDao {

    @Insert
    void setInsertUser(User user);

    @Update
    void setUpdateUser(User user);

    @Delete
    void setDeleteUser(User user);

    // 조회 쿼리
    @Query("SELECT * FROM User") // 쿼리 : db에 요청하는 명령문
    List<User> getUserAll();

}
