package com.cevlikalprn.harrypotterwizards.presentation.ui.favoritescreen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.cevlikalprn.harrypotterwizards.presentation.adapter.AdapterClickListener
import com.cevlikalprn.harrypotterwizards.presentation.adapter.FavoriteWizardsAdapter
import com.cevlikalprn.harrypotterwizards.data.database.WizardEntity
import com.cevlikalprn.harrypotterwizards.databinding.FragmentFavoriteWizardsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FavoriteWizardsFragment : Fragment(), AdapterClickListener {

    private var _binding: FragmentFavoriteWizardsBinding? = null
    private val binding: FragmentFavoriteWizardsBinding
        get() = _binding!!

    private val viewModel: FavoriteWizardsViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFavoriteWizardsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        //adapter
        val adapter = FavoriteWizardsAdapter(this)

        binding.favoriteWizardsRecyclerView.adapter = adapter

        viewModel.favoriteWizards.observe(viewLifecycleOwner) { favoriteWizards ->
            adapter.favoriteWizards = favoriteWizards
        }
    }

    private fun navigateToDetailsFragment(wizard: WizardEntity) {
        findNavController().navigate(
            FavoriteWizardsFragmentDirections.actionFavoriteWizardsFragmentToWizardDetailsFragment(
                wizard
            )
        )
    }

    override fun updateWizard(wizard: WizardEntity) {
        viewModel.updateWizard(wizard)
    }

    override fun onItemClicked(wizard: WizardEntity) {
        navigateToDetailsFragment(wizard)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}