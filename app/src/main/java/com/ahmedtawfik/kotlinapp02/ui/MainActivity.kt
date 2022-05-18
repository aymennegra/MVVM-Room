package com.ahmedtawfik.kotlinapp02.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ahmedtawfik.kotlinapp02.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {


    //Global references
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)


//        btn_login.setOnClickListener(this)


    }

}

//    override fun onClick(view: View?) {
//
//        when (view!!.id) {
//            R.id.btn_login -> {
//                Toast.makeText(this, "Login Button Clicked", Toast.LENGTH_LONG).show()
//            }
//
//        }
//    }


//    fun onClickLogin(view: View) {
//        Toast.makeText(this, "Login Button Clicked", Toast.LENGTH_LONG).show()
//    }


