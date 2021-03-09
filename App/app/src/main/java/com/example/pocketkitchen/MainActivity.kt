package com.example.pocketkitchen

import android.content.Context
import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import android.view.inputmethod.InputMethodManager
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
        //binding.checkbox1.setOnClickListener { shopping_list_checked() }
        val myDataset = Datasource().loadIngredients()
        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        recyclerView.adapter = ItemAdapter(this, myDataset)
        recyclerView.setHasFixedSize(true)
        binding.shoppingListAddButton.setOnClickListener { addIngredientToShoppingList(this, recyclerView, myDataset) }

    }

    private fun addIngredientToShoppingList(context: AppCompatActivity, recyclerView: RecyclerView, myDataset:  MutableList<ShoppingList.Ingredient>){
        myDataset.add(ShoppingList.Ingredient(R.string.ingredient3))
        recyclerView.adapter = ItemAdapter(context, myDataset)
    }

//        binding.costOfServiceEditText.setOnKeyListener { view, keyCode, _ ->
//            handleKeyEvent(
//                view,
//                keyCode
//            )
//        }


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

private fun handleKeyEvent(view: View, keyCode: Int): Boolean {
    if (keyCode == KeyEvent.KEYCODE_ENTER) {
        // Hide the keyboard
        val inputMethodManager =
                getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
        return true
    }
    return false
}

}
