package egorikem.bidrushkotlin.presentation.view.interfaces

import egorikem.bidrushkotlin.data.vo.UserVO

/**
 * Created by egorikem on 22/10/16.
 */
interface UsersActivityView : BaseView {
    fun showUsers(data: MutableList<UserVO>?)
    fun showUsersError(e: Throwable?)

    fun showUser(data: UserVO?)
    fun showUserError(e: Throwable?)
}