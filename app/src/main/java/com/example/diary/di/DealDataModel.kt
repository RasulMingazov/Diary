package com.example.diary.di

import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module(includes = [DealDataModel.BindModule::class])
class DealDataModel {
    @Provides
    @WeatherDataScope
    @Named("Test.json")
    fun provideJsonPath(): String = "Test.json"

    @Module
    interface BindModule {
        @Binds
        fun bindRepository(repository: WeatherRepositoryImpl): WeatherRepository
    }
}