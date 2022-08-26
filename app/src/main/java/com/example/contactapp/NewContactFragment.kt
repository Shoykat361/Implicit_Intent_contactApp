package com.example.contactapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.contactapp.databinding.FragmentNewContactBinding

class NewContactFragment : Fragment() {
    private lateinit var binding:FragmentNewContactBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentNewContactBinding.inflate(inflater,container,false)
        binding.saveBtn.setOnClickListener {
            saveinfo()

        }
        return binding.root
    }
    private fun saveinfo() {
        val name=binding.nameInput.text.toString()
        val phone=binding.numberInput.text.toString()
        val email=binding.emailInput.text.toString()
        val address=binding.addressInput.text.toString()

        val contactobj=Contact_DB(
            id = System.currentTimeMillis(),
            name=name,
            phone=phone,
            email=email,
            address=address,
        )
        ContactDetails.add(contactobj)
        findNavController().navigate(R.id.action_newContactFragment_to_homeFragment)
    }


}