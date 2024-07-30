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

class ConstellationsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_constellations, container, false)

        val backgroundImageView = view.findViewById<ImageView>(R.id.background_image)
        Glide.with(this)
            .load(R.drawable.constellation_background)
            .into(backgroundImageView)

        val constellations = listOf(
            "Orion",
            "Cassiopeia",
            "Andromeda"
        )

        val listView = view.findViewById<ListView>(R.id.list_view_constellations)
        val adapter = CelestialBodyAdapter(requireContext(), constellations)
        listView.adapter = adapter

        return view
    }
}