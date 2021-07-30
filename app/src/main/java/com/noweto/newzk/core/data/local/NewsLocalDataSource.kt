package com.noweto.newzk.core.data.local

import com.noweto.newzk.ui.fragments.globalNewsFragment.models.GlobalArticle
import com.noweto.newzk.ui.fragments.localNewsFragment.models.LocalArticle
import javax.inject.Inject

class NewsLocalDataSource @Inject constructor (private val  newsDao: NewsDao) {


    //~~ get data from Dao
    fun getAllGlobalNews() = newsDao.getGlobalNews()
    fun getAllLocalNews() = newsDao.getLocalNews()


    //~~ insert data into room
    fun insertAllGlobalNews(globalNewsList:ArrayList<GlobalArticle>)
    = newsDao.insertGlobalNews(globalNewsList)


    fun insertAllLocalNews(localNewsList:ArrayList<LocalArticle>)
    = newsDao.insertLocalNews(localNewsList)


}