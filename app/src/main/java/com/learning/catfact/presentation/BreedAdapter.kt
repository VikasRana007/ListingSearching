package com.learning.catfact.presentation

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.learning.catfact.R
import com.learning.catfact.data.model.Data
import com.learning.catfact.databinding.ListItemBinding

@Suppress("UNCHECKED_CAST")
open class BreedAdapter : RecyclerView.Adapter<MyViewHolder>(), Filterable {
    private var breedList = ArrayList<Data>()
    private var breedListFiltered: List<Data> = arrayListOf()

    fun setList(breeds: List<Data>) {
        breedList.clear()
        breedList.addAll(breeds)
        breedListFiltered = breeds
//        breedListAll = ArrayList(breeds)
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

    override fun getFilter(): Filter {
        val filter = object : Filter() {
            override fun performFiltering(constraint: CharSequence?): FilterResults {
                var filterResultss = FilterResults()

                if (constraint == null || constraint.isEmpty()) {
                    filterResultss.values = breedListFiltered
                    filterResultss.count = breedListFiltered.size
                } else {
                    var searchChar = constraint.toString().toLowerCase()
                    var filterResults = ArrayList<Data>()

                    for (data in breedListFiltered) {
                        if (data.breed!!.toLowerCase().contains(searchChar)) {
                            filterResults.add(data)
                        }
                    }
                    filterResultss.values = filterResults
                    filterResultss.count = filterResults.size
                }
                return filterResultss
            }

            @SuppressLint("NotifyDataSetChanged")
            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
                breedList =
                    results!!.values as ArrayList<Data> /* = java.util.ArrayList<com.learning.catfact.data.model.Data> */
//                breedListAll =  results?.values as ArrayList<Data> /* = java.util.ArrayList<com.learning.catfact.data.model.Data> */
                notifyDataSetChanged()
            }
        }
        return filter
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
