package egorikem.bidrushkotlin.presentation

import android.app.Application
import egorikem.bidrushkotlin.di.initializeAppComponent

/**
 * Created by egorikem on 22/10/16.
 */
class BidRushKotlinApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        initializeAppComponent(this)
    }
}