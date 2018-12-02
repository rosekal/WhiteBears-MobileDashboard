package com.midterm.rose.whitebears_capstone;

import android.icu.util.Output;
import android.os.AsyncTask;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Rafael on 2018-12-01.
 */

public class HttpCall extends AsyncTask<String, String, String> {

    public AsyncResponse delegate = null;
    private String result;



    @Override
    protected void onPostExecute(String result) {
        delegate.processFinish(result);
    }

    public void requestLogin(String userName, String password){

    }
    public String RequestTasks(String userName) {
        try {
            URL url = new URL("http://whitebears.azurewebsites.net/Dashboard/LoadCompletedTasks");
            String message = "{\"projectId\" : \"_all\", \"username\" : \"" + userName + "\"}";
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("POST");
            urlConnection.setRequestProperty("Content-Type", "application/json");
            urlConnection.setFixedLengthStreamingMode(message.getBytes().length);
            urlConnection.connect();

            OutputStream os = new BufferedOutputStream(urlConnection.getOutputStream());
            os.write(message.getBytes());
            os.flush();
            InputStream is = urlConnection.getInputStream();
            BufferedReader r = new BufferedReader(new InputStreamReader(is));
            StringBuilder total = new StringBuilder();
            for(String line; (line = r.readLine())!=null;){
                total.append(line);
            }
            JSONObject obj = new JSONObject(total.toString());
            JSONArray obj2 = obj.getJSONArray("message");
            return obj2.toString();
        }
        catch (Exception e){
            String a = e.getMessage();
        }
        return null;
    }

    public String RequestLogin(String userName, String password) {
        try {
            URL url = new URL("http://whitebears.azurewebsites.net/Home/Login");
            String message = "{\"username\" : \"" + userName+ "\", \"password\" : \"" + password + "\"}";
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("POST");
            urlConnection.setRequestProperty("Content-Type", "application/json");
            urlConnection.setFixedLengthStreamingMode(message.getBytes().length);
            urlConnection.connect();

            OutputStream os = new BufferedOutputStream(urlConnection.getOutputStream());
            os.write(message.getBytes());
            os.flush();
            InputStream is = urlConnection.getInputStream();
            BufferedReader r = new BufferedReader(new InputStreamReader(is));
            StringBuilder total = new StringBuilder();
            for(String line; (line = r.readLine())!=null;){
                total.append(line);
            }
            return total.toString();
        }
        catch (Exception e){
            String a = e.getMessage();
        }
        return null;
    }

    @Override
    protected String doInBackground(String... strings) {
        if (strings[0].equals("Login")) {
            result = RequestLogin(strings[1], strings[2]);
        } else {
            result =  RequestTasks(strings[1]);
        }
        return result;
    }

    public interface AsyncResponse {
        void processFinish(String output);
    }
}
