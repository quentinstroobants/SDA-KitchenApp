package com.example.pocketkitchen.data

import com.example.pocketkitchen.R
import com.example.pocketkitchen.model.ShoppingList

class Datasource {

    fun loadIngredients(): List<ShoppingList.Ingredient>{
        return listOf<ShoppingList.Ingredient>(
                ShoppingList.Ingredient(R.string.ingredient1),
                ShoppingList.Ingredient(R.string.ingredient2),
                ShoppingList.Ingredient(R.string.ingredient3),
                ShoppingList.Ingredient(R.string.ingredient4),
                ShoppingList.Ingredient(R.string.ingredient5),
                ShoppingList.Ingredient(R.string.ingredient6),
                ShoppingList.Ingredient(R.string.ingredient7)
        )
    }
}