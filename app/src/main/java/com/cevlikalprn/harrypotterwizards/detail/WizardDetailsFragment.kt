package com.cevlikalprn.harrypotterwizards.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.cevlikalprn.harrypotterwizards.R
import com.cevlikalprn.harrypotterwizards.data.database.WizardEntity
import com.cevlikalprn.harrypotterwizards.databinding.FragmentWizardDetailsBinding
import com.cevlikalprn.harrypotterwizards.di.HarryPotterWizardsApplication

class WizardDetailsFragment : Fragment() {

    private lateinit var binding: FragmentWizardDetailsBinding
    private val args: WizardDetailsFragmentArgs by navArgs()
    private lateinit var viewModel: WizardDetailsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_wizard_details, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val appContainer =
            (requireActivity().application as HarryPotterWizardsApplication).appContainer

        viewModel = ViewModelProvider(this, appContainer.wizardDetailsViewModelFactory).get(
            WizardDetailsViewModel::class.java
        )

        val wizard = args.wizard
        if (wizard != null) {
            viewModel.wizard.value = wizard
            setWizardCurrentFavoriteStatus(wizard.isFavorite)
            binding.favoriteImageView.setOnClickListener {
                setWizardFavoriteStatus(wizard)
            }
        }

        //binding
        binding.lifecycleOwner = this
        binding.viewmodel = viewModel

    }

    private fun setWizardCurrentFavoriteStatus(isFavorite: Boolean) {
        val icon = if (isFavorite) R.drawable.star else R.drawable.empty_star
        binding.favoriteImageView.setImageResource(icon)
    }

    private fun setWizardFavoriteStatus(wizard: WizardEntity) {
        if (wizard.isFavorite) {
            binding.favoriteImageView.setImageResource(R.drawable.empty_star)
            wizard.isFavorite = false
            updateWizard(wizard)
        } else {
            binding.favoriteImageView.setImageResource(R.drawable.star)
            wizard.isFavorite = true
            updateWizard(wizard)
        }
    }

    private fun updateWizard(wizard: WizardEntity) {
        viewModel.updateWizard(wizard)
    }
}