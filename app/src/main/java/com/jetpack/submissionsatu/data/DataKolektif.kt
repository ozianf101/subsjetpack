package com.jetpack.submissionsatu.data

import com.jetpack.submissionsatu.R
import com.jetpack.submissionsatu.model.DataEntitas

object DataKolektif {
    fun getDataMovies() : List<DataEntitas>{

        val listMovie = ArrayList<DataEntitas>()

        listMovie.apply {
            add(
                DataEntitas(
                    "m1",
                    "Alita: Battle Angel",
                    "Action, Sci-fi",
                    7.3,
                    "Alita, a battle cyborg, is revived by Ido, a doctor, who realises that she actually has the soul of a teenager. Alita then sets out to learn about her past and find her true identity.",
                    R.drawable.poster_alita,
                    R.drawable.latar_alita,
                    "2019",
                    "2h 2m",
                    "en"
                )
            )
            add(
                DataEntitas(
                    "m2",
                    "A Star Is Born",
                    "Drama, Percintaan, Musik",
                    6.9,
                    "Seorang bintang musik country yang karirnya mulai memudar, Jackson Maine (Bradley Cooper) menemukan sebuah talenta yang sangat berbakat di dalam diri dari seorang musisi muda bernama Ally (Lady Gaga). Maine berhasil mengorbitkan Ally menjadi seorang bintang muda yang menjanjikan. Namun keduanya terlibat hubungan yang lebih jauh dari sekedar mentor dan anak didik. Seiring dengan meroketnya karir dari Ally dan dirinya, Maine mengalami dilema mengenai masalah ini.",
                    R.drawable.poster_a_star_is_born,
                    R.drawable.latar_a_star,
                    "2018",
                    "2h 22m",
                    "en"
                )
            )
            add(
                DataEntitas(
                    "m3",
                    "Bohemian Rhapsody",
                    "Musical, Drama",
                    8.0,
                    "With his impeccable vocal abilities, Freddie Mercury and his rock band, Queen, achieve superstardom. However, amidst his skyrocketing success, he grapples with his ego, sexuality and a fatal illness.",
                    R.drawable.poster_bohemian,
                    R.drawable.latar_bohemian,
                    "2018",
                    "2h 13m",
                    "en"
                )
            )
            add(
                DataEntitas(
                    "m4",
                    "Cold Pursuit",
                    "Aksi, Kejahatan, Cerita Seru",
                    7.1,
                    "The quiet family life of Nels Coxman, a snowplow driver, is upended after his son's murder. Nels begins a vengeful hunt for Viking, the drug lord he holds responsible for the killing, eliminating Viking's associates one by one. As Nels draws closer to Viking, his actions bring even more unexpected and violent consequences, as he proves that revenge is all in the execution.",
                    R.drawable.poster_cold_persuit,
                    R.drawable.latar_cold_persuit,
                    "2018",
                    "2h 10m",
                    "en"
                )
            )
            add(
                DataEntitas(
                    "m5",
                    "Spider-Main: Into the Spider-Verse",
                    "Aksi, Petualangan, Animasi",
                    6.7,
                    "Miles Morales is juggling his life between being a high school student and being a spider-man. When Wilson \"Kingpin\" Fisk uses a super collider, others from across the Spider-Verse are transported to this dimension.",
                    R.drawable.poster_spiderman,
                    R.drawable.latar_spiderman,
                    "2019",
                    "2h 9m",
                    "en"
                )
            )
            add(
                DataEntitas(
                    "m6",
                    "How to Train Your Dragon: The Hidden World",
                    " Family, Fantasy",
                    7.5,
                    "Hiccup aims to unite the vikings and the dragons in order to bring peace on the island of Berk. However, he must stop the evil Grimmel and his devious plans to wipe out all dragons.",
                    R.drawable.poster_how_to_train,
                    R.drawable.latar_how_to_train,
                    "2019",
                    "1h 45m",
                    "en"
                )
            )
            add(
                DataEntitas(
                    "m7",
                    "Avengers: Infinity War",
                    "Action, Sci-fi",
                    8.4,
                    "The Avengers must stop Thanos, an intergalactic warlord, from getting his hands on all the infinity stones. However, Thanos is prepared to go to any lengths to carry out his insane plan.",
                    R.drawable.poster_infinity_war,
                    R.drawable.latar_infinity_war,
                    "2018",
                    "2h 40m",
                    "en"
                )
            )
            add(
                DataEntitas(
                    "m8",
                    "T-34",
                    "Horror, Action",
                    6.6,
                    "In 1944, a courageous group of Russian soldiers managed to escape from German captivity in a half-destroyed legendary T-34 tank. Those were the times of unforgettable bravery, fierce fighting, unbreakable love, and legendary miracles.",
                    R.drawable.poster_t34,
                    R.drawable.latar_t34,
                    "2018",
                    "1h 48m",
                    "en"
                )
            )
            add(
                DataEntitas(
                    "m9",
                    "Ralph Breaks the Internet",
                    "Family, Comedy",
                    7.0,
                    "Ralph and his best friend, Vanellope, face various challenges as they visit the uncharted land of the Internet through a Wi-Fi router at the arcade to save the game, Sugar Rush.",
                    R.drawable.poster_ralph,
                    R.drawable.latar_ralph,
                    "2018",
                    "1h 56m",
                    "en"
                )
            )
            add(
                DataEntitas(
                    "m10",
                    "Robin Hood",
                    "Adventure, Action",
                    5.3,
                    "After returning home to England, aristocrat Robin of Loxley learns that the evil Sheriff of Nottingham has seized his family estate. He soon joins forces with Friar Tuck and Little John -- a fierce Arabian warrior who wants to put an end to the Crusades. Armed with arrows and dubbed Robin Hood, Loxley leads a band of oppressed rebels in a daring plan to rob the Sheriff of his money and take away his power.",
                    R.drawable.poster_robin_hood,
                    R.drawable.latar_robin_hood,
                    "2018",
                    "1h 56m",
                    "en"
                )
            )
        }
        return listMovie
    }

    fun getDataTv() : List<DataEntitas>{
        val listTvShows = ArrayList<DataEntitas>()

        listTvShows.apply {
            add(
                DataEntitas(
                    "tv1",
                    "Arrow",
                    "Action",
                    7.7,
                    "After mastering the skill of archery on a deserted island, multi-millionaire playboy Oliver Queen returns to his city to take on the vigilante persona of Arrow to fight crime and corruption",
                    R.drawable.poster_arrow,
                    R.drawable.latar_arrow,
                    "2012",
                    "42m",
                    "en"
                )
            )
            add(
                DataEntitas(
                    "tv2",
                    "NCIS",
                    "Aksi & Petualangan, Kejahatan, Drama",
                    8.5,
                    "From murder and espionage to terrorism and stolen submarines, a team of special agents investigates any crime that has a shred of evidence connected to Navy and Marine Corps personnel, regardless of rank or position.",
                    R.drawable.poster_ncis,
                    R.drawable.latar_ncis,
                    "1986",
                    "24m",
                    "en"
                )
            )
            add(
                DataEntitas(
                    "tv3",
                    "The Simpsons",
                    "Animasi, Komedi, Keluarga, Drama",
                    8.0,
                    "Bertempat di Springfield, kota rata-rata di Amerika, pertunjukan ini berfokus pada kejenakaan dan petualangan sehari-hari keluarga Simpson; Homer, Marge, Bart, Lisa dan Maggie, serta ribuan pemain virtual. Sejak awal, serial ini telah menjadi ikon budaya pop, menarik ratusan selebriti menjadi bintang tamu. Acara ini juga menjadi terkenal karena satirnya yang tak kenal takut terhadap kehidupan politik, media, dan Amerika secara umum.",
                    R.drawable.poster_the_simpson,
                    R.drawable.latar_the_simpson,
                    "1989",
                    "24m",
                    "en"
                )
            )
            add(
                DataEntitas(
                    "tv4",
                    "Family Guy",
                    "Sitcom",
                    8.1,
                    "Peter Griffin and his family of two teenagers, a smart dog, a devilish baby and his wife find themselves in some of the most hilarious scenarios.",
                    R.drawable.poster_family_guy,
                    R.drawable.latar_family_guy,
                    "1999",
                    "22m",
                    "en"
                )
            )
            add(
                DataEntitas(
                    "tv5",
                    "Flash",
                    "Action, Adventure",
                    7.7,
                    "Barry Allen, a forensic scientist with the Central City police force, is struck by lightning in a freak accident. When he wakes up after nine months, he discovers that he can achieve great speeds.",
                    R.drawable.poster_flash,
                    R.drawable.latar_flash,
                    "2014",
                    "43m",
                    "en"
                )
            )
            add(
                DataEntitas(
                    "tv6",
                    "Grey's Anatomy",
                    "Drama",
                    9.3,
                    "Ikuti kehidupan pribadi dan profesional sekelompok dokter di Rumah Sakit Gray Sloan Memorial di Seattle.",
                    R.drawable.poster_grey_anatomy,
                    R.drawable.latar_grey_anatomy,
                    "2005",
                    "57m",
                    "en"
                )
            )
            add(
                DataEntitas(
                    "tv7",
                    "Gotham",
                    "Action",
                    7.4,
                    "Detective James Gordon is a new recruit assigned to investigate the murder of Thomas and Martha Wayne. The case acquaints him with the slain couple's son and future crusader, Bruce.",
                    R.drawable.poster_gotham,
                    R.drawable.latar_gotham,
                    "2014",
                    "42m",
                    "en"
                )
            )
            add(
                DataEntitas(
                    "tv8",
                    "Hanna",
                    "Drama",
                    7.5,
                    "Hanna is an extraordinary girl who has been raised in the forest, evading the relentless pursuit of an off-the-book CIA agent. This series -- part high-concept thriller, part coming-of-age drama -- follows the girl on her journey as she tries to unearth the truth behind who she is. \"Hanna\" is based on the 2011 film of the same name that starred Oscar-nominated actress Saoirse Ronan in the title role.",
                    R.drawable.poster_hanna,
                    R.drawable.latar_hanna,
                    "2019",
                    "60m",
                    "en"
                )
            )
            add(
                DataEntitas(
                    "tv9",
                    "Doom Patrol",
                    "Action, Fiction",
                    6.5,
                    "The Doom Patrol’s members each suffered horrible accidents that gave them superhuman abilities — but also left them scarred and disfigured. Traumatized and downtrodden, the team found purpose through The Chief, who brought them together to investigate the weirdest phenomena in existence — and to protect Earth from what they find.",
                    R.drawable.poster_doom_patrol,
                    R.drawable.latar_doom_patrol_,
                    "2019",
                    "55m",
                    "en"
                )
            )

            add(
                DataEntitas(
                    "tv10",
                    "Naruto Shippuden",
                    "Action, Anime",
                    8.6,
                    "Naruto Uzumaki wants to be the best ninja in the land. He's done well so far, but with the looming danger posed by the mysterious Akatsuki organization, Naruto knows he must train harder than ever and leaves his village for intense exercises that will push him to his limits.",
                    R.drawable.poster_naruto_shipudden,
                    R.drawable.latar_naruto_shipudden,
                    "2007",
                    "24m",
                    "en"
                )
            )
        }
        return  listTvShows
    }
}