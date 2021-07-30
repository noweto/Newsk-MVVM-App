package com.noweto.newzk.core.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.noweto.newzk.core.utils.BusinessConst.NEWSK_DB
import com.noweto.newzk.ui.fragments.globalNewsFragment.models.GlobalConverters
import com.noweto.newzk.ui.fragments.globalNewsFragment.models.GlobalArticle
import com.noweto.newzk.ui.fragments.localNewsFragment.models.LocalArticle
import com.noweto.newzk.ui.fragments.localNewsFragment.models.LocalConverters


//~~ single tone of Room DB -> abstract class

@Database(entities = [GlobalArticle::class,LocalArticle::class],version = 1,exportSchema = false)
@TypeConverters(GlobalConverters::class,LocalConverters::class)




abstract class AppDatabaseBuilder : RoomDatabase() {



    companion object{

        private var db : AppDatabaseBuilder ?=null

        fun provideRoomDatabase(context: Context):AppDatabaseBuilder =
            db?: synchronized(this){
                db?: buildDataBase(context).also { db = it }
            }

        private fun buildDataBase (context: Context) =
            Room.databaseBuilder(context,AppDatabaseBuilder::class.java,NEWSK_DB)
                .fallbackToDestructiveMigration()
                .build()


    }

    //~~ abstract function ..
    abstract fun getNews(): NewsDao



}