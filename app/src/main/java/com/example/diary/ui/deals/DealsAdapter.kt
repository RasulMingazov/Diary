package com.example.diary.ui.deals

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

import com.example.diary.data.entities.Deal
import com.example.diary.databinding.ItemDealBinding
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class DealsAdapter(private val listener: DealItemListener) : RecyclerView.Adapter<DealViewHolder>() {

    interface DealItemListener {
        fun onClickedDeal(characterId: Int)
    }

    private val items = ArrayList<Deal>()

    fun setItems(items: ArrayList<Deal>) {
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DealViewHolder {
        val binding: ItemDealBinding = ItemDealBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DealViewHolder(binding, listener)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: DealViewHolder, position: Int) = holder.bind(items[position])
}

class DealViewHolder(private val itemBinding: ItemDealBinding, private val listener: DealsAdapter.DealItemListener) : RecyclerView.ViewHolder(itemBinding.root),
    View.OnClickListener {

    private lateinit var deal: Deal

    init {
        itemBinding.root.setOnClickListener(this)
    }

    @SuppressLint("SetTextI18n", "SimpleDateFormat")
    fun bind(item: Deal) {
        this.deal = item
        itemBinding.taskName.text = deal.name

        val sf = SimpleDateFormat("HH:mm")
        val dateS = Date(deal.dateStart.toLong()*1000L)
        val dateF = Date(deal.dateFinish.toLong()*1000L)

        val dateT = sf.format(dateS) + " - " + sf.format(dateF)

        itemBinding.date.text = dateT
    }

    override fun onClick(v: View?) {
        listener.onClickedDeal(deal.id)
    }
}

