package com.example.assignment_1firebase

import android.app.ProgressDialog
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_userlist.*

@Suppress("DEPRECATION")
class MainActivity : AppCompatActivity() {

    private val db = Firebase.firestore
    lateinit var recyclerbtn : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        saveButton.setOnClickListener {
            val name = nameEditText.text.toString()
            val number = numberEditText.text.toString()
            val address = addressEditText.text.toString()


            val person = hashMapOf(
                "name" to name,
                "number" to number,
                "address" to address
            )

            db.collection("Users")
                .add(person)
                .addOnSuccessListener { documentReference ->
                    Toast.makeText(applicationContext,"${documentReference.id}",Toast.LENGTH_SHORT).show()
                }
                .addOnFailureListener { e ->
                    Toast.makeText(applicationContext,"$e",Toast.LENGTH_SHORT).show()

                }


        }

        recyclerbtn = findViewById(R.id.btnGet)
        recyclerbtn.setOnClickListener {
            var i = Intent(this,Userlist::class.java)
            startActivity(i)
        }

    }

    }


