package com.anikulki.nasa.ui.pager

import android.os.Bundle
import android.transition.TransitionInflater
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager2.widget.ViewPager2
import com.anikulki.nasa.R
import com.anikulki.nasa.databinding.FragmentImagePagerBinding
import com.anikulki.nasa.ui.SharedViewModel
import com.anikulki.nasa.utils.State
import com.anikulki.nasa.utils.ViewModelFactory

class ImagePagerFragment: Fragment(R.layout.fragment_image_pager) {


    companion object {
        const val TAG = "Image_Pager"
        const val KEY_CURRENT_POSITION = "current_position"

        fun newInstance(position: Int): ImagePagerFragment {
            val args = Bundle()
            args.putInt(KEY_CURRENT_POSITION, position)
            val fragment = ImagePagerFragment()
            fragment.arguments = args
            return fragment
        }
    }

    private var _binding: FragmentImagePagerBinding? = null

    private val binding: FragmentImagePagerBinding
            get() = _binding!!

    private lateinit var sharedViewModel: SharedViewModel

    private var currentPosition = 0

    private lateinit var adapter: ImagePagerAdapter

    private val mAnimator = ViewPager2.PageTransformer { page, position ->
        val absPos = Math.abs(position)
        page.apply {
            translationY = absPos * 500f
            translationX = 0f
            scaleX = 1f
            scaleY = 1f
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val inflater = TransitionInflater.from(requireContext())
        enterTransition = inflater.inflateTransition(R.transition.slide_right)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _binding = FragmentImagePagerBinding.bind(view)

        arguments?.let {
            currentPosition = it.getInt(KEY_CURRENT_POSITION, 0)
        }

        sharedViewModel = ViewModelProvider(requireActivity(), ViewModelFactory())
            .get(SharedViewModel::class.java)

        adapter = ImagePagerAdapter(mutableListOf())

        binding.viewPager.adapter = adapter

        binding.viewPager.setPageTransformer(mAnimator)

        binding.viewPager.requestTransform()

        setupObservers()

    }

    private fun setupObservers(){
        sharedViewModel.nasaImagesListLiveData.observe(viewLifecycleOwner, Observer {
            when (it) {
                is State.Loading -> {
                    binding.viewPager.visibility = View.GONE
                }
                is State.Success -> {
                    binding.viewPager.visibility = View.VISIBLE
                    adapter.setData(data = it.data)
                    binding.viewPager.setCurrentItem(currentPosition, false)
                }

                is State.Error -> {
                    binding.viewPager.visibility = View.GONE
                    Toast.makeText(requireContext(), it.errorMessage, Toast.LENGTH_LONG).show()
                }
            }
        })
    }


    override fun onDestroy() {
        super.onDestroy()

        _binding = null
    }
}