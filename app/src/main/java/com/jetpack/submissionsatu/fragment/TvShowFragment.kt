package com.jetpack.submissionsatu.fragment

import android.content.Intent
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import com.jetpack.submissionsatu.adapter.ContentTvAdapter
import com.jetpack.submissionsatu.adapter.ContentTvCallback
import com.jetpack.submissionsatu.data.Helper
import com.jetpack.submissionsatu.databinding.TvShowFragmentBinding
import com.jetpack.submissionsatu.model.TvShowEntity
import com.jetpack.submissionsatu.source.ViewModelFactory
import com.jetpack.submissionsatu.ui.detail.DetailActivity
import com.jetpack.submissionsatu.vo.Status

class TvShowFragment : Fragment(), ContentTvCallback {
    private var binding: TvShowFragmentBinding? = null
    private lateinit var tvAdapter : ContentTvAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = TvShowFragmentBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val factory = ViewModelFactory.getInstance(context!!)
        val viewModel by lazy {
            ViewModelProvider(this, factory).get(TvShowViewModel::class.java)
        }
        tvAdapter = ContentTvAdapter(this@TvShowFragment,viewModel)
        viewModel.getTvShows().observe(viewLifecycleOwner, { list ->
            if (list!= null){
                when (list.status){
                    Status.LOADING -> true.progressBar()
                    Status.SUCCESS -> {
                        false.progressBar()
                        tvAdapter.submitList(list.body)
                    }
                    Status.ERROR -> {
                        Toast.makeText(context, "Terjadi kesalahan", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        })
        setRecycler()
    }

    private fun setRecycler() {
        binding?.rvTvshow?.apply {
            layoutManager = GridLayoutManager(context, 2)
            adapter = tvAdapter
        }
    }

    override fun onItemClicked(dataTv: TvShowEntity) {
        startActivity(
            Intent(context, DetailActivity::class.java)
                .putExtra(DetailActivity.EXTRA_DATA, dataTv.id)
                .putExtra(DetailActivity.EXTRA_TYPE, Helper.TYPE_TVSHOW)
        )
    }
    private fun Boolean.progressBar() {
        binding?.progressBarTv?.visibility = if (this) View.VISIBLE else View.GONE
    }


}