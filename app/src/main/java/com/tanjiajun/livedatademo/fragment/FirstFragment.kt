package com.tanjiajun.livedatademo.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.tanjiajun.livedatademo.FRAGMENT_TAG_SECOND
import com.tanjiajun.livedatademo.R
import com.tanjiajun.livedatademo.activity.MainActivity
import com.tanjiajun.livedatademo.databinding.FragmentFirstBinding
import com.tanjiajun.livedatademo.viewmodel.MainViewModel

/**
 * Created by TanJiaJun on 2019-12-22.
 */
class FirstFragment : Fragment(), FirstHandlers {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? =
        DataBindingUtil.inflate<FragmentFirstBinding>(
            inflater,
            R.layout.fragment_first,
            container,
            false
        )
            .also { binding ->
                binding.lifecycleOwner = this
                binding.viewModel = activity?.let {
                    ViewModelProviders.of(it)[MainViewModel::class.java]
                }
                binding.handlers = this
            }
            .root

    override fun onNavigateToSecondFragmentClick(view: View) {
        (activity as MainActivity).addFragment(SecondFragment(), FRAGMENT_TAG_SECOND)
    }

}

interface FirstHandlers {

    fun onNavigateToSecondFragmentClick(view: View)

}