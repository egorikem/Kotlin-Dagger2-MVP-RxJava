package egorikem.bidrushkotlin.controller.cache.framework

/**
 * Created by egorikem on 2/5/17.
 */
interface PaperWorker<T> {
    fun set(key: String, value: T)
    fun set(key: String, value: List<T>)
    fun read(key: String): T?
    fun remove(key: String)
}