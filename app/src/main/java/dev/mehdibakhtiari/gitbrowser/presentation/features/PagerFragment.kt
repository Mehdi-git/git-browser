package dev.mehdibakhtiari.gitbrowser.presentation.features

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayoutMediator
import dev.mehdibakhtiari.gitbrowser.R
import dev.mehdibakhtiari.gitbrowser.databinding.FragmentPagerBinding
import dev.mehdibakhtiari.gitbrowser.utils.DepthPageTransformer


class PagerFragment : Fragment() {

    private var _binding: FragmentPagerBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPagerBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val viewPager = binding.viewPager.apply {
            adapter = PageAdapter(childFragmentManager, viewLifecycleOwner.lifecycle)
            setPageTransformer(DepthPageTransformer())
        }

        val tabLayout = binding.tabLayout
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = when (position) {
                0 -> getString(R.string.profile)
                else -> getString(R.string.repos)
            }
        }.attach()
    }
}

