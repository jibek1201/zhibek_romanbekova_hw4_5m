package com.example.zhibek_romanbekova_hw4_5m.remote

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.zhibek_romanbekova_hw4_5m.Repository

class LoveApi : ViewModel() {

    private val repository = Repository()

    fun getLove(firstName: String, secondName: String): LiveData<LoveModel> {
        return repository.getLoveModel(firstName = firstName, secondName = secondName)
    }

}