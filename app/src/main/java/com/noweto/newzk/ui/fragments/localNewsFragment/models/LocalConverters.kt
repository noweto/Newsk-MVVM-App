package com.noweto.newzk.ui.fragments.localNewsFragment.models

import androidx.room.TypeConverter

//~~ For convert source object and insert it into Room DB
class LocalConverters {

    @TypeConverter
    fun fromSource(source: Source): String? = source.name

    @TypeConverter
    fun toSource(name:String):Source = Source(name,name)


}