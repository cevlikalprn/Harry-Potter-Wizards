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
import com.cevlikalprn.harrypotterwizards.data.database.WizardEntity
import com.cevlikalprn.harrypotterwizards.databinding.FragmentWizardListBinding
import com.cevlikalprn.harrypotterwizards.di.MyApplication

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

        viewModel.wizards.observe(viewLifecycleOwner) { wizards ->
            adapter.data = wizards
        }

    }

    private fun navigateToDetailsFragment(wizard: WizardEntity) {
        findNavController().navigate(
            WizardListFragmentDirections.actionWizardsFragmentToWizardDetailsFragment(wizard)
        )
    }

}