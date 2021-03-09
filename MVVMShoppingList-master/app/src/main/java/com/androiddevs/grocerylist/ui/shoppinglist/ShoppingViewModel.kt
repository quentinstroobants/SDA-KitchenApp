package com.androiddevs.grocerylist.ui.shoppinglist

import androidx.lifecycle.ViewModel
import com.androiddevs.grocerylist.data.db.entities.ShoppingItem
import com.androiddevs.grocerylist.data.repositories.ShoppingRepository
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class ShoppingViewModel(
    private val repository: ShoppingRepository
) : ViewModel() {

    //coroutinescope is where you start the coroutine here you want to start it in the main thread
    //normally for db you would use IO option but Room provides Main safety so we are fine to launch in main context
    fun upsert(item: ShoppingItem) =
        GlobalScope.launch {
            repository.upsert(item)
        }

    fun delete(item: ShoppingItem) = GlobalScope.launch {
        repository.delete(item)
    }

    //doesn't need a coroutine bc is only a read operation
    fun getAllShoppingItems() = repository.getAllShoppingItems()

}
