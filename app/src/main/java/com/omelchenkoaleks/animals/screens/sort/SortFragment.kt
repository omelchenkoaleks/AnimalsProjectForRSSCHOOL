package com.omelchenkoaleks.animals.screens.sort

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.omelchenkoaleks.animals.R
import com.omelchenkoaleks.animals.databinding.FragmentSortBinding
import com.omelchenkoaleks.animals.utils.APP_ACTIVITY

class SortFragment : Fragment() {

    private var _binding: FragmentSortBinding? = null
    private val binding get() = requireNotNull(_binding)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSortBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()

        APP_ACTIVITY.buttonBack.setOnClickListener {
            APP_ACTIVITY.buttonBack.visibility = View.INVISIBLE

            APP_ACTIVITY.navController.navigate(R.id.action_extraOnSortFragment_to_animalsFragment)
        }
    }

    override fun onResume() {
        super.onResume()
        APP_ACTIVITY.toolbarTitle.text = getString(R.string.sort_by)
        APP_ACTIVITY.buttonSort.visibility = View.INVISIBLE
        APP_ACTIVITY.buttonBack.visibility = View.VISIBLE
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}