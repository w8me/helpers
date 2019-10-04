package com.relucks.helpers.modules;

import android.content.Context;
import android.preference.PreferenceManager;

import androidx.annotation.NonNull;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

public class Storage {

    private Context context;

    Storage(Context context) {
        this.context = context;
    }

    public void writeString(String key, String value) {
        PreferenceManager.getDefaultSharedPreferences(context).edit().putString(key, value).apply();
    }

    public String readString(String key) {
        return PreferenceManager.getDefaultSharedPreferences(context).getString(key, "");
    }

    public void writeBoolean(String key, Boolean value) {
        PreferenceManager.getDefaultSharedPreferences(context).edit().putBoolean(key, value).apply();
    }

    public Boolean readBoolean(String key) {
        return PreferenceManager.getDefaultSharedPreferences(context).getBoolean(key, false);
    }

    public void writeLong(String key, Long value) {
        PreferenceManager.getDefaultSharedPreferences(context).edit().putLong(key, value).apply();
    }

    public void remove(String key) {
        PreferenceManager.getDefaultSharedPreferences(context).edit().remove(key).apply();
    }

    public long readLong(String key) {
        return PreferenceManager.getDefaultSharedPreferences(context).getLong(key, 0);
    }

    public void writeInteger(String key, Integer value) {
        PreferenceManager.getDefaultSharedPreferences(context).edit().putInt(key, value).apply();
    }

    public Integer readInteger(String key) {
        return PreferenceManager.getDefaultSharedPreferences(context).getInt(key, 0);
    }

    public void writeFloat(String key, Float value) {
        PreferenceManager.getDefaultSharedPreferences(context).edit().putFloat(key, value).apply();
    }

    public Float readFloat(String key) {
        return PreferenceManager.getDefaultSharedPreferences(context).getFloat(key, 0);
    }

    public void writeObject(String key, Object object) {
        PreferenceManager.getDefaultSharedPreferences(context).edit().putString(key, new Gson().toJson(object)).apply();
    }

    public <T> T readObject(String key, Class<T> type) {
        return new Gson().fromJson(PreferenceManager.getDefaultSharedPreferences(context).getString(key, ""), type);
    }


    public void writeList(String key, Object object, Type type) {
        PreferenceManager.getDefaultSharedPreferences(context).edit().putString(key, new Gson().toJson(object, type)).apply();
    }

    public <T> T readList(String key, Type type) {
        return new Gson().fromJson(PreferenceManager.getDefaultSharedPreferences(context).getString(key, ""), type);
    }

    public void clearData() {
        PreferenceManager.getDefaultSharedPreferences(context).edit().clear().apply();
    }

    public <T> List<T> readList(String key, Class<T> type) {
        return new Gson().fromJson(PreferenceManager.getDefaultSharedPreferences(context).getString(key, ""), new ListOfSomething<>(type));
    }

    public <T> void writeList(String key, List<T> object, Class<T> type) {
        PreferenceManager.getDefaultSharedPreferences(context).edit().putString(key, new Gson().toJson(object, new TypeToken<List<T>>() {
        }.getType())).apply();
    }

    class ListOfSomething<X> implements ParameterizedType {

        private Class<?> wrapped;

        ListOfSomething(Class<X> wrapped) {
            this.wrapped = wrapped;
        }

        @NonNull
        public Type[] getActualTypeArguments() {
            return new Type[]{wrapped};
        }

        @NonNull
        public Type getRawType() {
            return List.class;
        }

        public Type getOwnerType() {
            return null;
        }
    }
}