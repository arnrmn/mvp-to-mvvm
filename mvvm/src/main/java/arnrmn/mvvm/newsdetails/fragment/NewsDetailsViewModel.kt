package arnrmn.mvvm.newsdetails.fragment

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import arnrmn.mvvm.newsdetails.fragment.formatter.ArticleDescriptionFormatter
import arnrmn.mvvm.newsdetails.fragment.formatter.ArticleTitleFormatter
import arnrmn.mvvm.utils.entity.Article
import arnrmn.mvvm.utils.livedata.SingleLiveData
import javax.inject.Inject

class NewsDetailsViewModel @Inject constructor(
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