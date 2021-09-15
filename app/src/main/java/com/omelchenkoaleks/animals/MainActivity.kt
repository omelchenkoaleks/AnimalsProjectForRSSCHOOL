package com.omelchenkoaleks.animals

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatImageButton
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.google.android.material.textview.MaterialTextView
import com.omelchenkoaleks.animals.databinding.ActivityMainBinding
import com.omelchenkoaleks.animals.utils.APP_ACTIVITY

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    lateinit var navController: NavController
    lateinit var toolbar: androidx.appcompat.widget.Toolbar
    lateinit var toolbarTitle: MaterialTextView
    lateinit var buttonSort: AppCompatImageButton
    lateinit var buttonBack: AppCompatImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        APP_ACTIVITY = this

        navController = Navigation.findNavController(this, R.id.nav_host_fragment)
        initToolbar()

        binding.btnSort.setOnClickListener {
            this.navController.navigate(R.id.action_animalsFragment_to_extraOnSortFragment)
        }
    }

    private fun initToolbar() {
        toolbar = binding.toolbar
        toolbarTitle = binding.toolbarTitle
        buttonSort = binding.btnSort
        buttonBack = binding.btnBack

        setSupportActionBar(toolbar)
    }

}