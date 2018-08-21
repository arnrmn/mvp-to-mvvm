package arnrmn.mvvmkoin.newspager.fragment

import android.os.Bundle
import android.view.View
import arnrmn.mvvmkoin.R
import arnrmn.mvvmkoin.utils.android.BaseFragment
import kotlinx.android.synthetic.main.fragment_pager.*
import javax.inject.Inject

class NewsPagerFragment : BaseFragment() {
    @Inject lateinit var adapter: NewsPagerAdapter

    override fun getLayoutId(): Int = R.layout.fragment_pager

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        newsPager.adapter = adapter
    }

    companion object {
        fun newInstance(): NewsPagerFragment = NewsPagerFragment()
    }
}