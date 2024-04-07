package com.example.myapplication.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.adapter.UserAdapter
import com.example.myapplication.model.User
import com.example.myapplication.viewmodel.HomeScreenState
import com.example.myapplication.viewmodel.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint

@Suppress("DEPRECATION")
@AndroidEntryPoint
class HomeFragment : Fragment(), UserAdapter.OnUserActionListener {

    private val viewModel: HomeViewModel by viewModels()
    private lateinit var userAdapter: UserAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var loaderView: ProgressBar

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_home, container, false)

        recyclerView = view.findViewById(R.id.recyclerView)
        loaderView = view.findViewById(R.id.loader)

        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        userAdapter = UserAdapter(ArrayList(), this)
        recyclerView.adapter = userAdapter

        viewModel.screenState.observe(viewLifecycleOwner) { isScreenOn ->
            when (isScreenOn) {
                is HomeScreenState.Completed -> {
                    recyclerView.isVisible = true
                    loaderView.isVisible = false
                }

                is HomeScreenState.Loading -> {
                    recyclerView.isVisible = false
                    loaderView.isVisible = true
                }
            }
        }

        viewModel.observeUserData().observe(viewLifecycleOwner) { users ->
            userAdapter.updateUsers(users)
        }

        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }

    override fun onAccept(user: User) {
        viewModel.updateUserStatus(user, true)
    }

    override fun onDecline(user: User) {
        viewModel.updateUserStatus(user, false)
    }
}