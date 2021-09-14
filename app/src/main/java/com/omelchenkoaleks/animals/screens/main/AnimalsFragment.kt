package com.omelchenkoaleks.animals.screens.main

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResultListener
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.RecyclerView
import com.omelchenkoaleks.animals.AnimalsApplication
import com.omelchenkoaleks.animals.R
import com.omelchenkoaleks.animals.databinding.FragmentAnimalsBinding
import com.omelchenkoaleks.animals.utils.APP_ACTIVITY


class AnimalsFragment : Fragment() {

    private var _binding: FragmentAnimalsBinding? = null
    private val binding get() = requireNotNull(_binding)

    // TODO: until not used!!!
    var updateList: Boolean = false

    private val animalViewModel: AnimalViewModel by viewModels {
        AnimalViewModelFactory((activity?.application as AnimalsApplication).repository)
    }

    private lateinit var recycler: RecyclerView
    private lateinit var adapter: AnimalsAdapter

    @SuppressLint("NotifyDataSetChanged")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // TODO: returned data from fragment Sort ??? until not used!!!
        setFragmentResultListener("key_redraw_list_request") { _, bundle ->
            updateList = bundle.getBoolean("key_redraw_list_bundle")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAnimalsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        animalViewModel.allAnimals.observe(this) { animals ->
            animals.let { adapter.setAnimals(it) }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = AnimalsAdapter()
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