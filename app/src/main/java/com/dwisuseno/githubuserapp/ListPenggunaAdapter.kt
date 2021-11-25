package com.dwisuseno.githubuserapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class ListPenggunaAdapter(private val listPengguna: ArrayList<Pengguna>) : RecyclerView.Adapter<ListPenggunaAdapter.ListViewHolder>(){


    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ListViewHolder {
        val view: View = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_row_user, viewGroup, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name,user_name, avatar, follower, following) = listPengguna[position]
        holder.imgPhoto.setImageResource(avatar)
        holder.tvName.text = name.toString()
        holder.tvUsername.text = user_name.toString()
        holder.tvFollower.text = follower.toString()
        holder.tvFollowing.text = following.toString()
        holder.itemView.setOnClickListener {
            Toast.makeText(holder.itemView.context, "Kamu memilih " + listPengguna[holder.adapterPosition].name, Toast.LENGTH_SHORT).show()
        }
    }

    override fun getItemCount(): Int = listPengguna.size

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
        var tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        var tvUsername: TextView = itemView.findViewById(R.id.tv_item_username)
        var tvFollower: TextView = itemView.findViewById(R.id.tv_item_follower)
        var tvFollowing: TextView = itemView.findViewById(R.id.tv_item_following)
    }
}