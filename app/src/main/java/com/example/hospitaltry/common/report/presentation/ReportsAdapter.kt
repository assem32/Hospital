package com.example.hospitaltry.common.report.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.hospitaltry.common.report.data.model.ReportData
import com.example.hospitaltry.databinding.ItemTaskBinding

class ReportsAdapter(
    val onClick:(Int)->Unit,
) : RecyclerView.Adapter<ReportsAdapter.Holder>() {

    var list :List<ReportData>?=null



    inner class Holder(val binding : ItemTaskBinding) : RecyclerView.ViewHolder(binding.root){
        init {
            binding.root.setOnClickListener{
                onClick.invoke(layoutPosition)

            }
        }
        fun bind(data: ReportData){

            binding.txtTaskName.text = data.report_name
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