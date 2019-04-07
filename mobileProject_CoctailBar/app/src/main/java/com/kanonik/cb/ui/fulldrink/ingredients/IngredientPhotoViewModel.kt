package com.kanonik.cb.ui.fulldrink.ingredients

import android.arch.lifecycle.MutableLiveData
import com.kanonik.cb.ui.base.BaseViewModel
import com.kanonik.cb.model.Ingredient
import com.kanonik.cb.util.BASE_URL_IMAGES

class IngredientPhotoViewModel : BaseViewModel() {

    val ingredientName = MutableLiveData<String>()
    val ingredientPhoto = MutableLiveData<String>()
    val ingredientMeasure = MutableLiveData<String>()

    fun bind(ingredient: Ingredient) {
        ingredientName.value = ingredient.strIngredient1
        ingredientPhoto.value = "$BASE_URL_IMAGES${ingredientName.value}-Small.png"
        ingredientMeasure.value = ingredient.strMeasure1
    }
}