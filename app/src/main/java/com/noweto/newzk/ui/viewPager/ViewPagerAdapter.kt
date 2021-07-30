package com.noweto.newzk.ui.viewPager

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter

class ViewPagerAdapter(fragmentManager: FragmentManager):FragmentStatePagerAdapter(fragmentManager)  {

     var fragments: ArrayList<Fragment> = arrayListOf()
     var titls : ArrayList<String> = arrayListOf()

    override fun getCount(): Int {

        return fragments.size
    }

    override fun getItem(position: Int): Fragment {
        return fragments[position]
    }

    //~~ add Your Fragments here ..
    fun addFragment(fragment: Fragment,title:String){
        fragments.add(fragment)
        titls.add(title)
    }

    override fun getPageTitle(position: Int): CharSequence {
        return titls[position]
    }


}