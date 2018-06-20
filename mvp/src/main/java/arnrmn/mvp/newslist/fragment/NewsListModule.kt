package arnrmn.mvp.newslist.fragment

import dagger.Binds
import dagger.Module
import dk.tv2.onboarding.FragmentScope

@Module
abstract class NewsListModule {
    @Binds @FragmentScope
    abstract fun bindPresenter(presenter: NewsListPresenter): NewsListContract.Presenter

    @Binds
    abstract fun bindModel(model: NewsListModel): NewsListContract.Model
}