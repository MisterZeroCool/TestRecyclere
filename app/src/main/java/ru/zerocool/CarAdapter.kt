package ru.zerocool

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.zerocool.databinding.CarItemBinding

class CarAdapter : RecyclerView.Adapter<CarAdapter.CarViewHolder>() {
    val carList = ArrayList<Car>()
    class CarViewHolder(item: View) : RecyclerView.ViewHolder(item) {
        private val binding = CarItemBinding.bind(item)
        fun bind(car: Car) = with(binding) {
            imageId.setImageResource(car.id)
            textView.text = car.title

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.car_item, parent,false)
        return CarViewHolder(view)
    }

    override fun getItemCount(): Int {
        return carList.size
    }

    override fun onBindViewHolder(holder: CarViewHolder, position: Int) {
        holder.bind(carList[position])
    }

    fun addCar(car: Car){
        carList.add(car)
        notifyDataSetChanged()
    }

}