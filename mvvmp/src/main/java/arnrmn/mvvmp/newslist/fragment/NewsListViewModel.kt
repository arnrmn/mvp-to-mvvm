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

    fun observeArticles(): LiveData<List<Article>> = articles

    fun observeMessage(): LiveData<String> = message

    fun observeProgress(): LiveData<Boolean> = progress

    fun observeDetails(): LiveData<Article> = details

    fun observeNoArticles(): LiveData<Boolean> = noArticles

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