package arnrmn.mvvmkoin.app

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import org.koin.dsl.module.Module
import org.koin.dsl.module.module

const val UI = "ui"
const val IO = "io"

val appModule: Module = module {
    single(IO) { Schedulers.io() }
    single(UI) { AndroidSchedulers.mainThread() }
}