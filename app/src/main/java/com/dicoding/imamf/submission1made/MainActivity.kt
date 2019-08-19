package com.dicoding.imamf.submission1made

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.content.res.TypedArray
import kotlinx.android.synthetic.main.activity_main.*
import android.widget.Toast


class MainActivity : AppCompatActivity() {

    //movies' attribute
    private var dataTitle: Array<String>? = null
    private var dataReleaseDate: Array<String>? = null
    private var dataScore: Array<String>? = null
    private var dataTopCast: Array<String>? = null
    private var dataDescription: Array<String>? = null
    private var dataPoster: TypedArray? = null
    private var movies: ArrayList<Movie>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        prepare()
        addItem()

        listV_movie.setOnItemClickListener { parent, view, position, id ->
            Toast.makeText(this, movies!![position].title + " clicked", Toast.LENGTH_SHORT).show()

            val intent = Intent(this@MainActivity, DetailActivity::class.java)
            intent.putExtra("extra_movie", movies!![position])
            startActivity(intent)
        }


    }

    private fun prepare() {
        //attribute initialization
        dataTitle = resources.getStringArray(R.array.data_title)
        dataReleaseDate = resources.getStringArray(R.array.data_release_date)
        dataScore = resources.getStringArray(R.array.data_score)
        dataTopCast = resources.getStringArray(R.array.data_top_cast)
        dataDescription = resources.getStringArray(R.array.data_description)
        dataPoster = resources.obtainTypedArray(R.array.data_poster)
    }

    private fun addItem() {
        //insert item to movie list

        movies = ArrayList()

        for (i in 0 until dataTitle!!.size - 1) {
            val movie = Movie(
                dataTitle!![i], dataReleaseDate!![i], dataScore!![i], dataTopCast!![i],
                dataDescription!![i], dataPoster!!.getResourceId(i, -1)
            )

            movies!!.add(movie)
            listV_movie.adapter = MovieAdapter(this, movies!!)
        }

    }


}

