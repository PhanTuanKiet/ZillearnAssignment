package com.example.zillearnassignment.view

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import com.example.zillearnassignment.databinding.ActivityMainBinding
import com.example.zillearnassignment.view.fragment.CourseListFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        addFragment(CourseListFragment.newInstance())
    }


    fun addFragment(f: Fragment){
        binding.fragContainer?.let {
            val ft = supportFragmentManager.beginTransaction()

            ft.add(it.id, f, f.javaClass.simpleName)

            ft.addToBackStack(f.javaClass.simpleName)

            ft.commitAllowingStateLoss()
        }
    }

    fun replaceFragment(f: Fragment){
        binding.fragContainer?.let {
            val ft = supportFragmentManager.beginTransaction()

            ft.replace(it.id, f, f.javaClass.simpleName)

            ft.addToBackStack(f.javaClass.simpleName)

            ft.commitAllowingStateLoss()
        }
    }
}