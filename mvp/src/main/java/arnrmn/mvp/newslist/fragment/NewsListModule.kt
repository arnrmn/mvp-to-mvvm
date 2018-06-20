package arnrmn.mvp.newslist.fragment

import arnrmn.mvp.newslist.fragment.list.ArticleViewHolderFactory
import arnrmn.mvp.newslist.fragment.list.ArticlesAdapter
import dagger.Binds
import dagger.Module
import dagger.Provides
import dk.tv2.onboarding.FragmentScope

@Module
abstract class NewsListModule {
    @Binds @FragmentScope
    abstract fun bindPresenter(presenter: NewsListPresenter): NewsListContract.Presenter

    @Binds
    abstract fun bindModel(model: NewsListModel): NewsListContract.Model

    @Module
    companion object {
        @JvmStatic @Provides
        fun provideViewHolderFactory(): ArticleViewHolderFactory {
            return ArticleViewHolderFactory()
        }

        @JvmStatic @Provides
        fun provideAdapter(factory: ArticleViewHolderFactory): ArticlesAdapter {
            return ArticlesAdapter(factory)
        }
    }
}