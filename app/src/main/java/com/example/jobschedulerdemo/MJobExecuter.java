package com.example.jobschedulerdemo;

import android.os.AsyncTask;
import android.text.PrecomputedText;
import android.util.Log;

public class MJobExecuter extends AsyncTask<Void,Void,String> {


    @Override
    protected String doInBackground(Void... voids) {

        Log.d("check", "doInBackground: ");
        return "Background long task finishes...";
    }
}
