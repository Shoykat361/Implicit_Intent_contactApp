package com.example.contactapp

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.contactapp.databinding.FragmentContactDetailsBinding

class ContactDetailsFragment : Fragment() {
    private lateinit var binding:FragmentContactDetailsBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentContactDetailsBinding.inflate(inflater,container,false)
        val phone = arguments?.getString("phone_value")
        val email = arguments?.getString("email_value")
        val address = arguments?.getString("address_value")
        binding.phoneTV.text = phone.toString()
        binding.showemailTV.text = email.toString()
        binding.addressTV.text = address.toString()
        binding.callBtn.setOnClickListener {
            try {
                val intent = Intent(Intent.ACTION_DIAL).apply {
                    data = Uri.parse("tel:$phone")
                }
                startActivity(intent)
            } catch (e: ActivityNotFoundException){
                Toast.makeText(requireActivity(), "Could not launch any app", Toast.LENGTH_SHORT).show()
            }
        }
        binding.smsBtn.setOnClickListener {
            try {
                val intent = Intent(Intent.ACTION_SENDTO).apply {
                    data = Uri.parse("smsto:$phone")
                }
                startActivity(intent)
            }catch (e: ActivityNotFoundException){
                Toast.makeText(requireActivity(), "Could not launch any app", Toast.LENGTH_SHORT).show()
            }
        }
        binding.emailBtn.setOnClickListener {
            try {
                val intent = Intent(Intent.ACTION_SEND).apply {
                    type = "*/*"
                    putExtra(Intent.EXTRA_EMAIL, arrayOf("$email"))
                    /*putExtra(Intent.EXTRA_SUBJECT, "Test")
                    putExtra(Intent.EXTRA_STREAM, "Hello")*/
                }
                startActivity(intent)
            } catch (e: ActivityNotFoundException) {
                Toast.makeText(requireActivity(), "Could not launch any app", Toast.LENGTH_SHORT)
                    .show()
            }
        }
        binding.addressBtn.setOnClickListener {
            try {
                val intent = Intent(Intent.ACTION_VIEW).apply {
                    data = Uri.parse("geo: 0,0?q=$address")
                }
                startActivity(intent)
            }catch (e: ActivityNotFoundException){
                Toast.makeText(requireActivity(), "Could not launch any app", Toast.LENGTH_SHORT).show()
            }
        }
        return binding.root
    }


}