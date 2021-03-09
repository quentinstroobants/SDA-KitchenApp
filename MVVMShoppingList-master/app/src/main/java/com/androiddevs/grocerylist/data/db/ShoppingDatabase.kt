package com.androiddevs.grocerylist.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.androiddevs.grocerylist.data.db.entities.ShoppingItem

@Database(
    entities = [ShoppingItem::class],
    version = 1
)
abstract class ShoppingDatabase: RoomDatabase() {

    abstract fun getShoppingDao(): ShoppingDao

    companion object {
        @Volatile //means that instance will be made visible to other
        // threads to be sure that only one thread at a time is wrtiting at this instace
        private var instance: ShoppingDatabase? = null
        private val LOCK = Any()

        //is invoked each time we create an instance of the database : ShoppingDatabase()
        //returns the instance but if the instance is null call the synchronzed block
        //no one can set the instance at the time the ocde inside that block is executed
        //creates the instance and also set the instance after to it
        operator fun invoke(context: Context) = instance
            ?: synchronized(LOCK) {
            instance
                ?: createDatabase(
                    context
                ).also { instance = it }
        }

        private fun createDatabase(context: Context) =
            Room.databaseBuilder(context.applicationContext,
                ShoppingDatabase::class.java, "ShoppingDB.db").build()
    }
}