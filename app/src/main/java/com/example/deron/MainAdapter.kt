package com.example.deron

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.deron.databinding.ItemMainBinding
import com.example.deron.model.MainListModel

class MainAdapter(
    private val list: List<MainListModel>,
    private val listener: Listener
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    interface Listener {
        fun goToNextPage(pageClass: Class<*>?)
        fun showErrorMsg(message: String)
    }

    override fun getItemViewType(position: Int): Int {
        return TYPE
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            TYPE -> MainViewHolder.from(parent)
            else -> MainViewHolder.from(parent)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as MainViewHolder).bind(list[position], listener)
    }

    override fun getItemCount(): Int = list.size

    companion object {
        const val TYPE = 1
    }
}

class MainViewHolder(val binding: ItemMainBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(model: MainListModel, listener: MainAdapter.Listener) {
        binding.root.setOnClickListener {
            if (model.page != null) {
                listener.goToNextPage(model.page)
            } else {
                listener.showErrorMsg("尚未開放")
            }
        }
        binding.tvTopic.text = model.name
    }

    companion object {
        fun from(parent: ViewGroup): MainViewHolder {
            val itemView =
                ItemMainBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            return MainViewHolder(itemView)
        }
    }
}