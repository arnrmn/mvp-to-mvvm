package arnrmn.mvvm.newspager.fragment

import arnrmn.mvvm.R
import arnrmn.mvvm.utils.android.BaseFragment

class NewsPagerFragment : BaseFragment() {
    override fun getLayoutId(): Int = R.layout.fragment_pager

    companion object {
        fun newInstance() : NewsPagerFragment = NewsPagerFragment()
    }
}