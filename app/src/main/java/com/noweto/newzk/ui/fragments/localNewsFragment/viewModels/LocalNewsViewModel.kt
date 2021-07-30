package com.noweto.newzk.ui.fragments.localNewsFragment.viewModels

import androidx.lifecycle.ViewModel
import com.noweto.newzk.core.data.repository.NewsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LocalNewsViewModel @Inject constructor(private val newsRepository: NewsRepository):ViewModel(){

    val newsList = newsRepository.getLocalNews()

}