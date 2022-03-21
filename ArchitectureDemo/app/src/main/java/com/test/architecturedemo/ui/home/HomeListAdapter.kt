package com.test.architecturedemo.ui.home

import com.test.architecturedemo.BR
import com.test.architecturedemo.R
import com.test.architecturedemo.databinding.HomeItemBinding
import com.test.architecturedemo.ui.base.BaseListAdapter

class HomeListAdapter : BaseListAdapter<String, HomeItemBinding>(
    itemLayoutId = R.layout.home_item,
    bindingItemId = BR.data,
    areItemsSameLambda = { oldItem, newItem -> oldItem == newItem},
    areContentsTheSame = { oldItem, newItem -> oldItem == newItem}
) {
}