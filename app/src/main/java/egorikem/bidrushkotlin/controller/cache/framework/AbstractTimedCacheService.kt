package egorikem.bidrushkotlin.controller.cache.framework

import egorikem.bidrushkotlin.controller.cache.TimedCacheObject

/**
 * Created by egorikem on 2/5/17.
 */
abstract class AbstractTimedCacheService<T> {

    private val timedPaperService: ImpTimedAbstractPaperService<T>
    private val executor: java.util.concurrent.Executor

    protected abstract fun provideTimedPaperService(): ImpTimedAbstractPaperService<T>

    constructor(executor: java.util.concurrent.Executor) {
        this.timedPaperService = provideTimedPaperService()
        this.executor = executor
    }

    fun readItem(id: String): rx.Observable<T?> {
        return rx.Observable.create {
            subscriber ->
            val timedCacheObj = timedPaperService.readItem(id)
//            if(timedCacheObj != null && timedCacheObj.isValid()) {
            if(timedCacheObj != null) {
                subscriber.onNext(timedCacheObj.getData())
                subscriber.onCompleted()
            }
            else {
                subscriber.onNext(null)
            }
        }
    }

    fun addItem(item: T) {
        executor.execute {
            timedPaperService.addItem(TimedCacheObject(item))
        }
    }

    fun addItem(index: Int, item: T) {
        executor.execute {
            timedPaperService.addItem(index, item = TimedCacheObject(item))
        }
    }

    fun addItem(item: T, ttl: Long) {
        executor.execute {
            timedPaperService.addItem(TimedCacheObject(item, ttl))
        }
    }

    fun readCollection(): rx.Observable<List<T>> {
        return rx.Observable.create {
            subscriber ->
                val list = timedPaperService.readCollection()
//                        .filter { it.isValid() }
                        .map {
                            it.getData()!!
                        }
                subscriber.onNext(list)
                subscriber.onCompleted()
        }
    }

    fun setCollection(collection: List<T>) {
        executor.execute {
            timedPaperService.setCollection(
                    collection.map {
                        TimedCacheObject(it)
                    }
            )
        }
    }

    fun updateCollection(collection: List<T>) {
        executor.execute {
            timedPaperService.updateCollection(
                    collection.map {
                        TimedCacheObject(it)
                    }
            )
        }
    }

    fun updateCollection(collection: List<T>, ttl: Long) {
        executor.execute {
            timedPaperService.updateCollection(
                    collection.map {
                        TimedCacheObject(it, ttl)
                    }
            )
        }
    }

    fun updateItem(item: T) {
        executor.execute {
            val newTimeCachedItem = TimedCacheObject(item)
            newTimeCachedItem.updateCreationTimestamp()
            timedPaperService.updateItem(
                    timedPaperService.comparator(newTimeCachedItem),
                    newTimeCachedItem
            )
        }
    }

    fun updateItem(item: T, ttl: Long) {
        executor.execute {
            timedPaperService.updateItem(
                    timedPaperService.comparator(TimedCacheObject(item)),
                    TimedCacheObject(item, ttl)
            )
        }
    }

    fun updateItem(itemId: String, item: T) {
        executor.execute {
            timedPaperService.updateItem(
                    itemId,
                    TimedCacheObject(item)
            )
        }
    }

    fun updateItem(itemId: String, item: T, ttl: Long) {
        executor.execute {
            timedPaperService.updateItem(
                    itemId,
                    TimedCacheObject(item, ttl)
            )
        }
    }

    fun removeItem(item: T) {
        executor.execute {
            timedPaperService.eraseItem(
                    timedPaperService.comparator(TimedCacheObject(item))
            )
        }
    }

    fun removeItem(id: String) {
        executor.execute {
            timedPaperService.eraseItem(
                    id // TODO Check if works
            )
        }
    }

    fun eraseCollection() {
        executor.execute {
            timedPaperService.eraseCollection()
        }
    }
}