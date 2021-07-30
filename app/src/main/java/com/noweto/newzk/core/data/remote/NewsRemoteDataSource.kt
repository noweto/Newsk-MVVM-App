package com.noweto.newzk.core.data.remote

import com.noweto.newzk.core.utils.BusinessConst.ABI_KEY
import javax.inject.Inject

class NewsRemoteDataSource @Inject constructor(private val newsApiServices: NewsApiServices) :
    BaseRemoteDataSource() {


    suspend fun getGlobalNews() = getResults { newsApiServices.getGlobalNewsByTopic("bitcoin+tesla+apple",ABI_KEY)  }


    suspend fun getLocalNews() =  getResults { newsApiServices.getLocalNewsByCountry("eg",ABI_KEY) }




}