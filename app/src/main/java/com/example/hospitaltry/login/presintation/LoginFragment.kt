package com.example.hospitaltry.login.presintation

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.hospitaltry.R
import com.example.hospitaltry.databinding.FragmentLoginBinding
import com.example.hospitaltry.login.data.dataSource.remote.LoginDataSourceImp
import com.example.hospitaltry.login.domain.repo.ILoginRepo
import com.example.hospitaltry.login.domain.usecase.LoginUseCase
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject


@AndroidEntryPoint
class LoginFragment : Fragment() {

    var binding: FragmentLoginBinding? =null


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

        binding?.loginBtn?.setOnClickListener{

            val email = binding?.phone?.text?.toString()?.trim()
            val password = binding?.password?.text?.toString()?.trim()

            lifecycleScope.launch {
               val resp = loginDataSource(email.toString(),password.toString(),"ase")
                Log.d("d",resp.email)
                if (resp.type=="doctor"){
                    findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToDoctorHomeFragment())
                }
                if (resp.type=="docotr"){
                    findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToSpecalistFragment())
                }

            }

        }



    }
}