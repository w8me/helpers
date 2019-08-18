package com.relucks.helpers;

import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.widget.EditText;

import androidx.core.content.ContextCompat;

import java.util.Objects;
import java.util.regex.Pattern;


public class Verifier {

    private static final Pattern EMAIL = Pattern.compile(
            "[a-zA-Z0-9+._%-+]{1,256}" +
                    "@" +
                    "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
                    "(" +
                    "\\." +
                    "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +
                    ")+"
    );

    public static boolean checksEmail(EditText email, int idError) {
        Drawable icon = ContextCompat.getDrawable(email.getContext(), idError);
        icon.setBounds(new Rect(0, 0, Objects.requireNonNull(icon).getIntrinsicWidth(), icon.getIntrinsicHeight()));
        if (EMAIL.matcher(email.getText().toString().trim()).matches()) {
            email.setError(null, null);
            return true;
        } else {
            email.requestFocus();
            email.setError(email.getResources().getString(idError), icon);
            return false;
        }
    }

    public static boolean checksPasswordLength(EditText password, int length, int idError) {
        Drawable icon = ContextCompat.getDrawable(password.getContext(), idError);
        icon.setBounds(new Rect(0, 0, Objects.requireNonNull(icon).getIntrinsicWidth(), icon.getIntrinsicHeight()));
        if (password.getText().toString().length() >= length) {
            password.setError(null, null);
            return true;
        } else {
            password.requestFocus();
            password.setError(password.getResources().getString(idError), icon);
            return false;
        }
    }

    public static boolean checksPasswordsMatch(EditText passwordOne, EditText passwordTwo, int idError) {
        Drawable icon = ContextCompat.getDrawable(passwordTwo.getContext(), idError);
        icon.setBounds(new Rect(0, 0, Objects.requireNonNull(icon).getIntrinsicWidth(), icon.getIntrinsicHeight()));
        if (passwordOne.getText().toString().equals(passwordTwo.getText().toString())) {
            passwordTwo.setError(null, null);
            return true;
        } else {
            passwordTwo.requestFocus();
            passwordTwo.setError(passwordTwo.getResources().getString(idError), icon);
            return false;
        }
    }
}
