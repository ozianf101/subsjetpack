package com.jetpack.submissionsatu.fragment

import android.content.Intent
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.jetpack.submissionsatu.R
import com.jetpack.submissionsatu.adapter.ContentAdapter
import com.jetpack.submissionsatu.adapter.ContentCallback
import com.jetpack.submissionsatu.data.Helper
import com.jetpack.submissionsatu.databinding.MoviesFragmentBinding
import com.jetpack.submissionsatu.databinding.TvShowFragmentBinding
import com.jetpack.submissionsatu.model.DataEntitas
import com.jetpack.submissionsatu.ui.detail.DetailActivity

class TvShowFragment : Fragment(),ContentCallback {

    private lateinit var tvViewModel: TvShowViewModel
    private var binding : TvShowFragmentBinding? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = TvShowFragmentBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        tvViewModel = ViewModelProvider(this).get(TvShowViewModel::class.java)

        val listTvShows =tvViewModel.getTvShows()
        setRecycler(listTvShows)
    }

    private fun setRecycler(data: List<DataEntitas>) {
        binding?.rvTvshow?.apply {
            layoutManager = GridLayoutManager(context, 2)
            adapter = ContentAdapter(this@TvShowFragment)
        }.also {
            it?.adapter.let { adapter ->
                when (adapter) {
                    is ContentAdapter -> {
                        adapter.setData(data)
                    }
                }
            }
        }
    }

    override fun onItemClicked(data: DataEntitas) {
        startActivity(
            Intent(context, DetailActivity::class.java)
                .putExtra(DetailActivity.EXTRA_DATA, data.id)
                .putExtra(DetailActivity.EXTRA_TYPE, Helper.TYPE_TVSHOW)
        )
    }

}