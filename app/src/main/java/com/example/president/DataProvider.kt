package com.example.president

import values.PresidentData

object DataProvider {
    val presidents: MutableList<PresidentData> = ArrayList()

    init {
        // construct the data source
        presidents.add(PresidentData("Kaarlo Stahlberg", 1919, 1925, "Eka presidentti"))
        presidents.add(PresidentData("Lauri Relander", 1925, 1931, "Toka presidentti"))
        presidents.add(PresidentData("P. E. Svinhufvud", 1931, 1937, "Kolmas presidentti"))
        presidents.add(PresidentData("Kyösti Kallio", 1937, 1940, "Neljas presidentti"))
        presidents.add(PresidentData("Risto Ryti", 1940, 1944, "Viides presidentti"))
        presidents.add(PresidentData("Carl Gustaf Emil Mannerheim", 1944, 1946, "Kuudes presidentti"))
        presidents.add(PresidentData("Juho Kusti Paasikivi", 1946, 1956, "Äkäinen ukko"))
        presidents.add(PresidentData("Urho Kekkonen", 1956, 1982, "Pelimies"))
        presidents.add(PresidentData("Mauno Koivisto", 1982, 1994, "Manu"))
        presidents.add(PresidentData("Martti Ahtisaari", 1994, 2000, "Mahtisaari"))
        presidents.add(PresidentData("Tarja Halonen", 2000, 2012, "Eka naispresidentti"))
        presidents.add(PresidentData("Sauli Niinistö", 2012, 2024, "Ensimmäisen koiran, Oskun, omistaja"))
        presidents.sortBy { it.name }
    }
}

