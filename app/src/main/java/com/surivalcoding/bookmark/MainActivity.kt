package com.surivalcoding.bookmark

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val sites = listOf(
            Site(
                name = "네이버",
                url = "https://www.naver.com",
            ),
            Site(
                name = "구글",
                url = "https://www.google.com",
            ),
            Site(
                name = "페이스북",
                url = "https://www.facebook.com",
            ),
            Site(
                name = "인스타그램",
                url = "https://www.instagram.com",
            ),
        )


        val adapter = BookmarkAdapter(sites) { site ->
            openWebPage(site.url)
        }

        recyclerView.adapter = adapter
    }

    fun openWebPage(url: String) {
        val webpage: Uri = Uri.parse(url)
        val intent = Intent(Intent.ACTION_VIEW, webpage)
        startActivity(intent)
    }
}