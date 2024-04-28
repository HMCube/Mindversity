package com.app.mindversity

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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
            ListItem("Lesson 1", "Information about Lesson 1!"),
            ListItem("Lesson 2", "Information about Lesson 2!"),
            ListItem("Lesson 3", "Information about Lesson 3!"),
            ListItem("Lesson 4", "Information about Lesson 4!"),
            ListItem("Lesson 5", "Information about Lesson 5!"),
            ListItem("Lesson 6", "Information about Lesson 6!"),
            ListItem("Lesson 7", "Information about Lesson 7!"),
            ListItem("Lesson 8", "Information about Lesson 8!"),
            ListItem("Lesson 9", "Information about Lesson 9!")
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
