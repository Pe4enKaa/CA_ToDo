package com.example.ca_todo.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.ca_todo.data.ShopListRepositoryImpl
import com.example.ca_todo.domain.*

class MainViewModel : ViewModel() {

    private val repository = ShopListRepositoryImpl

    private val getShopList = GetShopList(repository)

    private val deleteShopList = DeleteShopItem(repository)

    private val editShopList = EditShopItem(repository)

    val shopList = getShopList.getShopList()

    fun deleteShopList(shopItem : ShopItem) {
        deleteShopList.deleteShopItem(shopItem)
    }

    fun changeEnabledState(shopItem: ShopItem) {
        val newItem = shopItem.copy(enabled = !shopItem.enabled)
        editShopList.editShopItem(newItem)
    }
}