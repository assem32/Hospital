package com.example.hospitaltry.reciptionist.presintation.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.hospitaltry.R
import com.example.hospitaltry.databinding.FragmentCallDetailsBinding
import com.example.hospitaltry.reciptionist.presintation.viewModel.CallDetailsViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class CallDetails : Fragment() {

    private lateinit var binding:FragmentCallDetailsBinding

    private val viewModel : CallDetailsViewModel by viewModels()

    private val args :CallDetailsArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_call_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding=FragmentCallDetailsBinding.bind(view)

        val id:Int = args.id
        val token:String = args.token


        viewModel.getDetails(id,token)

        viewModel.callDetailsLiveData.observe(viewLifecycleOwner){
            binding.patientTxt.text=it.name
            binding.ageTxt.text=it.age
            binding.patientTxt.text=it.phone
            binding.dateTxt.text=it.date
            binding.statusTxt.text=it.status
            binding.descriptionText.text=it.description
        }



    }
}
