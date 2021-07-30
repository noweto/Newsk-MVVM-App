package com.noweto.newzk.core.data.remote

import com.noweto.newzk.core.utils.Resource
import retrofit2.Response
import retrofit2.Retrofit

//~~ class connect between Response of retrofit and My Resource class
abstract class BaseRemoteDataSource {


    suspend fun<T> getResults(call:suspend ()->Response<T>):Resource<T>{
        try {
            val response = call()
            if(response.isSuccessful){
                val body = response.body()
                if (body!=null)
                    return Resource.success(body)
            }
            return Resource.error("${response.code()} ${response.message()}")

        }catch (e:Exception){
            return Resource.error("${e.message}")
        }
    }


}