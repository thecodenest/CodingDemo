package com.test.appchallenge.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.test.appchallenge.databinding.HomeFragmentBinding
import com.test.appchallenge.utils.GridItemDecoration
import com.test.appchallenge.ui.home.adapter.GiphyRecyclerAdapter
import com.test.appchallenge.ui.home.viewmodel.HomeViewModel

class HomeFragment : Fragment() {

    private val viewModel: HomeViewModel by activityViewModels()
    private var _binding: HomeFragmentBinding? = null
    private val gifAdapter = GiphyRecyclerAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = HomeFragmentBinding.inflate(inflater, container, false)


        _binding?.gifRecyclerview?.apply {
            layoutManager = GridLayoutManager(context, 5)
            addItemDecoration(GridItemDecoration(10, 2))
            adapter = gifAdapter
        }

        viewModel.repos.observe(viewLifecycleOwner, {
            gifAdapter.submitList(it)
        })
        return _binding!!.root
    }
}