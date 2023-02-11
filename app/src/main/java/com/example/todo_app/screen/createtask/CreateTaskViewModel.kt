package com.example.todo_app.screen.createtask

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.todo_app.base.BaseViewModel
import com.example.todo_app.data.model.task.Person
import com.example.todo_app.repositories.person.PersonRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CreateTaskViewModel @Inject constructor(private val repository: PersonRepository) :
    BaseViewModel() {

    val personList = MutableLiveData<List<Person>>()

    fun getPersonList() {
        personList.postValue(repository.getPersonList())
    }

}