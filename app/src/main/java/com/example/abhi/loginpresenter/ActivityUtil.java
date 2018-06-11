package com.example.abhi.loginpresenter;

import android.content.Context;
import android.content.Intent;

class ActivityUtil {
    private Context context;

    public ActivityUtil(Context context) {
        this.context = context;
    }

    public void startMainActivity() {
        context.startActivity(new Intent(context, MainActivity.class));
    }
}
