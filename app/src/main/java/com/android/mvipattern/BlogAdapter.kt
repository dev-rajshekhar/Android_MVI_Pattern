package com.android.mvipattern

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.android.mvipattern.databinding.ItemBlogRowBinding
import com.android.mvipattern.model.Blog

class BlogAdapter : ListAdapter<Blog, BlogAdapter.BlogViewHolder>(DiffUtilsCallBack()) {


    inner class BlogViewHolder( private  val binding: ItemBlogRowBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(currentItem: Blog?) {

            binding.apply {
                blogTitle.text= currentItem?.title
            }

        }

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BlogViewHolder {

        val view = ItemBlogRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return BlogViewHolder(view)
    }


    class DiffUtilsCallBack : DiffUtil.ItemCallback<Blog>() {
        override fun areItemsTheSame(oldItem: Blog, newItem: Blog): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Blog, newItem: Blog): Boolean {
            return oldItem == newItem
        }
    }

    override fun onBindViewHolder(holder: BlogViewHolder, position: Int) {
        val currentItem= getItem(position)
        holder.bind(currentItem)
    }

}