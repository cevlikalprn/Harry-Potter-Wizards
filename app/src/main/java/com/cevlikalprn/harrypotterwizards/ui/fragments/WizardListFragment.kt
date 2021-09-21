package com.cevlikalprn.harrypotterwizards.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.cevlikalprn.harrypotterwizards.R
import com.cevlikalprn.harrypotterwizards.adapter.WizardAdapter
import com.cevlikalprn.harrypotterwizards.databinding.FragmentWizardsBinding
import com.cevlikalprn.harrypotterwizards.network.HarryPotterApi
import com.cevlikalprn.harrypotterwizards.repository.WizardRepository
import com.cevlikalprn.harrypotterwizards.viewmodel.WizardListViewModel
import com.cevlikalprn.harrypotterwizards.viewmodel.WizardListViewModelFactory

class WizardListFragment : Fragment() {

    private lateinit var binding: FragmentWizardsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_wizards, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val repository = WizardRepository()
        val viewModelFactory = WizardListViewModelFactory(repository)
        val viewModel =
            ViewModelProvider(this, viewModelFactory).get(WizardListViewModel::class.java)

        val adapter = WizardAdapter()
        binding.wizardListRecyclerView.adapter = adapter

        viewModel.wizards.observe(viewLifecycleOwner) { wizards ->
            adapter.data = wizards
        }


    }

}