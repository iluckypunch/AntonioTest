package com.example.antoniotest.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.antoniotest.data.RepositoryImpl
import com.example.antoniotest.domain.GetSumUseCase
import java.lang.NumberFormatException

class MainViewModel: ViewModel() {
    private val repository = RepositoryImpl

    private val getSumUseCase = GetSumUseCase(repository)

    private var _sum = MutableLiveData<String>()
    val sum: LiveData<String>
        get() = _sum

    private val _errorInput = MutableLiveData<Boolean>()
    val errorInput: LiveData<Boolean>
        get() = _errorInput

    fun getSum(a: String, b: String) {
        _sum.value = getSumUseCase.getSum(a, b)
    }

    fun validateInput(input: String): Boolean {
        try {
            input.toInt()
            return true
        } catch (e: NumberFormatException) {
            _errorInput.value = true
        }
        _errorInput.value = true
        return false
    }

    fun resetErrorInput() {
        _errorInput.value = false
    }

}