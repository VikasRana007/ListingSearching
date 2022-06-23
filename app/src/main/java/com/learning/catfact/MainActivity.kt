package com.learning.catfact

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.learning.catfact.data.model.Data
import com.learning.catfact.databinding.ActivityMainBinding
import com.learning.catfact.presentation.BreedAdapter
import com.learning.catfact.presentation.BreedViewModel
import com.learning.catfact.presentation.BreedViewModelFactory
import com.learning.catfact.presentation.di.Injector
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    @Inject
    lateinit var factory: BreedViewModelFactory
    private lateinit var breedViewModel: BreedViewModel
    private lateinit var activityMainBinding: ActivityMainBinding
    private lateinit var adapter: BreedAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        (application as Injector).createBreedSubComponent()
            .inject(this)
        // now we can inject dependencies into this activity , lets inject view model factory class

        breedViewModel = ViewModelProvider(this, factory)[BreedViewModel::class.java]
        initRecyclerView()
    }

    private fun initRecyclerView() {
        activityMainBinding.recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = BreedAdapter()
        activityMainBinding.recyclerView.adapter = adapter
        displayBreedList()
    }

    private fun displayBreedList() {
        activityMainBinding.breedProgressBar.visibility = View.VISIBLE
        val responseLiveData: LiveData<List<Data>?> = breedViewModel.getBreed()
        responseLiveData.observe(this) {
//            Log.i("MY TAG", it.toString())
            if (it != null) {
                adapter.setList(it)
                adapter.notifyDataSetChanged()
                activityMainBinding.breedProgressBar.visibility = View.GONE
            } else {
                activityMainBinding.breedProgressBar.visibility = View.GONE
                Toast.makeText(this, "No Data Available", Toast.LENGTH_LONG).show()
            }
        }
    }
}