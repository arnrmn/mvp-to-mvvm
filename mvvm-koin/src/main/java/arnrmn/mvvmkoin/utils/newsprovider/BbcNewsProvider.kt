package arnrmn.mvvmkoin.utils.newsprovider

import arnrmn.mvvmkoin.utils.entity.Article
import arnrmn.mvvmkoin.utils.network.RestApi
import io.reactivex.Single

class BbcNewsProvider(
        private val restApi: RestApi
) : NewsProvider {
    override fun getNews(): Single<List<Article>> {
        return restApi.getTopHeadlines (SOURCE)
                .map { response -> response.articles }
    }

    companion object {
        private const val SOURCE = "bbc-news"
    }
}