package com.noweto.newzk.ui.fragments.localNewsFragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.noweto.newzk.R
import com.noweto.newzk.core.utils.BusinessConst.LOCAL_NEWS_ITEM
import com.noweto.newzk.core.utils.Resource
import com.noweto.newzk.ui.fragments.localNewsFragment.adapter.LocalNewsAdapter
import com.noweto.newzk.ui.fragments.localNewsFragment.models.LocalArticle
import com.noweto.newzk.ui.fragments.localNewsFragment.viewModels.LocalNewsViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_local_news.*

@AndroidEntryPoint
class LocalNewsFragment : Fragment(),LocalNewsAdapter.OnItemClick {


    private val viewModel:LocalNewsViewModel by viewModels()

    private val adapter : LocalNewsAdapter = LocalNewsAdapter(this)


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_local_news, container, false)
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.e("Now","From Local News Fragment")

        initViews()
        setUpObserver()
    }

    private fun initViews() {
        localNewsRv.layoutManager = LinearLayoutManager(activity)

    }

    private fun setUpObserver() {

        viewModel.newsList.observe(viewLifecycleOwner, Observer {

            when(it.status){
                Resource.Status.SUCCESS->{
                    Log.e("Status_Local","Success"+it.data)
                    it.data?.let { it1 -> adapter.setItems(it1 as ArrayList<LocalArticle>) }
                    localNewsRv.adapter = adapter
                }
                Resource.Status.ERROR->{
                    Log.e("Status_Local","Error"+it.message)

                }
                Resource.Status.LOADING->{
                    Log.e("Status_Local","Loading")

                }
            }
        })


    }

    override fun onItemClicked(article: LocalArticle) {
        findNavController().navigate(R.id.from_home_to_local_details, bundleOf(LOCAL_NEWS_ITEM to article))
    }


}