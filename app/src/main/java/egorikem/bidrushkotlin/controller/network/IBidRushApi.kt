package egorikem.bidrushkotlin.controller.network

import egorikem.bidrushkotlin.data.dto.UserDTO
import retrofit2.http.GET
import retrofit2.http.Query
import rx.Observable

/**
 * Created by egorikem on 22/10/16.
 */
interface IBidRushApi {
    @GET("user")
    fun getUser(@Query("id") id: String): Observable<UserDTO>

    @GET("user")
    fun getUsers(): Observable<List<UserDTO>>
}