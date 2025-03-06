package com.example.hospitaltry.reciptionist.presintation.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.hospitaltry.R
import com.example.hospitaltry.databinding.FragmentCallCreateBinding
import com.example.hospitaltry.reciptionist.domain.model.CallCreateEntitiy
import com.example.hospitaltry.reciptionist.domain.model.CallEntity
import com.example.hospitaltry.reciptionist.presintation.viewModel.CallCreateViewModel
import com.example.hospitaltry.reciptionist.presintation.viewModel.CallsViewModel
import com.example.hospitaltry.user
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CreateCall : Fragment() {

    private lateinit var binding: FragmentCallCreateBinding

    private val args: CreateCallArgs by navArgs()

    private val viewModel: CallCreateViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_call_create, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentCallCreateBinding.bind(view)
        val token = args.token
        binding.selectDoctorEditor.setOnClickListener {
            findNavController().navigate(
                CreateCallDirections.actionCreateCallToAllDoctorsFragment(
                    token
                )
            )
        }

        binding.selectDoctorEditor.hint = args.doctorId
//        val entity=CallCreateEntitiy(
//            name = binding.nameEditor.text.toString(),
//            age = binding.ageEditor.text.toString(),
//            phone = binding.phoneEditor.text.toString(),
//            doctorId = args.doctorId,
//            description = binding.descriptionEditor.text.toString()
//        )


        binding.createBtn.setOnClickListener {
            val entity = CallCreateEntitiy(
                patient_name = binding.nameEditor.text.toString(),
                age = binding.ageEditor.text.toString(),
                phone = binding.phoneEditor.text.toString(),
                doctor_id = args.doctorId,
                description = binding.descriptionEditor.text.toString()
            )
            viewModel.createCall(entity, user.accessToken)
        }
        viewModel.createResponseLiveData.observe(viewLifecycleOwner) {
            if(it.status==1){
                Toast.makeText(view.context,"Call created success",Toast.LENGTH_SHORT).show()
                findNavController().navigate(CreateCallDirections.actionCreateCallToCallsFragment(
                    user.accessToken))
            }
            else{
                Toast.makeText(view.context,"Call create failed",Toast.LENGTH_SHORT).show()
            }
            Log.d("is create", "" + it.message)
        }
    }
}