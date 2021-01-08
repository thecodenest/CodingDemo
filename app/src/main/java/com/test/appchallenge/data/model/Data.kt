package com.test.appchallenge.data.model

data class Data (
	val type : String,
	val id : String,
	val url : String,
	val slug : String,
	val bitly_gif_url : String,
	val bitly_url : String,
	val embed_url : String,
	val username : String,
	val source : String,
	val title : String,
	val rating : String,
	val content_url : String,
	val source_tld : String,
	val source_post_url : String,
	val is_sticker : Int,
	val import_datetime : String,
	val trending_datetime : String,
	val images : Images
)