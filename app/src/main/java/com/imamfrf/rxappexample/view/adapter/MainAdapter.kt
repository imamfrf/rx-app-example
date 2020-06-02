package com.imamfrf.rxappexample.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.imamfrf.domain.models.User
import com.imamfrf.rxappexample.R
import javax.inject.Inject

class MainAdapter @Inject constructor(): RecyclerView.Adapter<MainAdapter.ViewHolder>() {
    private lateinit var list: List<User>
    private lateinit var listener: MainListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_list_user, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = list[position]

        holder.textViewName.text = "${item.firstName} ${item.lastName}"
        holder.textViewEmail.text = item.email
        Glide.with(holder.itemView.context).load(item.avatar).into(holder.imageViewAvatar)

        holder.itemView.setOnClickListener {
            listener.onItemClicked(item)
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    fun setList(list: List<User>) {
        this.list = list
        notifyDataSetChanged()
    }

    fun setListener(listener: MainListener) {
        this.listener = listener
    }


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textViewName: TextView = itemView.findViewById(R.id.text_view_user_name)
        val textViewEmail: TextView = itemView.findViewById(R.id.text_view_user_email)
        val imageViewAvatar: ImageView = itemView.findViewById(R.id.image_view_avatar)
    }

    interface MainListener {
        fun onItemClicked(user: User)
    }

}

