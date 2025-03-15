package com.example.hospitaltry.common.tasks.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.hospitaltry.common.cases.data.model.CaseData
import com.example.hospitaltry.databinding.ItemCasesMangerBinding

class CasesAdapter (val onClick:(Int)->Unit):RecyclerView.Adapter<CasesAdapter.Holder>(){
    var list :List<CaseData>?=null

    inner class Holder(val binding : ItemCasesMangerBinding) : RecyclerView.ViewHolder(binding.root){
        init {
            binding.root.setOnClickListener{
                onClick.invoke(layoutPosition)
            }
        }
        fun bind(caseData: CaseData){
            binding.txtName.text=caseData.patient_name
            binding.dateTxt.text=caseData.created_at

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding =
            ItemCasesMangerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
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