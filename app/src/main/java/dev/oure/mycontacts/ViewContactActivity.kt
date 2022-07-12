package dev.oure.mycontacts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class ViewContactActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_contact)
        getExtras()
    }
    fun getExtras(){
        val extras = intent.extras
        var name = extras?.getString("NAME", "")
        var phone = extras?.getString("PHONE_NUMBER", "")

        Toast
            .makeText(this, name, Toast.LENGTH_LONG)
            .show()
    }
}