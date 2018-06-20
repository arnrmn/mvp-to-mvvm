package arnrmn.mvp.utils.network

import arnrmn.mvp.utils.network.response.ArticlesResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface RestApi {
    @GET("top-headlines")
    fun getTopHeadlines(@Query("sources") source: String): Single<ArticlesResponse>
}