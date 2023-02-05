package com.example.todo_app.screen.createtask

import android.view.LayoutInflater
import androidx.fragment.app.viewModels
import com.example.todo_app.base.BaseFragment
import com.example.todo_app.databinding.FragmentCreateTaskBinding

class CreateTaskFragment : BaseFragment<FragmentCreateTaskBinding>() {
    override val bindingInflater: (LayoutInflater) -> FragmentCreateTaskBinding =
        FragmentCreateTaskBinding::inflate

    override val viewModel: CreateTaskViewModel by viewModels()

    override fun initObservers() {

    }

    override fun initViews() {

    }
}