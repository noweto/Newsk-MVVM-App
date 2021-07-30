package com.noweto.newzk.core.utils

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.LiveDataScope
import androidx.lifecycle.liveData
import androidx.lifecycle.map
import kotlinx.coroutines.Dispatchers

/**
 * set default data base as a local DB
 * Get data from remote data source
 * Save fresh data in local data source
 */


fun<T,A> performGetOperations(
            dataBaseQuery:()->LiveData<T>,
            networkCall:suspend ()->Resource<A>,
            saveCallResult:suspend (A)->Unit ) : LiveData<Resource<T>> =
    liveData(Dispatchers.IO) {
        //~~ start with loading state
        emit(Resource.loading())
        //~~ attach live data scope with local data base

        val source = dataBaseQuery.invoke().map { Resource.success(it) }
        emitSource(source)

        //~~ Get data from APis
        val responseStatus = networkCall.invoke()

        if(responseStatus.status==Resource.Status.SUCCESS){
            //~~ you get data successfully from APIS
            saveCallResult(responseStatus.data!!)
            Log.e("My_API_Response",responseStatus.data.toString())
        }else if(responseStatus.status==Resource.Status.ERROR){
            //~~ show error message
            emit(Resource.error(responseStatus.message!!))
            //~~ set default data source [ Local Db ]
            emitSource(source)
        }


    }