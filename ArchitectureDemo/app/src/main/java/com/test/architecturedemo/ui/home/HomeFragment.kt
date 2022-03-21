package com.test.architecturedemo.ui.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.test.architecturedemo.R
import com.test.architecturedemo.databinding.FragmentHomeBinding
import com.test.architecturedemo.ui.base.BaseFragment

/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment() : BaseFragment<HomeViewModel, FragmentHomeBinding>(R.layout.fragment_home) {
    override val viewModel: HomeViewModel by viewModels()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.setList()
    }
}