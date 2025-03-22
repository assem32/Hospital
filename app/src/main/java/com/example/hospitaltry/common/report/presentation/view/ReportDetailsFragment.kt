package com.example.hospitaltry.common.report.presentation.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import com.example.hospitaltry.common.report.domain.repo.IReport
import com.example.hospitaltry.common.report.presentation.ReportsAdapter
import com.example.hospitaltry.databinding.FragmentReportDetailsBinding
import com.example.hospitaltry.databinding.FragmentReportsBinding
import com.example.hospitaltry.user
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class ReportDetailsFragment :Fragment() {
    var binding : FragmentReportDetailsBinding?=null
    @Inject
    lateinit var repo: IReport

    val arg : ReportDetailsFragmentArgs by navArgs()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentReportDetailsBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentReportDetailsBinding.bind(view)


        lifecycleScope.launch {
            val res= repo.getReportDetails(6).data
            if ( user.specialist!="manger"){
                binding!!.edtAnswer.visibility=View.GONE
            }
            binding!!.txtTaskName.text=res.report_name
            binding!!.txtUserName.text=res.user.first_name+res.user.last_name
            binding!!.txtType.text=res.user.specialist
            binding!!.textDate.text=res.created_at
            binding!!.txtMangerName.text=res.manger.first_name+res.manger.last_name
            binding!!.txtMangerDate.text=res.created_at
            binding!!.txtMangerType.text=res.manger.specialist
            binding!!.txtDetails.text=res.description
            if(res.answer==""){
                binding!!.txtAnswer.text="Manger Not Answer Yet"
            }
            else{
                binding!!.txtAnswer.text=res.answer
            }

            Log.d("www",""+res)
        }

    }
}