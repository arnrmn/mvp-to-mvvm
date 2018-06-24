package arnrmn.mvvmp.newsprovider

import arnrmn.mvvmp.utils.entity.Article
import arnrmn.mvvmp.utils.network.RestApi
import io.reactivex.Single
import javax.inject.Inject

class BbcNewsProvider @Inject constructor(
        private val restApi: RestApi
) : NewsProvider {
    override fun getNews(): Single<List<Article>> {
        return restApi.getTopHeadlines(SOURCE)
                .map { response -> response.articles }
    }

    companion object {
        private const val SOURCE = "bbc-news"
    }
}