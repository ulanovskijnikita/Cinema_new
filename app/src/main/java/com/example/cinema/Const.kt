package com.example.cinema

object Const {
//    Pattern
    const val patternName = ("[a-zA-Zа-яА-я0-9\\h]{1,15}")
    const val patternMail = ("[a-zA-Z0-9]{1,100}" + "@" + "[a-z]{1,6}" + "\\." + "[a-z]{1,5}")
    const val patternPass = ("[a-zA-Z0-9!@#$%&()-+]{8,20}")

//    SharedPref
    const val userTable = "userTable"
    const val name = "name"
    const val mail = "mail"
    const val pass = "pass"
    const val state = "state"

//    Intent
    const val news = "number"
}