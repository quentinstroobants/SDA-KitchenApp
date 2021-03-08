package com.example.pocketkitchen.model

import androidx.annotation.StringRes

sealed class ShoppingList{
    class Ingredient(@StringRes val stringResourceId: Int): ShoppingList(){
    }

    object Header: ShoppingList()
}
