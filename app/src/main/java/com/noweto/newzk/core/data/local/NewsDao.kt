package com.noweto.newzk.core.data.local

import androidx.lifecycle.LiveData
import androidx.room.*
import com.noweto.newzk.ui.fragments.globalNewsFragment.models.GlobalArticle
import com.noweto.newzk.ui.fragments.localNewsFragment.models.LocalArticle

//~~ class For Insert & Get functions in Room Db

@Dao
interface NewsDao {

    //~~ get all Global  news

    @Query("SELECT * FROM newsList")
    fun getGlobalNews():LiveData<List<GlobalArticle>>

    //~~ insert all Global news

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertGlobalNews(newsList : ArrayList<GlobalArticle>)


    //~~ get all Local news

    @Query("SELECT * FROM egyptNewsList")
    fun getLocalNews():LiveData<List<LocalArticle>>

    //~~ insert all Local news

    @Insert(onConflict = OnConflictStrategy.REPLACE)

    fun insertLocalNews(newsList : ArrayList<LocalArticle>)



    @Query("DELETE FROM newsList")
    fun deleteGlobalNews()

    @Query("DELETE FROM egyptNewsList")
    fun deleteLocalNews()



}