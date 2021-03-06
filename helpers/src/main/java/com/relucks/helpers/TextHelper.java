package com.relucks.helpers;

import android.os.Build;
import android.text.Html;
import android.text.Spanned;

public class TextHelper {

    @SuppressWarnings("deprecation")
    public static Spanned convertHtml(String html) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            return Html.fromHtml(html, Html.FROM_HTML_MODE_COMPACT);
        } else {
            return Html.fromHtml(html);
        }
    }
}
