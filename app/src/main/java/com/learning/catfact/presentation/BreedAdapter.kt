package com.learning.catfact.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.learning.catfact.R
import com.learning.catfact.data.model.Data
import com.learning.catfact.databinding.ListItemBinding

class BreedAdapter : RecyclerView.Adapter<MyViewHolder>() {
    private val breedList = ArrayList<Data>()
    fun setList(breeds: List<Data>) {
        breedList.clear()
        breedList.addAll(breeds)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: ListItemBinding =
            DataBindingUtil.inflate(layoutInflater, R.layout.list_item, parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(breedList[position])
    }

    override fun getItemCount(): Int {
        return breedList.size
    }

}

class MyViewHolder(private val binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(data: Data) {
        """Breed Name :  ${data.breed}""".also { binding.breedName.text = it }
        """Coat Name : ${data.coat}""".also { binding.coatName.text = it }
        """Country Name : ${data.country}""".also { binding.countryName.text = it }
        """Origin Name : ${data.origin}""".also { binding.originName.text = it }
        """Pattern Name : ${data.pattern}""".also { binding.patternName.text = it }
    }
}
