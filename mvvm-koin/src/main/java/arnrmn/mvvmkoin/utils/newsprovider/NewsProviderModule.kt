package arnrmn.mvvmkoin.utils.newsprovider

import org.koin.dsl.module.Module
import org.koin.dsl.module.module

val newsProviderModule: Module = module {
    single { BbcNewsProvider(get()) as NewsProvider }
}