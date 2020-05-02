package com.example.hometask1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class ListAdapter(val activity: MainActivity) : RecyclerView.Adapter<ListViewHolder>() {

    var models : List<User> = listOf()

    fun setData(data:List<User>){
        models = data
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ListViewHolder {
       val itmView : View = LayoutInflater.from(p0.context).inflate(R.layout.iteam,p0,false)
        return ListViewHolder(itmView)
    }

    override fun getItemCount(): Int {
        return models.size
    }

    override fun onBindViewHolder(p0: ListViewHolder, p1: Int) {
      p0.populateModel(models[p1],activity)
    }
}