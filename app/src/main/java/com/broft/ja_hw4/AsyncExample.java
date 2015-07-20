package com.broft.ja_hw4;

import android.os.AsyncTask;

/**
 * Created by Kevin on 2015-07-20.
 */
public class AsyncExample extends AsyncTask<Void, Void, Integer>{

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected void onPostExecute(Integer integer) {
        super.onPostExecute(integer);
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected Integer doInBackground(Void... params) {
        return null;
    }
}
