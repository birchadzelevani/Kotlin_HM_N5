package com.example.kotlin_hm_n5


import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import androidx.core.content.contentValuesOf


class SQLiteOpenHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object{
        private const val DATABASE_VERSION = 1
        private const val DATABASE_NAME = "movies.db"
        private const val TABLE_MOVIES = "movies_table"
        private const val ID = "id"
        private const val MOVIE_NAME = "movieName"
        private const val DIRECTOR = "director"
        private const val RELASE_YEAR = "relaseYear"
    }

    override fun onCreate(database: SQLiteDatabase?) {
        val createTableMovies = ("CREATE TABLE" +  TABLE_MOVIES +"(" + ID + MOVIE_NAME + DIRECTOR +RELASE_YEAR +")")

        database?.execSQL(createTableMovies)
    }

    override fun onUpgrade(database: SQLiteDatabase?, p1: Int, p2: Int) {
        database!!.execSQL("DROP TABLE IF EXISTS $TABLE_MOVIES")
        onCreate(database)
    }
    fun insertMovie(movie: MoviesModel):Long{
        val database = this.writableDatabase
        val contentValue = ContentValues()
        contentValue.put(ID, movie.id)
        contentValue.put(MOVIE_NAME, movie.movieName)
        contentValue.put(DIRECTOR, movie.director)
        contentValue.put(RELASE_YEAR, movie.relaseYear)

        val success = database.insert(TABLE_MOVIES, null, contentValue)
        database.close()
        return  success
    }




    fun getMovies(): ArrayList<MoviesModel>{
        val moviesList: ArrayList<MoviesModel> = ArrayList()
        val selectQuery = "select * from $TABLE_MOVIES"
        val database = this.readableDatabase

        val cursor: Cursor?
        try {
            cursor = database.rawQuery(selectQuery,null)

        }catch (exp: Exception){
            exp.printStackTrace()
            database.execSQL(selectQuery)
            return ArrayList()
        }

        var id: Int
        var movieName: String
        var director: String
        var relaseYear: Int

        if(cursor.moveToFirst()){
            do{
                id = cursor.getInt(cursor.getColumnIndex("id"))
                movieName = cursor.getString(cursor.getColumnIndex("movieName"))
                director = cursor.getString(cursor.getColumnIndex("director"))
                relaseYear = cursor.getInt(cursor.getColumnIndex("relaseYear"))

                val movie = MoviesModel(id = id, movieName = movieName, director = director, relaseYear = relaseYear)
                moviesList.add(movie)

            }while (cursor.moveToNext())
        }
        return moviesList
    }

    fun delete(id: String) {
        val database = writableDatabase
        val sQuery = ("delete from " + TABLE_MOVIES + " where id='"
                + id + "'")
        database.execSQL(sQuery)
        database.close()
    }


}