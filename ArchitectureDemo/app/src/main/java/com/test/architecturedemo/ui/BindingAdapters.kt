package com.test.architecturedemo.ui

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.test.architecturedemo.ui.home.HomeListAdapter

@BindingAdapter("bindHomeList")
fun bindHomeList(recyclerView: RecyclerView, list: List<String>?) {
    if (recyclerView.adapter == null) {
        val adapter = HomeListAdapter()
        recyclerView.adapter = adapter
    }
    (recyclerView.adapter as HomeListAdapter).submitList(list)
}