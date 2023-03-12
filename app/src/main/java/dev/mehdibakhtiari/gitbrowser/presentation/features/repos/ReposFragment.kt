package dev.mehdibakhtiari.gitbrowser.presentation.features.repos

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import dagger.hilt.android.AndroidEntryPoint
import dev.mehdibakhtiari.gitbrowser.data.models.ReposItem
import dev.mehdibakhtiari.gitbrowser.databinding.FragmentReposBinding
import kotlinx.coroutines.launch

@AndroidEntryPoint
class ReposFragment : Fragment() {

    private val viewModel: ReposViewModel by viewModels()
    private var _binding: FragmentReposBinding? = null
    private val binding get() = _binding!!
    lateinit var reposAdapter : ReposAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentReposBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeToNewsList()
        reposAdapter = ReposAdapter {
            onFavoriteClick(it)
        }
        binding.recyclerRepo.apply {
            adapter = reposAdapter
        }
    }

    private fun observeToNewsList() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.reposLiveData.observe(viewLifecycleOwner) { result ->
                result?.let {
                    reposAdapter.submitList(result)
                }
            }
        }
    }

    private fun onFavoriteClick(reposItem: ReposItem) {
        viewModel.onFavoriteClick(reposItem)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}