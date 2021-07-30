package com.noweto.newzk.ui.fragments.globalNewsFragment.models

import androidx.room.TypeConverter

//~~ For convert source object and insert it into Room DB
class GlobalConverters {

    @TypeConverter
    fun fromSource(source: Source) : String? {
        return source.name
    }

    @TypeConverter
    fun toSource(name: String):Source{
        return Source(name,name)
    }
}