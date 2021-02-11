package com.android.mvipattern.di

import com.android.mvipattern.network.ApiService
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object RetrofitModule {

    @Provides
    @Singleton
    fun provideGsonBuilder(): Gson = GsonBuilder().excludeFieldsWithoutExposeAnnotation().create()


    @Provides
    @Singleton
    fun provideRetrofit(gson: Gson): Retrofit.Builder {
        return Retrofit.Builder().baseUrl("https:/open-api.xyz/placeholder/").addConverterFactory(
            GsonConverterFactory.create(gson))
    }

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit.Builder):ApiService=retrofit.build().create(ApiService::class.java)


}