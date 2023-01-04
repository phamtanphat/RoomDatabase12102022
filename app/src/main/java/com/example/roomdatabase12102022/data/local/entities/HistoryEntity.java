package com.example.roomdatabase12102022.data.local.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

/**
 * Created by pphat on 1/4/2023.
 */

@Entity(tableName = "history",
        foreignKeys = {
            @ForeignKey(
                entity = UserEntity.class,
                parentColumns = "id",
                childColumns = "id_users",
                onDelete = ForeignKey.CASCADE
            )
        })
public class HistoryEntity {

    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo(name = "id_users")
    private int[] idUser;
    private long time;
    private String searchText;

    public HistoryEntity(int[] idUser, long time, String searchText) {
        this.idUser = idUser;
        this.time = time;
        this.searchText = searchText;
    }

    @Ignore
    public HistoryEntity() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int[] getIdUser() {
        return idUser;
    }

    public void setIdUser(int[] idUser) {
        this.idUser = idUser;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public String getSearchText() {
        return searchText;
    }

    public void setSearchText(String searchText) {
        this.searchText = searchText;
    }
}
