package egorikem.bidrushkotlin.controller.cache

/**
 * Created by egorikem on 2/5/17.
 */
class TimedCacheObject<T> {

    private val data: T?
    private var creationTimestamp: Long?
    private val ttl: Long?

    constructor() {
        data = null
        creationTimestamp = null
        ttl = null
    }

    constructor(data: T) {
        this.data = data
        ttl = 3600000
        this.creationTimestamp = createTimestamp()
    }

    constructor(data: T, ttl: Long) {
        this.data = data
        this.ttl = ttl
        this.creationTimestamp = createTimestamp()
    }

    fun isValid(): Boolean {
        return (creationTimestamp!!+ttl!!) >= getCurrentSystemTime()
    }

    fun updateCreationTimestamp() {
        this.creationTimestamp = createTimestamp()
    }

    //region Get/Set

    fun getData(): T? {
        return data
    }

    fun getCreationTimeStamp(): Long? {
        return creationTimestamp
    }

    fun getTtl(): Long? {
        return ttl
    }

    //endregion

    //region Private Helpers

    private fun createTimestamp(): Long {
        return getCurrentSystemTime()
    }

    private fun getCurrentSystemTime(): Long {
        return System.currentTimeMillis()
    }

    //endregion
}
