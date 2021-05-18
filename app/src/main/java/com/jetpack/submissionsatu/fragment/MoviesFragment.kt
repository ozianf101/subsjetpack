package com.jetpack.submissionsatu.fragment

import android.content.Intent
import android.nfc.NfcAdapter.EXTRA_DATA
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
import com.jetpack.submissionsatu.data.Helper.TYPE_MOVIE
import com.jetpack.submissionsatu.databinding.MoviesFragmentBinding
import com.jetpack.submissionsatu.model.DataEntitas
import com.jetpack.submissionsatu.ui.detail.DetailActivity

class MoviesFragment : Fragment(), ContentCallback {

    private lateinit var viewModel: MoviesViewModel
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
        viewModel = ViewModelProvider(this).get(MoviesViewModel::class.java)

        val listMovie =viewModel.getMoviesData()
        setRecycler(listMovie)
    }

    private fun setRecycler(data: List<DataEntitas>) {
        binding?.rvMovie?.apply {
            layoutManager = GridLayoutManager(context, 2)
            adapter = ContentAdapter(this@MoviesFragment)
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
                .putExtra(DetailActivity.EXTRA_TYPE, TYPE_MOVIE)
        )
    }

}