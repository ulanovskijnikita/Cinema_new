package com.example.cinema

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.cinema.databinding.ActivityEnterBinding
import com.example.cinema.db.RegDbManager

class EnterActivity : AppCompatActivity() {
    private val regDbManager = RegDbManager(this)

    private fun existenceMail(mail: String): Boolean {
        val mailArray = regDbManager.readDbDataMail()
        return mailArray.contains(mail)
    }

    private fun existenceMailAndPass(mail: String, pass: String): Boolean {
        val passArray = regDbManager.readDbDataPassOfMail(mail)
        return passArray.contains(pass)
    }

    private fun greeting(mail: String): String {
        return regDbManager.readDbDataNameOfMail(mail)
    }

    private lateinit var binding: ActivityEnterBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEnterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val tableUser= getSharedPreferences(Const.userTable, MODE_PRIVATE)

        binding.apply {
            enter.setOnClickListener {
                if (mail.text.toString().isNotEmpty() &&
                    pass.text.toString().isNotEmpty()) {
                    when (false) {
                        existenceMail(mail.text.toString()) -> {
                            Toast.makeText(
                                this@EnterActivity,
                                "Почта не зарегистрирована",
                                Toast.LENGTH_SHORT
                            ).show()
                            regDbManager.closeDb()
                        }

                        existenceMailAndPass(mail.text.toString(), pass.text.toString()) -> {
                            Toast.makeText(
                                this@EnterActivity,
                                "Неверный пароль",
                                Toast.LENGTH_SHORT
                            ).show()
                            regDbManager.closeDb()
                        }

                        else -> {
                            tableUser.edit()
                                .putString(Const.mail, mail.text.toString())
                                .putString(Const.pass, pass.text.toString())
                                .putBoolean(Const.state, checkBox.isChecked)
                                .apply()

                            Toast.makeText(
                                this@EnterActivity,
                                "Добро пожаловать, " + greeting(mail.text.toString()),
                                Toast.LENGTH_SHORT
                            ).show()
                            tableUser.edit()
                                .putString(Const.name, greeting(mail.text.toString()))
                                .apply()

                            val intent = Intent(this@EnterActivity, ToolbarActivity::class.java)
                            startActivity(intent)
                            finish()
                        }
                    }
                } else {
                    AlertDialog.Builder(this@EnterActivity)
                        .setTitle("Заполните текстовые поля")
                        .setPositiveButton("ОК", null)
                        .create()
                        .show()
                }
            }

            reg.setOnClickListener {
                val intent = Intent(this@EnterActivity, RegActivity::class.java)
                startActivity(intent)
                finish()
            }
        }
    }

    override fun onPause() {
        super.onPause()
        regDbManager.closeDb()
    }
}