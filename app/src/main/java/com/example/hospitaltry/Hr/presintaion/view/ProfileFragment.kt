package com.example.hospitaltry.Hr.presintaion.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import com.example.hospitaltry.Hr.domain.repo.IGetAllDoctorsRepo
import com.example.hospitaltry.R
import com.example.hospitaltry.databinding.FragmentProfileBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject


@AndroidEntryPoint
class ProfileFragment :Fragment(){

    @Inject
    lateinit var iGetAllDoctorsRepo: IGetAllDoctorsRepo

    val args : ProfileFragmentArgs by navArgs()

    private lateinit var _binding: FragmentProfileBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _binding = FragmentProfileBinding.bind(view)



        showLoadingState()
        lifecycleScope.launch {
            val res=iGetAllDoctorsRepo.getProfileR(args.id)
            Log.d("hey",res.first_name)

            _binding.nameTxt.text = res.first_name+res.last_name
            _binding.genderTxt.text = res.gender
            _binding.locationTxt.text = res.address
            _binding.mailTxt.text = res.email
            _binding.mobileTxt.text = res.mobile
            _binding.statusTxt.text=res.status
            _binding.specialTxt.text = res.specialist

            showDataState()



        }


    }

    private fun showLoadingState() {
        _binding.progressBar.visibility = View.VISIBLE
        _binding.errorTxt.visibility = View.GONE
        _binding.cardView.visibility = View.GONE
    }

    private fun showErrorState() {
        _binding.progressBar.visibility = View.GONE
        _binding.errorTxt.visibility = View.VISIBLE
        _binding.cardView.visibility = View.GONE
    }

    private fun showDataState() {
        _binding.progressBar.visibility = View.GONE
        _binding.errorTxt.visibility = View.GONE
        _binding.cardView.visibility = View.VISIBLE
    }

}