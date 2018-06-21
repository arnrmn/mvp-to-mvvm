package arnrmn.mvp.utils.network

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import dagger.Module
import dagger.Provides
import arnrmn.mvp.utils.dagger.IO
import io.reactivex.Scheduler
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.logging.HttpLoggingInterceptor.Level.BODY
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
abstract class NetworkModule {
    @Module
    companion object {
        private const val BASE_URL = "https://newsapi.org/v2/"

        @JvmStatic @Singleton @Provides
        fun createRetrofit(client: OkHttpClient, @IO scheduler: Scheduler): Retrofit {
            return Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(scheduler))
                    .build()
        }

        @JvmStatic @Provides
        fun provideOkHttpClient(): OkHttpClient {
            return OkHttpClient.Builder()
                    .addInterceptor(AuthInterceptor())
                    .addInterceptor(HttpLoggingInterceptor().setLevel(BODY))
                    .build()
        }

        @JvmStatic @Provides
        fun provideRestApi(retrofit: Retrofit): RestApi {
            return retrofit.create(RestApi::class.java)
        }
    }
}