package egorikem.bidrushkotlin.presentation.presenter

import egorikem.bidrushkotlin.di.scope.PerActivity
import egorikem.bidrushkotlin.presentation.view.interfaces.UserScreenView

/**
 * Created by egorikem on 22/10/16.
 */
@PerActivity
class UserScreenPresenter(view: UserScreenView) : BasePresenter<UserScreenView>(view) {

}