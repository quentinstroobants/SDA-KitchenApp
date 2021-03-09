package com.androiddevs.grocerylist.ui.shoppinglist

import com.androiddevs.grocerylist.data.db.entities.ShoppingItem

interface AddDialogListener {
    //whenever method is called we'll pas the item that we just created and then we can have it i the shoppingactivity class
    fun onAddButtonClicked(item: ShoppingItem)
}