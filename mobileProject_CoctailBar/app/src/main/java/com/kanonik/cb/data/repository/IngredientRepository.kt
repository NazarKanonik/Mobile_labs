package com.kanonik.cb.data.repository

import android.content.Context
import android.util.Log
import com.kanonik.cb.data.database.AppDatabase
import com.kanonik.cb.data.database.CallBack
import com.kanonik.cb.model.Ingredient
import com.kanonik.cb.network.Api
import com.kanonik.cb.ui.base.BaseRepositoryModel
import com.kanonik.cb.util.TIMEOUT_FOR_LOADING
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class IngredientRepository(val context: Context) : BaseRepositoryModel() {

    @Inject
    lateinit var api: Api

    private val ingredientDao = AppDatabase.getDatabase(context).ingredientDao

    fun loadIngredients(loadIngredientsCallBack: CallBack.LoadIngredientsCallBack) {
        ingredientDao.allIngredients
                .toObservable()
                .debounce(TIMEOUT_FOR_LOADING, TimeUnit.SECONDS)
                .subscribe({ result ->
                    if (result != null && result.size > 2) {
                        loadIngredientsCallBack.onLoad(result)
                        Log.d("draxvel", "loadIngredients from db")
                    } else {
                        api.getIngredientsList()
                                .subscribeOn(Schedulers.io())
                                .observeOn(AndroidSchedulers.mainThread())
                                .subscribe(
                                        //Add result
                                        { res ->
                                            Log.d("draxvel", "loadIngredients from api: ${res.drinks}")
                                            loadIngredientsCallBack.onLoad(res.drinks)
                                            saveIngredientsToBD(res.drinks)
                                        },
                                        { msg ->
                                            loadIngredientsCallBack.onError(msg.localizedMessage
                                                    ?: "Error")
                                        })
                    }
                },
                        { msg ->
                            loadIngredientsCallBack.onError(msg.localizedMessage ?: "Error")
                        })
    }

    private fun saveIngredientsToBD(list: List<Ingredient>) {
        val s: List<Ingredient> = list
        list.forEach { it.strMeasure1 = "" }
        Observable.fromCallable { ingredientDao.insertAll(s) }
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
                .subscribe({
                    Log.d("draxvel", "Inserted ${s.size} ingredients from API in DB...")
                }, {
                    Log.d("draxvel", "error in saveIngredientsToBD ${it.localizedMessage}")

                })
    }
}