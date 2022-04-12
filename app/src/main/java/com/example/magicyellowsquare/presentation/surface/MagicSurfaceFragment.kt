package com.example.magicyellowsquare.presentation.surface

import android.os.Bundle
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.magicyellowsquare.R
import com.example.magicyellowsquare.databinding.FragmentMagicSurfaceBinding
import com.example.magicyellowsquare.presentation.BaseFragment
import com.example.magicyellowsquare.util.observeInLifecycle
import com.example.magicyellowsquare.util.showToast
import com.example.magicyellowsquare.util.toStringDate
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.onEach

@AndroidEntryPoint
class MagicSurfaceFragment : BaseFragment<FragmentMagicSurfaceBinding, MagicSurfaceViewModel>(),
    View.OnTouchListener {

    override val viewModel: MagicSurfaceViewModel by viewModels()

    private var dX = 0f
    private var dY = 0f

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as AppCompatActivity).supportActionBar?.apply {
            show()
            title = getString(R.string.app_name)
            setDisplayShowTitleEnabled(true)
        }

        binding.dragViewSurface.setOnTouchListener(this)
        setupUi()
    }

    private fun setupUi() {
        setupButton()
        subscribeToCollects()
    }

    private fun setupButton() = with(binding) {
        buttonDataHistorySurface.setOnClickListener {
            viewModel.onNavigateToMagicDataScreen()
        }
    }

    private fun subscribeToCollects() = with(binding) {
        viewModel.getLastMagicData
            .onEach { magicData ->
                dragViewSurface.apply {
                    x = magicData.positionX.toFloat()
                    y = magicData.positionY.toFloat()
                }
            }
            .observeInLifecycle(viewLifecycleOwner)

        collectEvents()
    }

    private fun collectEvents() {
        viewModel.magicalSurfaceFlowEvent
            .onEach { event ->
                when (event) {
                    is MagicSurfaceViewModel.MagicSurfaceUiEvent.NavigateToMagicDataScreen -> {
                        val action =
                            MagicSurfaceFragmentDirections.actionSurfaceFragmentToMagicDataFragment()
                        findNavController().navigate(action)
                    }
                    is MagicSurfaceViewModel.MagicSurfaceUiEvent.ShowToastMessage -> context?.showToast(
                        event.message
                    )
                }
            }
            .observeInLifecycle(viewLifecycleOwner)
    }

    override fun onTouch(view: View, event: MotionEvent): Boolean {
        when (event.actionMasked) {
            MotionEvent.ACTION_DOWN -> {
                dX = view.x - event.rawX
                dY = view.y - event.rawY
            }
            MotionEvent.ACTION_MOVE -> {
                view.y = event.rawY + dY
                view.x = event.rawX + dX
            }
            MotionEvent.ACTION_UP -> {
                viewModel.onEvent(
                    MagicSurfaceEvent.SaveMagicData(
                        view.x.toDouble(),
                        view.y.toDouble()
                    )
                )
                viewModel.onShowToastMessage(
                    getString(
                        R.string.magic_surface_toast,
                        view.x,
                        view.y,
                        toStringDate()
                    )
                )
            }
            else -> return false
        }
        return true
    }

    override fun getViewBinding(inflater: LayoutInflater, container: ViewGroup?) =
        FragmentMagicSurfaceBinding.inflate(inflater, container, false)

}