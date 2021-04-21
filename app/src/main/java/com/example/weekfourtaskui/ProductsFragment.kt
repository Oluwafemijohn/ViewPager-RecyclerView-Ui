package com.example.weekfourtaskui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.example.weekfourtaskui.R
import com.example.weekfourtaskui.adapters.RecyclerAdapter
import com.example.weekfourtaskui.adapters.ViewPagerAdapter
import com.example.weekfourtaskui.datamode.ViewPagerMode
import com.example.weekfourtaskui.datasource.RecyclerViewDataSource
import com.example.weekfourtaskui.datasource.ViewPagerDataSource
import java.nio.file.Files.list
import java.util.Collections.list

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class ProductsFragment : Fragment() {

    private val adapter = RecyclerAdapter()

    lateinit var recyclerView: RecyclerView
    lateinit var viewPager: ViewPager2

    private var param1: String? = null
    private var param2: String? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_products, container, false)

        recyclerView = view.findViewById(R.id.recycler_view)
        viewPager = view.findViewById(R.id.view_pager)
//        addDataSet()
        initRecyclerView()
        initViewPager()


        return view

    }

    companion object {

        fun newInstance(): ProductsFragment = ProductsFragment()

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ProductsFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    private fun initRecyclerView() {

        recyclerView.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        recyclerView.adapter = adapter


//        recyclerView.apply {
//            layoutManager =  LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
//
//            this.adapter = this@ProductsFragment.adapter
//        }
    }

    private fun initViewPager() {
//
//        viewPager.layoutManager =
//            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        viewPager.adapter = ViewPagerAdapter()

            viewPager.apply {
            clipToPadding = false
            clipChildren = false
            offscreenPageLimit = 5
            setPadding(120, 0, 120, 0)



//        recyclerView.apply {
//            layoutManager =  LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
//
//            this.adapter = this@ProductsFragment.adapter
        }
    }

//
//    private fun loanDebits() {
//        /**
//         * Instantiate cards
//         * */
//        val debitCards = ViewPagerMode.list
/*

/ **
* Setup ViewpagerAdapter
* * /
*/
//    viewPagerAdapter = ViewPagerAdapter(list)
//        viewPager.apply {
//            clipToPadding = false
//            clipChildren = false
//            offscreenPageLimit = 2
//            setPadding(150, 0, 150, 0)
//        }
//        val marginPageTransformer = MarginPageTransformer(30)
//        val compositionPageTransformer = CompositePageTransformer()
//        compositionPageTransformer.addTransformer(marginPageTransformer)
//        compositionPageTransformer.addTransformer { page, position ->
//            page.scaleY = 1 - (0.25f * kotlin.math.abs(position))
//        }
//        viewPager.setPageTransformer(compositionPageTransformer)
//
////        TabLayoutMediator(indicator, viewPager) { tab, position ->
////            tab.icon = resources.getDrawable(R.drawable.active_indicator)
//////            viewPager.setCurrentItem(tab.position, true)
////        }.attach()
////        countDots = viewPagerAdapter.itemCount
////        val dots = arrayOfNulls<ImageView>(countDots)
////        for (i in 0 until countDots) {
////            dots[i] = ImageView(requireContext())
////            dots[i]!!.setImageDrawable(ContextCompat.getDrawable(requireContext(), R.drawable.default_indicator))
////        }
//    }


}