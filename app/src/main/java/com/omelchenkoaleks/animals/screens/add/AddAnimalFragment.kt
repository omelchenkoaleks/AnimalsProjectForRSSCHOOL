package com.omelchenkoaleks.animals.screens.add

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.omelchenkoaleks.animals.AnimalsApplication
import com.omelchenkoaleks.animals.R
import com.omelchenkoaleks.animals.databinding.FragmentAddAnimalBinding
import com.omelchenkoaleks.animals.model.Animal
import com.omelchenkoaleks.animals.utils.APP_ACTIVITY
import com.omelchenkoaleks.animals.utils.showToast

class AddAnimalFragment : Fragment() {

    private var _binding: FragmentAddAnimalBinding? = null
    private val binding get() = requireNotNull(_binding)

    private val addAnimalViewModel: AddAnimalViwModel by viewModels {
        AddAnimalViewModelFactory((activity?.application as AnimalsApplication).repository)
    }

//    override fun onStart() {
//        super.onStart()
//        addAnimalViewModel.allAnimals.observe(APP_ACTIVITY) { animals ->
//            animals.let {  }
//        }
//    }


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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.btnSaveAnimal.setOnClickListener {
            val name = binding.etName.text.toString()
            val age = binding.etAge.text.toString()
            val breed = binding.etBreed.text.toString()

            if (name.isEmpty() && age.isEmpty() && breed.isEmpty()) {
                showToast(getString(R.string.sort))
            } else {
                addAnimalViewModel.insert(Animal(name = name, age = age.toInt(), breed = breed))
                APP_ACTIVITY.navController.navigate(R.id.action_addAnimalFragment_to_animalsFragment)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}