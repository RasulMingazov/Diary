package com.example.diary.di

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Scope




@Module
@InstallIn(ApplicationComponent::class)
class AppModule {

    @Provides
    fun provideGson(): Gson = GsonBuilder().create()
//
//    @Provides
//    fun provideJsonDataSource() = JsonDataSource
//
//    @Singleton
//    @Provides
//    fun provideRepository(jsonDataSource: JsonDataSource
//                       ) =
//        DealRepository(jsonDataSource)


//    @Singleton
//    @Provides
//    fun provideJsonService(db: JsonDataSource) = db.jsonService()
//
//    @Singleton
//    @Provides
//    fun provideRepository(jsonDataSource: JsonDataSource) = DealRepository(jsonDataSource)

//}


//    @Provides
//    fun provideCharacterService(retrofit: Retrofit): DealService = retrofit.create(DealService::class.java)
//
//    @Singleton
//    @Provides
//    fun provideCharacterRemoteDataSource(characterService: DealService) = DealJsonDataSource(characterService)
//
//    @Singleton
//    @Provides
//    fun provideDatabase(@ApplicationContext appContext: Context) = AppDatabase.getDatabase(appContext)
//
//    @Singleton
//    @Provides
//    fun provideCharacterDao(db: AppDatabase) = db.DealDao()
//
//    @Singleton
//    @Provides
//    fun provideRepository(remoteDataSource: DealJsonDataSource,
//                          localDataSource: DealDao) =
//        DealRepository(remoteDataSource, localDataSource)
//}
//
}