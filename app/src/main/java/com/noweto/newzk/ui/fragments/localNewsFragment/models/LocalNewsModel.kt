package com.noweto.newzk.ui.fragments.localNewsFragment.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

data class LocalNewsModel(
    val articles: ArrayList<LocalArticle>,
    val status: String,
    val totalResults: Int
):Serializable

const val NEWS_ID = 0
@Entity(tableName = "egyptNewsList")
data class LocalArticle(
    val author: String?=null,
    val content: String?=null,
    val description: String?=null,
    val publishedAt: String?=null,
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