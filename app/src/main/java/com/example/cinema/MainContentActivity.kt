package com.example.cinema

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.view.WindowCompat
import com.example.cinema.databinding.ActivityMainContentBinding

class MainContentActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainContentBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainContentBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        StatusBar
        window.statusBarColor = getColor(R.color.opacity)
        WindowCompat.setDecorFitsSystemWindows(window, false)

//        Подготовка данных
        supportFragmentManager.beginTransaction().replace(R.id.frameLayout, FilmsFragment()).commit()
        binding.bottomNavigationView.selectedItemId =R.id.heart

//        Слушатель
        binding.apply {
            bottomNavigationView.apply {
                setOnItemSelectedListener {
                    when (it.itemId) {
                        R.id.home -> supportFragmentManager.beginTransaction().replace(R.id.frameLayout, NewsFragment()).commit()
                        R.id.heart -> supportFragmentManager.beginTransaction().replace(R.id.frameLayout, FilmsFragment()).commit()
                        R.id.gear -> supportFragmentManager.beginTransaction().replace(R.id.frameLayout, UserFragment()).commit()
                    }
                    true
                }
                setOnItemReselectedListener {
                    Toast.makeText(this@MainContentActivity, "Вы уже здесь", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}