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
import com.jetpack.submissionsatu.adapter.ContentMovieAdapter
import com.jetpack.submissionsatu.adapter.ContentMovieCallback
import com.jetpack.submissionsatu.data.Helper.TYPE_MOVIE
import com.jetpack.submissionsatu.databinding.MoviesFragmentBinding
import com.jetpack.submissionsatu.model.MovieEntity
import com.jetpack.submissionsatu.source.ViewModelFactory
import com.jetpack.submissionsatu.ui.detail.DetailActivity
import com.jetpack.submissionsatu.vo.Status

class MoviesFragment : Fragment(), ContentMovieCallback {

    private var binding: MoviesFragmentBinding? = null
    private lateinit var adapterMov : ContentMovieAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = MoviesFragmentBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val factory = ViewModelFactory.getInstance(context!!)
        val viewModel by lazy {
            ViewModelProvider(this, factory).get(MoviesViewModel::class.java)
        }
        adapterMov = ContentMovieAdapter(this@MoviesFragment,viewModel)
        viewModel.getMoviesData().observe(viewLifecycleOwner, { list ->
            if (list != null){
                when(list.status) {
                    Status.LOADING -> true.progressBar()
                    Status.SUCCESS -> {
                        false.progressBar()
                        adapterMov.submitList(list.body)
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
        binding?.rvMovie?.apply {
            layoutManager = GridLayoutManager(context, 2)
            adapter = adapterMov
        }
    }

    override fun onItemClicked(dataMovie: MovieEntity) {
        startActivity(
            Intent(context, DetailActivity::class.java)
                .putExtra(DetailActivity.EXTRA_DATA, dataMovie.id)
                .putExtra(DetailActivity.EXTRA_TYPE, TYPE_MOVIE)
        )
    }

    private fun Boolean.progressBar() {
        binding?.progressBar?.visibility = if (this) View.VISIBLE else View.GONE
    }

}