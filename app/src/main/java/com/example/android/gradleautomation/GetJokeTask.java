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
    private final Listener mListener;

    /**
     * Interface definition for a callback it will be invoked when jokes are loaded.
     */
    interface Listener {
        void onJokeLoaded(String joke);
    }

    public GetJokeTask(Listener listener) {
        mListener = listener;
    }


    @Override
    protected String doInBackground(Void... params) {
        return null;
    }
}

