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
        private val model: NewsListContract.Model
) : ViewModel(), NewsListContract.ViewModel {
    private val disposables = CompositeDisposable()
    private val articles = MutableLiveData<List<Article>>()
    private val progress = MutableLiveData<Boolean>()
    private val error = SingleLiveData<String>()
    private val details = SingleLiveData<Article>()

    init {
        loadArticles()
    }

    override fun observeArticles(): LiveData<List<Article>> {
        return articles
    }

    override fun observeError(): LiveData<String> {
        return error
    }

    override fun observeProgress(): LiveData<Boolean> {
        return progress
    }

    override fun observeDetails(): LiveData<Article> {
        return details
    }

    override fun onArticleClicked(article: Article) {
        details.postValue(article)
    }

    override fun onCleared() {
        disposables.dispose()
    }

    override fun onRefresh() {
        loadArticles()
    }

    private fun loadArticles() {
        model.loadNews().onResult(articles::postValue)
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