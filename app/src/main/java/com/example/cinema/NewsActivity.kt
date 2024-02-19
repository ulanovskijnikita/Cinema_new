package com.example.cinema

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import com.example.cinema.databinding.ActivityNewsBinding
import com.example.cinema.retrofit.MyRetrofit
import com.example.cinema.retrofit.`interface`.RetrofitFunctions
import com.example.cinema.retrofit.model.DataMovie
import retrofit2.Call
import retrofit2.Response

class NewsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityNewsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //        Retrofit
        val retrofit = MyRetrofit().getNews()
        val api = retrofit.create(RetrofitFunctions::class.java)
        val call= api.getData()
        call.enqueue(object: retrofit2.Callback<List<DataMovie>> {

            override fun onResponse(
                call: Call<List<DataMovie>>,
                response: Response<List<DataMovie>>
            ) {
                val list = response.body() as List<DataMovie>
                val position = intent.getIntExtra(Const.news, 0)

                binding.apply {
                    toolbar.title = list[position].name
                    setSupportActionBar(toolbar)
                    supportActionBar?.setDisplayHomeAsUpEnabled(true)

                    realname.text = "Настоящее имя актера: " + list[position].realname
                    team.text = "Линия: " + list[position].team
                    firstappearance.text = "Первая публикация: " + list[position].firstappearance
                    createdby.text = "Создатель: " + list[position].createdby
                    publisher.text = "Первая публикация: " + list[position].publisher
                }
            }

            override fun onFailure(call: Call<List<DataMovie>>, t: Throwable) {
                Toast.makeText(this@NewsActivity, t.localizedMessage, Toast.LENGTH_SHORT)
                    .show()
            }
        })
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> finish()
        }
        return true
    }
}