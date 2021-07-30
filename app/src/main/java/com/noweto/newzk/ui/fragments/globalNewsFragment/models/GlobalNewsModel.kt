package com.noweto.newzk.ui.fragments.globalNewsFragment.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable


data class GlobalNewsModel(
    val articles: ArrayList<GlobalArticle>,
    val status: String,
    val totalResults: Int
):Serializable

const val NEWS_ID = 0
@Entity(tableName = "newsList")
data class GlobalArticle(
    val author: String?=null,
    val content: String?=null,
    val description: String?=null,
    val publishedAt: String?=null,
    //~~ Type converter ..?
    val source: Source?=null,
    val title: String?=null,
    val url: String?=null,
    val urlToImage: String?=null
):Serializable{
    @PrimaryKey(autoGenerate = true)
    var id :Int = NEWS_ID
}

data class Source(
    val id: String?=null,
    val name: String?=null
):Serializable