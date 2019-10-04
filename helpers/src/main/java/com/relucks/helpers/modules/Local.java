package com.relucks.helpers.modules;

import android.content.Context;

import androidx.room.Room;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module(includes = {ContextModule.class})
public class Local {

    @Provides
    @Singleton
    DataBase provideDataBase(Context context) {
        return Room.databaseBuilder(context.getApplicationContext(), DataBase.class, "word_database").allowMainThreadQueries().build();
    }

    @Provides
    @Singleton
    Storage provideLocalStorage(Context context) {
        return new Storage(context);
    }
}
