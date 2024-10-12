package com.example.hospitaltry.doctor.presintation.recyclerView

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.hospitaltry.R
import com.example.hospitaltry.databinding.ItemCallsBinding
import com.example.hospitaltry.databinding.ItemProfileBinding
import com.example.hospitaltry.doctor.domain.model.CallsModleItem

class CallsAdapter (
    val onClick:(Int)->Unit
):RecyclerView.Adapter<CallsAdapter.Holder>(){

    var callList : List<CallsModleItem> ?=null

    inner class Holder(val binding : ItemCallsBinding):RecyclerView.ViewHolder(binding.root){
        init {
            binding.root.setOnClickListener {
            onClick.invoke(layoutPosition)
        }
        }

        fun bind(call:CallsModleItem){
            binding.nameTxt.text=call.patient_name
            binding.dateTxt.text=call.created_at
            if(call.status=="pending_doctor")
                binding.correctImg.setImageResource(R.drawable.correct_img)
            else
                binding.correctImg.setImageResource(R.drawable.pending_img)

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding =
            ItemCallsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return Holder(binding)
    }

    override fun getItemCount(): Int {
        return callList!!.size  ?: 0
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val data = callList?.get(position)
        holder.bind(data!!)
    }
}