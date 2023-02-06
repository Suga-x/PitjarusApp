package com.example.pitjarusapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class DataAdapter(private val loginResponse1: ArrayList<LoginResponseList>) : RecyclerView.Adapter<DataAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var namaToko : TextView = itemView.findViewById(R.id.tvToko)
        var namaCluster : TextView = itemView.findViewById(R.id.tvCluster)
        var alamatToko : TextView = itemView.findViewById(R.id.tvAlamat)
        var jarakToko : TextView = itemView.findViewById(R.id.tvDistance)
//        fun bind(rvList: LoginResponse){
//            with(itemView){
//                val namaTokoinstance = rvList.store_name
//                val namaClusterinstance = rvList.area_id
//                val alamatTokoinstance = rvList.address
//                namaToko.text = namaTokoinstance
//                namaCluster.text = namaClusterinstance
//                alamatToko.text = alamatTokoinstance
////                val testAPI = rvList.body
////                namaToko.text = testAPI
//                Log.e("namaToko : ", namaTokoinstance.toString())
//                Log.e("status : ", rvList.status.toString())
//
//
//            }
//
//        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_rv_liststore, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       // holder.bind(dataList[position])
        val loginResponse = loginResponse1[position]
        holder.namaToko.text = loginResponse.store_name
        holder.namaCluster.text = loginResponse.dc_name
        holder.alamatToko.text = loginResponse.address
        holder.jarakToko.text = loginResponse.area_id
    }

    override fun getItemCount() = loginResponse1.size

}
