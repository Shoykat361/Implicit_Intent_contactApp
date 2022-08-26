package com.example.contactapp


import android.app.Activity
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.contactapp.databinding.ContactRowBinding

class ConactappAdapter(val callback: (Contact_DB) -> Unit):ListAdapter<Contact_DB,ConactappAdapter.ContactViewHolder>(ContactDiffUtil()){



    class ContactViewHolder(val binding: ContactRowBinding)
        :RecyclerView.ViewHolder(binding.root){
        fun bind( ContactData:Contact_DB){
            binding.contactobj=ContactData

        }

    }
    class ContactDiffUtil:DiffUtil.ItemCallback<Contact_DB>(){
        override fun areItemsTheSame(oldItem: Contact_DB, newItem: Contact_DB): Boolean {
            return oldItem.id==newItem.id
        }

        override fun areContentsTheSame(oldItem: Contact_DB, newItem: Contact_DB): Boolean {
            return oldItem==newItem
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        // val binding=ContactRowBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        val binding = ContactRowBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return ContactViewHolder(binding)

    }

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        val schedule:Contact_DB=getItem(position)
        holder.bind(schedule)
        holder.binding.detailsIcon.setOnClickListener {
            callback(schedule)
        }

    }
}