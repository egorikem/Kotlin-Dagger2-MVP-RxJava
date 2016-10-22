package egorikem.bidrushkotlin.di.modules

import dagger.Module
import dagger.Provides
import egorikem.bidrushkotlin.di.scope.PerActivity
import retrofit2.Retrofit

/**
 * Created by egorikem on 22/10/16.
 */
@Module
class ApiModule {
    @Provides
    @PerActivity
    fun provideApiModule(retrofit: Retrofit): ApiModule {
        return retrofit.create(ApiModule::class.java)
    }
}