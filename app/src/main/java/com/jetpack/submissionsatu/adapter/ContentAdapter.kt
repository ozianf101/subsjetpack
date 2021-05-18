package com.jetpack.submissionsatu.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.jetpack.submissionsatu.databinding.ContentLayoutBinding
import com.jetpack.submissionsatu.model.DataEntitas

class ContentAdapter (private val callback: ContentCallback) : RecyclerView.Adapter<ContentAdapter.ListViewHolder>() {

    private val listData = ArrayList<DataEntitas>()

    fun setData(data: List<DataEntitas>?) {
        if (data == null) return
        listData.clear()
        listData.addAll(data)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val contentLayoutBinding =
            ContentLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListViewHolder(contentLayoutBinding)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.bind(listData[position])
    }

    override fun getItemCount(): Int = listData.size

    inner class ListViewHolder(private val binding : ContentLayoutBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(data: DataEntitas) {
            with(binding) {
                tvTitle.text = data.title
                txtRate.text = data.rating.toString().trim()

                Glide.with(itemView.context)
                    .load(data.imgPoster)
                    .into(imgItemPhoto)

                itemCard.setOnClickListener {
                    callback.onItemClicked(data)
                }
            }
        }
    }
}