package com.dicoding.imamf.submission1made

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView





class MovieAdapter(val context: Context, var movies: List<Movie>) : BaseAdapter() {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View? {
        var view: View? = null
        if (convertView == null) {
            view = LayoutInflater.from(context).inflate(R.layout.item_movie, convertView, false)
        }
        else{
            view = convertView
        }

        val viewHolder = ViewHolder(view)
        val movie = getItem(position) as Movie
        viewHolder.bind(movie)
        return view
    }

    override fun getItem(position: Int): Any {
        return movies[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return movies.size
    }

    private inner class ViewHolder internal constructor(view: View?) {
        private val tvTitle: TextView = view!!.findViewById(R.id.tv_title)
        private val tvDescription: TextView = view!!.findViewById(R.id.tv_description)
        private val imgPoster: ImageView = view!!.findViewById<View>(R.id.img_poster) as ImageView

        internal fun bind(movie: Movie) {
            tvTitle.text = movie.title
            tvDescription.text = movie.description
            imgPoster.setImageResource(movie.poster)
        }
    }
}