package com.example.zhibek_romanbekova_hw4_5m.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.zhibek_romanbekova_hw4_5m.LoveViewModel
import com.example.zhibek_romanbekova_hw4_5m.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: LoveViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initClicker()
    }

    private fun initClicker() {
        with(binding) {
            btnCalculate.setOnClickListener {
                viewModel.getLove(
                    firstName = binding.etName.text.toString(),
                    secondName = binding.etNameGl.text.toString()
                ).observe(this@MainActivity, Observer {
                    it?.let { model ->
                        tvResult.text
                        "${model.fname} \n ${model.sname} \n ${model.percentage} \n ${model.result}"
                    }
                })
            }
        }
    }

}