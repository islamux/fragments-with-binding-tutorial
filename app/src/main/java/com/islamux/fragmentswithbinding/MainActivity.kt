package com.islamux.fragmentswithbinding

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.islamux.fragmentswithbinding.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    /* Steps in main activity:
    * 1- Declare binding and fragments variables
    * 2- Initialize binding variable
    * 3- Set the layout for the activity using the binding variable
    * 4- Initialize the fragment variables and set the click listener for the button
    * 5- Set the click listener for the button to switch fragments in the activity from the button click listener
    * 6 Create a function to switch fragments in the activity
    *   1/6- Add the fragment to the activity using the supportFragmentManager and the fragmentTransaction
    * 7 Call the function to switch fragments in the activity from the button click listener */

    /* 1- Declare binding and FragmentManager variable */
    private lateinit var binding: ActivityMainBinding
    private lateinit var framentManager: FragmentManager


    private val TAG = "MainActivity" // Tag for logging purposes

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d(TAG,"Fathi: onCreate")

        super.onCreate(savedInstanceState)

        // 2- Initialize binding variable
        binding = ActivityMainBinding.inflate(layoutInflater)

        // 3- Set the layout for the activity using the binding variable
        setContentView(binding.root) // Set the layout for the activity

       // 4, 5 - Initialize the fragment variables and set the click listener for the button
        binding.btnFragment1.setOnClickListener{switchFragment(Fragment1())}
        binding.btnFragment2.setOnClickListener{switchFragment(Fragment2())}

    }

    /*     Functions   */
    // 7 - create a function to switch fragments in the activity
    private fun switchFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()

        fragmentTransaction.replace(R.id.fragmentContainerView, fragment)
        fragmentTransaction.commit()
    }
}