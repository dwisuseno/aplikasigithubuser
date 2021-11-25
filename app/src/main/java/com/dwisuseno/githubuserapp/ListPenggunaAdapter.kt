package com.dwisuseno.githubuserapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ListPenggunaAdapter(private val listPengguna: ArrayList<Pengguna>) : RecyclerView.Adapter<ListPenggunaAdapter.ListViewHolder>(){


    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ListViewHolder {
        val view: View = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_row_user, viewGroup, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name, user_name) = listPengguna[position]
        holder.tvName.text = name.toString()
        holder.tvUsername.text = user_name.toString()
    }

    override fun getItemCount(): Int = listPengguna.size

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        var tvUsername: TextView = itemView.findViewById(R.id.tv_item_username)
    }
}