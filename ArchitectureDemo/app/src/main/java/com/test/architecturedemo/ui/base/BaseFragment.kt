package com.test.architecturedemo.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import com.test.architecturedemo.BR

abstract class BaseFragment<ViewModelType : BaseViewModel, DataBindingType : ViewDataBinding>(
    private val layoutId: Int
) : Fragment() {
    protected lateinit var binding: DataBindingType
    abstract val viewModel: ViewModelType

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding =
            DataBindingUtil.inflate(inflater, layoutId, container, false) as DataBindingType
        binding.setVariable(BR.viewModel, viewModel)
        binding.lifecycleOwner = viewLifecycleOwner

        return binding.root
    }
}