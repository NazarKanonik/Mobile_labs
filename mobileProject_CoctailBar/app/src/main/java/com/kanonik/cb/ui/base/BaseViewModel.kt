package com.kanonik.cb.ui.base

import android.arch.lifecycle.ViewModel
import com.kanonik.cb.injection.component.DaggerViewModelInjector
import com.kanonik.cb.injection.component.ViewModelInjector
import com.kanonik.cb.injection.module.NetworkModule
import com.kanonik.cb.ui.categories.CategoryListViewModel
import com.kanonik.cb.ui.categories.CategoryViewModel
import com.kanonik.cb.ui.drinks.DrinkListViewModel
import com.kanonik.cb.ui.fulldrink.FullDrinkViewModel
import com.kanonik.cb.ui.ingredients.IngredientsListViewModel

abstract class BaseViewModel : ViewModel() {
    private val injector: ViewModelInjector = DaggerViewModelInjector
            .builder()
            .networkModule(NetworkModule)
            .build()

    init {
        inject()
    }

    /**
     * Injects the required dependencies
     */
    private fun inject() {
        when (this) {
            is IngredientsListViewModel -> injector.inject(this)
            is DrinkListViewModel -> injector.inject(this)
            is FullDrinkViewModel -> injector.inject(this)
            is CategoryListViewModel -> injector.inject(this)
            is CategoryViewModel -> injector.inject(this)
        }
    }
}