package com.dwisuseno.githubuserapp

import android.content.Intent
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
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
            val dataAvatar = resources.obtainTypedArray(R.array.avatar)
            val dataFollower = resources.getStringArray(R.array.followers)
            val dataFollowing = resources.getStringArray(R.array.following)
            val listUser = ArrayList<Pengguna>()
            for (i in dataName.indices) {
                val user = Pengguna(dataName[i],dataUsername[i],dataAvatar.getResourceId(i, -1),dataFollower[i],dataFollowing[i])
                listUser.add(user)
            }
            return listUser
        }
    private fun showRecyclerList() {
//        rvUsers.layoutManager = LinearLayoutManager(this)
        if (applicationContext.resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            rvUsers.layoutManager = GridLayoutManager(this, 2)
        } else {
            rvUsers.layoutManager = LinearLayoutManager(this)
        }
        val listPenggunaAdapter = ListPenggunaAdapter(list)
        rvUsers.adapter = listPenggunaAdapter

        listPenggunaAdapter.setOnItemClickCallback(object : ListPenggunaAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Pengguna) {
//                showSelectedPengguna(data)
                val moveWithObjectIntent = Intent(this@MainActivity, DetailPengguna::class.java)
                moveWithObjectIntent.putExtra(DetailPengguna.EXTRA_PERSON, data)
                startActivity(moveWithObjectIntent)
            }
        })
    }

    private fun showSelectedPengguna(pengguna: Pengguna) {
        Toast.makeText(this, "Kamu memilih " + pengguna.name, Toast.LENGTH_SHORT).show()
    }
}