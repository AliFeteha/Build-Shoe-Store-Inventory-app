package com.udacity.shoestore

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.*
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.udacity.shoestore.databinding.FragmentShoeslistBinding
import com.udacity.shoestore.databinding.ShoeTempBinding
import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.models.ShoeslistViewModel

class ShoeslistFragment : Fragment() {
    private lateinit var binding: FragmentShoeslistBinding
    val viewModel:ShoeslistViewModel  by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentShoeslistBinding.inflate(inflater,container,false)
        binding.floatingActionButton.setOnClickListener{
            view: View -> Navigation.findNavController(view).navigate(R.id.action_shoeslistFragment_to_shoesaddFragment)
        }
        viewModel.showList().observe(viewLifecycleOwner){item->
            item.forEach {
                binding.LinearToAddView.addView(TurnOn(it))
            }
        }
        setHasOptionsMenu(true)
        setMenuVisibility(true)

        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.logoutmenu,menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item, requireView().findNavController())
                || super.onOptionsItemSelected(item)
    }

    private fun TurnOn(shoe: Shoe):View{
        val Layout = ShoeTempBinding.
        inflate(LayoutInflater.from(requireContext()),null,false)
        Layout.shoes= shoe
        return Layout.root
    }
}