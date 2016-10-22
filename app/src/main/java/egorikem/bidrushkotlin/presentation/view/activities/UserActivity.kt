package egorikem.bidrushkotlin.presentation.view.activities

import android.os.Bundle
import egorikem.bidrushkotlin.data.dto.User
import egorikem.bidrushkotlin.data.network.NetworkDataProvider
import egorikem.bidrushkotlin.di.component.DaggerUsersScreenComponent
import egorikem.bidrushkotlin.di.getAppComponent
import egorikem.bidrushkotlin.di.modules.NetworkDataProviderModule
import egorikem.bidrushkotlin.di.modules.UsersScreenModule
import egorikem.bidrushkotlin.presentation.presenter.UserScreenPresenter
import egorikem.bidrushkotlin.presentation.view.interfaces.UserScreenView
import rx.observers.TestSubscriber
import javax.inject.Inject

/**
 * Created by egorikem on 22/10/16.
 */
class UserActivity: BaseActivity<UserScreenPresenter>(), UserScreenView {

    @Inject
    lateinit var networkDataProvider: NetworkDataProvider

    lateinit var testSubscriber : TestSubscriber<List<User>>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        testSubscriber = TestSubscriber.create()

        networkDataProvider.getAllUsers().subscribe(testSubscriber)

        testSubscriber.awaitTerminalEvent()

    }

    override fun inject() {
        DaggerUsersScreenComponent.builder()
                .appComponent(getAppComponent())
                .usersScreenModule(UsersScreenModule(this))
                .networkDataProviderModule(NetworkDataProviderModule())
                .build().inject(this)
    }
}