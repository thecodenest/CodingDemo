package com.test.appchallenge.ui.home.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.test.appchallenge.R
import com.test.appchallenge.data.model.Data


class GiphyRecyclerAdapter :
    PagedListAdapter<Data, GiphyRecyclerAdapter.ViewHolder>(DIFF_CALLBACK) {

    private lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.giphy_recycler_row_item,
            parent,
            false
        )
        context = parent.context
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val originalData: Data? = getItem(position)

        //holder.itemName.text = originalData?.url
        Glide.with(context).load(originalData?.images?.preview_gif?.url).into(holder.itemName)

        holder.itemView.setOnClickListener {

            val bundle = bundleOf(
                "gifUrl" to originalData?.images?.preview_gif?.url,
                "gifTitle" to originalData?.title
            )
            holder.itemView.findNavController().navigate(R.id.gifDetailsFragment, bundle)
        }
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var itemName: ImageView = itemView.findViewById(R.id.url)

    }

    companion object {

        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Data>() {

            override fun areItemsTheSame(oldItem: Data, newItem: Data): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Data, newItem: Data): Boolean {
                return oldItem == newItem
            }
        }
    }
}