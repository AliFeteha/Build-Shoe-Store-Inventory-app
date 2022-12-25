package com.udacity.shoestore

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.udacity.shoestore.databinding.FragmentLoginBinding

class LoginFragment() : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding: FragmentLoginBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_login, container, false
        )
        binding.logging.setOnClickListener{view: View ->
            if(binding.editTextTextEmailAddress.text.isEmpty() ||binding.editTextNumberPassword.text.isEmpty() ){
                binding.editTextTextEmailAddress.setText("")
                binding.editTextNumberPassword.setText("")
                Toast.makeText(context,"invalid data",Toast.LENGTH_SHORT).show()

            }else{
                Navigation.findNavController(view).navigate(R.id.action_loginFragment2_to_welcomeFragment2)
            }

        }
        binding.newLogin.setOnClickListener{view: View ->
            if(binding.editTextTextEmailAddress.text.isEmpty() ||binding.editTextNumberPassword.text.isEmpty() ){
                binding.editTextTextEmailAddress.setText("")
                binding.editTextNumberPassword.setText("")
                Toast.makeText(context,"invalid data",Toast.LENGTH_SHORT).show()

            }else{
                Navigation.findNavController(view).navigate(R.id.action_loginFragment2_to_welcomeFragment2)
            }
        }


        return binding.root
    }
}