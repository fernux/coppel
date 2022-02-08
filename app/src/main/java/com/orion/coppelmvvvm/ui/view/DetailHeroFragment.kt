package com.orion.coppelmvvvm.ui.view

import android.os.Bundle
import android.view.*
import android.widget.ProgressBar
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.orion.coppelmvvvm.R
import com.orion.coppelmvvvm.databinding.FragmentDetailHeroBinding
import com.orion.coppelmvvvm.domain.model.DetailHero
import com.orion.coppelmvvvm.ui.isConnected
import com.orion.coppelmvvvm.ui.viewmodel.DetailHeroViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.*

@ExperimentalCoroutinesApi
@AndroidEntryPoint
class DetailHeroFragment :Fragment(R.layout.fragment_detail_hero) {
    private var _binding: FragmentDetailHeroBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private val args by navArgs<DetailHeroFragmentArgs>()
    private val detailHeroViewModel: DetailHeroViewModel by viewModels()
    private lateinit var detailHero: DetailHero
    //private lateinit var binding: FragmentDetailHeroBinding
    private  var intIntelligence: Int =0
    private  var intStrength: Int =0
    private  var intSpeed: Int =0
    private  var intDurability: Int =0
    private  var intPower: Int =0
    private  var intCombat: Int =0
    private  var band: Boolean = false
    private val scope = MainScope()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(false)

    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //binding = FragmentDetailHeroBinding.bind(view)
        detailHeroViewModel.isNetworkAvailable.value =
            this.requireActivity().isConnected
       var idItem: Int = args.cuerrentHero!!.toInt()
        detailHeroViewModel.onCreate(idItem)
        detailHeroViewModel.detailHero.observe(viewLifecycleOwner, Observer { detail ->

            Glide.with(binding.image.context).load(detail.image.url).into(binding.image)
            //biography
            binding.tvSuperHeroName.text = detail.name
            binding.tvFullName.text = detail.biography.full_name
            binding.tvAliases.text = detail.biography.aliases.toString()
            binding.tvPlaceOfBirth.text = detail.biography.place_of_birth
            binding.tvFirstAppearance.text = detail.biography.first_appearance
            binding.tvAlterEgos.text = detail.biography.alter_egos
            binding.tvPublisher.text = detail.biography.publisher
            binding.tvAlignment.text = detail.biography.alignment
            //Appearance
            binding.tvGender.text = detail.appearance.gender
            binding.tvEyeColor.text = detail.appearance.eye_color
            binding.tvHeight.text = detail.appearance.height.toString()
            binding.tvRace.text = detail.appearance.race
            binding.tvHairColor.text = detail.appearance.hair_color
            //Work
            binding.tvOccupation.text = detail.work.occupation
            binding.tvBase.text = detail.work.base
            //Connections
            binding.tvAffiliation.text = detail.connections.group_affiliation
            binding.tvRelatives.text = detail.connections.relatives


            //ProgressBar
            intIntelligence = if (detail.powerstats.intelligence.toIntOrNull() == null) 0 else detail.powerstats.intelligence.toInt()
            intDurability = if(detail.powerstats.durability.toIntOrNull() == null) 0  else detail.powerstats.durability.toInt()
            intCombat = if(detail.powerstats.combat.toIntOrNull() == null) 0  else detail.powerstats.combat.toInt()
            intSpeed = if(detail.powerstats.speed.toIntOrNull() == null) 0  else detail.powerstats.speed.toInt()
            intStrength = if(detail.powerstats.strength.toIntOrNull() == null) 0  else detail.powerstats.strength.toInt()
            intPower = if(detail.powerstats.power.toIntOrNull() == null) 0  else detail.powerstats.power.toInt()
            band = true

        })


        scope.launch {

            while (true){
                delay(300)
                if (band){
                    progress(binding.pbIntelligence,intIntelligence)
                    progress(binding.pbDurability,intDurability)
                    progress(binding.pbCombat,intCombat)
                    progress(binding.pbSpeed,intSpeed)
                    progress(binding.pbStrength,intStrength)
                    progress(binding.pbPower,intPower)

                    break
                }
            }
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Retrieve and inflate the layout for this fragment
        _binding = FragmentDetailHeroBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }


    private suspend fun progress(progressBar: ProgressBar,max:Int) {

        while (progressBar.progress < max) {
            delay(5)
            progressBar.incrementProgressBy(5 )
        }
        progressBar.progress = max

    }
    override fun onDestroy() {
        super.onDestroy()
        scope.cancel()
        _binding = null
    }




}