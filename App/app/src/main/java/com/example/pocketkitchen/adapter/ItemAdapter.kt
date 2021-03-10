package com.example.pocketkitchen.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.pocketkitchen.R
import com.example.pocketkitchen.model.ShoppingList

// The adapter allows us to use Recycler Views which contain lists of UI elements.
// We should be able to create a class inside ItemAdapter for each type of UI item related to the Recycler View.
// Here we have only one kind of item, which is a checkbox

class ItemAdapter(
        private val context: Context,
        private val dataset: List<ShoppingList.Ingredient> //Defining the type of data that will be used in the RecyclerView
) : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() { //We override from RecyclerView.Adapter

// This ItemViewHolder class is defining the attribute of the UI element that we need to modify. It gets the textView of the check box in this case
    class ItemViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView = view.findViewById(R.id.checkbox)
        // Add an image to the viewHolder. Not used for the shopping list
        //val imageView: ImageView = view.findViewById(R.id.item_image)
    }

    // This function creates a new view that will be an ItemViewHolder and return it.
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        // We create the new view inside the "context" and the view will contain "list_item" items
        val adapterLayout = LayoutInflater.from(parent.context)
                .inflate(R.layout.list_item, parent, false)

        return ItemViewHolder(adapterLayout)
    }

    // Allows the program to know how many items will be inside the RecyclerView. If we are adding another kind of item, we will have to add the number of items to this function.
    override fun getItemCount() = dataset.size

    // This function is binding the viewHolders (items, checkboxes,...) to their attributes' value.
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        // Get the information from the dataset
        val item = dataset[position]
        // Modify the textView of each checkbox. stringResourceId is the name of the checkboxes text field.
        holder.textView.text = context.resources.getString(item.stringResourceId)
        // Set the image of the viewHolder. Not used for the shopping list
        //holder.imageView.setImageResource(item.imageResourceId)
    }


}