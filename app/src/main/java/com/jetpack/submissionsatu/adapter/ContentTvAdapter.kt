package com.jetpack.submissionsatu.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.jetpack.submissionsatu.data.Helper.IMG_URL
import com.jetpack.submissionsatu.databinding.ContentLayoutBinding
import com.jetpack.submissionsatu.model.DataEntitasTv

class ContentTvAdapter (private val tvCallback: ContentTvCallback) : RecyclerView.Adapter<ContentTvAdapter.ListViewHolder>() {

    private val listData = ArrayList<DataEntitasTv?>()

    fun setData(data: ArrayList<DataEntitasTv?>) {
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
        listData[position]?.let { holder.bind(it) }
    }

    override fun getItemCount(): Int = listData.size

    inner class ListViewHolder(private val binding : ContentLayoutBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(dataTv: DataEntitasTv) {
            with(binding) {
                tvTitle.text = dataTv.title
                txtRate.text = dataTv.rating.toString().trim()

                Glide.with(itemView.context)
                    .load(IMG_URL+dataTv.imgPoster)
                    .into(imgItemPhoto)

                itemCard.setOnClickListener {
                    tvCallback.onItemClicked(dataTv)
                }
            }
        }
    }
}