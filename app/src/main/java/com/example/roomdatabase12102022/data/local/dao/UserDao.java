package com.example.roomdatabase12102022.data.local.dao;

import androidx.room.Dao;
import androidx.room.Query;

import com.example.roomdatabase12102022.data.local.entities.UserEntity;

import java.util.List;

import io.reactivex.rxjava3.core.Observable;

/**
 * Created by pphat on 1/4/2023.
 */

@Dao
public interface UserDao {
    @Query("SELECT * FROM user")
    Observable<List<UserEntity>> getUsers();
}
