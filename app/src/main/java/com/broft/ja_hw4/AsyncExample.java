package com.broft.ja_hw4;

import android.os.AsyncTask;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Kevin on 2015-07-20.
 */
public class AsyncExample extends AsyncTask<Void, Void, String>{

    /// 작업수행전에 처리하는 부분을 작성하는 부분
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }
    /// 작업수행후에 처리하는 부분을 작성하는 부분
    @Override
    protected void onPostExecute(String string) {
        super.onPostExecute(string);
        if(onAsycCallback!=null) {
            onAsycCallback.OnCompleted(string);
        }

    }
    /// 작업수행도중에 처리하는 부분을 작성하는 부분
    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected String doInBackground(Void... params) {
        HttpClient http = new DefaultHttpClient();
        String result = "NoResponse";
        try {
            HttpParams httpParams = http.getParams();
            HttpConnectionParams.setConnectionTimeout(httpParams, 3500);
            HttpConnectionParams.setSoTimeout(httpParams, 3500);

            ArrayList<NameValuePair> nameValuePairs =
                    new ArrayList<NameValuePair>();
            HttpPost httpPost = new HttpPost( "http://azure-yj.cloudapp.net:5555/test");
            UrlEncodedFormEntity entityRequest = new UrlEncodedFormEntity(nameValuePairs, "EUC-KR");
            httpPost.setEntity(entityRequest);
            HttpResponse responsePost = http.execute(httpPost);
            HttpEntity resEntity = responsePost.getEntity();
            result = EntityUtils.toString(resEntity);
//            result = getContent(responsePost);
            return result;
        } catch (ClientProtocolException e) {
            e.printStackTrace();
            result ="ClientProtocolException";
            return result;
        } catch (IOException e) {
            e.printStackTrace();
            result ="IOException";
            return result;
        }
    }

    private OnAsycCallback onAsycCallback;

    public interface OnAsycCallback {
        void OnCompleted(String result);
    }

    public void setOnAsycCallback(OnAsycCallback onAsycCallback) {
        this.onAsycCallback = onAsycCallback;
    }


}
