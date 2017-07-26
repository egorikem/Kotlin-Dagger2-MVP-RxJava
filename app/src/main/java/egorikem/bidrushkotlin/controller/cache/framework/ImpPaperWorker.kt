package egorikem.bidrushkotlin.controller.cache.framework

/**
 * Created by egorikem on 2/5/17.
 */
class ImpPaperWorker<T>(private val book: String) : PaperWorker<T> {

    override fun set(key: String, value: T) {
        io.paperdb.Paper.book(book).write(key,value)
    }

    override fun set(key: String, value: List<T>) {
        io.paperdb.Paper.book(book).write(key,value)
    }

    override fun read(key: String): T? {
        val data: T = io.paperdb.Paper.book(book).read(key)
        return data
    }

    override fun remove(key: String) {
        io.paperdb.Paper.book(book).delete(key)
    }

}