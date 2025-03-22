package com.example.hospitaltry.doctor.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hospitaltry.R
import com.example.hospitaltry.databinding.FragmentCallsCommonBinding
import com.example.hospitaltry.doctor.presentation.recyclerView.CallsCommonAdapter
import com.example.hospitaltry.doctor.presentation.viewModel.CallsDoctorViewModel
import com.example.hospitaltry.reciptionist.presintation.view.CallsFragmentArgs
import com.example.hospitaltry.reciptionist.presintation.view.CallsFragmentDirections
import com.example.hospitaltry.user
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CallsCommonFragment : Fragment() {

    private lateinit var adapter: CallsCommonAdapter

    private lateinit var binding: FragmentCallsCommonBinding


    private val viewModel: CallsDoctorViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_calls_common, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding = FragmentCallsCommonBinding.bind(view)

        viewModel.getCalls(user.tokenType)


        adapter = CallsCommonAdapter(
            onClick = { index->
//                findNavController().navigate(
//                    CallsFragmentDirections.actionCallsFragmentToCallDetails(
//                        adapter.callList?.get(index)!!.id, user.tokenType
//                    )
//                )
            },
            onAccept ={
                index ->
                viewModel.AcceptOrRejectCalls(adapter.callList?.get(index)!!.id,"accept")
            } ,
            onBusy = {
                index ->
                viewModel.AcceptOrRejectCalls(adapter.callList?.get(index)!!.id,"busy")
            }
        )


        binding.recyclerCalls.adapter = adapter
        binding.recyclerCalls.layoutManager = LinearLayoutManager(requireContext())

        viewModel.callLiveData.observe(viewLifecycleOwner) {
                adapter.callList = it
                adapter.notifyDataSetChanged()
        }


    }
}