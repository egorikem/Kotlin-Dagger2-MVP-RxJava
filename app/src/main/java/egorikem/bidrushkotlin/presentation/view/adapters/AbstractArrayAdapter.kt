package egorikem.bidrushkotlin.presentation.view.adapters

import android.support.annotation.Nullable
import android.support.v7.widget.RecyclerView
import java.util.*

/**
 * Created by egorikem on 2/4/17.
 */
abstract class AbstractArrayAdapter<ITEM, VH : RecyclerView.ViewHolder>
/**
 * Constructs adapter with provided data set. Passing null as a parameter construct adapter with
 * empty list as data set

 * @param dataSet data set or null
 * *
 * @see .addItem
 * @see .setCollection
 */
internal constructor(@Nullable dataSet: MutableList<ITEM>?) : RecyclerView.Adapter<VH>() {

    override fun getItemCount(): Int {
        return dataSet.size
    }

    private val dataSet: MutableList<ITEM>

    init {
        if (dataSet != null) {
            this.dataSet = dataSet
        } else {
            this.dataSet = ArrayList()
        }
    }

    /**
     * Returns item from data set located at specified position

     * @param position position
     * *
     * @return item
     */
    internal fun getItemAtPosition(position: Int): ITEM {
        return dataSet[position]
    }

    /**
     * Adds item to collection and notifies adapter about changes

     * @param item item
     */
    fun addItem(item: ITEM) {
        val position = dataSet.size
        dataSet.add(item)
        notifyItemInserted(position)
    }

    /**
     * Returns dataset

     * *
     * @return dataset
     */
    fun getDataset(): List<ITEM> {
        return this.dataSet
    }

    /**
     * Merge existing collection with new one and notifies adapter about changes

     * @param items new collection
     * *
     * @see .replaceCollection
     */
    fun addCollection(items: List<ITEM>) {
        val positionStart = dataSet.size
        val itemCount = items.size

        dataSet.addAll(items)
        notifyItemRangeInserted(positionStart, itemCount)
    }

    /**
     * Replace existing collection with new one and notifies adapter about changes

     * @param items new collection
     * *
     * @see .setCollection
     */
    fun replaceCollection(items: List<ITEM>) {
        if (dataSet.size != 0) {
            removeAll()
        }
        addCollection(items)
    }

    /**
     * Remove item from collection at given position and notifies adapter about changes

     * @param position item position
     * *
     * @see .removeAll
     */
    fun removeItem(position: Int) {
        dataSet.removeAt(position)
        notifyItemRemoved(position)
    }

    fun updateItem(index: Int, item: ITEM) {
        if(dataSet.size-1>=index && dataSet.contains(item)) {
            dataSet[index] = item
            notifyItemChanged(index)
        }
    }

    fun updateItem(item: ITEM) {
        val index: Int? = dataSet.indexOf(item)
        if(index != null) {
            updateItem(index,item)
        }
    }

    /**
     * Remove all items from collection leaving it empty and notifies adapter about changes

     * @see .removeItem
     */
    fun removeAll() {
        val positionStart = 0
        val itemCount = dataSet.size

        dataSet.clear()
        notifyItemRangeRemoved(positionStart, itemCount)
    }
}