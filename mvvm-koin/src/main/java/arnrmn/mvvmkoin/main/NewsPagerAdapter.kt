package arnrmn.mvvmkoin.main

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import arnrmn.mvvmkoin.newslist.NewsListFragment

class NewsPagerAdapter(manager: FragmentManager) : FragmentPagerAdapter(manager) {

    override fun getItem(position: Int): Fragment {
        return NewsListFragment.newInstance()
    }

    override fun getCount(): Int {
        return 10
    }
}