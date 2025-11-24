package com.example.android_week10_ex2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class EmailAdapter(val emails: List<EmailModel>, val onStarClick: (Int) -> Unit) :
    RecyclerView.Adapter<EmailAdapter.EmailViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmailViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_email, parent, false)
        return EmailViewHolder(itemView, onStarClick)
    }

    override fun onBindViewHolder(holder: EmailViewHolder, position: Int) {
        val email = emails[position]
        holder.avatar.text = email.sender.substring(0, 1).uppercase()
        holder.sender.text = email.sender
        holder.subject.text = email.subject
        holder.preview.text = email.preview
        holder.time.text = email.time
        holder.star.setImageResource(
            if (email.isStarred) android.R.drawable.btn_star_big_on
            else android.R.drawable.btn_star_big_off
        )
    }

    override fun getItemCount() = emails.size

    class EmailViewHolder(itemView: View, val onStarClick: (Int) -> Unit) :
        RecyclerView.ViewHolder(itemView) {
        val avatar = itemView.findViewById<TextView>(R.id.text_avatar)
        val sender = itemView.findViewById<TextView>(R.id.text_sender)
        val subject = itemView.findViewById<TextView>(R.id.text_subject)
        val preview = itemView.findViewById<TextView>(R.id.text_preview)
        val time = itemView.findViewById<TextView>(R.id.text_time)
        val star = itemView.findViewById<ImageView>(R.id.img_star)

        init {
            star.setOnClickListener {
                if(adapterPosition != RecyclerView.NO_POSITION) {
                    onStarClick(adapterPosition)
                }
            }
        }
    }
}