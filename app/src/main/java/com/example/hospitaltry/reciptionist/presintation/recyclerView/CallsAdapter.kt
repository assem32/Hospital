package com.example.hospitaltry.reciptionist.presintation.recyclerView

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.hospitaltry.R
import com.example.hospitaltry.common.calls.domain.entity.CallsEntity
import com.example.hospitaltry.databinding.ItemCallsBinding
import com.example.hospitaltry.reciptionist.domain.model.CallsModleItem

class CallsAdapter (
    val onClick:(Int)->Unit
):RecyclerView.Adapter<CallsAdapter.Holder>(){

    var callList : List<CallsEntity> ?=null

    inner class Holder(val binding : ItemCallsBinding):RecyclerView.ViewHolder(binding.root){
        init {
            binding.root.setOnClickListener {
            onClick.invoke(layoutPosition)
        }
        }

        fun bind(call: CallsEntity){
            binding.txtName.text=call.patient_name
            binding.dateTxt.text=call.created_at
            if(call.status=="pending_doctor")
                binding.correctImg.setImageResource(R.drawable.icon_done)
            else
                binding.correctImg.setImageResource(R.drawable.icon_pending)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding =
            ItemCallsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return Holder(binding)
    }

    override fun getItemCount(): Int {
        return callList?.size  ?: 0
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val data = callList?.get(position)
        holder.bind(data!!)
    }
}