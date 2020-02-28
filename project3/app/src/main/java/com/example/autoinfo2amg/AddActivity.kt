package com.example.autoinfo2amg

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import java.time.LocalDateTime
import android.util.Log
import android.view.View
import com.example.autoinfo2amg.Model.list
import kotlinx.android.synthetic.main.add_activity.*
import kotlin.math.cos

class AddActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.add_activity)

        addButton.setOnClickListener {

            var gas = gasAdd.text.toString()
            var odometer = odoAdd.text.toString()
            var cost = costAdd.text.toString()

            var gallons = gas.toDouble()
            var miles = odometer.toDouble()
            var currentCost = cost.toDouble()
            val current = LocalDateTime.now()

            list.add(Item("$current",gallons,miles,currentCost))

            if (Model.count ==0)
            {
                Model.initialGallons = gallons
                Model.initialOdo = miles
                Model.initalGasCost = currentCost

            }
            else
            {
               Model.newGallons = gallons
                Model.newOdo = miles
                Model.newGasCost = currentCost
                Log.d("BM", "else ADD workin")
            }
             Model.count++
            var countHolder = Model.count
            val intent = Intent(this, ListActivity::class.java)
            startActivity(intent)

        }

    }
}
