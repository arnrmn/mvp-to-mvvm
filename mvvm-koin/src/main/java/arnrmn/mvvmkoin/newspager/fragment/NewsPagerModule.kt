package arnrmn.mvvmkoin.newspager.fragment

import android.support.v4.app.FragmentManager
import org.koin.dsl.module.Module
import org.koin.dsl.module.module
import org.koin.dsl.path.moduleName

val newsPagerModule: Module = module(NewsPagerFragment::class.moduleName) {
    factory { (manager: FragmentManager) -> NewsPagerAdapter(manager) }
}