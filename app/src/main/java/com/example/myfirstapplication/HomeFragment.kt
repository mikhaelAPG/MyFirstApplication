package com.example.myfirstapplication

import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.myfirstapplication.model.realm.User
import io.realm.Realm
import io.realm.exceptions.RealmException
import io.realm.kotlin.createObject
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {

    lateinit var realm: Realm

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initView()
        action()
    }

    fun initView() {
        realm = Realm.getDefaultInstance()
    }

    fun action() {
        btn_ad.setOnClickListener {
            var b = AlertDialog.Builder(activity)
            b.setTitle("Move to Movie Detail Page")
            b.setMessage("Are You Sure?")
            b.setPositiveButton("Yes", {dialog: DialogInterface?, which: Int ->
                var i = Intent(activity, MovieDetailActivity::class.java)
                startActivity(i)
            })

            b.setNegativeButton("No", {dialog: DialogInterface?, which: Int -> })

//            b.setNeutralButton("Ok", {dialog: DialogInterface?, which: Int ->
//                var i = Intent(activity, MovieDetailActivity::class.java)
//                startActivity(i)
//            })
            b.show()
        }

        btn_toast.setOnClickListener {
            Toast.makeText(activity, "Hello!", Toast.LENGTH_SHORT).show()
        }

        btn_add.setOnClickListener {
            realm.beginTransaction()
            try {
                var user = realm.createObject(User::class.java)
                user.setNama(et_nama.text.toString())
                user.setEmail(et_email.text.toString())

                tv_result.text = user.getNama() + " " + user.getEmail()

                realm.commitTransaction()

            } catch (e: RealmException) {
                Toast.makeText(activity, e.message, Toast.LENGTH_SHORT).show()
            }
        }
    }
}