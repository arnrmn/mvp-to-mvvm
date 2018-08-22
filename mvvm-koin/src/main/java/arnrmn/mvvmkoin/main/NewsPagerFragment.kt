package arnrmn.mvvmkoin.main

import android.os.Bundle
import android.view.View
import arnrmn.mvvmkoin.R
import arnrmn.mvvmkoin.utils.android.BaseFragment
import kotlinx.android.synthetic.main.fragment_pager.*
import org.koin.android.ext.android.inject
import org.koin.android.scope.ext.android.scopedWith
import org.koin.core.parameter.parametersOf
import org.koin.dsl.path.moduleName

class NewsPagerFragment : BaseFragment() {
    private val adapter: NewsPagerAdapter by inject { parametersOf(childFragmentManager)}

    override fun getLayoutId(): Int = R.layout.fragment_pager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        scopedWith(this::class.moduleName)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        newsPager.adapter = adapter
    }

    companion object {
        fun newInstance(): NewsPagerFragment = NewsPagerFragment()
    }
}