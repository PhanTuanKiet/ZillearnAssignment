package com.example.zillearnassignment.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.example.zillearnassignment.R
import com.example.zillearnassignment.base.BaseFragment
import com.example.zillearnassignment.databinding.FragmentCourseInfoBinding
import com.example.zillearnassignment.model.CourseModel
import com.example.zillearnassignment.viewmodel.CourseInfoViewModel
import dagger.hilt.android.AndroidEntryPoint
import java.util.*

@AndroidEntryPoint
class CourseInfoFragment : BaseFragment() {

    companion object {

        private const val COURSE_ID = "COURSE_ID"

        fun newInstance(courseId: String): CourseInfoFragment {
            val fragment = CourseInfoFragment()
            val args = Bundle()
            args.putString(COURSE_ID, courseId)
            fragment.arguments = args
            return fragment
        }
    }

    private val courseInfoViewModel: CourseInfoViewModel by viewModels()
    private lateinit var binding: FragmentCourseInfoBinding

    private val observerData: Observer<CourseModel?> by lazy {
        Observer<CourseModel?> { info ->
            if (info != null)
                buildUI(info)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (requireArguments().containsKey(COURSE_ID)) {
            val id = requireArguments().getString(COURSE_ID) ?: ""
            courseInfoViewModel.setCourseId(id)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCourseInfoBinding.inflate(inflater, container, false)
        val view = binding.root
        buildUIObserver()
        getCourseInfo()
        return view
    }

    private fun buildUIObserver() {
        courseInfoViewModel.courseInfoData.observe(
            this,
            observerData
        )
    }

    private fun buildUI(info: CourseModel) {
        binding.tvCourseTitle.text = info.title
        binding.tvDescription.text = info.description
        binding.tvCategories.text =  String.format(getString(R.string.course_categories), info.categories)
        binding.tvView.text = String.format(getString(R.string.course_view), info.views)
        binding.tvPrice.text = String.format(getString(R.string.course_price), info.price)
        Glide.with(requireContext())
            .load(info.cover)
            .into(binding.ivCourseCover)
    }


    private fun getCourseInfo() {
        courseInfoViewModel.getCourseInfo()
    }

    override fun onDestroy() {
        super.onDestroy()
        courseInfoViewModel.courseInfoData.removeObserver(observerData)
    }
}