package com.example.testapplockapi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONArrayRequestListener;
import com.androidnetworking.interfaces.JSONObjectRequestListener;

import org.json.JSONArray;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AndroidNetworking.post("http://192.168.1.37:3003/getThemes/getThemeAppLock")
                .addHeaders("Content-Type", "application/x-www-form-urlencoded")
                .addBodyParameter("pageNumberCurrent", "3")
                .setPriority(Priority.LOW)
                .build()
                .getAsJSONObject(new JSONObjectRequestListener() {
                    @Override
                    public void onResponse(JSONObject response) {
                        // do anything with response
                        Log.i("TinhNv", "onResponse: " + response.toString());
                    }

                    @Override
                    public void onError(ANError error) {
                        // handle error
                        Log.i("TinhNv", "onResponse: " + error.toString());
                    }
                });
    }
}