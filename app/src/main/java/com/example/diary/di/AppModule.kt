package com.example.diary.di

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent




@Module
@InstallIn(ApplicationComponent::class)
class AppModule {

    @Provides
    fun provideGson(): Gson = GsonBuilder().create()

}