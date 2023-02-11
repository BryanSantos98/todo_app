package com.example.todo_app.screen.createtask

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.OnItemClickListener
import androidx.fragment.app.viewModels
import com.example.todo_app.R
import com.example.todo_app.base.BaseFragment
import com.example.todo_app.databinding.FragmentCreateTaskBinding
import com.example.todo_app.screen.createtask.adapter.ResponsibleArrayAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CreateTaskFragment : BaseFragment<FragmentCreateTaskBinding>() {
    override val bindingInflater: (LayoutInflater) -> FragmentCreateTaskBinding =
        FragmentCreateTaskBinding::inflate

    override val viewModel: CreateTaskViewModel by viewModels()

    override fun initObservers() {
        viewModel.personList.observe(viewLifecycleOwner) {
            val adapter =
                ResponsibleArrayAdapter(requireContext(), R.layout.adapter_search_person, it)

            binding.tvResponsible.setAdapter(adapter)

            binding.tvResponsible.onItemClickListener =
                OnItemClickListener { parent, view, position, id ->
                    Log.e("test4", adapter.getItem(position).toString())
                }
        }
    }

    override fun initViews() {
        viewModel.getPersonList()
    }
}
