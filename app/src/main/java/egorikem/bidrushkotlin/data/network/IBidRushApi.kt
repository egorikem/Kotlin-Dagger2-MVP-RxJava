package egorikem.bidrushkotlin.data.network

import egorikem.bidrushkotlin.data.dto.User
import retrofit2.http.GET
import retrofit2.http.Query
import rx.Observable

/**
 * Created by egorikem on 22/10/16.
 */
interface IBidRushApi {
    @GET("user")
    fun getUser(@Query("id") id: String): Observable<User>

    @GET("user")
    fun getUsers(): Observable<List<User>>
}