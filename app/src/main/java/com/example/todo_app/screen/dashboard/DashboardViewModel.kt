package com.example.todo_app.screen.dashboard

import android.util.Log
import android.view.MenuItem
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.todo_app.R
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DashboardViewModel @Inject constructor() : ViewModel() {

    val switchFragment = MutableLiveData<Int>()
    val setMenuIcon = MutableLiveData<Pair<Int, Boolean>>()
    val setHomeStyle = MutableLiveData<Unit>()
    val setAssetsStyle = MutableLiveData<Unit>()
    val setHelpCenterStyle = MutableLiveData<Unit>()
    val setAgentsStyle = MutableLiveData<Unit>()

    fun selectBottomNavItem(menuItem: MenuItem): Boolean {
        when (menuItem.itemId) {
            R.id.menu_home -> {
                switchFragment.postValue(DashboardFragment.HOME_INDEX)
                return true
            }
            R.id.menu_assets -> {
                switchFragment.postValue(DashboardFragment.ASSETS_INDEX)
                return true
            }
            R.id.menu_help_center -> {
                switchFragment.postValue(DashboardFragment.HELP_CENTER_INDEX)
                return true
            }
            R.id.menu_agents -> {
                switchFragment.postValue(DashboardFragment.AGENTS_INDEX)
                return true
            }
            else -> return false
        }
    }

    fun setBottomMenuIcon(menuItemId: Int) {
        when (menuItemId) {
            R.id.menu_home -> setMenuIcon.postValue(Pair(DashboardFragment.HOME_INDEX, true))
            R.id.menu_assets -> setMenuIcon.postValue(Pair(DashboardFragment.ASSETS_INDEX, true))
            R.id.menu_help_center -> setMenuIcon.postValue(
                Pair(
                    DashboardFragment.HELP_CENTER_INDEX,
                    true
                )
            )
            R.id.menu_agents -> setMenuIcon.postValue(Pair(DashboardFragment.AGENTS_INDEX, true))
        }
    }

    fun setScreenDataAndStyle(pageIndex: Int) {
        when (pageIndex) {
            DashboardFragment.HOME_INDEX -> setHomeStyle.postValue(Unit)
            DashboardFragment.ASSETS_INDEX -> setAssetsStyle.postValue(Unit)
            DashboardFragment.HELP_CENTER_INDEX -> setHelpCenterStyle.postValue(Unit)
            DashboardFragment.AGENTS_INDEX -> setAgentsStyle.postValue(Unit)
        }

    }
}