package com.anikulki.nasa.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.anikulki.nasa.R
import com.anikulki.nasa.ui.grid.GridFragment
import com.anikulki.nasa.ui.pager.ImagePagerFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        openNasaGridFragment()
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

    private fun openImagePagerScreen(initialPosition: Int){

        val fragmentTransaction = supportFragmentManager.beginTransaction()

        var fragment = supportFragmentManager.findFragmentByTag(ImagePagerFragment.TAG) as ImagePagerFragment?

        if(fragment == null){
            fragment = ImagePagerFragment.newInstance(initialPosition)
            fragmentTransaction.add(R.id.containerView, fragment, ImagePagerFragment.TAG)
            fragmentTransaction.addToBackStack(ImagePagerFragment.TAG)
        }else{
            fragmentTransaction.show(fragment)
        }

        fragmentTransaction.commit()
    }

}