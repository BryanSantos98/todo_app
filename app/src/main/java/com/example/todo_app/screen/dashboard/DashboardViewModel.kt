package com.example.todo_app.screen.dashboard

import android.view.MenuItem
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.todo_app.R
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DashboardViewModel @Inject constructor() : ViewModel() {

    val showHomeDashboard = MutableLiveData<Unit>()
    val showAssetsDashboard = MutableLiveData<Unit>()
    val showHelpCenterDashboard = MutableLiveData<Unit>()
    val showAgentsDashboard = MutableLiveData<Unit>()

    fun selectBottomNavItem(menuItem: MenuItem) : Boolean {
        when (menuItem.itemId) {
            R.id.menu_home -> {
                showHomeDashboard.postValue(Unit)
                return true
            }
            R.id.menu_assets -> {
                showAssetsDashboard.postValue(Unit)
                return true
            }
            R.id.menu_help_center -> {
                showHelpCenterDashboard.postValue(Unit)
                return true
            }
            R.id.menu_agents -> {
                showAgentsDashboard.postValue(Unit)
                return true
            }
            else -> return false
        }
    }
}