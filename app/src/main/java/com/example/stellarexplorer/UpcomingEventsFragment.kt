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

class UpcomingEventsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_upcoming_events, container, false)

        val backgroundImageView = view.findViewById<ImageView>(R.id.background_image)
        Glide.with(this)
            .load(R.drawable.planet_background)
            .into(backgroundImageView)

        val events = listOf(
            "Lunar Eclipse - 28 July 2024",
            "Perseid Meteor Shower - 12 August 2024"
        )

        val listView = view.findViewById<ListView>(R.id.list_view_upcoming_events)
        val adapter = CelestialBodyAdapter(requireContext(), events)
        listView.adapter = adapter

        return view
    }
}