package com.example.teste.viewmodels

import PostsRepository
import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.teste.entity.PostEntity
import com.example.teste.service.listener.APIListener
import com.example.teste.service.model.ValidationModel
import com.example.teste.R


class PostViewModel(application: Application) : AndroidViewModel(application) {

    private val postsRepository = PostsRepository(application.applicationContext)

    private val _posts = MutableLiveData<List<PostEntity>>()
    val posts: LiveData<List<PostEntity>> = _posts


    private val _validation = MutableLiveData<ValidationModel>()
    val validation: LiveData<ValidationModel> = _validation

    private val _loading = MutableLiveData<Boolean>()
    val loading: LiveData<Boolean> = _loading

    fun list() {
        _loading.value = true
        postsRepository.list(object : APIListener<List<PostEntity>> {
            override fun onSuccess(result: List<PostEntity>) {
                _posts.value = result
                val context = getApplication<Application>().applicationContext
                val successMessage = context.getString(R.string.msg_successfully)
                _validation.value = ValidationModel(successMessage)
                _loading.value = false
            }

            override fun onFailure(message: String) {
                Log.e("PostViewModel", "Erro ao carregar posts: $message")
                _validation.value = ValidationModel(message)
                _loading.value = false
            }
        })
    }
}