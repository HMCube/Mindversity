package com.app.mindversity

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class HealthFragment : Fragment() {
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
        val view = inflater.inflate(R.layout.fragment_health, container, false)


        // Initialize RecyclerView
        val recyclerView: RecyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(activity)
        val items = listOf(
            ListItem("Item 1", "Details for Item 1"),
            ListItem("Navigating Nutrition", "Get ready to master your meals with 'Navigating Nutrition: Fueling Your College Journey'! Discover how to make healthy food choices that keep you energized and focused throughout your academic adventures. Let's dive in!"),
            ListItem("Stress Less, Live More", "Information about Lesson 2!"),
            ListItem("The Art of ZZZs", "Information about Lesson 3!"),
            ListItem("Fit for Finals", "Information about Lesson 4!"),
            ListItem("Smart Snacking", "Information about Lesson 5!"),
            ListItem("Balancing Act", "Information about Lesson 6!"),
            ListItem("Heart Health on Campus", "Information about Lesson 7!"),
            ListItem("Mind Matters", "Information about Lesson 8!"),
            ListItem("Hydrate to Graduate", "Information about Lesson 9!")
        )
        val adapter = ListAdapterH(items)
        recyclerView.adapter = adapter

        return view
    }

    companion object {
        private const val ARG_PARAM1 = "param1"
        private const val ARG_PARAM2 = "param2"

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            HealthFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
