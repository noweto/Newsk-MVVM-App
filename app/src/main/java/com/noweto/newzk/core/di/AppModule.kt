package com.noweto.newzk.core.di

import android.app.Application
import android.content.Context
import com.noweto.newzk.core.data.local.AppDatabaseBuilder
import com.noweto.newzk.core.data.local.NewsDao
import com.noweto.newzk.core.data.local.NewsLocalDataSource
import com.noweto.newzk.core.data.remote.AppNetworkBuilder
import com.noweto.newzk.core.data.remote.NewsApiServices
import com.noweto.newzk.core.data.remote.NewsRemoteDataSource
import com.noweto.newzk.core.data.repository.NewsRepository
import com.noweto.newzk.core.utils.MainApp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

//~~ For Hilt .. as a dependency Injection


@Module
@InstallIn(SingletonComponent::class)



object AppModule  {

    @Singleton
    @Provides
    fun provideAppNetworkBuilder():Retrofit =
        AppNetworkBuilder().provideRetrofitClient()

    @Singleton
    @Provides
    fun provideAppDataBaseBuilder(@ApplicationContext context: Context) =
        AppDatabaseBuilder.provideRoomDatabase(context)

    @Provides
    fun provideNewsApiServices(retrofit: Retrofit):NewsApiServices =
        retrofit.create(NewsApiServices::class.java)

    @Provides
    fun provideNewsDao(appDatabaseBuilder: AppDatabaseBuilder) =
        appDatabaseBuilder.getNews()


    @Provides
    fun provideNewsRemoteDS(newsApiServices: NewsApiServices)=
        NewsRemoteDataSource(newsApiServices)

    @Provides
    fun provideNewsLocalDS(newsDao: NewsDao)=
        NewsLocalDataSource(newsDao)

    @Provides
    fun provideNewsRepository(
        newsRemoteDataSource: NewsRemoteDataSource,
        newsLocalDataSource: NewsLocalDataSource) =

        NewsRepository(newsRemoteDataSource,newsLocalDataSource)




}