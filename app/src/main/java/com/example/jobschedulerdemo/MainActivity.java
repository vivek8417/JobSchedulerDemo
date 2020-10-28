package com.example.jobschedulerdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public static final int JOB_ID=101;
    private JobInfo jobInfo;
    private JobScheduler jobScheduler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

      /*  ComponentName componentName=new ComponentName(this,MJobScheduler.class);
        JobInfo.Builder builder=new JobInfo.Builder(JOB_ID,componentName);
        builder.setPeriodic(5000);
        builder.setRequiredNetworkType(JobInfo.NETWORK_TYPE_ANY);
        builder.setPersisted(true);

        jobInfo=builder.build();
        jobScheduler= (JobScheduler) getSystemService(JOB_SCHEDULER_SERVICE);*/
        Log.d("check", "onCreate: ");

    }

    public void scheduleJob(View view) {
        Log.d("check", "scheduleJob: ");
        ComponentName componentName=new ComponentName(this,MJobScheduler.class);
        JobInfo.Builder builder=new JobInfo.Builder(JOB_ID,componentName);
        builder.setMinimumLatency(1000);
        builder.setRequiredNetworkType(JobInfo.NETWORK_TYPE_ANY);
        builder.setPersisted(true);

        jobInfo=builder.build();
        jobScheduler= (JobScheduler) getSystemService(JOB_SCHEDULER_SERVICE);
        jobScheduler.schedule(jobInfo);
        Log.e("check", "scheduleJob: " );

        Toast.makeText(this, "Job scheduled..", Toast.LENGTH_SHORT).show();
    }

    public void clearJob(View view) {
        jobScheduler= (JobScheduler) getSystemService(JOB_SCHEDULER_SERVICE);
        jobScheduler.cancel(JOB_ID);
        Toast.makeText(this, "Job Cancelled", Toast.LENGTH_SHORT).show();
    }
}