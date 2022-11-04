package com.example.kotlin_hm_n5

import  java.util.*

data class MoviesModel(
    var id: Int = getId(),
    var movieName: String = "",
    var director: String = "",
    var relaseYear: Int
    ) {
    companion object{
        fun getId():Int{
            val random = Random()
            return  random.nextInt(500)
        }
    }
}


