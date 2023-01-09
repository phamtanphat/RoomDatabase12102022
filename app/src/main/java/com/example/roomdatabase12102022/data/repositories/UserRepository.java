package com.example.roomdatabase12102022.data.repositories;

import android.content.Context;

import com.example.roomdatabase12102022.data.local.UserDatabase;
import com.example.roomdatabase12102022.data.local.dao.UserDao;
import com.example.roomdatabase12102022.data.local.entities.UserEntity;

import java.util.List;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;

/**
 * Created by pphat on 1/6/2023.
 */
public class UserRepository {
    private UserDao userDao;

    public UserRepository(Context context) {
        userDao = UserDatabase.getInstance(context).userDao();
    }

    public Observable<List<UserEntity>> getUsers() {
        return userDao.getUsers();
    }

    public Single<Long> addUser(UserEntity user) {
        return userDao.insertUser(user);
    }

    public Single<Integer> deleteUser(int id) {
        return userDao.deleteUser(id);
    }
}
