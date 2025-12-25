package com.example.test_lab_week_13.binding

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.test_lab_week_13.MovieAdapter

import com.example.lab_week_13.model.Movie

class RecyclerViewBinding {
    @BindingAdapter("list")
    fun bindMovies(view: RecyclerView, movies: List<Movie>?) {
        val adapter = view.adapter as? MovieAdapter ?: return
        adapter.addMovies((movies ?: emptyList()) as List<Movie>)
    }

}