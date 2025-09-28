package com.example.deron.t8_Fragment

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.deron.databinding.FragmentTwoBinding
import kotlin.getValue

class MyFragmentTwo : Fragment() {

    lateinit var binding: FragmentTwoBinding
    private val ac: MyFragmentActivity by lazy { activity as MyFragmentActivity }
    private val viewModel: MyFragmentViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTwoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnData.setOnClickListener {
            viewModel.updateData()
        }

        viewModel.data.observe(viewLifecycleOwner) { data ->
            binding.tvData.text = data
        }

    }

    override fun onStart() {
        super.onStart()
    }

    override fun onResume() {
        super.onResume()
    }

    companion object {
        @JvmStatic
        fun newInstance() = MyFragmentTwo()
    }
}