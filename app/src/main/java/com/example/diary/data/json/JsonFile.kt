package com.example.diary.data.json

class JsonFile {
    companion object {
        val jsonString = """
[
  {
    "id":1,
    "date_start":"1619607600",
    "date_finish":"1619611200",
    "name":"My task 1",
    "description":"Description 1"
  },
  {
    "id":2,
    "date_start":"1619697600",
    "date_finish":"1619701200",
    "name":"My task 2",
    "description":"Description 2"
  },
  {
    "id":3,
    "date_start":"1619712000",
    "date_finish":"1619715600",
    "name":"My task 3",
    "description":"Description 3"
  }
]
""".trimIndent()
    }
}