package com.misionTIC.retroshop.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import com.bumptech.glide.Glide
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.ktx.awaitMap
import com.google.maps.android.ktx.awaitMapLoad
import com.google.android.gms.maps.model.LatLngBounds
import com.google.android.gms.maps.model.MarkerOptions
import com.misionTIC.retroshop.R
import com.misionTIC.retroshop.databinding.FragmentHomeBinding
import com.misionTIC.retroshop.ui.viewmodels.StoreViewModel
import org.koin.androidx.viewmodel.ext.android.sharedViewModel


/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private val storeViewModel: StoreViewModel by sharedViewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        storeViewModel.loadInfo()
        observeViewModels()
    }

    private fun observeViewModels(){
        storeViewModel.info.observe(viewLifecycleOwner, Observer{ info ->
            binding.home.text = info.name
            binding.homeHistory.text = info.description
            binding.homeContact.text = info.contact
            binding.homeDirection.text = info.address
            Glide.with(binding.root).load(info.image).into(binding.homeImage)

            val mapFragment = childFragmentManager.findFragmentById(R.id.home_map) as SupportMapFragment
            lifecycleScope.launchWhenStarted {
                val googleMap = mapFragment.awaitMap()
                googleMap.awaitMapLoad()
                val latlng = LatLng(4.64749483867678, -74.10179015622796)
                googleMap.addMarker(
                    MarkerOptions()
                        .position(latlng)
                        .title(info.name!!)
                )
                val bounds = LatLngBounds.builder()
                    .include(latlng)
                    .build()
                googleMap.moveCamera(CameraUpdateFactory.newLatLngBounds(bounds, 20))
            }
        })
    }

}
