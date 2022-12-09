package com.atrii.design_1.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.atrii.design_1.Data.MainData
import com.atrii.design_1.Data.PopularData
import com.atrii.design_1.R
import com.atrii.design_1.databinding.SampleHomeLayoutBinding
import com.atrii.design_1.databinding.SampleHomePopularLayoutBinding

class PopularAdapter(var list: ArrayList<PopularData>, val context: Context) :
    RecyclerView.Adapter<PopularAdapter.ViewHolder>() {


    class ViewHolder(val binding: SampleHomePopularLayoutBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            SampleHomePopularLayoutBinding.inflate(
                LayoutInflater.from(context),
                parent,
                false
            )
        )
    }

    lateinit var binding: SampleHomePopularLayoutBinding
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val model = list[position]
        binding = holder.binding

        binding.apply {
            mRecipeImage.setImageResource(model.recipeImage)
            mRecipeName.text = model.recipeName
            if(model.rating ==0){
                mRating.text = "Yet to rate"
            }else{

            mRating.text = model.rating.toString()
            }
            mTime.text = "${model.time} m"
        }
        rating(model.rating)
        difficulty(model.difficulty)


    }

    private fun difficulty(difficulty: Int) {
        binding.apply {

            when (difficulty) {
                1 -> {
                    mDifficulty1.setImageResource(R.drawable.ic_star_selected)
                    mDifficulty2.setImageResource(R.drawable.ic_star_unselected)
                    mDifficulty3.setImageResource(R.drawable.ic_star_unselected)
                    binding.mDifficulty.text = "Easy"
                }
                2 -> {
                    mDifficulty1.setImageResource(R.drawable.ic_star_selected)
                    mDifficulty2.setImageResource(R.drawable.ic_star_selected)
                    mDifficulty3.setImageResource(R.drawable.ic_star_unselected)
                    binding.mDifficulty.text = "Medium"
                }
                3->{
                    mDifficulty1.setImageResource(R.drawable.ic_star_selected)
                    mDifficulty2.setImageResource(R.drawable.ic_star_selected)
                    mDifficulty3.setImageResource(R.drawable.ic_star_selected)
                    binding.mDifficulty.text = "Hard"
                }
            }


        }
    }

    private fun rating(rating: Int) {

        binding.apply {
            if (rating < 1) {
                mRating1.setImageResource(R.drawable.ic_rating_unselected)
                mRating2.setImageResource(R.drawable.ic_rating_unselected)
                mRating3.setImageResource(R.drawable.ic_rating_unselected)
                mRating4.setImageResource(R.drawable.ic_rating_unselected)
                mRating5.setImageResource(R.drawable.ic_rating_unselected)
            } else if (rating in 2..2) {
                mRating1.setImageResource(R.drawable.ic_rating_selected)
                mRating2.setImageResource(R.drawable.ic_rating_unselected)
                mRating3.setImageResource(R.drawable.ic_rating_unselected)
                mRating4.setImageResource(R.drawable.ic_rating_unselected)
                mRating5.setImageResource(R.drawable.ic_rating_unselected)
            } else if (rating in 3..4) {
                mRating1.setImageResource(R.drawable.ic_rating_selected)
                mRating2.setImageResource(R.drawable.ic_rating_selected)
                mRating3.setImageResource(R.drawable.ic_rating_unselected)
                mRating4.setImageResource(R.drawable.ic_rating_unselected)
                mRating5.setImageResource(R.drawable.ic_rating_unselected)
            } else if (rating in 4..5) {
                mRating1.setImageResource(R.drawable.ic_rating_selected)
                mRating2.setImageResource(R.drawable.ic_rating_selected)
                mRating3.setImageResource(R.drawable.ic_rating_selected)
                mRating4.setImageResource(R.drawable.ic_rating_unselected)
                mRating5.setImageResource(R.drawable.ic_rating_unselected)
            } else if (rating in 6..8) {
                mRating1.setImageResource(R.drawable.ic_rating_selected)
                mRating2.setImageResource(R.drawable.ic_rating_selected)
                mRating3.setImageResource(R.drawable.ic_rating_selected)
                mRating4.setImageResource(R.drawable.ic_rating_selected)
                mRating5.setImageResource(R.drawable.ic_rating_unselected)
            } else if (rating in 9..10) {
                mRating1.setImageResource(R.drawable.ic_rating_selected)
                mRating2.setImageResource(R.drawable.ic_rating_selected)
                mRating3.setImageResource(R.drawable.ic_rating_selected)
                mRating4.setImageResource(R.drawable.ic_rating_selected)
                mRating5.setImageResource(R.drawable.ic_rating_selected)
            } else {
                mRating1.setImageResource(R.drawable.ic_rating_unselected)
                mRating2.setImageResource(R.drawable.ic_rating_unselected)
                mRating3.setImageResource(R.drawable.ic_rating_unselected)
                mRating4.setImageResource(R.drawable.ic_rating_unselected)
                mRating5.setImageResource(R.drawable.ic_rating_unselected)
            }


        }


    }

    override fun getItemCount() = list.size

}