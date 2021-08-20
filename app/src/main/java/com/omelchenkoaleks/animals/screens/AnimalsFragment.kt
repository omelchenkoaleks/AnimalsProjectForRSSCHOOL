package com.omelchenkoaleks.animals.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.omelchenkoaleks.animals.R
import com.omelchenkoaleks.animals.databinding.FragmentAnimalsBinding
import com.omelchenkoaleks.animals.utils.APP_ACTIVITY

class AnimalsFragment : Fragment() {

    private var _binding: FragmentAnimalsBinding? = null
    private val binding get() = requireNotNull(_binding)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAnimalsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnAddAnimal.setOnClickListener {
            APP_ACTIVITY.navController.navigate(R.id.action_animalsFragment_to_addAnimalFragment)
        }

    }

    override fun onResume() {
        super.onResume()
        APP_ACTIVITY.toolbarTitle.text = getString(R.string.animals)
        APP_ACTIVITY.buttonSort.visibility = View.VISIBLE
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}