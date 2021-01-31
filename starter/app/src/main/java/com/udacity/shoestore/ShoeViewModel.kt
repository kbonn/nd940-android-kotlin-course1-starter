package com.udacity.shoestore

import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class ShoeViewModel: ViewModel() {

    private val _shoeList = MutableLiveData<MutableList<Shoe>>()
    val shoeList: LiveData<MutableList<Shoe>>
        get() = _shoeList

    private val _newShoe = MutableLiveData<Boolean>()
    val newShoe: LiveData<Boolean>
        get() = _newShoe

    fun addShoes(name: String, size: String, company: String, description: String) {
        val newShoe = Shoe(
            name, size.toDouble(), company, description
        )
        _shoeList.value?.add(newShoe)
    }
}