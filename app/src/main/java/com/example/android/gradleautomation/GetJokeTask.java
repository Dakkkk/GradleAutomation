package com.example.android.gradleautomation;

import android.os.AsyncTask;

import com.mobileallin.android.gradleautomation.jokes_supply.myApi.MyApi;

/**
 * Created by Dawid on 2017-06-04.
 */

public class GetJokeTask extends AsyncTask<Void, Void, String> {

    @SuppressWarnings("unused")
    public static String LOG_TAG = GetJokeTask.class.getSimpleName();
    private static MyApi myApiService = null;


    @Override
    protected String doInBackground(Void... params) {
        return null;
    }
}

