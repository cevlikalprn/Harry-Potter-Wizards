package com.cevlikalprn.harrypotterwizards.favorite

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.cevlikalprn.harrypotterwizards.R
import com.cevlikalprn.harrypotterwizards.databinding.FragmentFavoriteWizardsBinding
import com.cevlikalprn.harrypotterwizards.di.MyApplication

class FavoriteWizardsFragment : Fragment() {

    private lateinit var binding: FragmentFavoriteWizardsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_favorite_wizards, container, false)
        return inflater.inflate(R.layout.fragment_favorite_wizards, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val appContainer = (requireActivity().application as MyApplication).appContainer

        val viewModel = ViewModelProvider(this, appContainer.favoriteWizardsViewModel).get(
            FavoriteWizardsViewModel::class.java
        )

        viewModel.favoriteWizards.observe(viewLifecycleOwner) { favoriteWizards ->
            favoriteWizards.forEach {
                Log.i("FavoriteWizardsFragment", it.name)
            }
        }
    }
}