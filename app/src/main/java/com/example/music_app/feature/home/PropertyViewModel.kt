package com.example.music_app.feature.home

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.music_app.core.model.Property
import com.example.music_app.core.network.RetrofitClient
import com.example.music_app.core.repository.PropertyRepository
import kotlinx.coroutines.launch

class PropertyViewModel : ViewModel() {
    private val repository = PropertyRepository(RetrofitClient.instance)

    private val _properties = mutableStateOf<List<Property>>(emptyList())
    val properties: State<List<Property>> = _properties

    private val _isLoading = mutableStateOf(false)
    val isLoading: State<Boolean> = _isLoading

    private val _error = mutableStateOf<String?>(null)
    val error: State<String?> = _error

    init {
        fetchProperties()
    }

    fun fetchProperties() {
        viewModelScope.launch {
            _isLoading.value = true
            _error.value = null
            try {
                val response = repository.getProperties()
                if (response.isSuccessful) {
                    _properties.value = response.body()?.data?.content ?: emptyList()
                } else {
                    _error.value = "Failed to fetch properties: ${response.message()}"
                }
            } catch (e: Exception) {
                _error.value = "An error occurred: ${e.message}"
            } finally {
                _isLoading.value = false
            }
        }
    }
}
