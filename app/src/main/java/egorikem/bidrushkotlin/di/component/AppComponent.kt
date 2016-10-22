package egorikem.bidrushkotlin.di.component

import android.content.Context
import dagger.Component
import egorikem.bidrushkotlin.di.modules.AppModule
import javax.inject.Singleton

/**
 * Created by egorikem on 22/10/16.
 */
@Singleton
@Component(
        modules = arrayOf(AppModule::class)
)
interface AppComponent {
    fun getAppContext() : Context
}