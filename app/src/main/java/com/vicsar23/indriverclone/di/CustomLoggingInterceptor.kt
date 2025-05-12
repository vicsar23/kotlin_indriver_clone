package com.vicsar23.indriverclone.di

import android.util.Log
import okhttp3.Interceptor
import okhttp3.Response
import okio.Buffer
import java.nio.charset.Charset

class CustomLoggingInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val requestBody = request.body
        val buffer = Buffer()
        requestBody?.writeTo(buffer)
        val charset = requestBody?.contentType()?.charset(Charset.forName("UTF-8")) ?: Charset.forName("UTF-8")
        val requestBodyString = buffer.readString(charset)

        val t1 = System.nanoTime()
        Log.i("API_LOG", "\nAPI: ${request.url}")
        Log.i("API_LOG", "Type: ${request.method}")
        Log.i("API_LOG", "Request: $requestBodyString")

        val response = chain.proceed(request)
        val t2 = System.nanoTime()

        val responseBody = response.peekBody(1024 * 1024)
        Log.i("API_LOG", "Status Code: ${response.code}")
        Log.i("API_LOG", "Response: ${responseBody.string()}")
        Log.i("API_LOG", "Time: ${(t2 - t1) / 1e6} ms\n")

        return response
    }
}
