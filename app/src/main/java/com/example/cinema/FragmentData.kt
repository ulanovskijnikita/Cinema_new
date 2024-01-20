package com.example.cinema

data class FragmentData(val img_frament:Int, val text_frament:String)
class FragmentList {
    val list= listOf(FragmentData(R.drawable.films_avatar, "ГГшка рожает детей, но потом\nприходят люди и\nначинается охота!"),
        FragmentData(R.drawable.films_wednesday, "Семейка Аддамс в\nреальном мире!\nВенсдей звезда действа!"),
        FragmentData(R.drawable.films_emily, "Какая-то Эмили?\nНаверное интересно\nПосмотрите и расскажите!"))
}
