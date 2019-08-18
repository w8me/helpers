package com.relucks.helpers;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.util.Base64;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class FileHelper {
    public static byte[] getByteFromUri(Uri uri, Context context) {
        try {
            final InputStream inputStream = context.getContentResolver().openInputStream(uri);
            ByteArrayOutputStream byteBuffer = new ByteArrayOutputStream();
            int bufferSize = 1024;
            byte[] buffer = new byte[bufferSize];

            int len;
            if (inputStream == null)
                return new byte[0];
            while ((len = inputStream.read(buffer)) != -1) {
                byteBuffer.write(buffer, 0, len);
            }
            return byteBuffer.toByteArray();
        } catch (Exception e) {
            return new byte[0];
        }
    }

    public static String getBase64FromUri(Uri uri, Context context) {
        try {
            final InputStream inputStream = context.getContentResolver().openInputStream(uri);
            Bitmap bm = BitmapFactory.decodeStream(inputStream);
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            bm.compress(Bitmap.CompressFormat.JPEG, 100, outputStream);
            byte[] b = outputStream.toByteArray();
            return Base64.encodeToString(b, Base64.DEFAULT);
        } catch (FileNotFoundException e) {
            return "";
        }
    }

    public static Bitmap getBitmapFromUri(Uri uri, Context context) {
        try {
            final InputStream inputStream = context.getContentResolver().openInputStream(uri);
            return BitmapFactory.decodeStream(inputStream);
        } catch (FileNotFoundException e) {
            return null;
        }
    }
}
