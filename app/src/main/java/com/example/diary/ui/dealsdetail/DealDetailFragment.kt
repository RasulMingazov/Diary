package com.example.diary.ui.dealsdetail

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.example.diary.data.entities.Deal
import com.example.diary.utils.autoCleared
import dagger.hilt.android.AndroidEntryPoint
import com.example.diary.databinding.DealFragmentBinding
import java.text.SimpleDateFormat
import java.util.*

@AndroidEntryPoint
class DealDetailFragment: Fragment() {
    private var binding: DealFragmentBinding by autoCleared()
    private val viewModel: DealDetailViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DealFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.getInt("id")?.let { viewModel.start(it) }
        bindCharacter(viewModel.deal)
    }

    @SuppressLint("SimpleDateFormat")
    private fun bindCharacter(deal: Deal?) {
        binding.name.text = deal!!.name

        val sf = SimpleDateFormat("HH:mm")
        val dateS = Date(deal.dateStart.toLong()*1000L)
        val dateF = Date(deal.dateFinish.toLong()*1000L)

        val dateT = sf.format(dateS) + " - " + sf.format(dateF)


        binding.date.text = dateT
        binding.description.text = deal.description
    }
}