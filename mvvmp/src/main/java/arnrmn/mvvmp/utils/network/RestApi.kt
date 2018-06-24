package arnrmn.mvvmp.utils.network

import arnrmn.mvvmp.utils.network.response.ArticlesResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface RestApi {
    @GET("top-headlines")
    fun getTopHeadlines(@Query("sources") source: String): Single<ArticlesResponse>
}