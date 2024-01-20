package com.example.cinema

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import com.example.cinema.databinding.ActivityTestBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class TestActivity : AppCompatActivity() {

    private fun backToFilms() {
        val intent= Intent(this, FilmsActivity::class.java)
        startActivity(intent)
        finish()
    }

    private fun backToToolbar() {
        val intent= Intent(this, ToolbarActivity::class.java)
        startActivity(intent)
        finish()
    }

    private lateinit var binding: ActivityTestBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTestBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        Текстовые поля
        val userTable = getSharedPreferences(Const.userTable, MODE_PRIVATE)
        binding.apply {
            nameView.text = userTable?.getString(Const.name, "")
            mailView.text = userTable?.getString(Const.mail, "")
        }

//        Навигация
        binding.apply {
            bottom.apply {
                selectedItemId = R.id.gear
                setOnItemSelectedListener {
                    when (it.itemId) {
                        R.id.home -> backToToolbar()
                        R.id.heart -> backToFilms()
                        R.id.gear -> Toast.makeText(
                            this@TestActivity,
                            "Вы уже здесь",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                    true
                }
            }
        }

//        Кнопка
        binding.goWatch.setOnClickListener() {
            startActivity(Intent(this, FilmsActivity::class.java))
            finish()
        }

////        Toolbar
//        setSupportActionBar(findViewById(R.id.toolbar))
//        supportActionBar?.title="Ваш профиль"
//    }
//
//    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
//        menuInflater.inflate(R.menu.toolbar_user, menu)
//        return true
//    }
//
//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
////        if (item.itemId == R.id.butter)
//        return true
//    }
    }
}