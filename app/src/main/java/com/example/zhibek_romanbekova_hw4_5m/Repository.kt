package com.example.zhibek_romanbekova_hw4_5m

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.zhibek_romanbekova_hw4_5m.remote.LoveModel
import com.example.zhibek_romanbekova_hw4_5m.remote.RetrofitService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Repository {

    val api = RetrofitService().api

    fun getLoveModel(firstName:String,secondName:String): MutableLiveData<LoveModel> {
        val mutableLiveData = MutableLiveData<LoveModel>()
        api.getCapability(firstName = firstName,secondName = secondName)
            .eneuque(object : Callback<LoveModel> {
                override fun onResponse(call: Call<LoveModel>, response: Response<LoveModel>) {
                    if (response.isSuccessful){
                        val model = response.body()!!
                        mutableLiveData.postValue(model)
                    }
                }

                override fun onFailure(call: Call<LoveModel>, t: Throwable) {
                    Log.e("ololo","onFailure: ${t.message}")
                }
            })
        return mutableLiveData
    }

}