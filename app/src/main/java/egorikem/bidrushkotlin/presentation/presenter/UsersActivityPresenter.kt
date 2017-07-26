package egorikem.bidrushkotlin.presentation.presenter

import egorikem.bidrushkotlin.controller.IUsersController
import egorikem.bidrushkotlin.data.dto.UserDTO
import egorikem.bidrushkotlin.data.vo.UserVO
import egorikem.bidrushkotlin.data.vo.copyFrom
import egorikem.bidrushkotlin.di.scope.PerActivity
import egorikem.bidrushkotlin.presentation.view.interfaces.UsersActivityView
import rx.Completable
import rx.Subscriber
import rx.Subscription
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers
import javax.inject.Inject

/**
 * Created by egorikem on 22/10/16.
 */
@PerActivity
class UsersActivityPresenter : BasePresenter<UsersActivityView>{

    private val usersController: IUsersController

    @Inject
    constructor(view: UsersActivityView, usersController: IUsersController) : super(view) {
        this.usersController = usersController
    }

    fun loadUsers() {
        usersController.getUsers()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : Subscriber<List<UserDTO>>() {
                override fun onCompleted() {

                }

                override fun onNext(t: List<UserDTO>?) {
                    // Too lazy to add create user flow, so for now let's manually add another one(c)
                    val formattedData = t?.map { UserVO.copyFrom(t)!! }?.toMutableList()
                    val user = UserDTO(id = "0", firstName = "Test", lastName = "User", score = 100)
                    formattedData?.add(
                            UserVO.copyFrom(user)!!
                    )
                    //Huge overhead, but it's ok for test purposes
                    usersController.addUser(user)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(object : Completable.CompletableSubscriber {
                            override fun onSubscribe(d: Subscription?) {

                            }

                            override fun onError(e: Throwable?) {
                                view.showUserError(e)
                            }

                            override fun onCompleted() {
                                view.showUsers(
                                        formattedData
                                )
                            }
                        })

                }

                override fun onError(e: Throwable?) {
                    view.showUsersError(e)
                }
            })
    }

    fun loadUser(userId: String) {
        usersController.getUser(userId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : Subscriber<UserDTO>() {
                    override fun onCompleted() {

                    }

                    override fun onNext(t: UserDTO?) {
                        val formattedData = UserVO.copyFrom(t)!!
                        view.showUser(
                                formattedData
                        )
                        unsubscribe()
                    }

                    override fun onError(e: Throwable?) {
                        view.showUsersError(e)
                    }
                })
    }
}