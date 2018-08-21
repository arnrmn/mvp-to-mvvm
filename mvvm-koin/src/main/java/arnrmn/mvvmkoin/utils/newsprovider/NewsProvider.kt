package arnrmn.mvvmkoin.utils.newsprovider

import arnrmn.mvvmkoin.utils.entity.Article
import io.reactivex.Single

interface NewsProvider {
    fun getNews(): Single<List<Article>>
}