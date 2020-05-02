package com.example.hometask1

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.iteam.view.*

class ListViewHolder(iteamView: View): RecyclerView.ViewHolder(iteamView) {

    val tvTitle : TextView = iteamView.TextView_title
    val tvDescription : TextView = iteamView.TextView_description
    val tvnumber : TextView = iteamView.TextView_num

    fun populateModel(user:User,activity:MainActivity){
        tvDescription.text = user.description
        tvnumber.text = user.number
        tvTitle.text = user.title

        itemView.setOnClickListener {
            activity.OnData(user)
        }
        itemView.option_menu.setOnClickListener {
            activity.onOptionMenu(itemView.option_menu,user)
        }
    }
}