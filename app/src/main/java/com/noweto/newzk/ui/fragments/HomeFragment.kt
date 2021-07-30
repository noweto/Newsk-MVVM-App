package com.noweto.newzk.ui.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.noweto.newzk.R
import com.noweto.newzk.ui.fragments.globalNewsFragment.GlobalNewsFragment
import com.noweto.newzk.ui.fragments.localNewsFragment.LocalNewsFragment
import com.noweto.newzk.ui.viewPager.ViewPagerAdapter
import kotlinx.android.synthetic.main.fragment_home.*


class HomeFragment : Fragment() {

    private lateinit var viewPagerAdapter: ViewPagerAdapter

    override fun onCreateView(

        //~~ Handle any ui ...

        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle? ): View? {
        // Inflate the layout for this fragment
        Log.e("Now","From Home Fragment")

        return inflater.inflate(R.layout.fragment_home, container, false)


    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        //~~ Handle any of data set ..
        super.onViewCreated(view, savedInstanceState)
        setUpViewPagerAdapter()


    }


    private fun setUpViewPagerAdapter() {
        Log.e("Now","From function")

        viewPagerAdapter  = ViewPagerAdapter(childFragmentManager)

        viewPagerAdapter.addFragment(GlobalNewsFragment(),"")
        viewPagerAdapter.addFragment(LocalNewsFragment(),"")


        viewPager.adapter = viewPagerAdapter
        tabLayout.setupWithViewPager(viewPager)
        tabLayout.getTabAt(0)?.setIcon(R.drawable.world_n)
        tabLayout.getTabAt(1)?.setIcon(R.drawable.local)



    }




}