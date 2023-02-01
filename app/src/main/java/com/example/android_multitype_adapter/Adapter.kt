package com.example.android_multitype_adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.android_multitype_adapter.databinding.ItemRepositoriesBinding
import com.example.android_multitype_adapter.databinding.ItemUserPremiumBinding

class Adapter(var users: ArrayList<User>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var differ = AsyncListDiffer(this, DIFF_CALLBACK)
    private val TYPE_USER_FREE = 0
    private val TYPE_USER_PRO = 1

    override fun getItemCount(): Int = users.size

    override fun getItemViewType(position: Int): Int {
        var user = users[position]
        if (user.isPro) {
            return TYPE_USER_PRO
        }
        return TYPE_USER_FREE
    }

    fun addItems(items: List<User>) {
        differ.submitList(items)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if (viewType == TYPE_USER_PRO) {
            return AdapterTypeTwoViewHolder(
                ItemUserPremiumBinding.inflate(
                    LayoutInflater.from(
                        parent.context
                    ), parent, false
                )
            )
        }

        return AdapterTypeOneViewHolder(
            ItemRepositoriesBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
    }


    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<User>() {
            override fun areItemsTheSame(oldItem: User, newItem: User): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: User, newItem: User): Boolean {
                return oldItem == newItem
            }
        }

    }

    private class AdapterTypeOneViewHolder(binding: ItemRepositoriesBinding) :
        RecyclerView.ViewHolder(binding.root)


    private class AdapterTypeTwoViewHolder(binding: ItemUserPremiumBinding) :
        RecyclerView.ViewHolder(binding.root)


}