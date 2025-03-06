package com.example.hospitaltry.reciptionist.presintation.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hospitaltry.R
import com.example.hospitaltry.databinding.FragmentCallsBinding
import com.example.hospitaltry.reciptionist.domain.repo.IReceptionistRepo
import com.example.hospitaltry.reciptionist.presintation.recyclerView.CallsAdapter
import com.example.hospitaltry.reciptionist.presintation.viewModel.CallsViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class CallsFragment : Fragment() {

    private lateinit var adapter: CallsAdapter

    private lateinit var binding: FragmentCallsBinding

    private val args: CallsFragmentArgs by navArgs()

    private val viewModel: CallsViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_calls, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val token = args.token

        binding = FragmentCallsBinding.bind(view)

        viewModel.getCalls(token)

        adapter = CallsAdapter { index ->
            findNavController().navigate(
                CallsFragmentDirections.actionCallsFragmentToCallDetails(
                    adapter.callList?.get(index)!!.id, token
                )
            )
        }

        binding.recyclerCalls.adapter = adapter
        binding.recyclerCalls.layoutManager = LinearLayoutManager(requireContext())

        viewModel.callLiveData.observe(viewLifecycleOwner) {
                adapter.callList = it
                adapter.notifyDataSetChanged()
        }

        binding.add.setOnClickListener{
            findNavController().navigate(CallsFragmentDirections.actionCallsFragmentToCreateCall(token))
        }
    }
}