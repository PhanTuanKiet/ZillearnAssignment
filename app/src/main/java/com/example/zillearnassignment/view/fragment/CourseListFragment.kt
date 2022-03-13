package com.example.zillearnassignment.view.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.zillearnassignment.base.BaseFragment
import com.example.zillearnassignment.databinding.FragmentCourseListBinding
import com.example.zillearnassignment.model.response.CourseDetail
import com.example.zillearnassignment.view.MainActivity
import com.example.zillearnassignment.view.adapter.CourseAdapter
import com.example.zillearnassignment.viewmodel.CourseListViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CourseListFragment : BaseFragment() {

    companion object {
        fun newInstance(): CourseListFragment {
            return CourseListFragment()
        }
    }

    private val courseListViewModel: CourseListViewModel by viewModels()
    private lateinit var binding: FragmentCourseListBinding
    private val courseAdapter : CourseAdapter by lazy {
        CourseAdapter(::onCourseClick)
    }

    private val observerData: Observer<List<CourseDetail>?> by lazy {
        Observer<List<CourseDetail>?> { list ->
            courseAdapter.listData = list as MutableList<Any>?
            courseAdapter.notifyDataSetChanged()
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (activity != null) {
            mainActivity = activity as MainActivity
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCourseListBinding.inflate(inflater, container, false)
        val view = binding.root
        buildUI()
        getCourseList()
        return view
    }

    private fun buildUI() {
        val linearLayoutManager = LinearLayoutManager(
            requireContext(),
            LinearLayoutManager.VERTICAL,
            false
        )

        binding?.rcvCourseList?.apply {
            layoutManager = linearLayoutManager
        }
        binding?.rcvCourseList?.adapter = courseAdapter

        buildUIObserver()
    }

    private fun buildUIObserver() {
        courseListViewModel.courseResultData.observe(
            this,
            observerData
        )
    }


    private fun getCourseList(){
        courseListViewModel.getCourseList()
    }

    private fun onCourseClick(course : CourseDetail){
        mainActivity.replaceFragment(CourseInfoFragment.newInstance(course.id))
    }

    override fun onDestroy() {
        super.onDestroy()
        courseListViewModel.courseResultData.removeObserver(observerData)
    }


}