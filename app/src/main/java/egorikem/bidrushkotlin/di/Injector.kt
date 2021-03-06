package egorikem.bidrushkotlin.di

import android.app.Application
import egorikem.bidrushkotlin.di.component.AppComponent
import egorikem.bidrushkotlin.di.component.DaggerAppComponent
import egorikem.bidrushkotlin.di.modules.ApiModule
import egorikem.bidrushkotlin.di.modules.AppModule
import egorikem.bidrushkotlin.di.modules.ExecutorModule
import egorikem.bidrushkotlin.di.modules.RetrofitModule
import java.util.*

/**
 * Created by egorikem on 22/10/16.
 */

private var appComponent: AppComponent? = null

fun initializeAppComponent(application: Application) {
    appComponent = DaggerAppComponent.builder()
                .appModule(AppModule(application))
                .executorModule(ExecutorModule())
                .apiModule(ApiModule())
                .retrofitModule(RetrofitModule("http://website.com"))
                .build()
}

fun getAppComponent(): AppComponent? {
    Objects.requireNonNull(appComponent, "AppComponent is null")
    return appComponent
}
