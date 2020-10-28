package com.example.jobschedulerdemo;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.util.Log;
import android.widget.Toast;

public class MJobScheduler extends JobService {
    private MJobExecuter mJobExecuter;
    @Override
    public boolean onStartJob(JobParameters params) {
        Log.d("check", "onStartJob: ");
        mJobExecuter=new MJobExecuter()
        {
            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                Toast.makeText(MJobScheduler.this,s, Toast.LENGTH_SHORT).show();
                Log.d("check", "onPostExecute: ");
                jobFinished(params,false);
                Log.d("check", "AfteronPostExecute: ");
            }
        };

        mJobExecuter.execute();
        return true;
    }

    @Override
    public boolean onStopJob(JobParameters params) {
        Log.d("check", "onStopJob: ");
        mJobExecuter.cancel(true);
        return false;
    }
}
