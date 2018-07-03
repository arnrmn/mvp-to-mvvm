package arnrmn.mvvm.utils.entity

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class Article(
        val author: String,
        val title: String,
        val description: String,
        val url: String,
        val urlToImage: String,
        val publishedAt: String
): Parcelable