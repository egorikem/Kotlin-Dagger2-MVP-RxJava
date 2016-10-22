package egorikem.bidrushkotlin.di.modules

import dagger.Module
import dagger.Provides
import egorikem.bidrushkotlin.di.scope.PerActivity
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by egorikem on 22/10/16.
 */
@Module
class RetrofitModule(val api: String) {
    @Provides
    @PerActivity
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(api)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}