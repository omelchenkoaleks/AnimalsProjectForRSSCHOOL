package com.omelchenkoaleks.animals

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatImageButton
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.preference.PreferenceManager
import com.google.android.material.textview.MaterialTextView
import com.omelchenkoaleks.animals.databinding.ActivityMainBinding
import com.omelchenkoaleks.animals.utils.APP_ACTIVITY
import com.omelchenkoaleks.animals.utils.showToast

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

    override fun onResume() {
        super.onResume()

        val prefs = PreferenceManager.getDefaultSharedPreferences(this)
        val name = prefs.getString(getString(R.string.key_name), "Nothing").toString()
        val age = prefs.getString(getString(R.string.key_age), "1").toString()
        val breed = prefs.getString(getString(R.string.key_breed), "Nothing").toString()

        showToast("$name $age $breed")
    }

}