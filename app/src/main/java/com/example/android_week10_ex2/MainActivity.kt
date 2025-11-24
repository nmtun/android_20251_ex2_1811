package com.example.android_week10_ex2

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private val emails = mutableListOf<EmailModel>()
    private lateinit var adapter: EmailAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        emails.add(EmailModel("1", "Edurila.com", "$19 Only (First 10 spots) - Bestselling...", "Are you looking to Learn Web Designing...", "12:34 PM"))
        emails.add(EmailModel("2", "Chris Abad", "Help make Campaign Monitor better", "Let us know your thoughts! No Images...", "11:22 AM"))
        emails.add(EmailModel("3", "Tuto.com", "8h de formation gratuite et les nouvea...", "Photoshop, SEO, Blender, CSS, WordPre...", "11:04 AM"))
        emails.add(EmailModel("4", "support", "Société Ovh : suivi de vos services - hp...", "SAS OVH - http://www.ovh.com 2 rue K...", "10:26 AM"))
        emails.add(EmailModel("5", "Matt from Ionic", "The New Ionic Creator Is Here!", "Announcing the all-new Creator, buildi...", "10:15 AM"))
        emails.add(EmailModel("6", "Google", "Your weekly digest of new videos", "Check out the latest from your subscri...", "9:45 AM"))

        adapter = EmailAdapter(emails) { position ->
            emails[position] = emails[position].copy(isStarred = !emails[position].isStarred)
            adapter.notifyItemChanged(position)
        }

        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)
    }
}