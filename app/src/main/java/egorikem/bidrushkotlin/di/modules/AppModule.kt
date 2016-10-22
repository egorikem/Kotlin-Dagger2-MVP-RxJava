package egorikem.bidrushkotlin.di.modules

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by egorikem on 22/10/16.
 */
@Module
class AppModule(private val application: Application) {
    @Provides
    @Singleton
    fun provideAppContext(): Context {
        return application.applicationContext
    }
}