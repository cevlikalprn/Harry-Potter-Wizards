package com.cevlikalprn.harrypotterwizards.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.navArgs
import com.cevlikalprn.harrypotterwizards.R
import com.cevlikalprn.harrypotterwizards.databinding.FragmentWizardDetailsBinding
import com.cevlikalprn.harrypotterwizards.models.WizardItem
import com.squareup.picasso.Picasso

class WizardDetailsFragment : Fragment() {

    private lateinit var binding: FragmentWizardDetailsBinding
    private val args: WizardDetailsFragmentArgs by navArgs()


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

        val wizard = args.wizard
        if (wizard != null) {
            showWizardInformation(wizard)
        }

    }


    private fun showWizardInformation(wizard: WizardItem) {
        binding.apply {
            nameTextView.text = wizard.name
            aliveTextView.text = if (wizard.alive) "Yes" else "No"
            ancestryTextView.text = wizard.ancestry
            houseNameTextView.text = wizard.house
            speciesTextView.text = wizard.species
            Picasso.get().load(wizard.image).into(characterImageView)
        }
    }

}