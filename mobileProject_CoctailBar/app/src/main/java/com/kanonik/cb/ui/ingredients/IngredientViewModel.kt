package com.kanonik.cb.ui.ingredients

import android.arch.lifecycle.MutableLiveData
import com.kanonik.cb.model.Ingredient

class IngredientViewModel {
    private val ingredientName = MutableLiveData<String>()

    fun bind(ingredient: Ingredient) {
        ingredientName.value = ingredient.strIngredient1
    }

    fun getIngredientName(): MutableLiveData<String> {
        return ingredientName
    }
}