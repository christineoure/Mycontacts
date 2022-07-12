package dev.oure.mycontacts


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import dev.oure.mycontacts.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        displayNames()
    }

    fun displayNames(){
        var contact1 = Contact("Misky", "0700123456", "kmisky@gmail.com" , "457Ksm", "https://images.pexels.com/photos/871495/pexels-photo-871495.jpeg?auto=compress&cs=tinysrgb&w=600")
        var contact2 = Contact("Misky", "0700123456", "kmisky@gmail.com" , "457Ksm", "https://images.pexels.com/photos/794062/pexels-photo-794062.jpeg?auto=compress&cs=tinysrgb&w=600")
        var contact3 = Contact("Misky", "0700123456", "kmisky@gmail.com" , "457Ksm", "https://images.pexels.com/photos/1667849/pexels-photo-1667849.jpeg?auto=compress&cs=tinysrgb&w=600")
        var contact4 = Contact("Misky", "0700123456", "kmisky@gmail.com" , "457Ksm","https://images.pexels.com/photos/3031396/pexels-photo-3031396.jpeg?auto=compress&cs=tinysrgb&w=600")
        var contact5 = Contact("Misky", "0700123456", "kmisky@gmail.com" , "457Ksm", "https://images.pexels.com/photos/965324/pexels-photo-965324.jpeg?auto=compress&cs=tinysrgb&w=600")
        var contactList= listOf(contact1,contact2,contact3,contact4,contact5)
        var namesAdapter = ContactRvAdapter(contactList)


        binding.rvContacts.layoutManager = LinearLayoutManager(this)
        binding.rvContacts.adapter = namesAdapter
    }
}