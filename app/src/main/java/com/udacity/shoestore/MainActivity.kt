package com.udacity.shoestore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil

import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import com.udacity.shoestore.databinding.ActivityMainBinding
import com.udacity.shoestore.databinding.FragmentLoginBinding

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityMainBinding = DataBindingUtil.inflate(
            layoutInflater, R.layout.activity_main, container, false
        )
        setContentView(binding.container)
        val configration = AppBarConfiguration(setOf(R.id.loginFragment2,R.id.instructionFragment,R.id.shoeslistFragment,R.id.welcomeFragment2))
        val navHost = NavHostFragment.findNavController(supportFragmentManager.findFragmentById(R.id.logFragment)!!)
        NavigationUI.setupWithNavController(toolbar2,navHost,configration)
        setSupportActionBar(findViewById(R.id.toolbar2))
    }
}
