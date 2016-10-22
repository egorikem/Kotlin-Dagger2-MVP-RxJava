package egorikem.bidrushkotlin.presentation.presenter

import android.content.Intent
import android.os.Bundle
import egorikem.bidrushkotlin.presentation.view.interfaces.BaseView

/**
 * Created by egorikem on 22/10/16.
 */
@Suppress("UNUSED_PARAMETER")
abstract class BasePresenter<out V : BaseView>(val view: V) {

    fun onCreate(state: Bundle?) {

    }

    fun onViewCreated() {

    }

    fun onStart() {

    }

    fun onStop() {

    }

    fun onSaveInstanceState(state: Bundle?) {

    }

    fun onDestroy() {

    }

    fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent) {

    }
}
