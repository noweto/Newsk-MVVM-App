package com.noweto.newzk.core.data.remote

import com.noweto.newzk.ui.fragments.globalNewsFragment.models.GlobalArticle
import com.noweto.newzk.ui.fragments.globalNewsFragment.models.GlobalNewsModel
import com.noweto.newzk.ui.fragments.localNewsFragment.models.LocalNewsModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

//~~ interface for endpoints ..
interface NewsApiServices {



    @GET("everything")
   suspend fun getGlobalNewsByTopic(@Query("q") topic:String,@Query("apiKey") apiKey:String)
    :Response<GlobalNewsModel>



    @GET("top-headlines")
   suspend fun getLocalNewsByCountry(@Query("country") country:String,@Query("apiKey") apiKey:String)
    :Response<LocalNewsModel>

}