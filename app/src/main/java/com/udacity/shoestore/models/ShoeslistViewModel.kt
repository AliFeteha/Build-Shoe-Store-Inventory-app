package com.udacity.shoestore.models


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ShoeslistViewModel:ViewModel() {
    val _ShoeList : MutableLiveData<MutableList<Shoe>> = MutableLiveData(mutableListOf())
    var shoeItem = Shoe()
    fun addShoe(){
        _ShoeList.value?.add(shoeItem)
    }
    fun showList(): MutableLiveData<MutableList<Shoe>>{
        return _ShoeList
    }

}