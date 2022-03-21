package com.test.architecturedemo.di

import com.test.architecturedemo.data.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    @Provides
    fun provideAnalyticsService(
        // Potential dependencies of this type
    ): ApiService {
        return Retrofit.Builder()
            .baseUrl("https://example.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }
}