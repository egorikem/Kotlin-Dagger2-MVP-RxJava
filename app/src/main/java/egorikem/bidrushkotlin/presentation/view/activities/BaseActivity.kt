package egorikem.bidrushkotlin.presentation.view.activities

import android.content.Intent
import android.os.Bundle
import android.support.annotation.CallSuper
import android.support.v7.app.AppCompatActivity
import egorikem.bidrushkotlin.presentation.presenter.BasePresenter
import javax.inject.Inject

/**
 * Created by egorikem on 22/10/16.
 */
abstract class BaseActivity<P : BasePresenter<*>> : AppCompatActivity() {

    @Inject
    protected lateinit var presenter: P

    @CallSuper
    override fun onCreate(savedInstanceState: Bundle?) {
        inject()
        super.onCreate(savedInstanceState)
    }

    @CallSuper
    override fun onStart() {
        super.onStart()
        presenter.onStart()
        presenter.onViewCreated()
    }

    @CallSuper
    override fun onStop() {
        super.onStop()
        presenter.onStart()
    }

    @CallSuper
    override fun onDestroy() {
        super.onDestroy()
        presenter.onDestroy()
    }

    @CallSuper
    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        presenter.onSaveInstanceState(outState)
    }

    @CallSuper
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent) {
        super.onActivityResult(requestCode, resultCode, data)
        presenter.onActivityResult(requestCode,resultCode, data)
    }

    abstract fun inject()
    abstract fun initUi()
}