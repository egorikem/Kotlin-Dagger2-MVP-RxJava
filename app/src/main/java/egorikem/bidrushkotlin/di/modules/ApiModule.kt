package egorikem.bidrushkotlin.di.modules

import dagger.Module
import dagger.Provides
import egorikem.bidrushkotlin.controller.network.IBidRushApi
import retrofit2.Retrofit

/**
 * Created by egorikem on 22/10/16.
 */
@Module
class ApiModule {
    @Provides
    fun provideApiModule(retrofit: Retrofit): IBidRushApi {
        return retrofit.create(IBidRushApi::class.java)
    }
}