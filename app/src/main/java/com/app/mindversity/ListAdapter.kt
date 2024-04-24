package com.app.mindversity

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.Spinner
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ListAdapter(private val items: List<ListItem>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    // ViewHolder types
    private val VIEW_TYPE_DEFAULT = 0
    private val VIEW_TYPE_IMAGE = 1

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            VIEW_TYPE_IMAGE -> {
                val view = LayoutInflater.from(parent.context).inflate(R.layout.item_image, parent, false)
                ImageViewHolder(view)
            }
            else -> {
                val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item_layout, parent, false)
                DefaultViewHolder(view)
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is ImageViewHolder -> {
                // Bind image item here
                // You can set image and other details
            }
            is DefaultViewHolder -> {
                val currentItem = items[position]
                holder.itemView.apply {
                    findViewById<TextView>(R.id.textViewHeader).text = currentItem.header
                    findViewById<TextView>(R.id.textViewDetails).text = currentItem.details
                    val arrowImage = findViewById<ImageView>(R.id.arrowImage)
                    val detailsText = findViewById<TextView>(R.id.textViewDetails)

                    // Set click listener for arrow
                    arrowImage.setOnClickListener {
                        // Toggle visibility of details text
                        detailsText.visibility = if (detailsText.visibility == View.VISIBLE) View.GONE else View.VISIBLE
                        // Rotate arrow icon
                        val rotationAngle = if (detailsText.visibility == View.VISIBLE) 180f else 0f
                        arrowImage.rotation = rotationAngle
                    }
                }
            }
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun getItemViewType(position: Int): Int {
        return if (position == 0) {
            VIEW_TYPE_IMAGE
        } else {
            VIEW_TYPE_DEFAULT
        }
    }

    inner class DefaultViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    inner class ImageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}
