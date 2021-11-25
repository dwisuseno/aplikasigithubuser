package com.dwisuseno.githubuserapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var rvUsers: RecyclerView
    private val list = ArrayList<Pengguna>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvUsers = findViewById(R.id.rv_user)
        rvUsers.setHasFixedSize(true)

        list.addAll(listUsers)
        showRecyclerList()
    }

    private val listUsers: ArrayList<Pengguna>
        get() {
            val dataName = resources.getStringArray(R.array.data_name)
            val dataUsername = resources.getStringArray(R.array.data_username)
            val listUser = ArrayList<Pengguna>()
            for (i in dataName.indices) {
                val user = Pengguna(dataName[i])
                listUser.add(user)
            }
            return listUser
        }
    private fun showRecyclerList() {
        rvUsers.layoutManager = LinearLayoutManager(this)
        val listPenggunaAdapter = ListPenggunaAdapter(list)
        rvUsers.adapter = listPenggunaAdapter
    }
}