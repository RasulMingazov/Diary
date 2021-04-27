package com.example.diary.ui.deals

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TimePicker
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.applandeo.materialcalendarview.listeners.OnDayClickListener
import com.example.diary.R
import com.example.diary.data.entities.Deal
import com.example.diary.databinding.DealsFragmentBinding
import com.example.diary.utils.autoCleared
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.item_deal.*
import java.sql.Timestamp
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList


@AndroidEntryPoint
class DealsFragment: Fragment(), DealsAdapter.DealItemListener {

    private var binding: DealsFragmentBinding by autoCleared()
    private val viewModel: DealsViewModel by viewModels()
    private lateinit var adapter: DealsAdapter
    private var chTimestamp: Long = 0

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DealsFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.calendarView.setOnDayClickListener(OnDayClickListener { eventDay ->
            val clickedDayCalendar = eventDay.calendar
            chTimestamp = clickedDayCalendar.timeInMillis
            setupRecyclerView()
        })
    }

    private fun setupRecyclerView() {
        adapter = DealsAdapter(this)
        binding.dealsRv.layoutManager = LinearLayoutManager(requireContext())
        binding.dealsRv.adapter = adapter
        adapter.setItems(ArrayList(makeArrayOfDay()))
    }

    private fun makeArrayOfDay() : ArrayList<Deal>{
        val sf = SimpleDateFormat("dd.MM.yyyy")
        val dateCh = Date(chTimestamp)
        val dateChStr = sf.format(dateCh)
        val dealsDay = arrayListOf<Deal>()

        for (deal: Deal in viewModel.deals!!) {
            val date = Date(deal.dateStart.toLong()*1000L)
            val dateStr = sf.format(date)
            if (dateChStr == dateStr) {
                dealsDay.add(deal)
            }
        }
        return dealsDay
    }

    override fun onClickedDeal(dealId: Int) {
        findNavController().navigate(
           R.id.action_dealsFragment_to_dealsDetailFragment,
            bundleOf("id" to dealId)
        )
    }


}