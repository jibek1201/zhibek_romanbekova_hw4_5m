package com.example.zhibek_romanbekova_hw4_5m.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.zhibek_romanbekova_hw4_5m.databinding.ActivitySecondBinding
import com.example.zhibek_romanbekova_hw4_5m.remote.LoveModel


class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondbinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding inflate(layoutInflater)
        setContentView(binding.root)

        val result = intent.getSerializableExtra("result") as? LoveModel

        if (result != null) {
            binding.tvName.text = result.fname
            binding.tvNameGl.text = result.sname
            binding.tvResult.text = result.result
            binding.tvPercentage.text = result.percentage
        } else {
            Toast.makeText(this, "Ошибка: Результат не был передан", Toast.LENGTH_SHORT).show()
            finish()
        }
    }

}