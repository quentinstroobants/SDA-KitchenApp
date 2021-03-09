package com.androiddevs.grocerylist.data.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.androiddevs.grocerylist.data.db.entities.ShoppingItem

//data acces object
@Dao
interface ShoppingDao {

    //cannot acces database in main function so those functions
    // will need to be called assynchronously in threads or coroutines
    //that's why we add suspend in front of fun

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(item: ShoppingItem)

    @Delete
    suspend fun delete(item: ShoppingItem)

    @Query("SELECT * FROM shopping_items")
    fun getAllShoppingItems(): LiveData<List<ShoppingItem>>
}