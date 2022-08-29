package com.example.querydsl.domain

import java.io.Serializable

@kotlinx.serialization.Serializable
data class Message (
    private var type:String="",
    private var sender:String="",
    private var channelId:String="",
    private var data:String? = ""
        ) {
    fun setSender(sender:String){
        this.sender = sender
    }

    fun newConnect(){
        this.type = "new"
    }

    fun closeConnect(){
        this.type = "close"
    }

    fun getChannelId():String{
        return this.channelId
    }

}