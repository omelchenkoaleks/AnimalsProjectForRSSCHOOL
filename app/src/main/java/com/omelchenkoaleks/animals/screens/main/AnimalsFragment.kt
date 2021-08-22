package com.omelchenkoaleks.animals.screens.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.omelchenkoaleks.animals.R
import com.omelchenkoaleks.animals.databinding.FragmentAnimalsBinding
import com.omelchenkoaleks.animals.utils.APP_ACTIVITY
import com.omelchenkoaleks.animals.utils.listAnimals

class AnimalsFragment : Fragment() {

    private var _binding: FragmentAnimalsBinding? = null
    private val binding get() = requireNotNull(_binding)

    private lateinit var recycler: RecyclerView
    private lateinit var adapter: AnimalsAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAnimalsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = AnimalsAdapter()
        adapter.setAnimals(listAnimals)
        recycler = binding.recyclerView
        recycler.adapter = adapter


        binding.btnAddAnimal.setOnClickListener {
            APP_ACTIVITY.navController.navigate(R.id.action_animalsFragment_to_addAnimalFragment)
        }

    }

    override fun onResume() {
        super.onResume()
        APP_ACTIVITY.toolbarTitle.text = getString(R.string.animals)
        APP_ACTIVITY.buttonSort.visibility = View.VISIBLE
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
        recycler.adapter = null
    }

}