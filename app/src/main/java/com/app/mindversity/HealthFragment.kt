package com.app.mindversity

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ProgressBar
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class HealthFragment : Fragment() {
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
        val view = inflater.inflate(R.layout.fragment_health, container, false)

        val progressBar: ProgressBar = view.findViewById(R.id.workoutBar)
        val exerciseBttn: Button = view.findViewById(R.id.exerciseCounterBttn)

        // Initialize RecyclerView
        val recyclerView: RecyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(activity)
        val items = listOf(
            ListItem("Item 1", "Details for Item 1"),
            ListItem("Lesson 1", "Information about Lesson 1"),
            ListItem("Lesson 2", "Information about Lesson 2"),
            ListItem("Lesson 3", "Information about Lesson 3"),
            ListItem("Lesson 4", "Information about Lesson 4"),
            ListItem("Lesson 5", "Information about Lesson 5"),
            ListItem("Lesson 6", "Information about Lesson 6"),
            ListItem("Lesson 7", "Information about Lesson 7"),
            ListItem("Lesson 8", "Information about Lesson 8"),
            ListItem("Lesson 9", "Information about Lesson 9!")
        )
        val adapter = ListAdapterH(items)
        recyclerView.adapter = adapter


        // Define action for the ExerciseButton
        exerciseBttn.setOnClickListener {

            if (progressBar.progress < 8) {
                progressBar.progress++
            }
            else{
                progressBar.progress = 0
            }
        }

            // Perform the desired action when the button is clicked
            // For example, show a toast message
            Toast.makeText(activity, "Exercise completed!", Toast.LENGTH_SHORT).show()

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
