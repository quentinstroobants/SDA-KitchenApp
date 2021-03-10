package com.example.pocketkitchen

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.pocketkitchen.adapter.ItemAdapter
import com.example.pocketkitchen.data.Datasource
import com.example.pocketkitchen.databinding.ActivityMainBinding
import com.example.pocketkitchen.model.ShoppingList

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Do an action when a checkbox is checked
        //binding.checkbox.setOnClickListener { shopping_list_checked() }

        // Initialise the dataset. It can be modified during the use of the app, but won't be saved. SEE Datasource
        val myDataset = Datasource().loadIngredients()
        // Initialise the RecyclerView defined in ItemAdapter
        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        // Link the recyclerView with the Adapter and the dataset. The behaviour of the recyclerView depends mainly on the ItemAdapter
        recyclerView.adapter = ItemAdapter(this, myDataset)
        recyclerView.setHasFixedSize(true)
        // Click listeners for different buttons in the app.
        binding.shoppingListAddButton.setOnClickListener { addIngredientToShoppingList(this, recyclerView, myDataset) }
        binding.shoppingListRemoveButton.setOnClickListener { removeIngredientFromShoppingList(this, recyclerView, myDataset) }
        binding.shoppingListClearButton.setOnClickListener { clearShoppingList(this, recyclerView, myDataset) }
    }

    // Add a particular ingredient to the shopping list.
    /************* TO DO **********/
    /**
     * The user should be able to input the ingredient by himself instead of always adding the same element.
     * Do the link with an SQL database so the modified data is saved. SEE Quentin **/
    private fun addIngredientToShoppingList(context: AppCompatActivity, recyclerView: RecyclerView, myDataset: MutableList<ShoppingList.Ingredient>) {
        myDataset.add(ShoppingList.Ingredient(R.string.ingredient3))
        // The Toast.makeTest display a message at the bottom of the screen. The message disappears quickly.
        Toast.makeText(this, "Ingredient added", Toast.LENGTH_SHORT).show()
        // We need to "draw" again (update) the recyclerView each time that the database is modified.
        recyclerView.adapter = ItemAdapter(context, myDataset)
    }

    // Remove the first ingredient of the shopping list.
    /************* TO DO **********/
    /**
     * Each ingredient should have a delete button, or an edit button
     * Do the link with an SQL database so the modified data is saved. SEE Quentin **/
    private fun removeIngredientFromShoppingList(context: AppCompatActivity, recyclerView: RecyclerView, myDataset: MutableList<ShoppingList.Ingredient>) {
        // Do not try to remove the first element of the list if the list is empty.
        if (myDataset.size > 0) {
            // Remove the first element of the database.
            myDataset.removeAt(0)
            // Display a message to confirm the deletion.
            Toast.makeText(this, "Ingredient successfully removed", Toast.LENGTH_SHORT).show()
        } else {
            // Display a message to state that the list was already empty.
            Toast.makeText(this, "No ingredient to remove!", Toast.LENGTH_SHORT).show()
        }

        // Update the recyclerView.
        recyclerView.adapter = ItemAdapter(context, myDataset)
    }

    // Clear the whole shopping list.
    /************* TO DO **********/
    /**
     * Display a confirmation pop up since it can be a miss click.
     * Do the link with an SQL database so the modified data is saved. SEE Quentin **/
    private fun clearShoppingList(context: AppCompatActivity, recyclerView: RecyclerView, myDataset: MutableList<ShoppingList.Ingredient>) {
        // Empty the dataset.
        myDataset.clear()
        // Display a confirmation message.
        Toast.makeText(this, "Shopping list cleared!", Toast.LENGTH_SHORT).show()
        // Update the recyclerView.
        recyclerView.adapter = ItemAdapter(context, myDataset)
    }

    // Next are not used functions that could be useful if needed (structure, code...)

/*   private fun shopping_list_checked() {
       val bought = binding.checkbox1.isChecked

       if(bought){
           Toast.makeText(this, "Ingredient successfully bought!", Toast.LENGTH_SHORT).show()
       }
   }*/

/*    fun calculateTip() {
        val stringInTextField = binding.costOfServiceEditText.text.toString()
        val cost = stringInTextField.toDouble()
        val tipPercentage = when (binding.tipOptions.checkedRadioButtonId) {
            R.id.option_twenty_percent -> 0.20
            R.id.option_eighteen_percent -> 0.18
            else -> 0.15
        }
        var tip = cost * tipPercentage
        val roundUp = binding.roundUpSwitch.isChecked

        if (roundUp) {
            tip = kotlin.math.ceil(tip)
        }

        val formattedTip = NumberFormat.getCurrencyInstance().format(tip)
        binding.tipResult.text = getString(R.string.tip_amount, formattedTip)

    }*/


}
