package com.abschlussapp.majateichmann.luckyvstreamerlist.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.abschlussapp.majateichmann.luckyvstreamerlist.R
import com.abschlussapp.majateichmann.luckyvstreamerlist.data.AppRepository
import com.abschlussapp.majateichmann.luckyvstreamerlist.data.datamodels.Streamer
import com.abschlussapp.majateichmann.luckyvstreamerlist.data.datamodels.StreamerList
import com.abschlussapp.majateichmann.luckyvstreamerlist.data.remote.StreamerApi

/**
 * Diese Klasse organisiert mithilfe der ViewHolder Klasse das Recycling
 */
class LiveAdapter(
    private val dataset: List<Streamer>
) : RecyclerView.Adapter<LiveAdapter.ItemViewHolder>() {

    /**
     * der ViewHolder umfasst die View und stellt einen Listeneintrag dar
     */
    inner class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val ivStreamVorschau: ImageView = itemView.findViewById(R.id.iv_stream_vorschau)
        val tvStreamername: TextView = itemView.findViewById(R.id.tv_streamername)
        val tvCharname: TextView = itemView.findViewById(R.id.tv_charname)
    }


    /**
     * hier werden neue ViewHolder erstellt
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val itemLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item_live, parent, false)

        return ItemViewHolder(itemLayout)
    }

    /**
     * damit der LayoutManager weiß, wie lang die Liste ist
     */
    override fun getItemCount(): Int {
        return dataset.size
    }

    /**
     * hier findet der Recyclingprozess statt
     * die vom ViewHolder bereitgestellten Parameter erhalten die Information des Listeneintrags
     */
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {

        //streamer aus dem dataset holen
        var streamer = dataset[position]

        if (streamer.live) {
            holder.ivStreamVorschau.setImageResource(streamer.logo_url.toInt())
            holder.tvStreamername.text = streamer.name
            holder.tvCharname.text = streamer.ic_name
        }
    }
}