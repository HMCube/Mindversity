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

class MindfullnessFragment : Fragment() {
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

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_mindfullness, container, false)
        // Initialize RecyclerView
        val recyclerView: RecyclerView = view.findViewById(R.id.recyclerView1)
        recyclerView.layoutManager = LinearLayoutManager(activity)
        val items = listOf(
            ListItem("Item 1", "Details for Item 1"),
            ListItem("Introduction to Mindfulness", "Information about Lesson 1!"),
            ListItem("Mindfulness Meditation", "Information about Lesson 2!"),
            ListItem("Mindfulness in Daily Life", "Information about Lesson 3!"),
            ListItem("Research on Mindfulness", "Information about Lesson 4!"),
            ListItem("Mindfulness for Stress", "Information about Lesson 5!"),
            ListItem("Mindfulness in Education", "Information about Lesson 6!"),
            ListItem("Mindfulness in the Workplace", "Information about Lesson 7!"),
            ListItem("Emotional Regulation", "Information about Lesson 8!"),
            ListItem("Mindfulness and Relationships", "Information about Lesson 9!")
        )
        val adapter = ListAdapterM(items)
        recyclerView.adapter = adapter

        return view
    }

    companion object {
        private const val ARG_PARAM1 = "param1"
        private const val ARG_PARAM2 = "param2"

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            MindfullnessFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
