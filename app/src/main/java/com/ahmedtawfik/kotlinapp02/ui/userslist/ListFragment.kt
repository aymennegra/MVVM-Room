package com.ahmedtawfik.kotlinapp02.ui.userslist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.ahmedtawfik.kotlinapp02.R
import com.ahmedtawfik.kotlinapp02.databinding.FragmentListBinding
import com.ahmedtawfik.kotlinapp02.model.entity.User
import com.ahmedtawfik.kotlinapp02.ui.adapter.OnListItemClick
import com.ahmedtawfik.kotlinapp02.ui.adapter.UserRecyclerView

class ListFragment : Fragment(), OnListItemClick {

    lateinit var binding: FragmentListBinding
    var userList: List<User> = emptyList()
    var userName: String? = null

    val userRecyclerView: UserRecyclerView by lazy {
        UserRecyclerView()
    }

    lateinit var viewModel: UsersViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        userName = arguments?.getString("userName")

        viewModel = ViewModelProvider(requireActivity()).get(UsersViewModel::class.java)

        binding.rvShowData.adapter = userRecyclerView

        getAllUsers()

        binding.btnAdd.setOnClickListener {

            var msg = binding.edtMessage.text.toString()

            viewModel.addUser(
                User(
                    0,
                    userName.toString(),
                    msg,
                    R.drawable.userlogin
                )
            )

            getAllUsers()

            binding.edtMessage.setText("")
        }

        userRecyclerView.onListItemClick = this

        viewModel.usersLiveData.observe(viewLifecycleOwner,
            Observer {
                if (!it.isNullOrEmpty()) {
                    userRecyclerView.setList(it)
                    binding.progressBar.visibility = View.GONE
                }
            })

    }

    fun getAllUsers() {

        viewModel.getUsers()
        binding.progressBar.visibility = View.VISIBLE

    }


    override fun onItemClick(user: User) {

        viewModel.deleteUser(user)

        Toast.makeText(
            context,
            "The user is deleted successfully",
            Toast.LENGTH_SHORT
        ).show()

        getAllUsers()
    }
}