package com.example.pwapplication

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.pwapplication.data.repository.CharacterRepository
import com.example.pwapplication.ui.characterdetail.CharacterDetailViewModel
import com.example.pwapplication.ui.characterlist.CharacterListViewModel

class CharacterViewModelFactory (private val repository: CharacterRepository) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CharacterListViewModel::class.java)) {
            return CharacterListViewModel(repository) as T
        }
        if (modelClass.isAssignableFrom(CharacterDetailViewModel::class.java)) {
            return CharacterDetailViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}