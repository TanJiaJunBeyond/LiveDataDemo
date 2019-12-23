package com.tanjiajun.livedatademo.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * Created by TanJiaJun on 2019-12-22.
 */
class MainViewModel : ViewModel() {

    val firstContent: MutableLiveData<String> by lazy {
        MutableLiveData<String>().apply { value = "第一个文本" }
    }

    val secondContent: MutableLiveData<String> by lazy {
        MutableLiveData<String>().apply { value = "第二个文本" }
    }

}