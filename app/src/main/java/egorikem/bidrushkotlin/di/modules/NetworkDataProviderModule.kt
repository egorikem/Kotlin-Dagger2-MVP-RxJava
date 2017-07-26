package egorikem.bidrushkotlin.di.modules

import dagger.Module
import dagger.Provides
import egorikem.bidrushkotlin.controller.network.IBidRushApi
import egorikem.bidrushkotlin.controller.network.NetworkDataProvider

/**
 * Created by egorikem on 22/10/16.
 */
@Module
class NetworkDataProviderModule {
    @Provides
    fun provideNetworkDataProvider(api: IBidRushApi): NetworkDataProvider {
        return NetworkDataProvider(api)
    }
}