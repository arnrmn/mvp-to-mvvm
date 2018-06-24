package arnrmn.mvvmp.newsprovider

import dagger.Binds
import dagger.Module

@Module
abstract class NewsProviderModule {
    @Binds
    abstract fun bindProvider(provider: BbcNewsProvider): NewsProvider
}