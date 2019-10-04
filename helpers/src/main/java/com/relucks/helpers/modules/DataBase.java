package com.relucks.helpers.modules;

import androidx.room.Dao;
import androidx.room.Database;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.RoomDatabase;
import androidx.room.Update;

import com.google.gson.Gson;

@Database(entities = {SaveDataModel.class}, version = 1)
public abstract class DataBase extends RoomDatabase {

    public abstract SaveDataDao mSaveDataDao();

    public void writeObject(String key, Object object) {
        SaveDataModel saveData = new SaveDataModel();
        saveData.setDataKey(key);
        saveData.setValue(new Gson().toJson(object));
        mSaveDataDao().insert(saveData);
    }

    public <T> T readObject(String key, Class<T> type) {
        return new Gson().fromJson(mSaveDataDao().getSaveData(key).getValue(), type);
    }

    @Dao
    public interface SaveDataDao {

        @Insert(onConflict = OnConflictStrategy.REPLACE)
        void insert(SaveDataModel saveData);

        @Update()
        void update(SaveDataModel saveData);

        @Query("DELETE FROM SaveDataModel")
        void deleteAll();

        @Query("SELECT * from SaveDataModel where dataKey = :dataKey")
        SaveDataModel getSaveData(String dataKey);
    }
}