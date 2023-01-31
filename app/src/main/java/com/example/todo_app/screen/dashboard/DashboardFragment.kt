package com.example.todo_app.screen.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.todo_app.databinding.FragmentDashboardBinding
import com.example.todo_app.screen.dashboard.adapter.ViewPagerAdapter
import com.example.todo_app.screen.dashboardagents.AgentsDashboardFragment
import com.example.todo_app.screen.dashboardassets.AssetsDashboardFragment
import com.example.todo_app.screen.dashboardhelpcenter.HelpCenterDashboardFragment
import com.example.todo_app.screen.dashboardhome.HomeDashboardFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DashboardFragment : Fragment() {
    private var _binding: FragmentDashboardBinding? = null
    private val binding get() = _binding!!

    val viewModel: DashboardViewModel by viewModels()
    lateinit var adapter: ViewPagerAdapter

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
        adapter = ViewPagerAdapter(this)
        initViews()
        initObservers()
    }

    private fun initViews() {
        setViewPager()
        setBottomNavigationListener()
    }

    private fun initObservers() {
        viewModel.showHomeDashboard.observe(viewLifecycleOwner) {
            if (binding.vpDashboardScreen.currentItem < adapter.itemCount - 1)
                binding.vpDashboardScreen.currentItem += 1
        }
        viewModel.showAssetsDashboard.observe(viewLifecycleOwner) {
            if (binding.vpDashboardScreen.currentItem < adapter.itemCount - 1)
                binding.vpDashboardScreen.currentItem += 1
        }
        viewModel.showHelpCenterDashboard.observe(viewLifecycleOwner) {
            if (binding.vpDashboardScreen.currentItem < adapter.itemCount - 1)
                binding.vpDashboardScreen.currentItem += 1
        }
        viewModel.showAgentsDashboard.observe(viewLifecycleOwner) {
            if (binding.vpDashboardScreen.currentItem < adapter.itemCount - 1)
                binding.vpDashboardScreen.currentItem += 1
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun setViewPager() {
        adapter.addFragment(HomeDashboardFragment())
        adapter.addFragment(AssetsDashboardFragment())
        adapter.addFragment(HelpCenterDashboardFragment())
        adapter.addFragment(AgentsDashboardFragment())

        binding.vpDashboardScreen.adapter = adapter

        // set animation to navigate between view pager fragments
        //viewPager.setPageTransformer(YourPageTransformer())
    }

    private fun setBottomNavigationListener() {
        binding.bnvDashboard.setOnItemSelectedListener { menuItem ->
            viewModel.selectBottomNavItem(menuItem)
        }
    }
}