package com.example.hospitaltry.auth.presintation

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.hospitaltry.R
import com.example.hospitaltry.databinding.FragmentLoginBinding
import com.example.hospitaltry.auth.domain.usecase.LoginUseCase
import com.example.hospitaltry.user
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject


@AndroidEntryPoint
class LoginFragment : Fragment() {

    lateinit var binding: FragmentLoginBinding



    private val viewModel: LoginViewModel by viewModels()



    @Inject
    lateinit var loginDataSource: LoginUseCase

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding= FragmentLoginBinding.bind(view)

        binding.loginBtn.setOnClickListener{
            viewModel.login(binding.email.text.toString(),binding.password.text.toString())
        }
        viewModel.userModel.observe(viewLifecycleOwner){
            if (it.specialist=="receptionist"){
                findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToReceptionistHomeFragment(it.firstName+it.lastName,it.specialist,it.accessToken))
            }
            else if (it.specialist=="hr"){
                findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToSpecalistFragment(it.firstName+it.lastName,it.specialist))
            }
            else if(it.specialist=="doctor"){
                findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToDoctorHomeFragment())
            }
            else if(it.specialist=="manger"){
                findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToMangerHomeFragment())
            }
            user=it

        }



    }
}