package com.example.hospitaltry.common.tasks.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.hospitaltry.common.tasks.data.model.TasksData
import com.example.hospitaltry.common.tasks.data.model.ToDo
import com.example.hospitaltry.databinding.ItemTaskBinding
import com.example.hospitaltry.databinding.ItemTodoBinding

class TodoAdapter :RecyclerView.Adapter<TodoAdapter.Holder>(){
    var list :List<ToDo>?=null

    inner class Holder(val binding : ItemTodoBinding) : RecyclerView.ViewHolder(binding.root){
        init {
            binding.root.setOnClickListener{

            }
        }
        fun bind(todoString: ToDo){
            binding.txtTodo.text = todoString.title
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding =
            ItemTodoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return Holder(binding)
    }

    override fun getItemCount(): Int {
        return list?.size ?: 0
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val string = list?.get(position)
        holder.bind(string!!)
    }
}