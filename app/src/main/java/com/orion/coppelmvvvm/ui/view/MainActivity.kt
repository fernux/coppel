package com.orion.coppelmvvvm.ui.view

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.orion.coppelmvvvm.R
import com.orion.coppelmvvvm.databinding.ActivityMainBinding

import com.orion.coppelmvvvm.domain.model.Hero
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var navController: NavController
    private lateinit var binding: ActivityMainBinding
   /* protected lateinit var connectionLiveData: ConnectionLiveData
    private lateinit var heroList: MutableList<Hero>
    private val heroViewModel:HeroViewModel by viewModels()*/


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //connectionLiveData = ConnectionLiveData(this)


        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



       /* val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainerView2) as NavHostFragment
        val navController = navHostFragment.navController
 val appBarConfiguration = AppBarConfiguration(navController.graph)
*/

        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.fragmentContainerView2) as NavHostFragment
        // Instantiate the navController using the NavHostFragment
        navController = navHostFragment.navController
        // Make sure actions in the ActionBar get propagated to the NavController
           NavigationUI.setupWithNavController(binding.toolbar,navController)
        //setupActionBarWithNavController(navController)








      /*  heroViewModel.isNetworkAvailable.value = isConnected

        heroViewModel.onCreate()

        heroViewModel.heroModelLst.observe( this, Observer { currentHero ->
            heroList = currentHero
            initRecyclerView()
           // binding.tvName.text = currentHero.name
           // binding.tvUrl.text = currentHero.url
        })


        heroViewModel.isLoading.observe(this, Observer {
            binding.progress.isVisible = it
        })
 */
        //binding.viewContainer.setOnClickListener { heroViewModel.randomHero() }
    }
    fun initRecyclerView(){

        /*binding.rvHero.layoutManager = GridLayoutManager(this,2)
        binding.rvHero.adapter =
            HeroAdapter(heroList){
                onItemSelected(
                    it
                )
            }*/
    }
    fun onItemSelected(hero:Hero){
        Toast.makeText(this,hero.name, Toast.LENGTH_SHORT).show()
    }
}


