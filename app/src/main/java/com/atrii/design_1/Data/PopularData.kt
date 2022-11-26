package com.atrii.design_1.Data

import androidx.annotation.DrawableRes

data class PopularData(
    val recipeName: String,
    val rating: Int,
    val difficulty:Int,
    val time:Int,
    @DrawableRes val recipeImage: Int
)
