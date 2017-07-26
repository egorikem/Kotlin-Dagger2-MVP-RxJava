package egorikem.bidrushkotlin.di.modules

import dagger.Module
import dagger.Provides
import java.util.concurrent.Executor
import java.util.concurrent.Executors

/**
 * Created by egorikem on 7/26/17.
 */
@Module
class ExecutorModule {
    @Provides
    fun provideExecutor(): Executor {
        return Executors.newCachedThreadPool()
    }
}