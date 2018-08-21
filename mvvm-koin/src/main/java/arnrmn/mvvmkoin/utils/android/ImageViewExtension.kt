package arnrmn.mvvmkoin.utils.android

import android.widget.ImageView
import com.squareup.picasso.Picasso

fun ImageView.loadUrl(url: String?) {
    if (url != null && url.isNotBlank()) {
        Picasso.get().load(url).into(this)
    }
}