package com.example.ca_todo.presentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.ca_todo.data.repository.ShopListRepositoryImpl
import com.example.ca_todo.domain.DeleteShopItem
import com.example.ca_todo.domain.EditShopItem
import com.example.ca_todo.domain.GetShopList
import com.example.ca_todo.domain.ShopItem
import kotlinx.coroutines.launch

class MainViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = ShopListRepositoryImpl(application)

    private val getShopList = GetShopList(repository)

    private val deleteShopList = DeleteShopItem(repository)

    private val editShopList = EditShopItem(repository)

    val shopList = getShopList.getShopList()

    fun deleteShopList(shopItem : ShopItem) {
        viewModelScope.launch {
            deleteShopList.deleteShopItem(shopItem)
        }
    }

    fun changeEnabledState(shopItem: ShopItem) {
        viewModelScope.launch {
            val newItem = shopItem.copy(enabled = !shopItem.enabled)
            editShopList.editShopItem(newItem)
        }

    }
}