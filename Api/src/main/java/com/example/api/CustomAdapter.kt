package com.example.api

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.ObservableArrayList
import androidx.databinding.ObservableList
import androidx.databinding.ObservableList.OnListChangedCallback
import androidx.recyclerview.widget.RecyclerView

abstract class CustomAdapter<T>(protected val data: ObservableArrayList<T>) : RecyclerView.Adapter<CustomAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(layout, parent, false)
        return ViewHolder(view)
    }

    protected abstract val layout: Int

    abstract override fun onBindViewHolder(holder: ViewHolder, position: Int)

    override fun getItemCount(): Int {
        return data.size
    }

    class ViewHolder(val view: View) : RecyclerView.ViewHolder(view)

    init {
        data.addOnListChangedCallback(object : OnListChangedCallback<ObservableList<T>?>() {
            override fun onChanged(sender: ObservableList<T>?) {
                notifyDataSetChanged()
            }

            override fun onItemRangeChanged(sender: ObservableList<T>?, positionStart: Int, itemCount: Int) {
                notifyItemRangeChanged(positionStart, itemCount)
            }

            override fun onItemRangeInserted(sender: ObservableList<T>?, positionStart: Int, itemCount: Int) {
                notifyItemRangeInserted(positionStart, itemCount)
            }

            override fun onItemRangeMoved(sender: ObservableList<T>?, fromPosition: Int, toPosition: Int, itemCount: Int) {
                notifyItemMoved(fromPosition, toPosition)
            }

            override fun onItemRangeRemoved(sender: ObservableList<T>?, positionStart: Int, itemCount: Int) {
                notifyItemRangeRemoved(positionStart, itemCount)
            }
        })
    }
}

// AN EXAMPLE OF HOW TO USE!
//class ContactsAdapter(data: ObservableArrayList<Contact>, private val listener: ContactClickedListener) : CustomAdapter<Contact?>(data) {
//    override val layout
//        get() = R.layout.contact_list_item
//
//    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//        val contact = data[position]
//        val nameDisplay = holder.view.findViewById<TextView>(R.id.nameDisplay)
//        val phoneNumberDisplay = holder.view.findViewById<TextView>(R.id.phoneNumberDisplay)
//        nameDisplay.setText(contact.name)
//        phoneNumberDisplay.setText(contact.phoneNumber);
//        val button = holder.view.findViewById<Button>(R.id.call)
//        button.setOnClickListener { listener.onClick(contact) }
//    }
//}
