package com.example.hospitaltry.Hr.presintaion.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.hospitaltry.Hr.domain.model.UserModelItem
import com.example.hospitaltry.databinding.ItemProfileBinding
import com.example.hospitaltry.login.domain.model.User

class DoctorAdapter (
    val onClick : (Int)-> Unit
) :RecyclerView.Adapter<DoctorAdapter.Holder>(){

    var list:List<UserModelItem>?=null



    inner class Holder(val binding :ItemProfileBinding) :RecyclerView.ViewHolder(binding.root){
        init {
            binding.root.setOnClickListener{
                onClick.invoke(layoutPosition)

            }
        }
        fun bind(user: UserModelItem){
            binding.itemName.text = user.firstName
            binding.itemSpeclaist.text = "Specialist - " + user.type
            Glide.with(binding.root).load(user.avatar).into(binding.itemImage)


        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding =
            ItemProfileBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return Holder(binding)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val data = list?.get(position)
        holder.bind(data!!)
    }

    override fun getItemCount(): Int {
        return list!!.size ?: 0
    }


}