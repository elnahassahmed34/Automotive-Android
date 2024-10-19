package com.example.myapplication

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.work.Data
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager
import androidx.work.workDataOf
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val dataobj = workDataOf(
            Pair("Number" , 5),
            "name" to "Nahas"
        )

        val dataobj2 = Data.Builder().putString("name" , "Nahas").build()

        val request = OneTimeWorkRequestBuilder<DemoWorker>()
            .setInitialDelay(1 , TimeUnit.MINUTES)
            .setInputData(dataobj)
            //.setBackoffCriteria()
            .build()

        val request2 = OneTimeWorkRequestBuilder<DemoWorker>().build()

        WorkManager.getInstance(this).beginWith(request).then(request2).enqueue()

        val periodicRequest = PeriodicWorkRequestBuilder<DemoWorker>(15, TimeUnit.MINUTES).build()

        WorkManager.getInstance(this).enqueue(request)
    }
}