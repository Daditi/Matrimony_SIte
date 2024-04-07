package com.example.myapplication.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.adapter.UserStateAdapter
import com.example.myapplication.model.UserStateProfile
import com.example.myapplication.viewmodel.ConnectionViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ConnectionsFragment : Fragment(), UserStateAdapter.OnUserStateActionListener {

    private val viewModel: ConnectionViewModel by viewModels()
    private lateinit var userStateAdapter: UserStateAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var placeholderView: LinearLayout

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_connections, container, false)
        recyclerView = view.findViewById(R.id.userStateRecyclerView)
        placeholderView = view.findViewById(R.id.emptyScreenLayout)

        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        userStateAdapter = UserStateAdapter(ArrayList(), this)
        recyclerView.adapter = userStateAdapter

        viewModel.observeAcceptedUserData().observe(viewLifecycleOwner) { users ->
            users?.let {
                if (users.isNotEmpty()) {
                    recyclerView.isVisible = true
                    placeholderView.isVisible = false
                    userStateAdapter.updateUsers(users)
                } else {
                    recyclerView.isVisible = false
                    placeholderView.isVisible = true
                }
            }
        }
        return view
    }

    override fun onRemove(user: UserStateProfile) {
        viewModel.removedUser(user.email)
    }
}