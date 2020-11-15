package com.anikulki.nasa.ui.grid

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.anikulki.nasa.R
import com.anikulki.nasa.SharedViewModel
import com.anikulki.nasa.databinding.FragmentGridBinding

class GridFragment: Fragment(R.layout.fragment_grid), NasaImageAdapter.OnItemClickListener {

    companion object {
        const val TAG = "NASA_GRID"

        fun newInstance(): GridFragment {
            val args = Bundle()
            val fragment = GridFragment()
            fragment.arguments = args
            return fragment
        }
    }


    private lateinit var sharedViewModel: SharedViewModel

    private var _binding: FragmentGridBinding? = null

    private val binding: FragmentGridBinding
        get() = _binding!!

    private lateinit var adapter: NasaImageAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _binding = FragmentGridBinding.bind(view)

        adapter = NasaImageAdapter(mutableListOf(), this)

        val gridLayoutManager = GridLayoutManager(requireContext(), 2)

        binding.apply {
            recyclerView.layoutManager = gridLayoutManager
            recyclerView.adapter = adapter
        }

    }

    override fun onImageClick(position: Int) {

    }

    override fun onDestroy() {
        super.onDestroy()

        _binding = null
    }
}