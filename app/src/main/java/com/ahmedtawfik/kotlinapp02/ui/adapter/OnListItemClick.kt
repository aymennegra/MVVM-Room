package com.ahmedtawfik.kotlinapp02.ui.adapter

import com.ahmedtawfik.kotlinapp02.model.entity.User

interface OnListItemClick {
    fun onItemClick(user: User)
}