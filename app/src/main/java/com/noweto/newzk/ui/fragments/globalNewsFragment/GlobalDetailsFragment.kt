package com.noweto.newzk.ui.fragments.globalNewsFragment

import android.content.Intent
import android.graphics.Color
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.noweto.newzk.R
import com.noweto.newzk.core.utils.BusinessConst.GLOBAL_NEWS_ITEM
import com.noweto.newzk.ui.fragments.globalNewsFragment.models.GlobalArticle
import kotlinx.android.synthetic.main.fragment_global_details.*

class GlobalDetailsFragment : Fragment()  {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_global_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        retrieveData()
    }

    private fun  retrieveData() {
        val newsItem : GlobalArticle = arguments?.getSerializable(GLOBAL_NEWS_ITEM)  as GlobalArticle




        if (newsItem.author!=null){
            author.text = newsItem.author
        }
        if (newsItem.description!=null){
            description.text = newsItem.description
        }
        if (newsItem.content!=null){
            content.text = newsItem.content
        }
        if (newsItem.url!=null){
            link.text = newsItem.url

            link.setOnClickListener {
                goToUrl(newsItem.url)
                link.setLinkTextColor(Color.BLUE)
            }

        }
        if (newsItem.urlToImage!=null){
            Glide.with(newsImage.context).load(newsItem.urlToImage).into(newsImage)
        }
    }

    private fun goToUrl(s:String){
        val uri : Uri = Uri.parse(s)
        startActivity(Intent(Intent.ACTION_VIEW,uri) )
    }


}