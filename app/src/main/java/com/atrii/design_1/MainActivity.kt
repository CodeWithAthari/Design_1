package com.atrii.design_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.transition.Explode
import android.transition.Slide
import androidx.appcompat.widget.Toolbar
import com.atrii.design_1.Adapter.MainAdapter
import com.atrii.design_1.Adapter.PopularAdapter
import com.atrii.design_1.Data.MainData
import com.atrii.design_1.Data.PopularData
import com.atrii.design_1.databinding.ActivityMainBinding
import com.yarolegovich.slidingrootnav.SlidingRootNavBuilder

class MainActivity : AppCompatActivity() {

    lateinit var binding:ActivityMainBinding
    val activity = this

    var popularList:ArrayList<PopularData> = ArrayList()
    lateinit var popularAdapter:PopularAdapter

    var mainList:ArrayList<MainData> = ArrayList()
    lateinit var mainAdapter: MainAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        with(window) {
            enterTransition = Explode()
            exitTransition = Explode()
            enterTransition.duration = 1000
            exitTransition.duration = 1000
        }
        setContentView(binding.root)
        setSupportActionBar(binding.mToolbar.toolbar)
        supportActionBar.apply {
            title = ""
        }
        initPopular()
        initMain()
        navigationView(savedInstanceState)


    }



    private fun navigationView(savedInstanceState:Bundle?) {
        SlidingRootNavBuilder(activity)
            .withToolbarMenuToggle( binding.mToolbar.toolbar)
            .withMenuOpened(false)
            .withContentClickableWhenMenuOpened(true)
            .withSavedState(savedInstanceState)
            .withMenuLayout(R.layout.navigation_layout)
            .inject()
       binding.mToolbar.toolbar.setNavigationIcon(R.drawable.ico_menu)
    }

    private fun initMain() {
        mainAdapter = MainAdapter(mainList,activity)
        binding.mRVMain.adapter = mainAdapter

        mainList.add(MainData("Vege",R.drawable.ic_vege))
        mainList.add(MainData("Main dishes",R.drawable.ic_man_dishes))
        mainList.add(MainData("Cakes",R.drawable.ic_cakes))
        mainList.add(MainData("Fast food",R.drawable.ic_fast_food))
        mainList.add(MainData("Kid’s menu",R.drawable.ic_kids_menu))
        mainList.add(MainData("Soup",R.drawable.ic_soup))
    }

    private fun initPopular() {
        popularAdapter = PopularAdapter(popularList,activity)
        binding.mRVPopular.adapter = popularAdapter

        popularList.add(PopularData("Recipe One",6,2,20,R.drawable.recipe_one))
        popularList.add(PopularData("Recipe Two",2,1,10,R.drawable.recipe_two))
        popularList.add(PopularData("Recipe Three",0,3,55,R.drawable.recipe_three))
        popularList.add(PopularData("Recipe Four",4,1,45,R.drawable.recipe_four))
        popularList.add(PopularData("Recipe Five",8,2,55,R.drawable.recipe_five))
        popularList.add(PopularData("Recipe Six",4,1,5,R.drawable.recipe_six))
        popularList.add(PopularData("Recipe Seven",10,3,15,R.drawable.recipe_seven))

    }

    override fun onBackPressed() {
        finishAffinity()
    }

}