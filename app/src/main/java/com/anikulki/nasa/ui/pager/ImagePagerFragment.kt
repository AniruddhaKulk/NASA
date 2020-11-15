package com.anikulki.nasa.ui.pager

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.anikulki.nasa.R
import com.anikulki.nasa.databinding.FragmentImagePagerBinding
import com.anikulki.nasa.ui.SharedViewModel
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


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _binding = FragmentImagePagerBinding.bind(view)

        arguments?.let {
            currentPosition = it.getInt(KEY_CURRENT_POSITION, 0)
        }

        sharedViewModel = ViewModelProvider(requireActivity(), ViewModelFactory())
            .get(SharedViewModel::class.java)


        setupObservers()

    }

    private fun setupObservers(){
        //TODO
    }


    override fun onDestroy() {
        super.onDestroy()

        _binding = null
    }
}