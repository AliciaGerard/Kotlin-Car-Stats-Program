package com.example.autoinfo2amg

data class Item (var date: String, var gallons: Double, var odo: Double, var cost: Double) {
    override fun toString(): String {
        return "$date $odo miles $cost dollars"
    }
}
