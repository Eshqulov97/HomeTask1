package com.example.hometask1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.PopupMenu
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val adapter : ListAdapter = ListAdapter(this)
    val models : MutableList<User> = mutableListOf()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recycleview.adapter = adapter

        recycleview.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        recycleview.addItemDecoration(DividerItemDecoration(this,DividerItemDecoration.VERTICAL))

        val model: User = User()
        model.title = "Title"
        model.description = "Description"
        model.number = "1"

        models.add(model)
        adapter.setData(models)

    }

    fun OnData(user:User){

        var temp1 = models.size

        for(i in 1..user.number.toInt()){
            val model : User = User()
            model.title = "Title"
            model.description = "Description"
            model.number = "${i + temp1}"
            models.add(model)

        }

        adapter.setData(models)
}

    fun Delete(user:User){

        models.removeAt((user.number.toInt() - 1))

        var s = 0
        for(i in 1..models.size){
            val mod : User = User()
            mod.title = "Title"
            mod.description = "Description"
            mod.number = "$i"
            models.set(s,mod)
            s ++
        }

        adapter.setData(models)

    }

    fun AddElement(user:User){

        val model : User = User()
        model.title = "Title"
        model.description = "Description"
        model.number = "${user.number}"
        models.add(user.number.toInt(),model)

        var s = 0
        for(i in 1..models.size){
            val mod : User = User()
            mod.title = "Title"
            mod.description = "Description"
            mod.number = "$i"
            models.set(s,mod)
            s ++
        }

        adapter.setData(models)

    }

    fun onOptionMenu(view: View, user: User){

        val optionMenu = PopupMenu(this,view)
        val menuinflater = optionMenu.menuInflater

        menuinflater.inflate(R.menu.menu_iteam_option,optionMenu.menu)

        optionMenu.setOnMenuItemClickListener {
            when(it.itemId){
                R.id.item_add ->{

                    AddElement(user)
                }
                R.id.item_delete ->{

                    Delete(user)
                }
            }
            true


        }

        optionMenu.show()
    }


}
