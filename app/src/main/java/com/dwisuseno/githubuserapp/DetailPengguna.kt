package com.dwisuseno.githubuserapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class DetailPengguna : AppCompatActivity() {

    companion object {
        const val EXTRA_PERSON = "extra_person"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_pengguna)

        val tvObject: TextView = findViewById(R.id.tv_item_name)

        val person = intent.getParcelableExtra<Pengguna>(EXTRA_PERSON) as Pengguna
        val text = "Name : ${person.name.toString()},\nUsername : ${person.username},\nFollower : ${person.followers},\nFollowing : ${person.following}\n" +
                "Photo : ${person.avatars}"
        tvObject.text = text
    }
}