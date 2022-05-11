package com.dhkim.mvvm_example

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.dhkim.mvvm_example.databinding.UserLayoutBinding

class UserAdapter : ListAdapter<User, UserAdapter.ViewHolder>(diffUtil) {

    inner class ViewHolder(private val binding: UserLayoutBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(user: User){
            with(binding){
                nameTextView.text = user.name

                Glide.with(profileImageView.context)
                    .load(user.imageUrl)
                    .into(profileImageView)

            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(UserLayoutBinding.bind(LayoutInflater.from(parent.context).inflate(R.layout.user_layout, parent, false)))

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(currentList[position])
    }

    companion object{
        private val diffUtil = object: DiffUtil.ItemCallback<User>(){
            override fun areItemsTheSame(oldItem: User, newItem: User): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: User, newItem: User): Boolean {
                return oldItem == newItem
            }

        }
    }

}