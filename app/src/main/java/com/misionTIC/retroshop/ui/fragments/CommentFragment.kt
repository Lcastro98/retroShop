package com.misionTIC.retroshop.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.misionTIC.retroshop.R
import com.misionTIC.retroshop.databinding.FragmentCommentBinding
import com.misionTIC.retroshop.ui.adapters.CommentAdapter
import com.misionTIC.retroshop.ui.viewmodels.CommentViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel


/**
 * A simple [Fragment] subclass.
 * Use the [CommentFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CommentFragment : Fragment() {

    private var _binding: FragmentCommentBinding? = null
    private val binding get() = _binding!!
    private val commentViewModel: CommentViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentCommentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        commentViewModel.loadComments()
        commentAdapter = CommentAdapter(
            listOf()
        )
        commentManager = LinearLayoutManager(requireContext())
        binding.commentRecycler.apply{
            adapter = commentAdapter
            layoutManager = commentManager
        }
        observeViewModels()
    }

    private fun observeViewModels(){
        commentViewModel.comments.observe(viewLifecycleOwner, Observer{ comments ->
            commentAdapter.newDataSet(comments)
        })
    }
}