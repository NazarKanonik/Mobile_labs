package com.kanonik.cb.data.database

import com.kanonik.cb.model.Category
import com.kanonik.cb.model.Drink
import com.kanonik.cb.model.Ingredient
import io.reactivex.Observable

interface CallBack {

    interface BaseCallback {
        fun onError(msg: String)
    }

    interface LoadingDBCallBack : BaseCallback {
        fun onLoad(list: List<Drink>)
    }

    interface LoadingApiCallBack : BaseCallback {
        fun onLoad(list: List<Drink>)
    }

    interface LoadingMainCallBack : BaseCallback {
        fun onLoad(list: Observable<List<Drink>>)
    }

    interface LoadingSingleDrinkCallBack : BaseCallback {
        fun onLoad(drink: Drink)
    }

    interface LoadCategoriesCallBack : BaseCallback {
        fun onLoad(list: List<Category>)
    }

    interface LoadIngredientsCallBack : BaseCallback {
        fun onLoad(list: List<Ingredient>)
    }
}
