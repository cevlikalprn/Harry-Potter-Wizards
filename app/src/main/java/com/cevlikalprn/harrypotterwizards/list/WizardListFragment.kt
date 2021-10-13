package com.cevlikalprn.harrypotterwizards.list

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.cevlikalprn.harrypotterwizards.R
import com.cevlikalprn.harrypotterwizards.adapter.AdapterClickListener
import com.cevlikalprn.harrypotterwizards.adapter.WizardListAdapter
import com.cevlikalprn.harrypotterwizards.data.database.WizardEntity
import com.cevlikalprn.harrypotterwizards.databinding.FragmentWizardListBinding
import com.cevlikalprn.harrypotterwizards.di.HarryPotterWizardsApplication

class WizardListFragment : Fragment(), AdapterClickListener {

    private lateinit var binding: FragmentWizardListBinding
    private lateinit var viewModel: WizardListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentWizardListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val appContainer =
            (requireActivity().applicationContext as HarryPotterWizardsApplication).appContainer

        viewModel =
            ViewModelProvider(
                this,
                appContainer.wizardListViewModelFactory
            ).get(WizardListViewModel::class.java)

        //adapter
        val adapter = WizardListAdapter(this)

        binding.wizardListRecyclerView.adapter = adapter

        viewModel.wizards.observe(viewLifecycleOwner) { wizards ->
            adapter.wizards = wizards
        }

    }

    private fun navigateToDetailsFragment(wizard: WizardEntity) {
        findNavController().navigate(
            WizardListFragmentDirections.actionWizardsFragmentToWizardDetailsFragment(wizard)
        )
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.favorites_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.favorite_menu_item -> {
                findNavController().navigate(WizardListFragmentDirections.actionWizardsFragmentToFavoriteWizardsFragment())
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun updateWizard(wizard: WizardEntity) {
        viewModel.updateWizard(wizard)
    }

    override fun onItemClicked(wizard: WizardEntity) {
        navigateToDetailsFragment(wizard)
    }
}