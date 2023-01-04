package com.example.roomdatabase12102022.data.local;

import androidx.room.Database;

import com.example.roomdatabase12102022.data.local.entities.HistoryEntity;
import com.example.roomdatabase12102022.data.local.entities.UserEntity;

/**
 * Created by pphat on 1/4/2023.
 */

@Database(entities = {UserEntity.class, HistoryEntity.class}, version = 1, exportSchema = false)
public abstract class UserDatabase {

}
