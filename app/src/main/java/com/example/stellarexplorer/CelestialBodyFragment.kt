package com.example.stellarexplorer.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ListView
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.stellarexplorer.R
import com.example.stellarexplorer.adapters.CelestialBodyAdapter

class CelestialBodyFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_celestial_body, container, false)

        val backgroundImageView = view.findViewById<ImageView>(R.id.background_image)
        Glide.with(this)
            .load(R.drawable.space_background)
            .into(backgroundImageView)

        val celestialBodies = listOf(
            "Sun",
            "Moon",
            "Mars",
            "Jupiter"
        )

        val listView = view.findViewById<ListView>(R.id.list_view_celestial_bodies)
        val adapter = CelestialBodyAdapter(requireContext(), celestialBodies)
        listView.adapter = adapter

        return view
    }
}