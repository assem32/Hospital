package com.example.hospitaltry.common.cases.presentation.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hospitaltry.common.cases.data.repo.CasesRepoImp
import com.example.hospitaltry.common.cases.domain.repo.ICasesRepo
import com.example.hospitaltry.common.tasks.presentation.adapter.CasesAdapter
import com.example.hospitaltry.databinding.FragmentHrHomeBinding
import com.example.hospitaltry.databinding.FragmentMangerCasesBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class CasesFragment :Fragment() {
    var binding :FragmentMangerCasesBinding?=null

    lateinit var adapter: CasesAdapter

    @Inject
    lateinit var use:ICasesRepo

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentMangerCasesBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)
        binding = FragmentMangerCasesBinding.bind(view)
        adapter= CasesAdapter(
            {
                findNavController().navigate(CasesFragmentDirections.actionCasesFragmentToCaseDetailsFragment(adapter.list!!.get(it).id))

            }
        )
        lifecycleScope.launch {
            val response=use.getAllCases().data
            adapter.list=response
            binding?.recyclerCalls?.layoutManager= LinearLayoutManager(requireContext())
            binding!!.recyclerCalls.adapter=adapter

        }
    }
}