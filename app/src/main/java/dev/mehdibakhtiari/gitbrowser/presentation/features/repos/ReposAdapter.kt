package dev.mehdibakhtiari.gitbrowser.presentation.features.repos

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import dev.mehdibakhtiari.gitbrowser.data.models.ReposItem
import dev.mehdibakhtiari.gitbrowser.databinding.ItemReposBinding

class ReposAdapter(private val onClickListener: (ReposItem) -> Unit)
    : ListAdapter<ReposItem, ReposAdapter.ReposViewHolder>(MyDiffCallback()) {
   
       override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReposViewHolder {
           val inflater = LayoutInflater.from(parent.context)
           val binding = ItemReposBinding.inflate(inflater, parent, false)
           return ReposViewHolder(binding)
       }
   
       override fun onBindViewHolder(holder: ReposViewHolder, position: Int) {
           holder.bind(getItem(position), onClickListener)
       }
   
       class ReposViewHolder(private val binding: ItemReposBinding) : RecyclerView.ViewHolder(binding.root) {
   
           fun bind(reposModel: ReposItem, onClickListener: (ReposItem) -> Unit) {
               binding.model = reposModel
               binding.btnAction.setOnClickListener { onClickListener(reposModel) }
               binding.executePendingBindings()
           }
       }
   
       class MyDiffCallback : DiffUtil.ItemCallback<ReposItem>() {
           
           override fun areItemsTheSame(oldItem: ReposItem, newItem: ReposItem): Boolean {
               return oldItem.id == newItem.id
           }
   
           override fun areContentsTheSame(oldItem: ReposItem, newItem: ReposItem): Boolean {
               return oldItem == newItem
           }
       }
    }

   
   