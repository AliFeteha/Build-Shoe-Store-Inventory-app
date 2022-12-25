package com.udacity.shoestore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.text.isDigitsOnly
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.databinding.FragmentShoesaddBinding
import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.models.ShoeslistViewModel

class ShoesaddFragment : Fragment() {
    private val viewModel:ShoeslistViewModel by activityViewModels()
    lateinit var binding:FragmentShoesaddBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentShoesaddBinding.inflate(inflater,container,false)
        binding.cancel.setOnClickListener{
            findNavController().navigate(ShoesaddFragmentDirections.actionShoesaddFragmentToShoeslistFragment())
        }
        binding.save.setOnClickListener{
            if(!binding.Size.text.isDigitsOnly()||binding.Size.text.isEmpty()){
                Toast.makeText(context,"invalid size date",Toast.LENGTH_SHORT).show()
            }else{
                viewModel.addShoe()
                findNavController().navigate(ShoesaddFragmentDirections.actionShoesaddFragmentToShoeslistFragment())

            }

        }
        binding.viewModel = viewModel
        return binding.root
    }


}