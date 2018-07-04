package arnrmn.mvvm.main.fragment

import android.os.Bundle
import android.view.View
import arnrmn.mvvm.R
import arnrmn.mvvm.newslist.NewsListActivity
import arnrmn.mvvm.newspager.NewsPagerActivity
import arnrmn.mvvm.utils.android.BaseFragment
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment : BaseFragment() {
    override fun getLayoutId(): Int = R.layout.fragment_main

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        listButton.setOnClickListener { NewsListActivity.start(context) }
        pagerButton.setOnClickListener { NewsPagerActivity.start(context) }
    }

    companion object {
        fun newInstance(): MainFragment = MainFragment()
    }
}