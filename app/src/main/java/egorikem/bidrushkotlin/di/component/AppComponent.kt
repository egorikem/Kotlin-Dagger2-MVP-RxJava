package egorikem.bidrushkotlin.di.component

import android.content.Context
import dagger.Component
import egorikem.bidrushkotlin.controller.network.IBidRushApi
import egorikem.bidrushkotlin.di.modules.ApiModule
import egorikem.bidrushkotlin.di.modules.AppModule
import egorikem.bidrushkotlin.di.modules.ExecutorModule
import egorikem.bidrushkotlin.di.modules.RetrofitModule
import retrofit2.Retrofit
import java.util.concurrent.Executor
import javax.inject.Singleton

/**
 * Created by egorikem on 22/10/16.
 */
@Singleton
@Component(
        modules = arrayOf(
                AppModule::class,
                ExecutorModule::class,
                ApiModule::class,
                RetrofitModule::class
        )
)
interface AppComponent {
    fun getAppContext() : Context
    fun provideExecutor(): Executor
    fun provideApi(): IBidRushApi
    fun provideRetofit(): Retrofit
}