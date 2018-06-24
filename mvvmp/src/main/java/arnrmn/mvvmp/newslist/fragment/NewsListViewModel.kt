package arnrmn.mvvmp.newslist.fragment

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import arnrmn.mvvmp.utils.entity.Article
import arnrmn.mvvmp.utils.livedata.SingleLiveData

class NewsListViewModel : ViewModel(), NewsListContract.View {
    private val articles = MutableLiveData<List<Article>>()
    private val noArticles = MutableLiveData<Boolean>()
    private val progress = MutableLiveData<Boolean>()
    private val message = SingleLiveData<String>()
    private val details = SingleLiveData<Article>()

    fun observeArticles(): LiveData<List<Article>> {
        return articles
    }

    fun observeMessage(): LiveData<String> {
        return message
    }

    fun observeProgress(): LiveData<Boolean> {
        return progress
    }

    fun observeDetails(): LiveData<Article> {
        return details
    }

    fun observeNoArticles(): LiveData<Boolean> {
        return noArticles
    }

    override fun showArticles(articles: List<Article>) {
        this.articles.postValue(articles)
        this.noArticles.postValue(false)
    }

    override fun showNoArticles() {
        this.noArticles.postValue(true)
        this.articles.postValue(emptyList())
    }

    override fun showMessage(message: String) {
        this.message.postValue(message)
    }

    override fun showProgress() {
        this.progress.postValue(true)
    }

    override fun hideProgress() {
        this.progress.postValue(false)
    }

    override fun showDetails(article: Article) {
        this.details.postValue(article)
    }
}