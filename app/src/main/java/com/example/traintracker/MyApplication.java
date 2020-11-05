package com.example.traintracker;

import android.app.Activity;
import android.app.Application;
import android.content.Context;

/**
 * Created by Arafat on 18/03/2017.
 */

public class MyApplication extends Application {
    public void onCreate() {
        super.onCreate();
    }
    private  Context mContext;

    public  Context getContext() {
        return mContext;
    }

    public  void setContext(Context mContext) {
        this.mContext = mContext;
    }
    private Activity mCurrentActivity = null;

    public Activity getCurrentActivity() {
        return mCurrentActivity;
    }

    public void setCurrentActivity(Activity mCurrentActivity) {
        this.mCurrentActivity = mCurrentActivity;
    }
}