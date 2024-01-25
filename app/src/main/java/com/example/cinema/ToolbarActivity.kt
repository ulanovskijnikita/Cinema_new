package com.example.cinema

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.content.Intent
import android.net.Uri
import android.view.Menu
import android.widget.MediaController
import android.widget.Toast
import android.widget.VideoView
import androidx.recyclerview.widget.RecyclerView
import com.example.cinema.databinding.ActivityToolbarBinding


class ToolbarActivity : AppCompatActivity() {
    private lateinit var binding: ActivityToolbarBinding

    fun backToMainActivity4() {
        val intent= Intent(this, TestActivity::class.java)
        startActivity(intent)
        finish()
    }

    fun backToFilms() {
        val intent= Intent(this, FilmsActivity::class.java)
        startActivity(intent)
        finish()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityToolbarBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        BottomNavigation
        binding.bottom.apply {
            selectedItemId = R.id.home
            setOnItemSelectedListener {
                when (it.itemId) {
                    R.id.heart->backToFilms()
                    R.id.gear->backToMainActivity4()
                }
                true
            }
            setOnItemReselectedListener() {
                Toast.makeText(this@ToolbarActivity, "Вы уже здесь", Toast.LENGTH_LONG).show()
            }
        }

//        Скаченное видео
        val video:VideoView = findViewById(R.id.videoView2)
        val mediaController = MediaController(this)
        mediaController.setAnchorView(video)
        val onLineUrl= Uri.parse("android.resource://$packageName/${R.raw.treiler}")
        video.setMediaController(mediaController)
        video.setVideoURI(onLineUrl)

//        Recycler с кадрами
        val cardRes:RecyclerView = findViewById(R.id.card)
        cardRes.adapter = CardAdapter(this, CardList().cList)

//        Recycler с актёрами
        val person_res:RecyclerView = findViewById(R.id.person)
        person_res.adapter = PersonAdapter(this, person_list().p_list)

//          Toolbar
        setSupportActionBar(binding.toolbar)
        supportActionBar?.title="Хищные птицы"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onCreateOptionsMenu(menu: Menu?):Boolean {
        menuInflater.inflate(R.menu.menu_of_five_activity, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> backToFilms()
            R.id.icon_check -> Toast.makeText(this, "Working", Toast.LENGTH_SHORT).show()
        }
        return true
    }
}