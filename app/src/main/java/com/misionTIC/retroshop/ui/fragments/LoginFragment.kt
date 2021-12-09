package com.misionTIC.retroshop.ui.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import com.misionTIC.retroshop.databinding.FragmentLoginBinding
import com.misionTIC.retroshop.isValidEmail
import com.misionTIC.retroshop.ui.activities.HomeActivity
import com.misionTIC.retroshop.ui.viewmodels.LoginViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * A simple [Fragment] subclass.
 * Use the [LoginFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class LoginFragment : Fragment() {

    private var _binding: FragmentLoginBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private val loginViewModel: LoginViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        observeViewModels()
        binding.buttonLogin.setOnClickListener {
            var isValid = true

            if (!binding.loginEmail.text.isValidEmail()) {
                isValid = false
                binding.loginEmailLayout.error = "Correo electronico no valido"
            } else {
                binding.loginEmailLayout.error = null
            }

            if (binding.loginPassword.text.toString().length < 4) {
                isValid = false
                binding.loginPasswordLayout.error = "Contraseña invalida"
            } else {
                binding.loginPasswordLayout.error = null
            }

            if (isValid) {
                loginViewModel.login(binding.loginEmail.text.toString(), binding.loginPassword.text.toString())
            }
        }
    }
    private fun observeViewModels(){
        loginViewModel.user.observe(viewLifecycleOwner, Observer { user ->
            if(user != null ){
                val intent = Intent(requireContext(), HomeActivity::class.java)
                startActivity(intent)
            }
        })
        loginViewModel.error.observe(viewLifecycleOwner, Observer { message ->
            Toast.makeText(requireContext(),message, Toast.LENGTH_LONG).show()
        })
    }
}
