package com.kanonik.cb.network

import com.kanonik.cb.model.Categories
import com.kanonik.cb.model.Drinks
import com.kanonik.cb.model.Ingredients
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {

    //List of ingredients
    @GET("list.php?i=list")
    fun getIngredientsList(): Observable<Ingredients>

    //Lookup a random cocktail
    @GET("random.php")
    fun getRandom(): Observable<Drinks>

    //Search cocktail by name
    @GET("search.php")
    fun searchCocktails(@Query("s") str: String): Observable<Drinks>

    //Search by ingredient
    @GET("filter.php")
    fun searchByIngredient(@Query("i") str: String): Observable<Drinks>

    //Lookup full cocktail details by id
    @GET("lookup.php")
    fun getFullCocktailRecipe(@Query("i") id: Int): Observable<Drinks>

    //List of categories
    @GET("list.php?c=list")
    fun getCategoriesList(): Observable<Categories>

    //Filter by Category
    @GET("filter.php")
    fun getFilteredList(@Query("c") str:String): Observable<Drinks>
}