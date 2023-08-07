package ru.zerocool

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.GridLayout
import androidx.recyclerview.widget.GridLayoutManager
import ru.zerocool.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private val adapter = CarAdapter()
    private val imageIdList = listOf(
        R.drawable.a1,
        R.drawable.a2,
        R.drawable.a3,
        R.drawable.a4,
        R.drawable.a5,
        R.drawable.a6,
        R.drawable.a7,
    )

    private var index = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
    }

    private fun init() = with(binding){
        rcView.layoutManager = GridLayoutManager(this@MainActivity, 3)
        rcView.adapter = adapter
        button.setOnClickListener {
            if (index > imageIdList.size-1) index = 0
            val car = Car(imageIdList[index], "Car $index")
            adapter.addCar(car)
            index++
        }
    }
}