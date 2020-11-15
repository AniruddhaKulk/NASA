package com.anikulki.nasa.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.anikulki.nasa.R
import com.anikulki.nasa.ui.grid.GridFragment
import com.anikulki.nasa.ui.pager.ImagePagerFragment
import com.anikulki.nasa.utils.ViewModelFactory

class MainActivity : AppCompatActivity() {

    private lateinit var sharedViewModel: SharedViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupObservers()

        openNasaGridFragment()
    }

    private fun setupObservers(){

        sharedViewModel = ViewModelProvider(this, ViewModelFactory())
            .get(SharedViewModel::class.java)

        sharedViewModel.nasaImagePagerNavigation.observe(this, Observer {
            it.getIfNotHandled()?.run {
                openImagePagerScreen(this)
            }
        })
    }


    private fun openNasaGridFragment(){

        val fragmentTransaction = supportFragmentManager.beginTransaction()

        var fragment = supportFragmentManager.findFragmentByTag(GridFragment.TAG) as GridFragment?

        if(fragment == null){
            fragment = GridFragment.newInstance()
            fragmentTransaction.replace(R.id.containerView, fragment, GridFragment.TAG)
        }else{
            fragmentTransaction.show(fragment)
        }

        fragmentTransaction.commit()
    }

    private fun openImagePagerScreen(currentPosition: Int){

        val fragmentTransaction = supportFragmentManager.beginTransaction()

        var fragment = supportFragmentManager.findFragmentByTag(ImagePagerFragment.TAG) as ImagePagerFragment?

        if(fragment == null){
            fragment = ImagePagerFragment.newInstance(currentPosition)
            fragmentTransaction.add(R.id.containerView, fragment, ImagePagerFragment.TAG)
            fragmentTransaction.addToBackStack(ImagePagerFragment.TAG)
        }else{
            fragmentTransaction.show(fragment)
        }

        fragmentTransaction.commit()
    }

}