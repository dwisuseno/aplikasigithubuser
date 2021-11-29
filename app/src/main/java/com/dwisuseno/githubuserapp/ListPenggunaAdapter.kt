package com.dwisuseno.githubuserapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
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
        val (name,user_name, avatar, follower, following) = listPengguna[position]
        holder.binding.imgItemPhoto.setImageResource(avatar)
        holder.binding.tvItemName.text = name.toString()
        holder.binding.tvItemUsername.text = user_name.toString()
        holder.binding.tvItemFollower.text = follower.toString()
        holder.binding.tvItemFollowing.text = following.toString()
//        holder.itemView.setOnClickListener {
//            Toast.makeText(holder.itemView.context, "Kamu memilih " + listPengguna[holder.adapterPosition].name, Toast.LENGTH_SHORT).show()
//        }

        holder.itemView.setOnClickListener { onItemClickCallback.onItemClicked(listPengguna[holder.adapterPosition]) }
    }

    override fun getItemCount(): Int = listPengguna.size

    class ListViewHolder(var binding: ItemRowUserBinding) : RecyclerView.ViewHolder(binding.root) {
//        var imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
//        var tvName: TextView = itemView.findViewById(R.id.tv_item_name)
//        var tvUsername: TextView = itemView.findViewById(R.id.tv_item_username)
//        var tvFollower: TextView = itemView.findViewById(R.id.tv_item_follower)
//        var tvFollowing: TextView = itemView.findViewById(R.id.tv_item_following)
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: Pengguna)
    }
}