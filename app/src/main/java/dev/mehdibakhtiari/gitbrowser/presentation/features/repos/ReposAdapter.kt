package dev.mehdibakhtiari.gitbrowser.presentation.features.repos

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import dev.mehdibakhtiari.gitbrowser.data.models.ReposEntity
import dev.mehdibakhtiari.gitbrowser.databinding.ItemReposBinding

class ReposAdapter(private val onClickListener: (ReposEntity) -> Unit)
    : ListAdapter<ReposEntity, ReposAdapter.ReposViewHolder>(MyDiffCallback()) {
   
       override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReposViewHolder {
           val inflater = LayoutInflater.from(parent.context)
           val binding = ItemReposBinding.inflate(inflater, parent, false)
           return ReposViewHolder(binding)
       }
   
       override fun onBindViewHolder(holder: ReposViewHolder, position: Int) {
           holder.bind(getItem(position), onClickListener)
       }
   
       class ReposViewHolder(private val binding: ItemReposBinding) : RecyclerView.ViewHolder(binding.root) {
   
           fun bind(reposModel: ReposEntity, onClickListener: (ReposEntity) -> Unit) {
               binding.model = reposModel
               binding.btnAction.setOnClickListener { onClickListener(reposModel) }
               binding.executePendingBindings()
           }
       }
   
       class MyDiffCallback : DiffUtil.ItemCallback<ReposEntity>() {
           
           override fun areItemsTheSame(oldItem: ReposEntity, newItem: ReposEntity): Boolean {
               return oldItem.id == newItem.id
           }
   
           override fun areContentsTheSame(oldItem: ReposEntity, newItem: ReposEntity): Boolean {
               return oldItem == newItem
           }
       }
    }

   
   