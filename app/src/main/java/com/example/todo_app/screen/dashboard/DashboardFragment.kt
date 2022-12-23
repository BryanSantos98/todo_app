package com.example.todo_app.screen.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.todo_app.databinding.FragmentDashboardBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DashboardFragment : Fragment() {
    private var _binding: FragmentDashboardBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViews()
    }

    private fun initViews() {
//        binding.tvDay.text = "Today"
//        binding.tvDate.text = "18 jun.2019. Tuesday"


        // TODO Colocar no tvDay o texto "Today"
        // TODO Colocar no tvDate a data do dispositivo no formato brasileiro dd/mm/yyyy
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}