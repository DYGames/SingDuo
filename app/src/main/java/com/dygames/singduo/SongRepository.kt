package com.dygames.singduo

class SongRepository {
    fun getSongData(idx: Int): String {
        return """{ "data" : {
	"title" : "Sweet Child'O Mine",
	"cover" : "https://m.media-amazon.com/images/I/71H9ZR6EGFL._SY355_.jpg",
	"lyrics" : [
		{
			"time" : "0",
			"lyrics" : "shes got smile that it seems to me"
		},
		{
			"time" : "3100",
			"lyrics" : "reminds me a childhood memory"
		},
		{
			"time" : "5110",
			"lyrics" : "everything was fresh as bright blue sky"
		},
		{
			"time" : "7120",
			"lyrics" : "now when then asdfasdff"
		},
		{
			"time" : "9150",
			"lyrics" : "sasdfasdkfja;dslkfjdsalkfjdsa;fkasdfe"
		}
	] }
}"""
    }

    fun getSongList(): String {
        return ""
    }
}