package egorikem.bidrushkotlin.di.modules

import dagger.Module
import dagger.Provides
import egorikem.bidrushkotlin.data.network.IBidRushApi
import egorikem.bidrushkotlin.data.network.NetworkDataProvider
import egorikem.bidrushkotlin.di.scope.PerActivity

/**
 * Created by egorikem on 22/10/16.
 */
@Module
class NetworkDataProviderModule {
    @Provides
    @PerActivity
    fun provideNetworkDataProvider(api: IBidRushApi): NetworkDataProvider {
        return NetworkDataProvider(api)
    }
}