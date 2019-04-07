package com.kanonik.cb.ui.base

import com.kanonik.cb.data.repository.CategoryRepository
import com.kanonik.cb.data.repository.DrinkRepository
import com.kanonik.cb.data.repository.IngredientRepository
import com.kanonik.cb.injection.component.DaggerRepositoryModelInjector
import com.kanonik.cb.injection.component.RepositoryModelInjector
import com.kanonik.cb.injection.module.NetworkModule

abstract class BaseRepositoryModel {
    private val injector: RepositoryModelInjector = DaggerRepositoryModelInjector
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
            is DrinkRepository -> injector.inject(this)
            is CategoryRepository -> injector.inject(this)
            is IngredientRepository -> injector.inject(this)
        }
    }
}