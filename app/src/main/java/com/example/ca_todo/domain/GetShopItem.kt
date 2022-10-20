package com.example.ca_todo.domain

class GetShopItem(private val shopListRepository: ShopListRepository) {

    suspend fun getShopItem(shopItemId : Int) : ShopItem {
        return shopListRepository.getShopItem(shopItemId)
    }
}