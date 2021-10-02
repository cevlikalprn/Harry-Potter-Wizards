package com.cevlikalprn.harrypotterwizards.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.cevlikalprn.harrypotterwizards.R
import com.cevlikalprn.harrypotterwizards.adapter.WizardAdapter
import com.cevlikalprn.harrypotterwizards.databinding.FragmentWizardListBinding
import com.cevlikalprn.harrypotterwizards.di.MyApplication
import com.cevlikalprn.harrypotterwizards.model.Wizard
import com.cevlikalprn.harrypotterwizards.util.NetworkResult
import com.squareup.picasso.Picasso

class WizardListFragment : Fragment() {

    private lateinit var binding: FragmentWizardListBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_wizard_list, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val appContainer = (requireActivity().applicationContext as MyApplication).appContainer

        val viewModel =
            ViewModelProvider(
                this,
                appContainer.wizardListViewModelFactory
            ).get(WizardListViewModel::class.java)

        //adapter
        val adapter = WizardAdapter { wizard ->
            navigateToDetailsFragment(wizard)
        }
        binding.wizardListRecyclerView.adapter = adapter

        //wizards
        viewModel.wizards.observe(viewLifecycleOwner) { wizards ->
            when (wizards) {
                is NetworkResult.Success -> adapter.data = wizards.data!!
                is NetworkResult.Error -> {
                    binding.apply {
                        networkStateImage.setImageResource(R.drawable.ic_mood_bad)
                        errorMessageTextView.text = wizards.errorMessage
                        networkStateImage.visibility = View.VISIBLE
                        errorMessageTextView.visibility = View.VISIBLE
                    }
                }
                is NetworkResult.Loading -> {
                    binding.networkStateImage.setImageResource(R.drawable.loading_image)
                }
            }
        }
    }

    private fun navigateToDetailsFragment(wizard: Wizard) {
        findNavController().navigate(
            WizardListFragmentDirections.actionWizardsFragmentToWizardDetailsFragment(wizard)
        )
    }

}