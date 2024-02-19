package com.example.cinema

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import com.example.cinema.databinding.ActivityMainBinding
import com.example.cinema.databinding.ActivityMainContentBinding
import com.example.cinema.retrofit.MyRetrofit
import com.example.cinema.retrofit.`interface`.RetrofitFunctions
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private var pref: SharedPreferences? = null

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        pref = getSharedPreferences(Const.userTable, MODE_PRIVATE)

        val timer=object:CountDownTimer(3000, 500) {
            override fun onTick(p0: Long) {
            }
            override fun onFinish() {
                if (pref?.getBoolean(Const.state, false) == true) {
                    val intent = Intent(this@MainActivity, MainContentActivity::class.java)
                    startActivity(intent)
                    finish()
                }
                else {
                    val intent = Intent(this@MainActivity, EnterActivity::class.java)
                    startActivity(intent)
                    finish()
                }
            }
        }
        timer.start()
    }
}