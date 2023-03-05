package com.example.assignment_1firebase

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.auth.User
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.user_item.*


class Userlist : AppCompatActivity() {
    private lateinit var userRecyclerview : RecyclerView
    private lateinit var userList : ArrayList<User>
    private var db = Firebase.firestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_userlist)

        userRecyclerview = findViewById(R.id.userList)
        userRecyclerview.layoutManager = LinearLayoutManager(this)
        userRecyclerview.setHasFixedSize(true)
        userList = arrayListOf()
        db = FirebaseFirestore.getInstance()
        val userList = ArrayList<Users>()
        db.collection("Users").get()
            .addOnSuccessListener {
                for (document in it.documents) {
                    val user = document.toObject(Users::class.java)
                    userList.add(user!!)
                }
                    userRecyclerview.adapter = MyAdapter(userList)
            }

            .addOnFailureListener {
                Toast.makeText(this , it.toString() , Toast.LENGTH_SHORT).show()
            }

    }

}