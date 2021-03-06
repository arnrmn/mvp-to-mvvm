package arnrmn.mvvmkoin.newslist.fragment

import android.arch.core.executor.testing.InstantTaskExecutorRule
import arnrmn.mvvmkoin.newslist.NewsListViewModel
import arnrmn.mvvmkoin.utils.entity.Article
import arnrmn.mvvmkoin.utils.newsprovider.NewsProvider
import com.nhaarman.mockito_kotlin.given
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import io.reactivex.Single
import junit.framework.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.clearInvocations

class NewsListViewModelTest {
    @get:Rule val rule = InstantTaskExecutorRule()
    private val provider = mock<NewsProvider>()

    @Before
    fun setup() {
        clearInvocations(provider)
    }

    @Test
    fun init_articlesLoaded_articlesSet() {
        val articles = emptyList<Article>()
        given(provider.getNews()).willReturn(Single.just(articles))

        val viewModel = NewsListViewModel(provider)

        assertEquals(articles, viewModel.observeArticles().value)
    }

    @Test
    fun init_articlesLoaded_noErrorSet() {
        val articles = emptyList<Article>()
        given(provider.getNews()).willReturn(Single.just(articles))

        val viewModel = NewsListViewModel(provider)

        assertNull(viewModel.observeError().value)
    }

    @Test
    fun init_emptyArticlesListLoaded_noArticlesSet() {
        given(provider.getNews()).willReturn(Single.just(emptyList()))

        val viewModel = NewsListViewModel(provider)

        assertEquals(true, viewModel.observeNoArticles().value)
    }

    @Test
    fun init_emptyArticlesListLoaded_noErrorSet() {
        given(provider.getNews()).willReturn(Single.just(emptyList()))

        val viewModel = NewsListViewModel(provider)

        assertNull(viewModel.observeError().value)
    }

    @Test
    fun init_errorOnLoading_messageSet() {
        val message = "test.message"
        val error = RuntimeException(message)
        given(provider.getNews()).willReturn(Single.error(error))

        val viewModel = NewsListViewModel(provider)

        assertEquals(message, viewModel.observeError().value)
    }

    @Test
    fun init_errorOnLoading_noArticlesSet() {
        given(provider.getNews()).willReturn(Single.error(RuntimeException()))

        val viewModel = NewsListViewModel(provider)

        assertNull(viewModel.observeArticles().value)
        assertNull(viewModel.observeNoArticles().value)
    }

    @Test
    fun init_startLoading_showProgress() {
        given(provider.getNews()).willReturn(Single.never())

        val viewModel = NewsListViewModel(provider)

        assertEquals(true, viewModel.observeProgress().value)
    }

    @Test
    fun init_loadingSuccess_hidesProgress() {
        given(provider.getNews()).willReturn(Single.just(emptyList()))

        val viewModel = NewsListViewModel(provider)

        assertEquals(false, viewModel.observeProgress().value)
    }

    @Test
    fun init_loadingFailed_hidesProgress() {
        given(provider.getNews()).willReturn(Single.error(RuntimeException()))

        val viewModel = NewsListViewModel(provider)

        assertEquals(false, viewModel.observeProgress().value)
    }

    @Test
    fun onRefresh_loadsArticles() {
        given(provider.getNews()).willReturn(Single.just(emptyList()))
        val viewModel = NewsListViewModel(provider)
        clearInvocations(provider)

        viewModel.onRefresh()

        verify(provider).getNews()
    }

    @Test
    fun onArticleClicked_setsDetails() {
        given(provider.getNews()).willReturn(Single.just(emptyList()))
        val viewModel = NewsListViewModel(provider)
        val article = mock<Article>()

        viewModel.onArticleClicked(article)

        assertEquals(article, viewModel.observeDetails().value)
    }

    @Test
    fun onCleared_clearsPendingRequests() {
        var isDisposed = false
        val request = Single.never<List<Article>>().doOnDispose { isDisposed = true }
        given(provider.getNews()).willReturn(request)
        val viewModel = NewsListViewModel(provider)

        viewModel.onCleared()

        assertTrue(isDisposed)
    }
}