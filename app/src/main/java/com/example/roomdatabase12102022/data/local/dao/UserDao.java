package com.example.roomdatabase12102022.data.local.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.roomdatabase12102022.data.local.entities.UserEntity;

import java.util.List;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;

/**
 * Created by pphat on 1/4/2023.
 */

@Dao
public interface UserDao {
    @Query("SELECT * FROM user")
    Observable<List<UserEntity>> getUsers();

    @Insert(entity = UserEntity.class, onConflict = OnConflictStrategy.REPLACE)
    Single<Long> insertUser(UserEntity user);

    @Query("DELETE FROM user WHERE id = :id")
    Single<Integer> deleteUser(int id);
}
