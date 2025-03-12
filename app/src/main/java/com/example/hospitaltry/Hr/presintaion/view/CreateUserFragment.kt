package com.example.hospitaltry.Hr.presintaion.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.hospitaltry.Hr.domain.model.RegisterModel
import com.example.hospitaltry.Hr.presintaion.viewModel.CreateUserViewModel
import com.example.hospitaltry.R
import com.example.hospitaltry.databinding.FragmentCreateUserBinding
import com.example.hospitaltry.user
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CreateUserFragment :Fragment() {

    lateinit var binding: FragmentCreateUserBinding

    private val viewModel: CreateUserViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_create_user, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentCreateUserBinding.bind(view)

        viewModel.gender.observe(
            viewLifecycleOwner
        ) { it ->
            val genderAdp =
                ArrayAdapter(view.context, android.R.layout.simple_spinner_dropdown_item, it)
            binding.genderSpinner.adapter = genderAdp

        }

        viewModel.status.observe(viewLifecycleOwner){
                it ->
            val statusAdp =
                ArrayAdapter(view.context, android.R.layout.simple_spinner_dropdown_item, it)
            binding.statusSpinner.adapter = statusAdp
        }

        viewModel.role.observe(viewLifecycleOwner){
            val roleAdp =
                ArrayAdapter(view.context, android.R.layout.simple_spinner_dropdown_item, it)
            binding.specialistSpinner.adapter = roleAdp
        }



        binding.createBtn.setOnClickListener{
            val registerModel= RegisterModel(
                email = binding.email.text.toString(),
                password = binding.password.text.toString(),
                first_name = binding.firstName.text.toString(),
                last_name = binding.lastName.text.toString(),
                gender = binding.genderSpinner.selectedItem.toString(),
                specialist = binding.specialistSpinner.selectedItem.toString(),
                birthday = binding.birthday.text.toString(),
                status = binding.statusSpinner.selectedItem.toString(),
                address = binding.address.text.toString(),
                mobile = binding.mobile.text.toString(),
                type = binding.specialistSpinner.selectedItem.toString(),
            )
            viewModel.registerFun(registerModel, )
           Log.d("stat",""+binding.statusSpinner.selectedItem.toString())
            Log.d("stat",""+binding.specialistSpinner.selectedItem.toString())
            Log.d("stat",""+binding.genderSpinner.selectedItem.toString())

        }
        viewModel.responseLiveData.observe(viewLifecycleOwner){
            if(it.status==1){
                Toast.makeText(view.context,"Call created success", Toast.LENGTH_SHORT).show()
            }
        }

        }


}