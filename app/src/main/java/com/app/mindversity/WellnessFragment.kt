package com.app.mindversity

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class WellnessFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_wellness, container, false)
        // Initialize RecyclerView
        val recyclerView: RecyclerView = view.findViewById(R.id.recyclerView2)
        recyclerView.layoutManager = LinearLayoutManager(activity)
        val items = listOf(
            ListItem("Item 1", "Details for Item 1"),
            ListItem("Yoga Flow", "Yoga Flow: Discover the transformative power of movement, breath, and mindfulness with our invigorating yoga class. Join us as we flow through dynamic sequences designed to enhance flexibility, strength, and inner calm. Whether you're a seasoned yogi or new to the mat, come experience the rejuvenating benefits of this holistic practice."),
            ListItem("Healthy Dorm Cooking", "Information about Lesson 2!"),
            ListItem("Nature Walks", "Information about Lesson 3!"),
            ListItem("Art Therapy Workshop", "Information about Lesson 4!"),
            ListItem("Mindfulness Meditation", "Information about Lesson 5!"),
            ListItem("Fitness Fusion", "Information about Lesson 6!"),
            ListItem("Stress Buster Bootcamp", "Information about Lesson 7!"),
            ListItem("Self-Care Spa Day", "Information about Lesson 8!"),
            ListItem("Mindful Moments", "Information about Lesson 9!")
        )
        val adapter = ListAdapterW(items)
        recyclerView.adapter = adapter

        return view
    }

    companion object {
        private const val ARG_PARAM1 = "param1"
        private const val ARG_PARAM2 = "param2"

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            WellnessFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}