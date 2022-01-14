package com.example.chat.ui.start_fragment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.chat.R
import com.example.chat.model.Message
import com.example.chat.model.Person

class PersonAdapter : RecyclerView.Adapter<PersonAdapter.PersonHolder>() {
    private var mPersonList = emptyList<Person>()

    var onItemClick: ((PersonId: Int) -> Unit)? = null


    inner class PersonHolder(view: View) : RecyclerView.ViewHolder(view) {
        val urlAvatarPerson: ImageView = view.findViewById(R.id.person_image)
        val fullName: TextView = view.findViewById(R.id.tv_full_name)

        init {
            view.setOnClickListener {
                onItemClick?.invoke(mPersonList[absoluteAdapterPosition].personId)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.person_item, parent, false)
        return PersonHolder(view)
    }

    override fun onBindViewHolder(holder: PersonHolder, position: Int) {
        val person = mPersonList[position]
        holder.fullName.text = person.personName



        Glide.with(holder.urlAvatarPerson.context)
            .load(mPersonList[position].urlPersonAvatar)
            .into(holder.urlAvatarPerson)

    }

    override fun getItemCount(): Int = mPersonList.size

    fun setList(list: List<Person>) {
        mPersonList = list
        notifyDataSetChanged()

    }

}
