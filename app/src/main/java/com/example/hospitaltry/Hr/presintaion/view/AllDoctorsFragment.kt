package com.example.hospitaltry.Hr.presintaion.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hospitaltry.Hr.domain.model.UserModelItem
import com.example.hospitaltry.Hr.domain.repo.IGetAllDoctorsRepo
import com.example.hospitaltry.Hr.presintaion.adapter.DoctorAdapter
import com.example.hospitaltry.R
import com.example.hospitaltry.databinding.FragmentAllDoctorBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject


@AndroidEntryPoint
class AllDoctorsFragment : Fragment() {

    @Inject
    lateinit var iGetAllDoctorsRepo: IGetAllDoctorsRepo

    private lateinit var adapter: DoctorAdapter

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
                findNavController().navigate(AllDoctorsFragmentDirections.actionAllDoctorsFragmentToProfileFragment2(
                    id = adapter.list?.get(it)?.id.toString(),
                ))
            }

        )

        adapter.list = emptyList()

        Log.d("fuu","fiuu")
        val usersList = listOf(
            UserModelItem(
                id = 2,
                firstName = "Ms. Wilma Raynor V Rahsaan Considine",
                type = "doctor",
                avatar = "https://hospital.elhossiny.net/public/avatar.png"
            ),
            UserModelItem(
                id = 8,
                firstName = "Parker Renner Jarvis Champlin",
                type = "doctor",
                avatar = "https://hospital.elhossiny.net/public/avatar.png"
            ),
            UserModelItem(
                id = 9,
                firstName = "Tanner Schneider Mellie Schumm II",
                type = "doctor",
                avatar = "https://hospital.elhossiny.net/public/avatar.png"
            ),
            UserModelItem(
                id = 12,
                firstName = "Mr. Tillman Bernier III Bryon Quigley",
                type = "doctor",
                avatar = "https://hospital.elhossiny.net/public/avatar.png"
            ),
            UserModelItem(
                id = 15,
                firstName = "Bette Bahringer Yasmeen Cronin",
                type = "doctor",
                avatar = "https://hospital.elhossiny.net/public/avatar.png"
            )
        )






//         Make the API call in a coroutine with error handling
        lifecycleScope.launch {

                val response = iGetAllDoctorsRepo.getDoctorR()
                Log.d("e", "First Doctor: ${response[0]}")
                Log.d("fuu","fiuu")

            adapter.list=response
            binding?.recyclerDoctors?.layoutManager= LinearLayoutManager(requireContext())
            binding?.recyclerDoctors?.adapter=adapter

        }

    }
}
