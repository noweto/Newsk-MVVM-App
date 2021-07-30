package com.noweto.newzk.ui.fragments.globalNewsFragment

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
import com.noweto.newzk.core.utils.BusinessConst.GLOBAL_NEWS_ITEM
import com.noweto.newzk.core.utils.Resource
import com.noweto.newzk.ui.fragments.globalNewsFragment.adapter.GlobalNewsAdapter
import com.noweto.newzk.ui.fragments.globalNewsFragment.models.GlobalArticle
import com.noweto.newzk.ui.fragments.globalNewsFragment.viewModels.GlobalNewsViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_global_news.*


@AndroidEntryPoint
class GlobalNewsFragment : Fragment() ,GlobalNewsAdapter.OnItemClick {

    private val viewModel : GlobalNewsViewModel by viewModels()

    private val adapter : GlobalNewsAdapter = GlobalNewsAdapter(this)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        Log.e("Now","From Global fra")

        return inflater.inflate(R.layout.fragment_global_news, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViews()
        setUpObserver()


    }



    private fun initViews() {
        newsRv.layoutManager = LinearLayoutManager(activity)
        newsRv.adapter = adapter
    }




    private fun setUpObserver() {


        viewModel.globalNewsList.observe(viewLifecycleOwner, Observer {

            when(it.status){
                Resource.Status.SUCCESS->{
                    Log.e("Status","Success"+it.data)
                    it.data?.let { it1 -> adapter.setItems(it1 as ArrayList<GlobalArticle>) }


                }
                Resource.Status.ERROR->{
                    Log.e("Status","Error"+it.message)

                }
                Resource.Status.LOADING->{
                    Log.e("Status","Loading")

                }
            }

        })
    }

    override fun onItemClicked(newsModel: GlobalArticle) {
        findNavController().navigate(R.id.from_home_to_global_details, bundleOf(GLOBAL_NEWS_ITEM to newsModel))

    }



}