package com.tanjiajun.livedatademo.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.tanjiajun.livedatademo.FRAGMENT_TAG_FIRST
import com.tanjiajun.livedatademo.R
import com.tanjiajun.livedatademo.fragment.FirstFragment

class MainActivity : AppCompatActivity() {

    private lateinit var manager: FragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        manager = supportFragmentManager
        addFragment(FirstFragment(), FRAGMENT_TAG_FIRST)
    }

    fun addFragment(fragment: Fragment, tag: String) =
        with(manager.beginTransaction()) {
            add(R.id.fl_content, fragment, tag)
            addToBackStack(tag)
            commitAllowingStateLoss()
        }

    override fun onBackPressed() {
        manager
            .takeIf { it.backStackEntryCount > 1 }
            ?.popBackStackImmediate()
            ?: finish()
    }

}