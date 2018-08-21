package arnrmn.mvvmkoin.utils.network

import okhttp3.Interceptor
import okhttp3.Response

class AuthInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val url = request.url().newBuilder().addQueryParameter(QUERY, KEY).build()
        val newRequest = request.newBuilder().url(url).build()
        return chain.proceed(newRequest)
    }

    companion object {
        private const val QUERY = "apiKey"
        private const val KEY = "57a79eac5a8f44efa2bd3408139b83f3"
    }
}