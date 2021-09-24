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
import com.cevlikalprn.harrypotterwizards.databinding.FragmentWizardListBinding
import com.cevlikalprn.harrypotterwizards.repository.WizardRepository
import com.cevlikalprn.harrypotterwizards.viewmodel.WizardListViewModel
import com.cevlikalprn.harrypotterwizards.viewmodel.WizardListViewModelFactory

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

        //dependencies
        val repository = WizardRepository()
        val viewModelFactory = WizardListViewModelFactory(repository)
        val viewModel =
            ViewModelProvider(this, viewModelFactory).get(WizardListViewModel::class.java)


        //adapter
        val adapter = WizardAdapter()
        binding.wizardListRecyclerView.adapter = adapter

        //wizards
        viewModel.wizards.observe(viewLifecycleOwner) { wizards ->
            adapter.data = wizards
        }

        //error message
        viewModel.errorMessage.observe(viewLifecycleOwner){ errorMessage ->
            if (errorMessage.isNotEmpty()){
                binding.apply {
                    errorMessageTextView.text = errorMessage
                    moodBadImage.visibility = View.VISIBLE
                    errorMessageTextView.visibility = View.VISIBLE
                }
            }
        }

    }

}