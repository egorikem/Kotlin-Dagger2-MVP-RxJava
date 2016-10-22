package egorikem.bidrushkotlin.presentation.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import egorikem.bidrushkotlin.R
import egorikem.bidrushkotlin.di.component.DaggerUsersScreenComponent
import egorikem.bidrushkotlin.di.getAppComponent
import egorikem.bidrushkotlin.di.modules.UsersScreenModule
import egorikem.bidrushkotlin.presentation.presenter.UserScreenPresenter
import egorikem.bidrushkotlin.presentation.view.interfaces.UserScreenView

/**
 * Created by egorikem on 22/10/16.
 */
class UserFragment : BaseFragment<UserScreenPresenter>(), UserScreenView {

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view: View = inflater!!.inflate(R.layout.user_screen, container, false)

        return view
    }

    override fun inject() {
        DaggerUsersScreenComponent.builder()
                .appComponent(getAppComponent())
                .usersScreenModule(UsersScreenModule(this))
                .build().inject(this)
    }
}