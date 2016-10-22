package egorikem.bidrushkotlin.di.modules

import dagger.Module
import dagger.Provides
import egorikem.bidrushkotlin.di.scope.PerActivity
import egorikem.bidrushkotlin.presentation.presenter.UserScreenPresenter
import egorikem.bidrushkotlin.presentation.view.interfaces.UserScreenView

/**
 * Created by egorikem on 22/10/16.
 */
@Module
class UsersScreenModule(var view: UserScreenView) {

    @Provides
    @PerActivity
    fun provideUserScreenPresenter(): UserScreenPresenter {
        return UserScreenPresenter(view)
    }
}