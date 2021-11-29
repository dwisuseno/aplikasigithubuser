package com.dwisuseno.githubuserapp

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dwisuseno.githubuserapp.databinding.ItemRowUserBinding

class ListPenggunaAdapter(private val listPengguna: ArrayList<Pengguna>) : RecyclerView.Adapter<ListPenggunaAdapter.ListViewHolder>(){
    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ListViewHolder {
        val binding = ItemRowUserBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)
//        val view: View = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_row_user, viewGroup, false)
        return ListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (photo,name,user_name) = listPengguna[position]
        holder.binding.avatars.setImageResource(photo)
        holder.binding.tvItemName.text = name.toString()
        holder.binding.tvItemUsername.text = user_name.toString()

        holder.itemView.setOnClickListener { onItemClickCallback.onItemClicked(listPengguna[holder.adapterPosition]) }
    }

    override fun getItemCount(): Int = listPengguna.size

    class ListViewHolder(var binding: ItemRowUserBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    interface OnItemClickCallback {
        fun onItemClicked(data: Pengguna)
    }
}