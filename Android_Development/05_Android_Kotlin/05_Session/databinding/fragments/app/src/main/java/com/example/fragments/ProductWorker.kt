package com.example.fragments

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters
import androidx.work.workDataOf
import com.google.gson.Gson
import retrofit2.HttpException
import java.io.IOException


class ProductWorker(context: Context, workerParams: WorkerParameters) : Worker(context, workerParams) {

    override fun doWork(): Result {
        return try {

            val response = RetrofitClient.api.getProducts().execute()

            if (response.isSuccessful) {
                // Pass the product data back to the main thread
                val products = response.body()?.products ?: emptyList()
                val productsJson = Gson().toJson(products)

                // Save data in the result for later processing
                val outputData = workDataOf("products_data" to productsJson)
                Result.success(outputData)
            } else {
                Result.failure()
            }
        } catch (e: HttpException) {
            Result.failure()
        } catch (e: IOException) {
            Result.failure()
        }
    }
}
