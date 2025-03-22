//package com.example.hospitaltry.common.calls.presentation
//
//import android.os.Bundle
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import androidx.fragment.app.Fragment
//import androidx.fragment.app.viewModels
//import androidx.navigation.fragment.findNavController
//import androidx.navigation.fragment.navArgs
//import androidx.recyclerview.widget.LinearLayoutManager
//import com.example.hospitaltry.R
//import com.example.hospitaltry.common.calls.presentation.recyclerView.CallsCommonAdapter
//import com.example.hospitaltry.databinding.FragmentCallsBinding
//import com.example.hospitaltry.reciptionist.presintation.recyclerView.CallsAdapter
//import com.example.hospitaltry.reciptionist.presintation.view.CallsFragmentArgs
//import com.example.hospitaltry.reciptionist.presintation.view.CallsFragmentDirections
//import com.example.hospitaltry.reciptionist.presintation.viewModel.CallsViewModel
//import dagger.hilt.android.AndroidEntryPoint
//
//@AndroidEntryPoint
//class CallsCommonFragment : Fragment() {
//
//    private lateinit var adapter: CallsCommonAdapter
//
//    private lateinit var binding: FragmentCallsBinding
//
//    private val args: CallsFragmentArgs by navArgs()
//
//    private val viewModel: CallsViewModel by viewModels()
//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_calls, container, false)
//    }
//
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//
//        val token = args.token
//
//        binding = FragmentCallsBinding.bind(view)
//
//        viewModel.getCalls(token)
//
//        adapter = CallsCommonAdapter { index ->
//            findNavController().navigate(
//                CallsFragmentDirections.actionCallsFragmentToCallDetails(
//                    adapter.callList?.get(index)!!.id, token
//                )
//            ),
//
//        }
//
//        binding.recyclerCalls.adapter = adapter
//        binding.recyclerCalls.layoutManager = LinearLayoutManager(requireContext())
//
//        viewModel.callLiveData.observe(viewLifecycleOwner) {
//                adapter.callList = it
//                adapter.notifyDataSetChanged()
//        }
//
//        binding.add.setOnClickListener{
//            findNavController().navigate(CallsFragmentDirections.actionCallsFragmentToCreateCall(token))
//        }
//    }
//}