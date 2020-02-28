package com.example.autoinfo2amg

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.stat_page.*

class Stats : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.stat_page)

            var currentCount = Model.count
            statFillUp.setText("total over $currentCount fillups")
        if (Model.count <= 1) {
            var iniGal = Model.initialGallons
            statGas.setText("$iniGal Gallons")
            var iniOdo = 0.0
            statMiles.setText("$iniOdo miles")
            var iniCost = Model.initalGasCost
            statCost.setText("$ $iniCost")
            statMPG.setText("0.0 mpg")

        } else {
            var totalGallons = Model.initialGallons + Model.newGallons
            var totalMileage = Model.newOdo - Model.initialOdo
            var effeciency = totalMileage / totalGallons
            var totalCost = Model.initalGasCost + Model.newGasCost

            statGas.setText("$totalGallons Gallons")
            statMiles.setText("$totalMileage miles")
            statCost.setText("$ $totalCost")
            statMPG.setText("$effeciency mpg")
        }
    }}