package com.kanonik.cb.injection.component

import com.kanonik.cb.injection.module.NetworkModule
import com.kanonik.cb.ui.categories.CategoryListViewModel
import com.kanonik.cb.ui.categories.CategoryViewModel
import com.kanonik.cb.ui.drinks.DrinkListViewModel
import com.kanonik.cb.ui.fulldrink.FullDrinkViewModel
import com.kanonik.cb.ui.ingredients.IngredientsListViewModel
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [(NetworkModule::class)])
interface ViewModelInjector {

    fun inject(ingredientsListViewModel: IngredientsListViewModel)
    fun inject(drinkListViewModel: DrinkListViewModel)
    fun inject(fullDrinkViewModel: FullDrinkViewModel)
    fun inject(categoryListViewModel: CategoryListViewModel)
    fun inject(categoryViewModel: CategoryViewModel)

    @Component.Builder
    interface Builder {
        fun build(): ViewModelInjector

        fun networkModule(networkModule: NetworkModule): Builder
    }
}