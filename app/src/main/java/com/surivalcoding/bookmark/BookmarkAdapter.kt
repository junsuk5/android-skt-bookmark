package com.surivalcoding.bookmark

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class BookmarkAdapter(
    private val sites: List<Site>,
    private val onClicked: (Site) -> Unit,
) :
    RecyclerView.Adapter<BookmarkAdapter.ViewHolder>() {

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder)
     */
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val nameTextView: TextView
        val urlTextView: TextView

        init {
            // Define click listener for the ViewHolder's View
            nameTextView = view.findViewById(R.id.name_text_view)
            urlTextView = view.findViewById(R.id.url_text_view)
        }
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.item_bookmark, viewGroup, false)

        return ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        val site = sites[position]

        viewHolder.nameTextView.text = site.name
        viewHolder.urlTextView.text = site.url

        viewHolder.itemView.setOnClickListener {
            onClicked(sites[viewHolder.adapterPosition])
        }
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = sites.size

}
