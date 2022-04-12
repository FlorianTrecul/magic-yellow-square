package com.example.magicyellowsquare.presentation.data

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.magicyellowsquare.R
import com.example.magicyellowsquare.databinding.FragmentMagicDataBinding
import com.example.magicyellowsquare.presentation.BaseFragment
import com.example.magicyellowsquare.util.hide
import com.example.magicyellowsquare.util.observeInLifecycle
import com.example.magicyellowsquare.util.show
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.onEach

@AndroidEntryPoint
class MagicDataFragment: BaseFragment<FragmentMagicDataBinding, MagicDataViewModel>() {

    override val viewModel: MagicDataViewModel by viewModels()

    private lateinit var magicDataAdapter: MagicDataAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as AppCompatActivity).supportActionBar?.apply {
            title = getString(R.string.app_name)
            setDisplayShowTitleEnabled(true)
            setDisplayHomeAsUpEnabled(true)
            show()
        }

        setupUi()
    }

    private fun setupUi() {
        subscribeToCollects()
        setupRecyclerView()
    }

    private fun setupRecyclerView() = with(binding) {
        magicDataAdapter = MagicDataAdapter(requireContext())
        recyclerViewData.apply {
            adapter = magicDataAdapter
            layoutManager = LinearLayoutManager(requireContext())
            setHasFixedSize(true)
        }
    }

    private fun subscribeToCollects() = with(binding) {
        viewModel.onEvent(MagicDataEvent.GetAllMagicData)

        viewModel.state
            .onEach { state ->
                when (state) {
                    is MagicDataUiState.Loading -> progressBarData.show()
                    is MagicDataUiState.Success -> {
                        progressBarData.hide()
                        magicDataAdapter.submitList(state.magicData)
                    }
                    is MagicDataUiState.Error -> progressBarData.hide()
                    else -> Unit
                }
            }
            .observeInLifecycle(viewLifecycleOwner)

    }

    override fun getViewBinding(inflater: LayoutInflater, container: ViewGroup?) =
        FragmentMagicDataBinding.inflate(inflater, container, false)

}