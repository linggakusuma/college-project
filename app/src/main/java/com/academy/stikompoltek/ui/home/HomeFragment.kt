package com.academy.stikompoltek.ui.home

import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.academy.stikompoltek.R
import com.academy.stikompoltek.data.base.BaseFragment
import com.academy.stikompoltek.databinding.FragmentHomeBinding
import com.academy.stikompoltek.utils.ext.observe
import com.smarteist.autoimageslider.SliderAnimations
import javax.inject.Inject


class HomeFragment : BaseFragment<FragmentHomeBinding>(R.layout.fragment_home) {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val viewModel: HomeViewModel by viewModels { viewModelFactory }

    override fun initBinding() {
        super.initBinding()
        binding.apply {
            recyclerViewSchedule.apply {
                observe(viewModel.schedule) {
                    setSliderAdapter(ScheduleAdapter(it))
                    currentPagePosition = 2
                }
                setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION)
            }
        }
    }
}
