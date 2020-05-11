package com.indra.negaraasean

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class ListNegaraAdapter(private val listNegara: ArrayList<Negara>) : RecyclerView.Adapter<ListNegaraAdapter.ListViewHolder>(){

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_row_negara, viewGroup,false )
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listNegara.size
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name, ibukota, flag, lambang, identity, overview ) = listNegara[position]

        Glide.with(holder.itemView.context)
            .load(flag)
            .apply(RequestOptions())
            .into(holder.imgFlag)

        holder.tvName.text = name
        holder.tvIbuKota.text = ibukota

        val mContext = holder.itemView.context

        holder.itemView.setOnClickListener {
            val moveDetail = Intent(mContext, DetailActivity::class.java)
            moveDetail.putExtra(DetailActivity.EXTRA_NAME, name)
            moveDetail.putExtra(DetailActivity.EXTRA_FLAG, flag)
            moveDetail.putExtra(DetailActivity.EXTRA_LAMBANG, lambang)
            moveDetail.putExtra(DetailActivity.EXTRA_IDENTITY, identity)
            moveDetail.putExtra(DetailActivity.EXTRA_OVERVIEW, overview)
            mContext.startActivity(moveDetail)
        }
    }

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        var tvIbuKota: TextView = itemView.findViewById(R.id.tv_item_ibukota)
        var imgFlag: ImageView = itemView.findViewById(R.id.img_item_flag)
    }
}