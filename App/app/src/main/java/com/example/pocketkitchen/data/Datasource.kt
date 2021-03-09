package com.example.pocketkitchen.data

import com.example.pocketkitchen.R
import com.example.pocketkitchen.model.ShoppingList

class Datasource {

    fun loadIngredients(): MutableList<ShoppingList.Ingredient>{
        val ingredients = mutableListOf<ShoppingList.Ingredient>()
        ingredients.addAll(
                listOf(
                        ShoppingList.Ingredient(R.string.ingredient1),
                        ShoppingList.Ingredient(R.string.ingredient2)
                )
        )
        return ingredients
    }
}