package arnrmn.mvvmkoin.newsdetails

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import arnrmn.mvvmkoin.newsdetails.formatter.ArticleDescriptionFormatter
import arnrmn.mvvmkoin.newsdetails.formatter.ArticleTitleFormatter
import arnrmn.mvvmkoin.utils.entity.Article
import arnrmn.mvvmkoin.utils.livedata.SingleLiveData

class NewsDetailsViewModel(
        private val titleFormatter: ArticleTitleFormatter,
        private val descriptionFormatter: ArticleDescriptionFormatter
) : ViewModel() {
    private lateinit var article: Article
    private val title = MutableLiveData<String>()
    private val description = MutableLiveData<String>()
    private val imageUrl = MutableLiveData<String>()
    private val openLinkAction = SingleLiveData<String>()

    fun observeTitle(): LiveData<String> = title

    fun observeDescription(): LiveData<String> = description

    fun observeImageUrl(): LiveData<String> = imageUrl

    fun observeOpenLinkAction(): LiveData<String> = openLinkAction

    fun onArticleSelected(article: Article) {
        this.article = article
        title.postValue(titleFormatter.format(article))
        description.postValue(descriptionFormatter.format(article))
        imageUrl.postValue(article.urlToImage)
    }

    fun onButtonClicked() {
        openLinkAction.postValue(article.url)
    }
}