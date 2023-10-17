package com.noma.livestockcare.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.noma.livestockcare.R
import com.noma.livestockcare.model.User

//class ActivityAdapter(var data:ArrayList<Response>):RecyclerView.Adapter<ActivityAdapter.ActivityViewHolder>() {
class ActivityAdapter():RecyclerView.Adapter<ActivityAdapter.ActivityViewHolder>() {

    private var users: List<User> = emptyList()

    fun setUsers(newUsers: ArrayList<User>){
        users = newUsers
        notifyDataSetChanged()
    }

    class ActivityViewHolder(itemView:View):ViewHolder(itemView){
        val worker_name = itemView.findViewById<TextView>(R.id.product_name)
        val worker_role = itemView.findViewById<TextView>(R.id.product_description)
        val worker_image = itemView.findViewById<ImageView>(R.id.product_image)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActivityViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.worker_item, null,false)
        return ActivityViewHolder(view)
    }

    override fun getItemCount(): Int {
        return  users.size
    }

    override fun onBindViewHolder(holder: ActivityViewHolder, position: Int) {
        val user = users[position]
        holder.worker_name.text = user.f_name + " " + user.l_name
        holder.worker_role.text = user.title
        holder.worker_image.setImageResource(R.drawable.avatar_2)
    }
}