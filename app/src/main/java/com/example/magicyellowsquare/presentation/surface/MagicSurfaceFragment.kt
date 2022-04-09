package com.example.magicyellowsquare.presentation.surface

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.magicyellowsquare.databinding.FragmentMagicSurfaceBinding
import com.example.magicyellowsquare.presentation.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MagicSurfaceFragment: BaseFragment<FragmentMagicSurfaceBinding, MagicSurfaceViewModel>() {

    override val viewModel: MagicSurfaceViewModel by viewModels()

    override fun getViewBinding(inflater: LayoutInflater, container: ViewGroup?) =
        FragmentMagicSurfaceBinding.inflate(inflater, container, false)

}