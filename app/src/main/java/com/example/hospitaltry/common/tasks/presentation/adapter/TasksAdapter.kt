package com.example.hospitaltry.common.tasks.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.hospitaltry.Hr.domain.model.UserModelItem
import com.example.hospitaltry.common.tasks.data.model.AllTasksRespons
import com.example.hospitaltry.common.tasks.data.model.TasksData
import com.example.hospitaltry.databinding.ItemProfileBinding
import com.example.hospitaltry.databinding.ItemTaskBinding

class TasksAdapter : RecyclerView.Adapter<TasksAdapter.Holder>() {

    var list :List<TasksData>?=null



    inner class Holder(val binding : ItemTaskBinding) : RecyclerView.ViewHolder(binding.root){
        init {
            binding.root.setOnClickListener{
//                onClick.invoke(layoutPosition)

            }
        }
        fun bind(data: TasksData){

            binding.txtTaskName.text = data.task_name
            binding.dateTxt.text = data.created_at
//            Glide.with(binding.root).load(user.avatar).into(binding.correctImg)


        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding =
            ItemTaskBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return Holder(binding)
    }

    override fun getItemCount(): Int {
        return list?.size ?: 0
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val data = list?.get(position)
        holder.bind(data!!)
    }
}