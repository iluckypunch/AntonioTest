package com.example.antoniotest.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.antoniotest.data.RepositoryImpl
import com.example.antoniotest.domain.GetJsonUseCase

class SecondViewModel: ViewModel() {
    private val repository = RepositoryImpl

    private val getJsonUseCase = GetJsonUseCase(repository)

    fun getNamesFromJson(name: String): String {
        val jsonArray = getJsonUseCase.getJson()
        var names = name + "\n\n"
        for (i in 0 until jsonArray.length()) {
            names += jsonArray.getJSONObject(i).getString(name) + "\n"
        }
        return names
    }
}