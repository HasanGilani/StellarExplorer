package com.example.stellarexplorer.fragments

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.RadioGroup
import com.example.stellarexplorer.R

class AddEventDialogFragment : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(activity)
        val inflater = requireActivity().layoutInflater
        val view: View = inflater.inflate(R.layout.fragment_add_event_dialog, null)

        builder.setView(view)
            .setTitle("Add Event")
            .setNegativeButton("Cancel") { dialog, _ -> dialog.dismiss() }
            .setPositiveButton("Add") { _, _ ->
                val editTextEventName = view.findViewById<EditText>(R.id.edit_text_event_name)
                val eventName = editTextEventName.text.toString()
                val editTextEventDate = view.findViewById<EditText>(R.id.edit_text_event_date)
                val eventDate = editTextEventDate.text.toString()
                val radioGroupEventType = view.findViewById<RadioGroup>(R.id.radio_group_event_type)
                val selectedEventTypeId = radioGroupEventType.checkedRadioButtonId
                val eventType = when (selectedEventTypeId) {
                    R.id.radio_eclipse -> "Eclipse"
                    R.id.radio_meteor_shower -> "Meteor Shower"
                    else -> "Unknown"
                }
                // Add logic to save the event
            }

        return builder.create()
    }
}