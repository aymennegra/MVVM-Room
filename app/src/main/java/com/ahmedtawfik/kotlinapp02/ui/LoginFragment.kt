package com.ahmedtawfik.kotlinapp02.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.ahmedtawfik.kotlinapp02.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {

    //Global Variables
    val userName: String = "test"
    val password: String = "test123"

    lateinit var binding: FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnLogin.setOnClickListener {

            if (!binding.edtUserName.text.toString()
                    .isNullOrEmpty() && !binding.edtPassword.text.toString().isNullOrEmpty()
            ) {
                if (binding.edtUserName.text.toString()
                        .equals(userName) && binding.edtPassword.text.toString().equals(password)
                ) {
                    Toast.makeText(context, "Login Successful", Toast.LENGTH_LONG).show()


                    var action =
                        LoginFragmentDirections.actionLoginFragmentToListFragment(
                            userName
                        )

                    findNavController().navigate(action)

                }
            }

        }

    }
}