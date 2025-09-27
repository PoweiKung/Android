package com.example.deron.t5_Room

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.deron.databinding.ItemRoomBinding
import com.example.deron.t5_Room.table.RoomUser

class RoomAdapter(
    private var list: List<RoomUser>
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun getItemViewType(position: Int): Int {
        return TYPE
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            TYPE -> RoomViewHolder.from(parent)
            else -> RoomViewHolder.from(parent)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as RoomViewHolder).bind(list[position])
    }

    override fun getItemCount(): Int = list.size

    fun updateData(userList: List<RoomUser>) {
        list = userList
        notifyDataSetChanged()
    }

    companion object {
        const val TYPE = 1
    }
}

class RoomViewHolder(val binding: ItemRoomBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(user: RoomUser) {
        binding.tvId.text = user.id.toString()
        binding.tvName.text = user.name
        binding.tvAge.text = user.age.toString()
    }

    companion object {
        fun from(parent: ViewGroup): RoomViewHolder {
            val itemView =
                ItemRoomBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            return RoomViewHolder(itemView)
        }
    }
}