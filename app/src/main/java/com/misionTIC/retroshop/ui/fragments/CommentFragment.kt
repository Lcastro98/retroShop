package com.misionTIC.retroshop.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.misionTIC.retroshop.R
import com.misionTIC.retroshop.databinding.FragmentCommentBinding
import com.misionTIC.retroshop.ui.adapters.Comment
import com.misionTIC.retroshop.ui.adapters.CommentAdapter


/**
 * A simple [Fragment] subclass.
 * Use the [CommentFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CommentFragment : Fragment() {

    private var _binding: FragmentCommentBinding? = null
    private val binding get() = _binding!!
    private lateinit var commentAdapter: CommentAdapter
    private lateinit var commentManager: LinearLayoutManager

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
        commentAdapter = CommentAdapter(
            listOf(
                Comment("1","buen producto", "Fulano", "https://st.depositphotos.com/2069323/2156/i/950/depositphotos_21568785-stock-photo-man-pointing.jpg", "2020-05-01"),
                Comment("2","buen producto", "Fulano", "https://st.depositphotos.com/2069323/2156/i/950/depositphotos_21568785-stock-photo-man-pointing.jpg", "2021-05-01")

            )
        )
        commentManager = LinearLayoutManager(requireContext())
        binding.commentRecycler.apply {
            adapter = commentAdapter
            layoutManager = commentManager
        }

    }
}