package egorikem.bidrushkotlin.presentation.view.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.LinearLayout
import android.widget.Toast
import butterknife.BindView
import butterknife.ButterKnife
import egorikem.bidrushkotlin.R
import egorikem.bidrushkotlin.data.vo.UserVO
import egorikem.bidrushkotlin.di.component.DaggerUsersActivityComponent
import egorikem.bidrushkotlin.di.getAppComponent
import egorikem.bidrushkotlin.di.modules.NetworkDataProviderModule
import egorikem.bidrushkotlin.di.modules.UsersActivityModule
import egorikem.bidrushkotlin.di.modules.UsersControllerModule
import egorikem.bidrushkotlin.di.modules.cache.UsersCacheModule
import egorikem.bidrushkotlin.presentation.presenter.UsersActivityPresenter
import egorikem.bidrushkotlin.presentation.view.adapters.IUsersAdapter
import egorikem.bidrushkotlin.presentation.view.adapters.UsersAdapter
import egorikem.bidrushkotlin.presentation.view.interfaces.UsersActivityView

/**
 * Created by egorikem on 22/10/16.
 */
class UserActivity: BaseActivity<UsersActivityPresenter>(), UsersActivityView {

    //region ButerKnife

    @BindView(R.id.users_screen_rcv)
    lateinit var usersRecyclerView: RecyclerView

    //endregion

    //region Data

    private lateinit var adapter: UsersAdapter

    //endregion

    //region Lifecycle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.user_screen)

        ButterKnife.bind(this)

        initUi()
    }

    //endregion

    override fun inject() {
        DaggerUsersActivityComponent.builder()
                .appComponent(getAppComponent())
                .usersCacheModule(UsersCacheModule())
                .networkDataProviderModule(NetworkDataProviderModule())
                .usersControllerModule(UsersControllerModule())
                .usersActivityModule(UsersActivityModule(this))
                .build().inject(this)
    }

    override fun initUi() {
        usersRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, false)

        presenter.loadUsers()
    }

    //region Listeners

    private val usersCallback = object : IUsersAdapter {
        override fun onUserClick(data: UserVO) {
            presenter.loadUser(data.id)
        }
    }

    //endregion

    //region Implements

    override fun showUsers(data: MutableList<UserVO>?) {
        if(data != null) {
            adapter = UsersAdapter(data, usersCallback)
            usersRecyclerView.adapter = adapter
        }
    }

    override fun showUsersError(e: Throwable?) {
        e?.printStackTrace()
        Toast.makeText(
                    this,
                    "Error loading data!",
                    Toast.LENGTH_SHORT
        ).show()
    }

    override fun showUser(data: UserVO?) {
        if(data != null) {
            Toast.makeText(
                    this,
                    "User: ${data.name}",
                    Toast.LENGTH_SHORT
            ).show()
        }
    }

    override fun showUserError(e: Throwable?) {
        e?.printStackTrace()
        Toast.makeText(
                    this,
                    "Error loading data!",
                    Toast.LENGTH_SHORT
        ).show()
    }

    //endregion

    companion object {

        fun newIntent(packageContext: Context): Intent {
            val intent = Intent(packageContext, UserActivity::class.java)
            return intent
        }

    }
}