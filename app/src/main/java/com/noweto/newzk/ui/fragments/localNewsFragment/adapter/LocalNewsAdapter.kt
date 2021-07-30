package com.noweto.newzk.ui.fragments.localNewsFragment.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.noweto.newzk.R
import com.noweto.newzk.ui.fragments.localNewsFragment.models.LocalArticle

class LocalNewsAdapter(private val onItemClick: OnItemClick): RecyclerView.Adapter<LocalNewsAdapter.NewsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val v : View = LayoutInflater.from(parent.context).inflate(R.layout.news_item,parent,false)
        return NewsViewHolder(v)
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        holder.bindData(newsList[position])

        //~~ When you click in specific item
        holder.itemView.setOnClickListener {
            onItemClick.onItemClicked(newsList[position])
        }
    }

    override fun getItemCount(): Int = newsList.size

    private var newsList:ArrayList<LocalArticle> = arrayListOf()

    //~~ setItems Fun
    @SuppressLint("NotifyDataSetChanged")
    fun setItems (itemList:ArrayList<LocalArticle>){
        newsList = itemList
        notifyDataSetChanged()
    }
    class NewsViewHolder(v: View): RecyclerView.ViewHolder(v) {

        private val newsTitle : TextView = v.findViewById(R.id.newsTitle)
        private val newsImage : ImageView = v.findViewById(R.id.newsImage)
        private val newsSource : TextView = v.findViewById(R.id.newsSource)
        private val newsTime : TextView = v.findViewById(R.id.newsTime)

        //~~ Function to bind data ..

        fun bindData(article: LocalArticle){

            if(article.title!=null)
                newsTitle.text = article.title
            if(article.urlToImage!=null)
                Glide.with(newsImage.context).load(article.urlToImage).into(newsImage)
            if(article.publishedAt!=null)
                newsTime.text = article.publishedAt
            newsSource.text = article.source?.name.toString()
        }

    }

    interface OnItemClick{
        fun onItemClicked(article: LocalArticle)
    }


}