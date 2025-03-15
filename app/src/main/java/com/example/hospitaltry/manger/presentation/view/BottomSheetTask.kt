package com.example.hospitaltry.manger.presentation.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.hospitaltry.R
import com.example.hospitaltry.databinding.PopupTodoBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class BottomSheetTask :BottomSheetDialogFragment() {

    var binding:PopupTodoBinding?=null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.popup_todo, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding= PopupTodoBinding.bind(view)
        binding!!.btnAddTask.setOnClickListener {
            val inputText = binding!!.edtReportDescription.text.toString()
            if (inputText.isNotEmpty()) {
                // Pass the input text back to the Activity
                (parentFragment as? OnBottomSheetSubmitListener)?.onSubmit(inputText)
                dismiss() // Close the bottom sheet
            } else {
                Toast.makeText(requireContext(), "Please enter something", Toast.LENGTH_SHORT).show()
            }
        }

    }

    interface OnBottomSheetSubmitListener {
        fun onSubmit(input: String)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        // Clean up the binding reference to avoid memory leaks
        binding = null
    }
}