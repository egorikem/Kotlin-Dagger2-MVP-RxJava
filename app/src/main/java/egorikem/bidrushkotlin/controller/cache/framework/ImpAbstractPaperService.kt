package egorikem.bidrushkotlin.controller.cache.framework

import egorikem.bidrushkotlin.di.getAppComponent
import io.paperdb.Paper
import java.util.*

/**
 * Created by egorikem on 2/5/17.
 */
abstract class ImpAbstractPaperService<T>: AbstractPaperService<T> {

    abstract fun setBook(): String
    abstract fun setKey(): String

    protected val genericPaperWorker: ImpPaperWorker<T>

    abstract fun comparator(item: T): String

    constructor() {
        this.genericPaperWorker = ImpPaperWorker(setBook())
        Paper.init(getAppComponent()!!.getAppContext())
    }

    override fun readItem(itemId: String): T? {
        var itemList = genericPaperWorker.read(setKey()) as List<T>?
        if(itemList != null) {
            return itemList.find { comparator(it) == itemId }
        }
        return null
    }

    override fun updateItem(itemId: String, item: T) {
        var itemList = genericPaperWorker.read(setKey()) as ArrayList<T>?

        if(itemList == null) {
            itemList = ArrayList()
        }

        var oldItem = itemList.find { comparator(it) == itemId }
        if(oldItem != null) {
            itemList[itemList.indexOf(oldItem)] = item
        }
        else {
            itemList.add(item)
        }
        genericPaperWorker.set(setKey(), itemList)
    }

    override fun updateCollection(collection: List<T>) {
        genericPaperWorker.set(setKey(), collection)
    }

    override fun eraseItem(itemId: String) {
        var itemList = genericPaperWorker.read(setKey()) as List<T>?
        if(itemList != null) {
            itemList = itemList.filter { comparator(it) != itemId }
            genericPaperWorker.set(setKey(), itemList)
        }
    }

    override fun readCollection(): List<T> {
        val itemList = genericPaperWorker.read(setKey()) as ArrayList<T>? ?: return ArrayList()
        return itemList
    }

    override fun addItem(item: T) {
        var itemList = genericPaperWorker.read(setKey()) as ArrayList<T>?
        if(itemList == null) {
            itemList = ArrayList()
        }

        if(!itemList.contains(item)) {
            itemList.add(item)
            genericPaperWorker.set(setKey(), itemList)
        }
    }

    override fun addItem(index: Int, item: T) {
        var itemList = genericPaperWorker.read(setKey()) as ArrayList<T>?
        if(itemList == null) {
            itemList = ArrayList()
        }

        if(!itemList.contains(item)) {
            itemList.add(index, item)
            genericPaperWorker.set(setKey(), itemList)
        }
    }

    override fun setCollection(collection: List<T>) {
        genericPaperWorker.set(setKey(), collection)
    }

    override fun eraseCollection() {
        genericPaperWorker.remove(setKey())
    }
}