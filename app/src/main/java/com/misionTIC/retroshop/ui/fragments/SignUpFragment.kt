package com.misionTIC.retroshop.ui.fragments

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.misionTIC.retroshop.R
import com.misionTIC.retroshop.databinding.FragmentSignUpBinding
import com.misionTIC.retroshop.ui.activities.HomeActivity
import com.misionTIC.retroshop.ui.viewmodels.LoginViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * A simple [Fragment] subclass.
 * Use the [SignUpFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SignUpFragment : Fragment() {

    private var _binding: FragmentSignUpBinding? = null
    private val binding get() = _binding!!
    private val loginViewModel: LoginViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentSignUpBinding.inflate(inflater, container, false)
        return binding.root
    }

  /**  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.buttonSignUp.setOnClickListener {
            findNavController().navigate(R.id.action_singUpFragment_to_loginFragment)
        }
    }**/

    override fun onStart() {
        super.onStart()
        observeViewModels()
        binding.buttonSignUp.setOnClickListener {
            findNavController().navigate(R.id.action_singUpFragment_to_loginFragment)
        }
        binding.buttonSignUp.setOnClickListener{
            loginViewModel.signUp(binding.signupEmail.text.toString(), binding.signupFirstname.text.toString(),
                 binding.signupPassword.text.toString())
        }
    }

    private fun observeViewModels(){
        loginViewModel.user.observe(viewLifecycleOwner, Observer { user ->
            if(user != null ){
                findNavController().navigate(R.id.action_singUpFragment_to_loginFragment)
            }
        })
        loginViewModel.error.observe(viewLifecycleOwner, Observer { message ->
            Toast.makeText(requireContext(),message, Toast.LENGTH_LONG).show()
        })
    }
}