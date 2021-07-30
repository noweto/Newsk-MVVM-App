package com.noweto.newzk.ui.fragments.localNewsFragment

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
import com.noweto.newzk.ui.fragments.localNewsFragment.models.LocalArticle
import kotlinx.android.synthetic.main.fragment_global_details.*
import kotlinx.android.synthetic.main.fragment_global_details.content
import kotlinx.android.synthetic.main.fragment_local_details.*


class LocalDetailsFragment : Fragment() {



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment


        return inflater.inflate(R.layout.fragment_local_details, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //~~ set Data to views
        retrieveData()
    }
    private fun  retrieveData() {

        val newsItem : LocalArticle = arguments?.getSerializable("localNewsItem")  as LocalArticle


        if (newsItem.author!=null){
            localAuthor.text = newsItem.author
        }
        if (newsItem.description!=null){
            localDescription.text = newsItem.description
        }
        if (newsItem.content!=null){
            content.text = newsItem.content
        }
        if (newsItem.url!=null){
            localLink.text = newsItem.url

            localLink.setOnClickListener {
                goToUrl(newsItem.url)
                localLink.setLinkTextColor(Color.BLUE)
            }

        }
        if (newsItem.urlToImage!=null){
            Glide.with(requireContext()).load(newsItem.urlToImage).into(localImage)
        }

    }

    private fun goToUrl(s:String){
        val uri : Uri = Uri.parse(s)
        startActivity(Intent(Intent.ACTION_VIEW,uri) )
    }



}