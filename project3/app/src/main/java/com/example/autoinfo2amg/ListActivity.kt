package com.example.autoinfo2amg

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.util.Log
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.item_list.*

class ListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.item_list)


        listView.adapter = ArrayAdapter<Item>(this, android.R.layout.simple_list_item_1, Model.list)

        plus2.bringToFront()
        plus2.setOnClickListener {
            // Handler code here.
            val intent = Intent(this, AddActivity::class.java)
            startActivity(intent)
        }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when(item.itemId){
            R.id.stats -> { val intent = Intent(this, Stats::class.java)
                startActivity(intent)}
            R.id.deleteAll -> {Model.list.removeAll(Model.list)
                listView.adapter = ArrayAdapter<Item>(this, android.R.layout.simple_list_item_1, Model.list)}

        }
        return super.onOptionsItemSelected(item)
    }
}
