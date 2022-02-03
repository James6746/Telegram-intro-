package com.example.animations28012022

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

class FragmentAdapter(val fragmentManager: FragmentManager, val lifecycle: Lifecycle) :
    FragmentStateAdapter(fragmentManager, lifecycle) {

    override fun getItemCount(): Int {
        return 6
    }

    override fun createFragment(position: Int): Fragment {

        when (position) {
            0 -> return FirstFragment()
            1 -> return SecondFragment()
            2 -> return ThirdFragment()
            3 -> return ForthFragment()
            4 -> return FifthFragment()
        }
        return SixthFragment()
    }

}
