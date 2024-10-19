package com.example.myapplication

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters
import androidx.work.workDataOf


class DemoWorker(appContext: Context, workerParams: WorkerParameters) : Worker(appContext, workerParams) {

    override fun doWork(): Result {

        if(runAttemptCount > 3){
            return Result.failure()
        }

        val data = inputData
        val number = data.getInt("Number" , 0)
        val name = data.getString("name")

        for(i in 0.. number) {
            Log.i("MyWorker", "Work is being executed $name $i")
        }

        if(number == 0 ){
            return Result.failure(workDataOf("error" to "Number is 0"))
        }
        else {
            return Result.success(workDataOf("result" to "Success"))
        }
    }
}