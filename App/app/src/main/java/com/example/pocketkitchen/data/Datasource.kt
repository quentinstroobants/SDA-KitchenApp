package com.example.pocketkitchen.data

import com.example.pocketkitchen.R
import com.example.pocketkitchen.model.ShoppingList

// Here we are creating the database(s).
class Datasource {

    // Since we are creating a modified list of ingredients, we need a MutableList of ingredients.
    // Since this is not connected to any online or local database (SQL), the changes made while running the app won't be saved.
    fun loadIngredients(): MutableList<ShoppingList.Ingredient> {
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