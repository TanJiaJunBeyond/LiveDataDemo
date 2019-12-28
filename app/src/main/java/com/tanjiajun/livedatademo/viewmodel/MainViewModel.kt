package com.tanjiajun.livedatademo.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

/**
 * Created by TanJiaJun on 2019-12-22.
 */
class MainViewModel : ViewModel() {

    private val _firstContent = MutableLiveData<String>().apply {
        value = "第一个文本"
    }
    val firstContent: LiveData<String> = _firstContent

    private val _secondContent = MutableLiveData<String>().apply {
        value = "第二个文本"
    }
    val secondContent: LiveData<String> = _secondContent

    fun changeFirstContent(text: String) {
        _firstContent.value = text
    }

    fun changeSecondContent(text: String) =
        viewModelScope.launch {
            withContext(Dispatchers.Default) {
                _secondContent.postValue(text)
            }
        }

}