package com.soumya.sonarqubelocal.view

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.soumya.sonarqubelocal.R
import com.soumya.sonarqubelocal.databinding.ActivityMainBinding
import com.soumya.sonarqubelocal.repository.PublicAPIRepository
import com.soumya.sonarqubelocal.retrofit.PublicAPIService
import com.soumya.sonarqubelocal.retrofit.RetrofitHelper
import com.soumya.sonarqubelocal.viewmodel.MainViewModel
import com.soumya.sonarqubelocal.viewmodel.MainViewModelFactory

class MainActivity : AppCompatActivity() {
    private lateinit var mainBinding: ActivityMainBinding
    private lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val publicServiceApi = RetrofitHelper.getInstance().create(PublicAPIService::class.java)
        val repository = PublicAPIRepository(publicServiceApi)
        mainViewModel =
            ViewModelProvider(this, MainViewModelFactory(repository)).get(MainViewModel::class.java)

    }

    fun fetchData(view: View) {
        mainViewModel.getEntries.observe(this, Observer {
            mainBinding.textView.text = it.toString()
        })
    }
}