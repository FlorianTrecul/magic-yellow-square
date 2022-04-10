package com.example.magicyellowsquare.presentation.surface

import android.os.Bundle
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.magicyellowsquare.databinding.FragmentMagicSurfaceBinding
import com.example.magicyellowsquare.presentation.BaseFragment
import com.example.magicyellowsquare.util.observeInLifecycle
import com.example.magicyellowsquare.util.toStringDate
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.onEach

@AndroidEntryPoint
class MagicSurfaceFragment: BaseFragment<FragmentMagicSurfaceBinding, MagicSurfaceViewModel>(), View.OnTouchListener {

    override val viewModel: MagicSurfaceViewModel by viewModels()

    private var dX = 0f
    private var dY = 0f

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.dragViewSurface.setOnTouchListener(this)
        setupUi()
    }

    private fun setupUi() {
        setupButton()
        collectEvents()
    }

    private fun setupButton() = with(binding) {
        buttonDataHistorySurface.setOnClickListener {
            viewModel.onNavigateToMagicDataScreen()
        }
    }

    private fun collectEvents() {
        viewModel.magicalSurfaceFlowEvent
            .onEach { event ->
                when (event) {
                    is MagicSurfaceViewModel.MagicSurfaceUiEvent.NavigateToMagicDataScreen -> {
                        val action = MagicSurfaceFragmentDirections.actionSurfaceFragmentToMagicDataFragment()
                        findNavController().navigate(action)
                    }
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
                viewModel.onEvent(MagicSurfaceEvent.SaveMagicData(view.x.toDouble(), view.y.toDouble()))
                Toast.makeText(requireContext(), "X : ${view.x} && Y : ${view.y} && Date : ${toStringDate()}", Toast.LENGTH_SHORT).show()
            }
            else -> return false
        }
        return true
    }

    override fun getViewBinding(inflater: LayoutInflater, container: ViewGroup?) =
        FragmentMagicSurfaceBinding.inflate(inflater, container, false)

}