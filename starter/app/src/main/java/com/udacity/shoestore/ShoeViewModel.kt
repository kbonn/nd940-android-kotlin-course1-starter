package com.udacity.shoestore

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class ShoeViewModel: ViewModel() {

    private val _shoeList = MutableLiveData<MutableList<Shoe>>()
    val shoeList: LiveData<MutableList<Shoe>>
        get() = _shoeList

    private val _addingShoe = MutableLiveData<Boolean>()
    val addingShoe: LiveData<Boolean>
        get() = _addingShoe

    init {
        val testShoe = Shoe("Name", 12.0, "Company", "Description")
        _shoeList.value = mutableListOf()
        _shoeList.value!!.add(testShoe)
    }

    fun emptyShoe(): Shoe {
        return Shoe("", 0.0, "", "")
    }

    fun addShoe(shoe: Shoe) {
        _shoeList.value!!.add(shoe)
        _addingShoe.value = true
    }

    fun shoeAdded(){
        _addingShoe.value = false
    }
}