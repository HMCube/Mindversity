package com.app.mindversity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

// MainActivity.kt
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        val items = listOf(

            ListItem("Item 1", "Details for Item 1"),
            ListItem("Lesson 1", "Information about Lesson 1!"),
            ListItem("Lesson 2", "Information about Lesson 2!"),
            ListItem("Lesson 3", "Information about Lesson 3!"),
            ListItem("Lesson 4", "Information about Lesson 4!"),
            ListItem("Lesson 5", "Information about Lesson 5!"),
            ListItem("Lesson 6", "Information about Lesson 6!"),
            ListItem("Lesson 7", "Information about Lesson 7!"),
            ListItem("Lesson 8", "Information about Lesson 8!"),
            ListItem("Lesson 9", "Information about Lesson 9!")
        )
        val adapter = ListAdapter(items)
        recyclerView.adapter = adapter
    }
}

