package com.jetpack.submissionsatu.fragment

import android.content.Intent
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.jetpack.submissionsatu.adapter.ContentMovieAdapter
import com.jetpack.submissionsatu.adapter.ContentMovieCallback
import com.jetpack.submissionsatu.data.Helper.TYPE_MOVIE
import com.jetpack.submissionsatu.databinding.MoviesFragmentBinding
import com.jetpack.submissionsatu.model.DataEntitasMovie
import com.jetpack.submissionsatu.source.ViewModelFactory
import com.jetpack.submissionsatu.ui.detail.DetailActivity

class   MoviesFragment : Fragment(), ContentMovieCallback {

    private var binding : MoviesFragmentBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = MoviesFragmentBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val factory = ViewModelFactory.getInstance()
        val viewModel by lazy {
            ViewModelProvider(this,factory).get(MoviesViewModel::class.java)
        }
        viewModel.getMoviesData().observe(viewLifecycleOwner,{ list ->
            list?.let { setRecycler(it) }
        })

    }

    private fun setRecycler(data: ArrayList<DataEntitasMovie?>) {
        binding?.rvMovie?.apply {
            layoutManager = GridLayoutManager(context, 2)
            adapter = ContentMovieAdapter(this@MoviesFragment)
        }.also {
            it?.adapter.let { adapter ->
                when (adapter) {
                    is ContentMovieAdapter -> {
                        adapter.setData(data)
                    }
                }
            }
        }
    }

    override fun onItemClicked(dataMovie: DataEntitasMovie) {
        startActivity(
            Intent(context, DetailActivity::class.java)
                .putExtra(DetailActivity.EXTRA_DATA, dataMovie.id)
                .putExtra(DetailActivity.EXTRA_TYPE, TYPE_MOVIE)
        )
    }

}