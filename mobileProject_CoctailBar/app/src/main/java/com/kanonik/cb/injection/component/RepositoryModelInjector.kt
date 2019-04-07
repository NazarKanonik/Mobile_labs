package com.kanonik.cb.injection.component

import com.kanonik.cb.data.repository.CategoryRepository
import com.kanonik.cb.data.repository.DrinkRepository
import com.kanonik.cb.data.repository.IngredientRepository
import com.kanonik.cb.injection.module.NetworkModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [(NetworkModule::class)])
interface RepositoryModelInjector {

    fun inject(drinkRepository: DrinkRepository)
    fun inject(categoryRepository: CategoryRepository)
    fun inject(ingredientRepository: IngredientRepository)

    @Component.Builder
    interface Builder {
        fun build(): RepositoryModelInjector

        fun networkModule(networkModule: NetworkModule): Builder
    }
}