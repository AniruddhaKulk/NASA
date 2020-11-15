package com.anikulki.nasa.ui.grid

import android.os.Bundle
import android.transition.TransitionInflater
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.anikulki.nasa.R
import com.anikulki.nasa.ui.SharedViewModel
import com.anikulki.nasa.databinding.FragmentGridBinding
import com.anikulki.nasa.utils.State
import com.anikulki.nasa.utils.ViewModelFactory

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


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val inflater = TransitionInflater.from(requireContext())
        exitTransition = inflater.inflateTransition(R.transition.fade)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _binding = FragmentGridBinding.bind(view)

        sharedViewModel = ViewModelProvider(requireActivity(), ViewModelFactory())
            .get(SharedViewModel::class.java)

        adapter = NasaImageAdapter(mutableListOf(), this)

        val gridLayoutManager = GridLayoutManager(requireContext(), 2)

        binding.apply {
            recyclerView.layoutManager = gridLayoutManager
            recyclerView.adapter = adapter
        }

        setupObservers()
    }

    private fun setupObservers(){

        sharedViewModel.nasaImagesListLiveData.observe(viewLifecycleOwner, Observer {
            when (it) {
                is State.Loading -> {
                    binding.progressBar.visibility = View.VISIBLE
                    binding.recyclerView.visibility = View.GONE
                }
                is State.Success -> {
                    binding.progressBar.visibility = View.GONE
                    binding.recyclerView.visibility = View.VISIBLE
                    adapter.setData(data = it.data)
                }

                is State.Error -> {
                    binding.progressBar.visibility = View.GONE
                    binding.recyclerView.visibility = View.GONE
                    Toast.makeText(requireContext(), it.errorMessage, Toast.LENGTH_LONG).show()
                }
            }
        })
    }

    override fun onImageClick(position: Int) {
        sharedViewModel.navigateToImagePagerScreen(position)
    }

    override fun onDestroy() {
        super.onDestroy()

        _binding = null
    }
}