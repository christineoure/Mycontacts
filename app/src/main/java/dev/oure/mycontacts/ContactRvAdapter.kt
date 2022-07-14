package dev.oure.mycontacts

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import dev.oure.mycontacts.databinding.ContactsItemListBinding
import org.w3c.dom.Text

class ContactRvAdapter(var contactList: List<Contact>): RecyclerView.Adapter<ContactViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        var binding = ContactsItemListBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return ContactViewHolder(binding)
//        var itemView = LayoutInflater.from(parent.context).inflate(R.layout.contacts_item_list, parent, false)
//        return ContactViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        val context = holder.itemView.context
        var  currentContact = contactList.get(position)
       with(holder.binding){

        tvName.text = currentContact.name
        tvPhoneNumber.text = currentContact.phone
        tvEmail.text = currentContact.email
        tvAddress.text = currentContact.address
           Picasso.get()
               .load(currentContact.image)
               .error(R.drawable.ic_baseline_error_outline_24)
               .resize(300, 300)
               .centerCrop()
               .placeholder(R.drawable.ic_baseline_person_24)
               .into(imgContacts)

           cvContacts.setOnClickListener {

               val intent = Intent(context, ViewContactActivity::class.java)
               intent.putExtra("NAME", currentContact.name)
               intent.putExtra("PHONE_NUMBER", currentContact.phone)
               intent.putExtra("EMAIL", currentContact.email)
               intent.putExtra("ADDRESS", currentContact.address)
               intent.putExtra("IMAGE", currentContact.image)

               context.startActivity(intent)
           }

           holder.binding.imgContacts.setOnClickListener {
               Toast
                   .makeText(context,"You have clicked on my face", Toast.LENGTH_LONG)
                   .show()
           }
    }

    }

    override fun getItemCount(): Int {
        return contactList.size
    }
}

class ContactViewHolder(var binding: ContactsItemListBinding): RecyclerView.ViewHolder(binding.root){

}