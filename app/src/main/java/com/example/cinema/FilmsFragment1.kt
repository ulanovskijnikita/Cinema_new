package com.example.cinema

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.cinema.databinding.FragmentFilms1Binding


class FilmsFragment1 : Fragment() {

    private lateinit var binding: FragmentFilms1Binding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentFilms1Binding.inflate(layoutInflater)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        val context = requireContext()

//        Recycler
        binding.fragmentFilmsRecycler.adapter = FragmentAdapter(context, FragmentList().list)
    }
}