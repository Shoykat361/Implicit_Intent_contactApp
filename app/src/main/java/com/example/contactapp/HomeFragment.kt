package com.example.contactapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.contactapp.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {
    private lateinit var binding:FragmentHomeBinding


    override fun onCreateView(

        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentHomeBinding.inflate(inflater,container,false)
        //val ConactappAdapter=ConactappAdapter()
        val ConactappAdapter = ConactappAdapter{
            val bundle = Bundle().apply {
                putString("user_Name",it.name)
                putString("phone_value",it.phone)
                putString("email_value",it.email)
                putString("address_value",it.address)
            }
            findNavController().navigate(R.id.action_homeFragment_to_contactDetailsFragment,bundle)
        }
        binding.contactRV.layoutManager= LinearLayoutManager(requireActivity())
        binding.contactRV.adapter=ConactappAdapter
        ConactappAdapter.submitList(ContactDetails)


        binding.floatingActionButton.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_newContactFragment)
        }
        return binding.root
    }

}