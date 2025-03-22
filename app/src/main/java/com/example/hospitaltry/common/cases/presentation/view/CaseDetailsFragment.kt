package com.example.hospitaltry.common.cases.presentation.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.hospitaltry.common.cases.presentation.viewModel.CaseDetailsViewModel
import com.example.hospitaltry.databinding.FragmentCaseDetailsBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class CaseDetailsFragment : Fragment() {
    var binding :FragmentCaseDetailsBinding?=null

    val args :CaseDetailsFragmentArgs by navArgs()
    val viewModel: CaseDetailsViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentCaseDetailsBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding=FragmentCaseDetailsBinding.bind(view)
        val id =args.id
        viewModel.getDetails(id)
        viewModel.taskDetailsLiveData.observe(viewLifecycleOwner){
            binding!!.patientTxt.text=it.data.patient_name
            binding!!.ageTxt.text=it.data.age
            binding!!.dateTxt.text=it.data.created_at
            binding!!.statusTxt.text=it.data.status
            binding!!.phoneTxt.text=it.data.phone
            binding!!.doctorTxt.text=it.data.doctor_id
            binding!!.txtNurse.text=it.data.nurse_id
            binding!!.descriptionText.text=it.data.description

        }


    }

}
