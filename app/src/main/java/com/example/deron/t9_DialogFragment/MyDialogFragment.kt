package com.example.deron.t9_DialogFragment

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.example.deron.databinding.DialogFragmentBinding
import androidx.core.graphics.drawable.toDrawable
import androidx.fragment.app.activityViewModels
import com.example.deron.R

class MyDialogFragment : DialogFragment() {

    lateinit var binding: DialogFragmentBinding
    private val viewModel: DialogFragmentViewModel by activityViewModels()

    override fun onStart() {
        super.onStart()
        // 背景 window 會影響自訂義的 background，改成透明
        dialog?.window?.apply {
            this.setBackgroundDrawable(Color.TRANSPARENT.toDrawable())
        }

        // window 預設會 WRAP_CONTENT，即便 xml 寫死寬度
        dialog?.window?.setLayout(
            resources.getDimensionPixelSize(R.dimen.dialog_width),
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModelObserve()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DialogFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnConfirm.setOnClickListener {
            viewModel.updateData()
        }

        binding.btnCancel.setOnClickListener {
            dismiss()
        }
    }

    private fun viewModelObserve() {
        viewModel.apply {
            data.observe(this@MyDialogFragment) { data ->
                binding.tvContent.text = data
            }
        }
    }

    companion object {
        fun newInstance(): MyDialogFragment {
            val fragment = MyDialogFragment()
            return fragment
        }
    }
}