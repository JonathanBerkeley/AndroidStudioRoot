package com.example.plainolnotes4.data

import java.util.*

class SampleDataProvider {
    companion object {
        private val sampleText1 = "A simple note"
        private val sampleText2 = "A note a\nline feed"
        private val sampleText3 = """
            Meh affogato deep v jianbing neutra keffiyeh aesthetic, bushwick green juice wolf af et leggings in butcher. 3 wolf moon tote bag PBR&B pariatur proident laborum fam pug kogi. Paleo leggings distillery polaroid est, pitchfork ex art party chambray tattooed heirloom. Poke umami cardigan craft beer, elit farm-to-table food truck shabby chic. Adaptogen forage health goth poke, farm-to-table venmo mollit slow-carb offal art party veniam. Asymmetrical lo-fi fam aesthetic chartreuse knausgaard. Umami retro laboris taxidermy meh.

            Do fugiat sustainable enamel pin. Kitsch swag ethical health goth disrupt literally. Anim VHS adipisicing irure, tousled succulents typewriter post-ironic adaptogen do shabby chic tofu pitchfork pariatur. Pour-over laborum elit kale chips woke kogi everyday carry pinterest esse enim raw denim shoreditch aute. Stumptown irure thundercats chia celiac tempor poke lyft messenger bag hot chicken try-hard 8-bit cray.
        """.trimIndent()

        private fun getDate(diff: Long): Date {
            return Date(Date().time + diff)
        }

        fun getNotes() = arrayListOf(
            NoteEntity(getDate(0), sampleText1),
            NoteEntity(getDate(1), sampleText2),
            NoteEntity(getDate(2), sampleText3)
        )
    }


}