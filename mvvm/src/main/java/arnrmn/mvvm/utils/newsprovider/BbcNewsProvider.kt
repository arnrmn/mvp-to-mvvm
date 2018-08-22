package arnrmn.mvvm.utils.newsprovider

import arnrmn.mvvm.utils.entity.Article
import arnrmn.mvvm.utils.network.RestApi
import io.reactivex.Single
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class BbcNewsProvider @Inject constructor(
        private val restApi: RestApi
) : NewsProvider {
    override fun getNews(): Single<List<Article>> {
        return restApi.getTopHeadlines (SOURCE)
                .delay(5, TimeUnit.SECONDS)
                .map { response -> response.articles }
    }

    companion object {
        private const val SOURCE = "bbc-news"
    }
}