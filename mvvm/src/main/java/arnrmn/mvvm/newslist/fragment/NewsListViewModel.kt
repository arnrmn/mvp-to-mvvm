package arnrmn.mvvm.newslist.fragment

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import arnrmn.mvvm.utils.entity.Article
import arnrmn.mvvm.utils.livedata.SingleLiveData
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class NewsListViewModel @Inject constructor(
        private val model: NewsListModel
) : ViewModel() {
    private val disposables = CompositeDisposable()
    private val articles = MutableLiveData<List<Article>>()
    private val noArticles = MutableLiveData<Boolean>()
    private val progress = MutableLiveData<Boolean>()
    private val error = SingleLiveData<String>()
    private val details = SingleLiveData<Article>()

    init {
        loadArticles()
    }

    fun observeArticles(): LiveData<List<Article>> = articles

    fun observeError(): LiveData<String> = error

    fun observeProgress(): LiveData<Boolean> = progress

    fun observeDetails(): LiveData<Article> = details

    fun observeNoArticles(): LiveData<Boolean> = noArticles

    fun onRefresh() {
        loadArticles()
    }

    fun onArticleClicked(article: Article) {
        details.postValue(article)
    }

    override fun onCleared() {
        disposables.dispose()
    }

    private fun loadArticles() {
        model.loadNews()
                .onResult { articles ->
                    this.articles.postValue(articles)
                    this.noArticles.postValue(articles.isEmpty())
                }
    }

    private fun <T> Single<T>.onResult(action: (T) -> Unit) {
        disposables.add(
                this.doOnSubscribe { progress.postValue(true) }
                        .doOnError { progress.postValue(false) }
                        .doOnSuccess { progress.postValue(false) }
                        .subscribe(
                                { result -> action.invoke(result) },
                                { cause -> error.postValue(cause.message) }
                        )
        )
    }
}