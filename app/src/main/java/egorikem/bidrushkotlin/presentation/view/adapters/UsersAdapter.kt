package egorikem.bidrushkotlin.presentation.view.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import butterknife.BindView
import butterknife.ButterKnife
import butterknife.Unbinder
import egorikem.bidrushkotlin.R
import egorikem.bidrushkotlin.data.vo.UserVO

/**
 * Created by egorikem on 7/26/17.
 */
class UsersAdapter (dataSet: MutableList<UserVO>, val callback: IUsersAdapter) : AbstractArrayAdapter<UserVO, UsersAdapter.BaseUserAdapter>(dataSet) {

    enum class Type(val value: Int) {
        SIMPLE(1)
    }

    private val simpleCellId = R.layout.user_item

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseUserAdapter {
        val inflater = LayoutInflater.from(parent.context)
        val itemView: View
        var dataHolder: BaseUserAdapter? = null
        when(viewType) {
            Type.SIMPLE.value -> {
                itemView  = inflater.inflate(simpleCellId, parent, false)
                dataHolder = NormalUserAdapter(itemView, callback)
            }
        }
        return dataHolder!!
    }

    override fun getItemViewType(position: Int): Int {
        return Type.SIMPLE.value
    }

    override fun onBindViewHolder(holder: BaseUserAdapter, position: Int) {
        holder.bindData(getItemAtPosition(position))
    }

    abstract class BaseUserAdapter(itemView: View?, protected var callback: IUsersAdapter) : RecyclerView.ViewHolder(itemView) {
        protected var unbinder: Unbinder? = null
        protected lateinit var data: UserVO
        abstract fun bindData(data: UserVO)
    }

    class NormalUserAdapter(itemView: View?, callback: IUsersAdapter) : BaseUserAdapter(itemView, callback) {

        init {
            unbinder = ButterKnife.bind(this, itemView!!)
        }

        @BindView(R.id.user_item_name_tv)
        lateinit var nameTv: TextView

        @BindView(R.id.user_item_score_tv)
        lateinit var scoreTv: TextView

        override fun bindData(data: UserVO) {
            nameTv.text = data.name
            scoreTv.text = "${data.score}"

            itemView.setOnClickListener {
                callback.onUserClick(data)
            }
        }
    }
}