package com.example.postsampledaggerhilt.ui

import android.util.Log
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.postsampledaggerhilt.common.ResultState
import com.example.postsampledaggerhilt.data.PostRepository
import com.example.postsampledaggerhilt.data.response.PostItem
import com.example.postsampledaggerhilt.data.response.PostResponse
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch

class PostViewModel @ViewModelInject constructor(private val repository: PostRepository) :
    ViewModel() {


    private val _posts = MutableLiveData<ResultState<List<PostItem>>>()
    val news: LiveData<ResultState<List<PostItem>>> get() = _posts


    init {
        fetchNews()
    }

    private fun fetchNews() {
        viewModelScope.launch {
            _posts.postValue(ResultState.loading(null))
            // delay(1_500)
            try {
                _posts.postValue(ResultState.success(repository.getPosts().body()))
            } catch (e: Exception) {
                _posts.postValue(ResultState.error(e.message.toString()))
                Log.e("called_error", e.message.toString())
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        viewModelScope.cancel()
    }
}