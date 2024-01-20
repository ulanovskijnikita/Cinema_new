package com.example.cinema
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.cinema.databinding.ActivityRegBinding
import com.example.cinema.db.RegDbManager
import java.util.regex.Pattern

class RegActivity : AppCompatActivity() {
    private val regDbManager = RegDbManager(this)
    private var userTable: SharedPreferences? = null

//    Pattern
    private fun validPass(pass: String):Boolean {
        return Pattern.compile(Const.patternPass).matcher(pass).matches()
    }

    private fun validName(name: String):Boolean {
        return Pattern.compile(Const.patternName).matcher(name).matches()
    }

    private fun validMail(mail: String):Boolean {
        return Pattern.compile(Const.patternMail).matcher(mail).matches()
    }

    private fun existenceMail(mail: String): Boolean {
        val mailArray = regDbManager.readDbDataMail()
        return mailArray.contains(mail)
    }

    private lateinit var binding: ActivityRegBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        SharedPref
        userTable = getSharedPreferences(Const.userTable, MODE_PRIVATE)

        binding.apply {
            regButton.setOnClickListener {
                if (name.text.toString().isNotEmpty() &&
                    family.text.toString().isNotEmpty() &&
                    mail.text.toString().isNotEmpty() &&
                    pass.text.toString().isNotEmpty() &&
                    passDouble.text.toString().isNotEmpty()) {
                    when (false) {
                        validName(name.text.toString()) -> Toast.makeText(
                            this@RegActivity,
                            "Имя заполненна некорректно",
                            Toast.LENGTH_SHORT
                        ).show()

                        validName(family.text.toString()) -> Toast.makeText(
                            this@RegActivity,
                            "Фамилия заполненна некорректно",
                            Toast.LENGTH_SHORT
                        ).show()

                        validMail(mail.text.toString()) -> Toast.makeText(
                            this@RegActivity,
                            "Почта заполненна некорректно",
                            Toast.LENGTH_SHORT
                        ).show()

                        !existenceMail(mail.text.toString()) -> {
                            Toast.makeText(
                                this@RegActivity,
                                "Почта уже зарегестрирована",
                                Toast.LENGTH_SHORT
                            ).show()
                        }

                        validPass(pass.text.toString()) -> Toast.makeText(
                            this@RegActivity,
                            "Пароль должен состоять из 8 и более символов",
                            Toast.LENGTH_SHORT
                        ).show()

                        (pass.text.toString() == passDouble.text.toString()) -> Toast.makeText(
                            this@RegActivity,
                            "Пароли не совпадают",
                            Toast.LENGTH_SHORT
                        ).show()

                        else -> {
                            regDbManager.insertToDb(
                                name.text.toString(),
                                family.text.toString(),
                                mail.text.toString(),
                                pass.text.toString()
                            )

                            Toast.makeText(
                                this@RegActivity,
                                "Регистрация успешна",
                                Toast.LENGTH_LONG)
                                .show()

                            val intent = Intent(this@RegActivity, EnterActivity::class.java)
                            startActivity(intent)
                            finish()
                        }
                    }
                } else {
                    AlertDialog.Builder(this@RegActivity)
                        .setTitle("Заполните текстовые поля")
                        .setPositiveButton("ОК", null)
                        .create()
                        .show()
                }
            }

//            Button
            exit.setOnClickListener {
                val intent= Intent(this@RegActivity, EnterActivity::class.java)
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
