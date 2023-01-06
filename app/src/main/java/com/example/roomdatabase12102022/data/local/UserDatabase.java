package com.example.roomdatabase12102022.data.local;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.roomdatabase12102022.data.local.dao.UserDAO;
import com.example.roomdatabase12102022.data.local.entities.HistoryEntity;
import com.example.roomdatabase12102022.data.local.entities.UserEntity;

/**
 * Created by pphat on 1/4/2023.
 */

@Database(entities = {UserEntity.class, HistoryEntity.class}, version = 1, exportSchema = false)
public abstract class UserDatabase extends RoomDatabase{
    public abstract UserDAO userDao();
    private static UserDatabase instance;

    public synchronized static UserDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(
              context,
              UserDatabase.class,
              "my-user"
            ).build();
        }
        return instance;
    }
}
