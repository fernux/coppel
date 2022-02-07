package com.orion.coppelmvvvm.ui.adapter

import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.accessibility.AccessibilityNodeInfo
import android.widget.Button
import androidx.annotation.RequiresApi
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.orion.coppelmvvvm.R
import com.orion.coppelmvvvm.domain.model.Hero


class HeroAdapter(private val HeroList: MutableLiveData<MutableList<Hero>>, private  val onClickListener:(Hero)-> Unit):RecyclerView.Adapter<HeroViewHolder>() {




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeroViewHolder {
        val layout = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_hero, parent, false)

        // Setup custom accessibility delegate to set the text read
        layout.accessibilityDelegate = Accessibility
        return HeroViewHolder(layout)
        //val layoutInflater = LayoutInflater.from(parent.context)
        //return HeroViewHolder(layoutInflater.inflate(R.layout.item_hero,parent,false))
    }

    override fun onBindViewHolder(holder: HeroViewHolder, position: Int) {
            val item = HeroList.value?.get(position)
        if (item != null) {
            holder.render(item, onClickListener)
        }

    }




    override fun getItemCount(): Int {
        if (HeroList.value!!.size   != null) {
            return  HeroList.value!!.size
        }
        return 0

    }

    // Setup custom accessibility delegate to set the text read with
    // an accessibility service
    companion object Accessibility : View.AccessibilityDelegate() {
        @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
        override fun onInitializeAccessibilityNodeInfo(
            host: View?,
            info: AccessibilityNodeInfo?
        ) {
            super.onInitializeAccessibilityNodeInfo(host, info)
            // With `null` as the second argument to [AccessibilityAction], the
            // accessibility service announces "double tap to activate".
            // If a custom string is provided,
            // it announces "double tap to <custom string>".
            val customString = host?.context?.getString(R.string.app_name)
            val customClick =
                AccessibilityNodeInfo.AccessibilityAction(
                    AccessibilityNodeInfo.ACTION_CLICK,
                    customString
                )
            info?.addAction(customClick)
        }
    }

}