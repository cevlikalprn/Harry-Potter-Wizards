package com.cevlikalprn.harrypotterwizards.favorite

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.cevlikalprn.harrypotterwizards.R
import com.cevlikalprn.harrypotterwizards.adapter.FavoriteWizardsAdapter
import com.cevlikalprn.harrypotterwizards.databinding.FragmentFavoriteWizardsBinding
import com.cevlikalprn.harrypotterwizards.di.HarryPotterWizardsApplication

class FavoriteWizardsFragment : Fragment() {

    private lateinit var binding: FragmentFavoriteWizardsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_favorite_wizards, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val appContainer = (requireActivity().application as HarryPotterWizardsApplication).appContainer

        val viewModel = ViewModelProvider(this, appContainer.favoriteWizardsViewModel).get(
            FavoriteWizardsViewModel::class.java
        )

        //adapter
        val adapter = FavoriteWizardsAdapter(updateWizard = {viewModel.updateWizard(it)})
        binding.favoriteWizardsRecyclerView.adapter = adapter

        viewModel.favoriteWizards.observe(viewLifecycleOwner) { favoriteWizards ->
            adapter.favoriteWizards = favoriteWizards
        }
    }
}