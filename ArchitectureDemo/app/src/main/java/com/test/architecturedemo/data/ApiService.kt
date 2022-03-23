package com.test.architecturedemo.data

import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("search/repositories")
    fun getCall() : Call<String>
}