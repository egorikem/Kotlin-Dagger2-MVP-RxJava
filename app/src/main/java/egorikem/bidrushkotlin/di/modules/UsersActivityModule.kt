package egorikem.bidrushkotlin.di.modules

import dagger.Module
import dagger.Provides
import egorikem.bidrushkotlin.controller.IUsersController
import egorikem.bidrushkotlin.presentation.presenter.UsersActivityPresenter
import egorikem.bidrushkotlin.presentation.view.interfaces.UsersActivityView

/**
 * Created by egorikem on 22/10/16.
 */
@Module
class UsersActivityModule(var view: UsersActivityView) {
    @Provides
    fun provideUserScreenPresenter(usersController: IUsersController): UsersActivityPresenter {
        return UsersActivityPresenter(view, usersController = usersController)
    }
}