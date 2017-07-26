package egorikem.bidrushkotlin.controller.cache.framework

/**
 * Created by egorikem on 2/5/17.
 */
interface AbstractPaperService<T> {
    fun readItem(itemId: String): T?
    fun readCollection(): List<T>
    fun updateItem(itemId: String, item: T)
    fun updateCollection(collection: List<T>)
    fun addItem(item: T)
    fun addItem(index: Int, item: T)
    fun setCollection(collection: List<T>)
    fun eraseItem(itemId: String)
    fun eraseCollection()
}