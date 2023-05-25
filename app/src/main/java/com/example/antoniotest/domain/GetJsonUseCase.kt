package com.example.antoniotest.domain

import org.json.JSONArray
import org.json.JSONObject

class GetJsonUseCase(val repository: Repository) {
    fun getJson(): JSONArray {
        return repository.getJson()
    }
}