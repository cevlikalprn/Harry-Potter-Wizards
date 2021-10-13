package com.cevlikalprn.harrypotterwizards.favorite

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.cevlikalprn.harrypotterwizards.adapter.AdapterClickListener
import com.cevlikalprn.harrypotterwizards.adapter.FavoriteWizardsAdapter
import com.cevlikalprn.harrypotterwizards.data.database.WizardEntity
import com.cevlikalprn.harrypotterwizards.databinding.FragmentFavoriteWizardsBinding
import com.cevlikalprn.harrypotterwizards.di.HarryPotterWizardsApplication

class FavoriteWizardsFragment : Fragment(), AdapterClickListener {

    private lateinit var binding: FragmentFavoriteWizardsBinding
    private lateinit var viewModel: FavoriteWizardsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFavoriteWizardsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val appContainer =
            (requireActivity().application as HarryPotterWizardsApplication).appContainer

        viewModel = ViewModelProvider(this, appContainer.favoriteWizardsViewModel).get(
            FavoriteWizardsViewModel::class.java
        )

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

}