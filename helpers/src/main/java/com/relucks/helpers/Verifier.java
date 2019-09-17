package com.relucks.helpers;

import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.widget.EditText;
import android.widget.TextView;

import androidx.core.content.ContextCompat;

import java.util.Objects;
import java.util.regex.Pattern;

public class Verifier {

    private static final Pattern EMAIL = Pattern.compile("[a-zA-Z0-9+._%\\-]{1,256}@[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}(\\.[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25})+");

    public static boolean checksEmail(TextView email, int idError) {
        if (EMAIL.matcher(email.getText().toString().trim()).matches()) {
            email.setError(null, null);
            return true;
        } else {
            showError(email, idError);
            return false;
        }
    }

    public static boolean checksPasswordLength(TextView password, int length, int idError) {
        if (password.getText().toString().length() >= length) {
            password.setError(null, null);
            return true;
        } else {
            showError(password, idError);
            return false;
        }
    }

    public static boolean checksPasswordsMatch(TextView passwordOne, EditText passwordTwo, int idError) {
        if (passwordOne.getText().toString().equals(passwordTwo.getText().toString())) {
            passwordTwo.setError(null, null);
            return true;
        } else {
            passwordTwo.requestFocus();
            showError(passwordTwo, idError);
            return false;
        }
    }

    public static void showError(TextView view, int idError) {
        showError(view, view.getContext().getString(idError));
    }

    public static void showError(TextView view, String error) {
        Drawable icon = ContextCompat.getDrawable(view.getContext(), R.drawable.error);
        icon.setBounds(new Rect(0, 0, Objects.requireNonNull(icon).getIntrinsicWidth(), icon.getIntrinsicHeight()));
        view.requestFocus();
        view.setError(error, icon);
    }
}
