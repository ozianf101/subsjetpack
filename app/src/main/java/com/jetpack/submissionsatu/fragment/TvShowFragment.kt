package com.jetpack.submissionsatu.fragment

import android.content.Intent
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.jetpack.submissionsatu.adapter.ContentTvAdapter
import com.jetpack.submissionsatu.adapter.ContentTvCallback
import com.jetpack.submissionsatu.data.Helper
import com.jetpack.submissionsatu.databinding.TvShowFragmentBinding
import com.jetpack.submissionsatu.model.DataEntitasTv
import com.jetpack.submissionsatu.source.ViewModelFactory
import com.jetpack.submissionsatu.ui.detail.DetailActivity

class TvShowFragment : Fragment(), ContentTvCallback {
    private var binding: TvShowFragmentBinding? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = TvShowFragmentBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val factory = ViewModelFactory.getInstance()
        val viewModel by lazy {
            ViewModelProvider(this, factory).get(TvShowViewModel::class.java)
        }
        viewModel.getTvShows().observe(viewLifecycleOwner, { list ->
            list?.let { setRecycler(it) }
        })
    }

    private fun setRecycler(data: ArrayList<DataEntitasTv?>) {
        binding?.rvTvshow?.apply {
            layoutManager = GridLayoutManager(context, 2)
            adapter = ContentTvAdapter(this@TvShowFragment)
        }.also {
            it?.adapter.let { adapter ->
                when (adapter) {
                    is ContentTvAdapter -> {
                        adapter.setData(data)
                    }
                }
            }
        }
    }

    override fun onItemClicked(dataTv: DataEntitasTv) {
        startActivity(
            Intent(context, DetailActivity::class.java)
                .putExtra(DetailActivity.EXTRA_DATA, dataTv.id)
                .putExtra(DetailActivity.EXTRA_TYPE, Helper.TYPE_TVSHOW)
        )
    }

}