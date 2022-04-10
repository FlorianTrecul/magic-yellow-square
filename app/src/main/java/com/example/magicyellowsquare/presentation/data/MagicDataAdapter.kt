package com.example.magicyellowsquare.presentation.data

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.magicyellowsquare.R
import com.example.magicyellowsquare.databinding.ItemDataBinding
import com.example.magicyellowsquare.domain.model.MagicData
import com.example.magicyellowsquare.util.toStringDate

class MagicDataAdapter(val context: Context) : ListAdapter<MagicData, MagicDataAdapter.MagicDataViewHolder>(DiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MagicDataViewHolder {
        return MagicDataViewHolder(
            ItemDataBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: MagicDataViewHolder, position: Int) {
        val magicData = getItem(position)
        holder.bind(magicData)
    }

    inner class MagicDataViewHolder(
        private val binding: ItemDataBinding
    ) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(magicData: MagicData) {
            binding.apply {
                dateItemData.text = context.getString(R.string.magic_data_date, toStringDate(magicData.date))
                positionXItemData.text = context.getString(R.string.magic_data_position_x, magicData.positionX.toString())
                positionYItemData.text = context.getString(R.string.magic_data_position_y, magicData.positionY.toString())
            }
        }
    }

    class DiffCallback : DiffUtil.ItemCallback<MagicData>() {

        override fun areItemsTheSame(oldItem: MagicData, newItem: MagicData) = oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: MagicData, newItem: MagicData) = oldItem == newItem

    }

}