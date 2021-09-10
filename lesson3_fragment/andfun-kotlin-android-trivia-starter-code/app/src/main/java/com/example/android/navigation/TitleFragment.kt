package com.example.android.navigation

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
//import com.example.android.navigation.databinding.FragmentTitle2Binding
import com.example.android.navigation.databinding.FragmentTitleBinding

class TitleFragment : Fragment() {



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       /*  choose which one fragment ex:  binding: FragmentTitle2Binding -> this for fragmenttitle2
       *  choose R.layout of fragment title 2
       * for example :
       *  val binding: FragmentTitle2Binding =
                DataBindingUtil.inflate(
                    inflater,
                    R.layout.fragment_title2,
                    container,
                    false
                )
       * */
            val binding: FragmentTitleBinding =
                DataBindingUtil.inflate(
                    inflater,
                    R.layout.fragment_title,
                    container,
                    false
                )
        binding.playButton.setOnClickListener( /// this better or!
            Navigation.createNavigateOnClickListener(R.id.action_titleFragment_to_gameFragment)
        )/*{ ---> use this but without between (...)
       use this one:     view:View -> view.findNavController().navigate(R.id.action_titleFragment_to_gameFragment)
       or use this :   view:View -> view.findNavController().navigate(TitleFragmentDirections.actionTitleFragmentToGameFragment())
        }*/
        setHasOptionsMenu(true)
        return binding.root
                }



    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.overflow_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item, requireView().findNavController())
                || super.onOptionsItemSelected(item)
    }

}