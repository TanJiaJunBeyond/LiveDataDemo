package com.tanjiajun.livedatademo.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.tanjiajun.livedatademo.R
import com.tanjiajun.livedatademo.databinding.FragmentSecondBinding
import com.tanjiajun.livedatademo.viewmodel.MainViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

/**
 * Created by TanJiaJun on 2019-12-22.
 */
class SecondFragment : Fragment(), SecondHandlers {

    private var viewModel: MainViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = activity?.let { ViewModelProviders.of(it)[MainViewModel::class.java] }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? =
        DataBindingUtil.inflate<FragmentSecondBinding>(
            inflater,
            R.layout.fragment_second,
            container,
            false
        )
            .also {
                it.handlers = this
            }
            .root

    override fun onChangeFirstContentClick(view: View) {
        viewModel?.firstContent?.value = getString(R.string.first_content_changed)
    }

    override fun onChangeSecondContentClick(view: View) {
        runBlocking {
            withContext(Dispatchers.Default) {
                viewModel?.secondContent?.postValue(getString(R.string.second_content_changed))
            }
        }
    }

}

interface SecondHandlers {

    fun onChangeFirstContentClick(view: View)

    fun onChangeSecondContentClick(view: View)

}