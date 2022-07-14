package dev.oure.mycontacts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.squareup.picasso.NetworkPolicy
import com.squareup.picasso.Picasso
import dev.oure.mycontacts.databinding.ActivityViewContactBinding

class ViewContactActivity : AppCompatActivity() {
    lateinit var binding: ActivityViewContactBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityViewContactBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getExtras()
    }
    fun getExtras(){
        val extras = intent.extras
        var name = extras?.getString("NAME", "")
        var phone = extras?.getString("PHONE_NUMBER", "")
        var email = extras?.getString("EMAIL", "")
        var address = extras?.getString("ADDRESS", "")
        var image = extras?.getString("IMAGE", "")

        binding.tvName1.text = name
        binding.tvPhoneNo.text = phone
        binding.tvEmail2.text = email
        binding.tvAddress2.text= address

        Picasso.get()
            .load(intent.getStringExtra("IMAGE"))
            .networkPolicy(NetworkPolicy.OFFLINE)
            .into(binding.imgProfile)

        Toast
            .makeText(this, name, Toast.LENGTH_LONG)
            .show()
    }
}