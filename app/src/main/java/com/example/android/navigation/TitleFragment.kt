package com.example.android.navigation

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.android.navigation.databinding.FragmentTitleBinding


class TitleFragment : Fragment() {

    private lateinit var binding: FragmentTitleBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_title, container, false)
        binding.playButton.setOnClickListener { view : View ->
            //view.findNavController().navigate(R.id.action_titleFragment_to_gameFragment)
            view.findNavController().navigate(TitleFragmentDirections.actionTitleFragmentToGameFragment())
        }
        (activity as AppCompatActivity).supportActionBar?.title = getString(R.string.app_name)
        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        // Menambahkan menu
        inflater.inflate(R.menu.menu_options, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return super.onOptionsItemSelected(item)
                || NavigationUI.onNavDestinationSelected(item, requireView().findNavController())
    }
}