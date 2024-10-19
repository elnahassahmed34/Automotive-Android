package com.example.fragments

import android.content.Intent
import android.content.res.Configuration.ORIENTATION_LANDSCAPE
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Fragment1 : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_1, container, false)

        val recyclerView: RecyclerView = view.findViewById(R.id.rv_recyclerview)

        val recyclerAdapter : ListAdapterDemo

        if(resources.configuration.orientation == ORIENTATION_LANDSCAPE) {
            recyclerAdapter = ListAdapterDemo() {
                var communicator: Communicator = this@Fragment1.activity as Communicator
                communicator.setText(it.name)

            }
        }
        else {
            recyclerAdapter = ListAdapterDemo() { language ->
                //Toast.makeText(requireContext(), language.name, Toast.LENGTH_SHORT).show()
                val intent = Intent(requireContext(), MainActivity2::class.java)
                intent.putExtra("name", language.name)
                startActivity(intent)
            }
        }
        recyclerAdapter.submitList(RecyclerRepo.getLanguages().toMutableList())

//        val recyclerAdapter = ListAdapterDemo(RecyclerRepo.getLanguages()) { language ->
//            Toast.makeText(requireContext(), language.name, Toast.LENGTH_SHORT).show()
//        }

        recyclerView.apply {
            adapter = recyclerAdapter
            layoutManager = LinearLayoutManager(requireContext()).apply {
                orientation = RecyclerView.VERTICAL
            }
        }

        return view
    }
}
