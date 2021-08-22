package com.omelchenkoaleks.animals.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.omelchenkoaleks.animals.R
import com.omelchenkoaleks.animals.databinding.FragmentAddAnimalBinding
import com.omelchenkoaleks.animals.utils.APP_ACTIVITY

class AddAnimalFragment : Fragment() {

    private var _binding: FragmentAddAnimalBinding? = null
    private val binding get() = requireNotNull(_binding)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAddAnimalBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onResume() {
        super.onResume()
        APP_ACTIVITY.toolbarTitle.text = getString(R.string.add_animal)
        APP_ACTIVITY.buttonSort.visibility = View.INVISIBLE
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}