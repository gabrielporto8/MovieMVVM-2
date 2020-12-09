package com.sample.android.moviemvvm.ui.item.tvshow

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.sample.android.moviemvvm.domain.TVShow
import com.sample.android.moviemvvm.network.TVShowApi
import com.sample.android.moviemvvm.ui.item.BaseItemFragment
import javax.inject.Inject

abstract class TVShowFragment : BaseItemFragment<TVShow>() {

    @Inject
    lateinit var api: TVShowApi

    override val viewModel by lazy {
        ViewModelProviders.of(this, object : ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                @Suppress("UNCHECKED_CAST")
                return TVShowsViewModel(api, sortType, requireNotNull(activity).application) as T
            }
        })[TVShowsViewModel::class.java]
    }
}