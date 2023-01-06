package com.example.roomdatabase12102022.data.local.entities;

import androidx.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class HistoryEntityConverter {
    @TypeConverter
    public static String fromString(int[] idUsers) {
        return new Gson().toJson(idUsers);
    }

    @TypeConverter
    public static int[] fromIntArray(String value) {
        return new Gson().fromJson(value, new TypeToken<int[]>() {}.getType());
    }
}
