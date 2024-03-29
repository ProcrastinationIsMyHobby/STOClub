package com.example.sto2.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sto2.R
import com.example.sto2.adapters.StoListAdapter
import com.example.sto2.databinding.FragmentStoListBinding
import com.example.sto2.objects.STO

class STOListFragment : Fragment() {

    private var _binding: FragmentStoListBinding? = null
    private val binding get() = _binding!!
    private lateinit var stoList: MutableList<STO>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentStoListBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        stoList = ArrayList()
        val sto = STO("У ашота","UID","Ашот крутой", "", "Петухова 18", null,3.toFloat(),null)
        stoList.add(sto)
        stoList.add(sto)
        stoList.add(sto)
        binding.fab.setOnClickListener { view ->
            findNavController().navigate(R.id.action_STOListFragment_to_towTruckCallFragment)
        }

        val layoutManager = LinearLayoutManager(context)
        binding.recycler.layoutManager = layoutManager
        binding.recycler.setHasFixedSize(true);
        val adapter  = StoListAdapter(stoList)
        adapter.notifyDataSetChanged()

        binding.recycler.adapter = adapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}