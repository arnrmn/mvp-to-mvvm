package arnrmn.mvvm.newspager

import android.content.Context
import android.content.Intent
import android.os.Bundle
import arnrmn.mvvm.utils.android.BaseActivity

class NewsPagerActivity: BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    companion object {
        fun start(context: Context?) {
            context?.startActivity(createIntent(context))
        }

        fun createIntent(context: Context?): Intent {
            return Intent(context, NewsPagerActivity::class.java)
        }
    }
}