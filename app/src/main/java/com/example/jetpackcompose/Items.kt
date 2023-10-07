package com.example.jetpackcompose

class Items {
    private val list = mutableListOf<Item>()

    fun getCategoryList() : MutableList<Item>{
        list.add(Item(R.drawable.coins,"dfd","sadfasd"))
        list.add(Item(R.drawable.coins,"dfd1","sadfasd"))
        list.add(Item(R.drawable.coins,"dfd2","sadfasd"))
        list.add(Item(R.drawable.coins,"dfd3","sadfasd"))
        list.add(Item(R.drawable.coins,"dfd4","sadfasd"))
        list.add(Item(R.drawable.coins,"dfd5","sadfasd"))
        list.add(Item(R.drawable.coins,"dfd6","sadfasd"))
        list.add(Item(R.drawable.coins,"dfd7","sadfasd"))
        list.add(Item(R.drawable.coins,"dfd8","sadfasd"))
        list.add(Item(R.drawable.coins,"dfd9","sadfasd"))
        list.add(Item(R.drawable.coins,"dfd10","sadfasd"))
        return list
    }

}


data class Item(
    val img : Int,
    val title : String,
    val subTitle : String
)