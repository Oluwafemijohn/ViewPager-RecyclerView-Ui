package com.example.weekfourtaskui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2
import com.example.weekfourtaskui.R
import com.example.weekfourtaskui.adapters.RecyclerAdapter
import com.example.weekfourtaskui.adapters.ViewPagerAdapter
import com.example.weekfourtaskui.datamode.ViewPagerMode
import com.example.weekfourtaskui.datasource.RecyclerViewDataSource
import com.example.weekfourtaskui.datasource.ViewPagerDataSource
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.fragment_products.*
import java.nio.file.Files.list
import java.util.Collections.list

class ProductsFragment : Fragment() {

    private val adapter = RecyclerAdapter()
    lateinit var recyclerView: RecyclerView
    lateinit var viewPager: ViewPager2
    lateinit var dotIndicator: TabLayout

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_products, container, false)
        recyclerView = view.findViewById(R.id.recycler_view)
        viewPager = view.findViewById(R.id.view_pager)


        initRecyclerView()
        initViewPager()


        /*
        * The mediator will synchronize the ViewPager2's position with the selected tab when a tab is selected,
        *  and the TabLayout's scroll position when the user drags the ViewPager2
        * */
        dotIndicator = view.findViewById(R.id.tab_layout)
        TabLayoutMediator(dotIndicator, viewPager) { tab, position ->
            viewPager.setCurrentItem(tab.position, true)
        }.attach()

        return view
    }


    // Initialize a new linear layout manager (Recycler view)
    private fun initRecyclerView() {
        recyclerView.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false) // Reverse layout
        recyclerView.adapter = adapter
    }

    //Setting the transformation for the viewpager
    private fun initViewPager() {
        viewPager.adapter = ViewPagerAdapter()

        viewPager.apply {
            clipToPadding = false
            clipChildren = false
            offscreenPageLimit = 5
            setPadding(120, 0, 120, 0)
            val marginPageTransformer = MarginPageTransformer(30)
            val compositionPageTransformer = CompositePageTransformer()
            compositionPageTransformer.addTransformer(marginPageTransformer)
            compositionPageTransformer.addTransformer { page, position ->
                page.scaleY = 1 - (0.25f * kotlin.math.abs(position))
            }
            viewPager.setPageTransformer(compositionPageTransformer)
        }
    }

}