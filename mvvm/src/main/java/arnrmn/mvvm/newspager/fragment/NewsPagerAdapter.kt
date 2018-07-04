package arnrmn.mvvm.newspager.fragment

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import arnrmn.mvvm.newsdetails.fragment.NewsDetailsFragment
import arnrmn.mvvm.utils.entity.Article

class NewsPagerAdapter(manager: FragmentManager) : FragmentPagerAdapter(manager) {

    private val articles = mutableListOf<Article>()

    override fun getItem(position: Int): Fragment {
        return NewsDetailsFragment.newInstance(articles[position])
    }

    override fun getCount(): Int {
        return articles.count()
    }

    fun update(articles: List<Article>) {
        this.articles.clear()
        this.articles.addAll(articles)
        notifyDataSetChanged()
    }
}