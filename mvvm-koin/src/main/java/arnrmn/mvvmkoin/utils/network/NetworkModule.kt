package arnrmn.mvvmkoin.utils.network

import arnrmn.mvvmkoin.app.IO
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import io.reactivex.Scheduler
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module.Module
import org.koin.dsl.module.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val networkModule: Module = module {
    factory { createOkHttpClient() }
    factory { provideRestApi(get()) }
    single { createRetrofit(get(), get(IO)) }
}

private fun createOkHttpClient(): OkHttpClient {
    return OkHttpClient.Builder()
            .addInterceptor(AuthInterceptor())
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .build()
}

private fun createRetrofit(client: OkHttpClient, scheduler: Scheduler): Retrofit {
    return Retrofit.Builder()
            .baseUrl("https://newsapi.org/v2/")
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(scheduler))
            .build()
}

private fun provideRestApi(retrofit: Retrofit): RestApi {
    return retrofit.create(RestApi::class.java)
}