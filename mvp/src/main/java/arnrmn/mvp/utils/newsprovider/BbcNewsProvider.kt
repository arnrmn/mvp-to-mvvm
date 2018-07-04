package arnrmn.mvp.utils.newsprovider

import arnrmn.mvp.utils.entity.Article
import arnrmn.mvp.utils.network.RestApi
import io.reactivex.Completable
import io.reactivex.Single
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class BbcNewsProvider @Inject constructor(
        private val restApi: RestApi
) : NewsProvider {
    override fun getNews(): Single<List<Article>> {
        return Completable.timer(2, TimeUnit.SECONDS)
                .andThen(restApi.getTopHeadlines (SOURCE))
                .map { response -> response.articles }
    }

    companion object {
        private const val SOURCE = "bbc-news"
    }
}