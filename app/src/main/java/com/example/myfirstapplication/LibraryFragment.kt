package com.example.myfirstapplication

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myfirstapplication.model.Comment
import com.example.myfirstapplication.service.CommentAPI
import com.example.myfirstapplication.util.Retro
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.create

class LibraryFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_library, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getCommentAPI()
    }

    fun getCommentAPI() {
        val retro = Retro().getRetroClientInstance().create(CommentAPI::class.java)
        retro.getComment().enqueue(object : Callback<List<Comment>>{
            override fun onResponse(call: Call<List<Comment>>, response: Response<List<Comment>>) {
                val comment = response.body()
                for (c in comment!!) {
                    Log.e("Hasil", c.email!!)
                }
            }

            override fun onFailure(call: Call<List<Comment>>, t: Throwable) {
               Log.e("Failed", t.message.toString())
            }

        })
    }

}