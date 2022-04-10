package com.example.magicyellowsquare.presentation.data

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.magicyellowsquare.databinding.FragmentMagicDataBinding
import com.example.magicyellowsquare.presentation.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MagicDataFragment: BaseFragment<FragmentMagicDataBinding, MagicDataViewModel>() {

    override val viewModel: MagicDataViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.onEvent(MagicDataEvent.GetAllMagicData)
    }

    override fun getViewBinding(inflater: LayoutInflater, container: ViewGroup?) =
        FragmentMagicDataBinding.inflate(inflater, container, false)

}