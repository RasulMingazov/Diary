package com.example.diary.data.json

class JsonFile {
    companion object {
        val jsonString = """
[
  {
    "id":1,
    "date_start":"1619555171",
    "date_finish":"1619562371",
    "name":"My task",
    "description":"Description 1"
  },
  {
    "id":2,
    "date_start":"1617309760",
    "date_finish":"1617316960",
    "name":"My task 2",
    "description":"Description 2"
  }
]
""".trimIndent()
    }
}