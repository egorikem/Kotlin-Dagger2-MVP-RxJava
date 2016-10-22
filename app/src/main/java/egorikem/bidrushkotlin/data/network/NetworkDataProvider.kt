package egorikem.bidrushkotlin.data.network

import egorikem.bidrushkotlin.data.dto.User
import rx.Observable
import rx.schedulers.Schedulers

/**
 * Created by egorikem on 22/10/16.
 */
class NetworkDataProvider(val api: IBidRushApi) : INetworkDataProvider {

    override fun getAllUsers(): Observable<List<User>> = api.getUsers()
            .subscribeOn(Schedulers.io())
            .map { it }


    override fun getUser(id: String): Observable<User> = api.getUser(id)
            .subscribeOn(Schedulers.io())
            .map { it }
}