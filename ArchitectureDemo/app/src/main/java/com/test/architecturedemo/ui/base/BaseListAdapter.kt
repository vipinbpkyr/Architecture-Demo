package com.test.architecturedemo.ui.base

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.AsyncDifferConfig
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import java.util.concurrent.Executors

open class BaseListAdapter<ListItemType, ViewBindingType : ViewDataBinding>(
    private val itemLayoutId: Int,
    private val bindingItemId: Int,
    private val bindingMap: HashMap<Int, Any> = HashMap(),
    areItemsSameLambda: (oldItem: ListItemType, newItem: ListItemType) -> Boolean = { oldItem, newItem ->
        oldItem?.equals(
            newItem
        ) ?: false
    },
    areContentsTheSame: (oldItem: ListItemType, newItem: ListItemType) -> Boolean = { _, _ -> false },
    diffCallback: DiffUtil.ItemCallback<ListItemType> = object :
        DiffUtil.ItemCallback<ListItemType>() {
        override fun areItemsTheSame(oldItem: ListItemType, newItem: ListItemType) =
            areItemsSameLambda(oldItem, newItem)

        override fun areContentsTheSame(oldItem: ListItemType, newItem: ListItemType) =
            areContentsTheSame(oldItem, newItem)
    }
) : ListAdapter<ListItemType, BaseListAdapter<ListItemType, ViewBindingType>.BaseViewHolder>(
    AsyncDifferConfig.Builder<ListItemType>(diffCallback)
        .setBackgroundThreadExecutor(Executors.newSingleThreadExecutor())
        .build()
) {

    /***************************************
     * Declarations
     ***************************************/
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BaseViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = DataBindingUtil.inflate<ViewBindingType>(
            layoutInflater,
            itemLayoutId,
            parent,
            false
        )
        return BaseViewHolder(binding)
    }

    /***************************************
     * Declarations
     ***************************************/
    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        holder.binding.run {
            setVariable(bindingItemId, getItem(position))
            bindingMap.keys.forEach {
                setVariable(it, bindingMap[it])
            }
            onBind(this, getItem(position), position)
        }
    }

    /***************************************
     * Declarations
     ***************************************/
    open fun onBind(binding: ViewBindingType, item: ListItemType, position: Int) {

    }

    /***************************************
     * Declarations
     ***************************************/
    open inner class BaseViewHolder constructor(val binding: ViewBindingType) :
        RecyclerView.ViewHolder(binding.root)
}

