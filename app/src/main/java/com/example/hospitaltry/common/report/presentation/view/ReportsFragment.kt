package com.example.hospitaltry.common.report.presentation.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.hospitaltry.common.report.domain.repo.IReport
import com.example.hospitaltry.common.report.presentation.ReportsAdapter
import com.example.hospitaltry.databinding.FragmentCaseDetailsBinding
import com.example.hospitaltry.databinding.FragmentReportsBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class ReportsFragment :Fragment() {
    var binding : FragmentReportsBinding?=null

    lateinit var adapter: ReportsAdapter

    @Inject
    lateinit var repo:IReport

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentReportsBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentReportsBinding.bind(view)
        adapter= ReportsAdapter{
            index->findNavController().navigate(ReportsFragmentDirections.actionReportsFragmentToReportDetailsFragment(adapter.list!![index].id))
        }


        lifecycleScope.launch {
            adapter.list=repo.getReport("2025-03-15").data
            binding!!.recyclerReport.adapter=adapter
        }



    }
}