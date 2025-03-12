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
import com.example.hospitaltry.Hr.domain.repo.IHrRepo
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
    lateinit var iHrRepo: IHrRepo

    private lateinit var adapter: DoctorAdapter

    private val arg : AllDoctorsFragmentArgs by  navArgs()

    lateinit var binding: FragmentAllDoctorBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_all_doctor, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentAllDoctorBinding.bind(view)


        binding.createBtn.setOnClickListener {
            findNavController().navigate(AllDoctorsFragmentDirections.actionAllDoctorsFragmentToCreateUserFragment())
        }

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

                val response = iHrRepo.getDoctor("eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJhdWQiOiIxIiwianRpIjoiZWEwMzVkYzViY2JmNzdiZjU3YmQ3ZGE5MWY0MzkxMjdiOTI0YTA3NzE2NGEyOWIyOGNjNjU4M2NkYTQ3MzkxOGZjMzdkODk4MjI5OTAxMTEiLCJpYXQiOjE3NDEzNTEyMDkuMzg1NzI0LCJuYmYiOjE3NDEzNTEyMDkuMzg1NzI2LCJleHAiOjE3NzI4ODcyMDkuMzg0NjM0LCJzdWIiOiIxMzAiLCJzY29wZXMiOltdfQ.vQIhUuOUvZ-bvoHirQhT86tMXVjdAJIG2owalS5E-sK4C_XhdxbFB8k9By_o4MwhngTiNs6NtNfpejO6ImryWEIXUbF9wEVPLIJ0N2e4lDN4UFoeTPtjQSSjFyUhcfqS1BhVeQbcNTvtW6V8pwZuvzccuWKAM1SZS9urJN0i_W-hS7WAeYiBSfFxanry97LNj1CX8zUcf49j9uCdMifTZtwpIEuRDVEsV-CrHF5s999Gh75tTh2N5XUt9ug15WH7AClRhaCc4Kc7JcdBfVKHiFfQfYvIAl1VXB3e9DtyTyeTrvjl7Vi3HpI07ZAcgVYFbRuY-eBpMbVCR1bkBb5sow9OrB7NV1dNljs0mzwsSrO3j1i2BabaWUhRxEiHOy1kWrjOiBq0yXvvTtz7GZcAuZ54pYP4TJu1hfTOok9D81VwCE12vqCUPDdWU0ckEYKTYAbbOthlrwTL-IRV0OBk_aMPYP7MgHJ7oZw8_qKrOkIimulKdnno4X5zmzLa1ADonyxFt5527tx9UlK2KBAk5pv78f-yffvCZ8gApAsJ1PFm7Y1IegkvMQZFjc3IYDA2dMIUZVDd-ZSODBHSWPuh0hcWP2Xil0q0QG0ENUGHv7Sbu1LftCwybVslScEwC0vbeMSM9f442Q63y7vZ9Sw6PJXs1mGzf96tETolMo-D5hs")

                Log.d("e", "First Doctor: ${response[0]}")
                Log.d("fuu","fiuu")

            adapter.list=response
            binding?.recyclerDoctors?.layoutManager= LinearLayoutManager(requireContext())
            binding?.recyclerDoctors?.adapter=adapter

        }

    }
}
