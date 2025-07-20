package com.example.teste.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.teste.databinding.FragmentPostsBinding
import com.example.teste.ui.adapter.PostsAdapter
import com.example.teste.viewmodels.PostViewModel

class PostsFragment : Fragment() {

    private var _binding: FragmentPostsBinding? = null

    private val binding get() = _binding!!

    private val viewModel: PostViewModel by viewModels()

    private val adapter: PostsAdapter = PostsAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPostsBinding.inflate(inflater, container, false)

        binding.recyclerPosts.layoutManager = LinearLayoutManager(context)
        binding.recyclerPosts.adapter = adapter
        observe()
        viewModel.list()

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun observe() {
        viewModel.posts.observe(viewLifecycleOwner) {
            adapter.updatePosts(it)
        }

        viewModel.validation.observe(viewLifecycleOwner) {
            if (it.message.isNotEmpty()) {
                Toast.makeText(requireContext(), it.message, Toast.LENGTH_SHORT).show()
            }
        }


        viewModel.loading.observe(viewLifecycleOwner) { isLoading ->
            binding.progressBar.visibility = if (isLoading) View.VISIBLE else View.GONE
        }

    }

}