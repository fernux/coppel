package com.orion.coppelmvvvm.ui.view

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.orion.coppelmvvvm.R
import com.orion.coppelmvvvm.databinding.FragmentHeroesBinding
import com.orion.coppelmvvvm.domain.model.Hero
import com.orion.coppelmvvvm.ui.ConnectionLiveData
import com.orion.coppelmvvvm.ui.adapter.HeroAdapter
import com.orion.coppelmvvvm.ui.viewmodel.HeroViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class HeroesFragment :Fragment(R.layout.fragment_heroes){
    private var _binding: FragmentHeroesBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private val heroViewModel: HeroViewModel by viewModels()
    protected lateinit var connectionLiveData: ConnectionLiveData
    private lateinit var heroList: LiveData<MutableList<Hero>>
   // private lateinit var binding: FragmentHeroesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)

    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Retrieve and inflate the layout for this fragment
        _binding = FragmentHeroesBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
       connectionLiveData = ConnectionLiveData(this.requireContext())
        _binding = FragmentHeroesBinding.bind(view)


        val cm = view.context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetwork: NetworkInfo? = cm.activeNetworkInfo

        val isConnected: Boolean = activeNetwork?.isConnectedOrConnecting == true

        heroViewModel.isNetworkAvailable.value = isConnected
        heroViewModel.onCreate()
        heroViewModel.onAllCreate()


        heroViewModel.heroModelLst.observe( viewLifecycleOwner, Observer { currentHero ->
            //heroList = currentHero
            initRecyclerView()
        })
        heroViewModel.isLoading.observe(viewLifecycleOwner, Observer {
            binding.progress.isVisible = it
        })







    }
    fun initRecyclerView(){

        binding.rvSuperHero.layoutManager = GridLayoutManager(this.requireContext(),2)
        binding.rvSuperHero.adapter =
            HeroAdapter(heroViewModel.heroModelLst){
                onItemSelected(
                    it
                )
            }
    }




    fun onItemSelected(hero:Hero){
        val action = HeroesFragmentDirections.actionHeroesFragmentToDetailHeroFragment(hero.id)
        // Navigate using that action
        findNavController().navigate(action)

        //val intent = Intent(view?.context , MainActivity::class.java)
        //startActivity(intent)
    }
}