package com.noweto.newzk.ui.fragments.globalNewsFragment.viewModels


import androidx.lifecycle.ViewModel
import com.noweto.newzk.core.data.repository.NewsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class GlobalNewsViewModel @Inject constructor(private val newsRepository: NewsRepository) : ViewModel() {


    val globalNewsList = newsRepository.getGlobalNews()



}