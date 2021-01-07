package com.example.myfirstapplication

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myfirstapplication.adapter.MovieAdapter
import com.example.myfirstapplication.listener.OnItemClickListener
import com.example.myfirstapplication.model.Movie
import kotlinx.android.synthetic.main.fragment_explore.*

class ExploreFragment : Fragment() {

    lateinit var movieAdapter: MovieAdapter
    val lm = LinearLayoutManager(activity)
    val addMoviewList: MutableList<Movie> = ArrayList()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_explore, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initView()
        action()
    }

    fun initView() {
        rv_movie.layoutManager = lm
        movieAdapter = MovieAdapter(activity!!)
        rv_movie.adapter = movieAdapter

        addMoviewList.add(Movie("Ini Movie A", "Lorem Ipsum Sing Amet Wedus Lara Aporto"))
        addMoviewList.add(Movie("Ini Movie B", "Lorem Ipsum Sing Amet Wedus Lara Aporto"))
        addMoviewList.add(Movie("Ini Movie C", "Lorem Ipsum Sing Amet Wedus Lara Aporto"))
        addMoviewList.add(Movie("Ini Movie D", "Lorem Ipsum Sing Amet Wedus Lara Aporto"))
        addMoviewList.add(Movie("Ini Movie E", "Lorem Ipsum Sing Amet Wedus Lara Aporto"))
        addMoviewList.add(Movie("Ini Movie F", "Lorem Ipsum Sing Amet Wedus Lara Aporto"))
        addMoviewList.add(Movie("Ini Movie G", "Lorem Ipsum Sing Amet Wedus Lara Aporto"))

        movieAdapter.setMovie(addMoviewList)
    }

    fun action() {
        movieAdapter.setOnClickItemListener(object : OnItemClickListener {
            override fun onItemClick(item: View, position: Int) {
                var i = Intent(context, MovieDetailActivity::class.java)
                i.putExtra("title", movieAdapter.getMovie().get(position).getTitle())
                i.putExtra("description", movieAdapter.getMovie().get(position).getDescription())
                startActivity(i)
            }
        })
    }
}