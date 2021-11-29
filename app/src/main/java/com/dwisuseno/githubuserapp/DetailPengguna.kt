package com.dwisuseno.githubuserapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class DetailPengguna : AppCompatActivity() {

    private lateinit var tvName: TextView
    private lateinit var tvUsername: TextView
    private lateinit var tvLocation: TextView
    private lateinit var tvFollower: TextView
    private lateinit var tvFollowing: TextView
    private lateinit var tvRepository: TextView
    private lateinit var tvCompany: TextView
    private lateinit var imgPhoto: ImageView

    companion object {
        const val EXTRA_PERSON = "extra_person"
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_pengguna)

        supportActionBar?.title = "Detail User"

        imgPhoto = findViewById(R.id.profile_image)
        tvName = findViewById(R.id.tv_data_name)
        tvUsername = findViewById(R.id.tv_data_username)
        tvFollower = findViewById(R.id.tv_data_follower)
        tvFollowing = findViewById(R.id.tv_data_following)
        tvCompany = findViewById(R.id.tv_data_company)
        tvRepository = findViewById(R.id.tv_data_repository)
        tvLocation = findViewById(R.id.tv_data_location)

        val person = intent.getParcelableExtra<Pengguna>(EXTRA_PERSON) as Pengguna

        imgPhoto.setImageResource(person.avatars)
        tvName.text = "Name : ${person.name.toString()}"
        tvUsername.text = "Username : ${person.username.toString()}"
        tvFollower.text = "Follower : ${person.followers.toString()}"
        tvFollowing.text = "Following : ${person.following.toString()}"
        tvCompany.text = "Company : ${person.company.toString()}"
        tvRepository.text = "Repository : ${person.repository.toString()}"
        tvLocation.text = "Location : ${person.location.toString()}"



    }
}