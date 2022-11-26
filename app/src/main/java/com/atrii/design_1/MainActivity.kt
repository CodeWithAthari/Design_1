package com.atrii.design_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.transition.Explode
import android.transition.Slide
import com.atrii.design_1.Adapter.MainAdapter
import com.atrii.design_1.Adapter.PopularAdapter
import com.atrii.design_1.Data.MainData
import com.atrii.design_1.Data.PopularData
import com.atrii.design_1.databinding.ActivityMainBinding

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

        popularList.add(PopularData("Sample Recipe",6,2,20,R.drawable.recipe_promo_one))
        popularList.add(PopularData("Sample Recipe",2,1,10,R.drawable.recipe_promo_two))
        popularList.add(PopularData("Sample Recipe",0,3,55,R.drawable.recipe_one))
        popularList.add(PopularData("Sample Recipe",4,1,45,R.drawable.recipe_promo_one))
        popularList.add(PopularData("Sample Recipe",8,2,35,R.drawable.recipe_promo_two))
        popularList.add(PopularData("Sample Recipe",10,3,25,R.drawable.recipe_one))

    }

    override fun onBackPressed() {
        finishAffinity()
    }

}