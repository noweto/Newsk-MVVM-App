package com.noweto.newzk.core.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.noweto.newzk.core.data.local.NewsLocalDataSource
import com.noweto.newzk.core.data.remote.NewsRemoteDataSource
import com.noweto.newzk.core.utils.Resource
import com.noweto.newzk.core.utils.performGetOperations
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

//~~ class for build app Data strategy

class NewsRepository @Inject constructor(private val newsRemoteDataSource: NewsRemoteDataSource ,
                     private val newsLocalDataSource: NewsLocalDataSource) {


    fun getGlobalNews() = performGetOperations(
        dataBaseQuery ={newsLocalDataSource.getAllGlobalNews()} ,
        networkCall = {newsRemoteDataSource.getGlobalNews()},
        saveCallResult = {newsLocalDataSource.insertAllGlobalNews(it.articles)}
        )



    fun getLocalNews()= performGetOperations(
        dataBaseQuery = {newsLocalDataSource.getAllLocalNews()},
        networkCall = {newsRemoteDataSource.getLocalNews()},
        saveCallResult = {newsLocalDataSource.insertAllLocalNews(it.articles)}
    )





}