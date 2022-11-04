package com.example.kotlin_hm_n5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    private var recyclerView: RecyclerView? = null
    private lateinit var add_movie : EditText
    private lateinit var add_director : EditText
    private lateinit var add_year : EditText
    private  lateinit var add_movie_button : Button

    private lateinit var sqliiteopenhelper : SQLiteOpenHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()

        sqliiteopenhelper = SQLiteOpenHelper(this)

    }

    private fun initView(){
        recyclerView = findViewById(R.id.recycler_view)
        add_movie_button = findViewById(R.id.add_movie_button)
    }
}