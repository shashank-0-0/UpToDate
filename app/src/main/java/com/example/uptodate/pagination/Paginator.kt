package com.example.uptodate.pagination

interface Paginator<Key, Item> {
    suspend fun loadNextItems()
    fun reset()
}