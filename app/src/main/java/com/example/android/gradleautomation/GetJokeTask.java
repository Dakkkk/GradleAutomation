package com.example.android.gradleautomation;

import android.os.AsyncTask;
import android.util.Log;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.mobileallin.android.gradleautomation.jokes_supply.myApi.MyApi;

import java.io.IOException;

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
        if (myApiService == null) {
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    // options for running against local devappserver
                    // - 10.0.2.2 is localhost's IP address in Android emulator
                    // - turn off compression when running against local devappserver
                    .setRootUrl("http://10.0.2.2:8080/_ah/api/")
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?>
                                                       abstractGoogleClientRequest)
                                throws IOException {
                            abstractGoogleClientRequest.setDisableGZipContent(true);
                        }
                    });
            myApiService = builder.build();
        }
        try {
            return myApiService.tellRandomJoke().execute().getJokesData();
        } catch (IOException e) {
            Log.e(LOG_TAG, e.getMessage(), e);
            return "";
        }
    }
}

