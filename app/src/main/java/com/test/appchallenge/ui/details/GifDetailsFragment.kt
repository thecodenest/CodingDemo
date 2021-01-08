package com.test.appchallenge.ui.details

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.test.appchallenge.databinding.GifDetailsFragmentBinding

class GifDetailsFragment : Fragment() {

    private lateinit var viewModel: GifDetailsViewModel
    private var gifUrl:String? = null
    private var gifTitle:String? = null
    private var _binding: GifDetailsFragmentBinding? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = GifDetailsFragmentBinding.inflate(inflater, container, false)

        Glide.with(requireContext()).load(gifUrl).into(_binding!!.gif)
        _binding?.title?.text = gifTitle

        return _binding?.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            gifUrl = it.getString("gifUrl")
            gifTitle = it.getString("gifTitle")
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(GifDetailsViewModel::class.java)
        // TODO: Use the ViewModel
    }

}