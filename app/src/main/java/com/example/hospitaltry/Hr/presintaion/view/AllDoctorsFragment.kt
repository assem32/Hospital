package com.example.hospitaltry.Hr.presintaion.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hospitaltry.Hr.domain.model.UserModelItem
import com.example.hospitaltry.Hr.domain.repo.IGetAllDoctorsRepo
import com.example.hospitaltry.Hr.presintaion.adapter.DoctorAdapter
import com.example.hospitaltry.R
import com.example.hospitaltry.databinding.FragmentAllDoctorBinding
import com.example.hospitaltry.user
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject


@AndroidEntryPoint
class AllDoctorsFragment : Fragment() {

    @Inject
    lateinit var iGetAllDoctorsRepo: IGetAllDoctorsRepo

    private lateinit var adapter: DoctorAdapter

    private val arg : AllDoctorsFragmentArgs by  navArgs()

    var binding: FragmentAllDoctorBinding? =null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_all_doctor, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentAllDoctorBinding.bind(view)



        adapter = DoctorAdapter(
            {
                Log.d("gg",it.toString())

//                findNavController().navigate(AllDoctorsFragmentDirections.actionAllDoctorsFragmentToProfileFragment2(
//                    id = adapter.list?.get(it)?.id.toString(),
//                ))

                findNavController().navigate(AllDoctorsFragmentDirections.actionAllDoctorsFragmentToCreateCall2(
                    user.accessToken,adapter.list!!.get(it).id.toString()))
            }

        )

        adapter.list = emptyList()





//         Make the API call in a coroutine with error handling
        lifecycleScope.launch {

                val response = iGetAllDoctorsRepo.getDoctorR(arg.token)
                Log.d("e", "First Doctor: ${response[0]}")
                Log.d("fuu","fiuu")

            adapter.list=response
            binding?.recyclerDoctors?.layoutManager= LinearLayoutManager(requireContext())
            binding?.recyclerDoctors?.adapter=adapter

        }

    }
}
