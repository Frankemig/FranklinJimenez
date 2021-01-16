package com.example.franklinjimenez

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.franklinjimenez.databinding.FragmentListBinding

class ListFragment : Fragment() {

    private lateinit var binding: FragmentListBinding

    private val vm: MyViewModel by activityViewModels()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentListBinding.inflate(layoutInflater)

        binding.rvList.layoutManager = LinearLayoutManager(context)

        val adapter = BookAdapter()
        binding.rvList.adapter = adapter

        adapter.selectedItem().observe(viewLifecycleOwner, {
            vm.selected(it)
        })
        vm.books().observe(viewLifecycleOwner, {
            adapter.update(it)
        })
        return binding.root

    }

}