package com.jetpack.submissionsatu.data

import com.jetpack.submissionsatu.model.DataEntitasMovie
import com.jetpack.submissionsatu.model.DataEntitasTv
import com.jetpack.submissionsatu.model.DetailMovie
import com.jetpack.submissionsatu.model.DetailTvShow

object DataKolektif {
    fun getDataMovies(): ArrayList<DataEntitasMovie?> {

        val listMovie = ArrayList<DataEntitasMovie?>()

        listMovie.apply {
            add(
                DataEntitasMovie(
                    id = 567189,
                    title = "Tom Clancy's Without Remorse",
                    rating = 7.3,
                    overview = "An elite Navy SEAL uncovers an international conspiracy while seeking justice for the murder of his pregnant wife.",
                    imgPoster = "/rEm96ib0sPiZBADNKBHKBv5bve9.jpg",
                    imgBackground = "/fPGeS6jgdLovQAKunNHX8l0avCy.jpg",
                    released = "2021-04-29"
                )
            )
            add(
                DataEntitasMovie(
                    id = 460465,
                    title = "Mortal Kombat",
                    rating = 7.6,
                    overview = "Washed-up MMA fighter Cole Young, unaware of his heritage, and hunted by Emperor Shang Tsung's best warrior, Sub-Zero, seeks out and trains with Earth's greatest champions as he prepares to stand against the enemies of Outworld in a high stakes battle for the universe.",
                    imgPoster = "/nkayOAUBUu4mMvyNf9iHSUiPjF1.jpg",
                    imgBackground = "/6ELCZlTA5lGUops70hKdB83WJxH.jpg",
                    released = "2021-04-07",
                )
            )
            add(
                DataEntitasMovie(
                    id = 567189,
                    title = "Tom Clancy's Without Remorse",
                    rating = 7.3,
                    overview = "An elite Navy SEAL uncovers an international conspiracy while seeking justice for the murder of his pregnant wife.",
                    imgPoster = "/rEm96ib0sPiZBADNKBHKBv5bve9.jpg",
                    imgBackground = "/fPGeS6jgdLovQAKunNHX8l0avCy.jpg",
                    released = "2021-04-29"
                )
            )
            add(
                DataEntitasMovie(
                    id = 460465,
                    title = "Mortal Kombat",
                    rating = 7.6,
                    overview = "Washed-up MMA fighter Cole Young, unaware of his heritage, and hunted by Emperor Shang Tsung's best warrior, Sub-Zero, seeks out and trains with Earth's greatest champions as he prepares to stand against the enemies of Outworld in a high stakes battle for the universe.",
                    imgPoster = "/nkayOAUBUu4mMvyNf9iHSUiPjF1.jpg",
                    imgBackground = "/6ELCZlTA5lGUops70hKdB83WJxH.jpg",
                    released = "2021-04-07",
                )
            )
            add(
                DataEntitasMovie(
                    id = 567189,
                    title = "Tom Clancy's Without Remorse",
                    rating = 7.3,
                    overview = "An elite Navy SEAL uncovers an international conspiracy while seeking justice for the murder of his pregnant wife.",
                    imgPoster = "/rEm96ib0sPiZBADNKBHKBv5bve9.jpg",
                    imgBackground = "/fPGeS6jgdLovQAKunNHX8l0avCy.jpg",
                    released = "2021-04-29"
                )
            )
            add(
                DataEntitasMovie(
                    id = 460465,
                    title = "Mortal Kombat",
                    rating = 7.6,
                    overview = "Washed-up MMA fighter Cole Young, unaware of his heritage, and hunted by Emperor Shang Tsung's best warrior, Sub-Zero, seeks out and trains with Earth's greatest champions as he prepares to stand against the enemies of Outworld in a high stakes battle for the universe.",
                    imgPoster = "/nkayOAUBUu4mMvyNf9iHSUiPjF1.jpg",
                    imgBackground = "/6ELCZlTA5lGUops70hKdB83WJxH.jpg",
                    released = "2021-04-07",
                )
            )
            add(
                DataEntitasMovie(
                    id = 567189,
                    title = "Tom Clancy's Without Remorse",
                    rating = 7.3,
                    overview = "An elite Navy SEAL uncovers an international conspiracy while seeking justice for the murder of his pregnant wife.",
                    imgPoster = "/rEm96ib0sPiZBADNKBHKBv5bve9.jpg",
                    imgBackground = "/fPGeS6jgdLovQAKunNHX8l0avCy.jpg",
                    released = "2021-04-29"
                )
            )
            add(
                DataEntitasMovie(
                    id = 460465,
                    title = "Mortal Kombat",
                    rating = 7.6,
                    overview = "Washed-up MMA fighter Cole Young, unaware of his heritage, and hunted by Emperor Shang Tsung's best warrior, Sub-Zero, seeks out and trains with Earth's greatest champions as he prepares to stand against the enemies of Outworld in a high stakes battle for the universe.",
                    imgPoster = "/nkayOAUBUu4mMvyNf9iHSUiPjF1.jpg",
                    imgBackground = "/6ELCZlTA5lGUops70hKdB83WJxH.jpg",
                    released = "2021-04-07",
                )
            )
            add(
                DataEntitasMovie(
                    id = 567189,
                    title = "Tom Clancy's Without Remorse",
                    rating = 7.3,
                    overview = "An elite Navy SEAL uncovers an international conspiracy while seeking justice for the murder of his pregnant wife.",
                    imgPoster = "/rEm96ib0sPiZBADNKBHKBv5bve9.jpg",
                    imgBackground = "/fPGeS6jgdLovQAKunNHX8l0avCy.jpg",
                    released = "2021-04-29"
                )
            )
            add(
                DataEntitasMovie(
                    id = 460465,
                    title = "Mortal Kombat",
                    rating = 7.6,
                    overview = "Washed-up MMA fighter Cole Young, unaware of his heritage, and hunted by Emperor Shang Tsung's best warrior, Sub-Zero, seeks out and trains with Earth's greatest champions as he prepares to stand against the enemies of Outworld in a high stakes battle for the universe.",
                    imgPoster = "/nkayOAUBUu4mMvyNf9iHSUiPjF1.jpg",
                    imgBackground = "/6ELCZlTA5lGUops70hKdB83WJxH.jpg",
                    released = "2021-04-07",
                )
            )

        }
        return listMovie
    }

    fun getRemoteDataMovies(): ArrayList<DataEntitasMovie> {

        val movies = ArrayList<DataEntitasMovie>()

        movies.apply {
            add(
                DataEntitasMovie(
                    id = 1,
                    title = "Gatotkaca"
                )
            )
        }

        return movies
    }

    fun getRemoteDetailDataMovies(id: Int): DetailMovie {
        return DetailMovie(id)
    }

    fun getDataTv(): ArrayList<DataEntitasTv?> {
        val listTvShows = ArrayList<DataEntitasTv?>()

        listTvShows.apply {
            add(
                DataEntitasTv(
                    id = 60735,
                    title = "The Flash",
                    rating = 7.7,
                    overview = "After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and falls into a coma. Months later he awakens with the power of super speed, granting him the ability to move through Central City like an unseen guardian angel. Though initially excited by his newfound powers, Barry is shocked to discover he is not the only \"meta-human\" who was created in the wake of the accelerator explosion -- and not everyone is using their new powers for good. Barry partners with S.T.A.R. Labs and dedicates his life to protect the innocent. For now, only a few close friends and associates know that Barry is literally the fastest man alive, but it won't be long before the world learns what Barry Allen has become...The Flash.",
                    imgPoster = "/lJA2RCMfsWoskqlQhXPSLFQGXEJ.jpg",
                    imgBackground = "/jeruqNWhqRqOR1QyqdQdHunrvU5.jpg",
                    released = "2014-10-07",
                )
            )
            add(
                DataEntitasTv(
                    id = 120168,
                    title = "Who Killed Sara?",
                    rating = 7.8,
                    overview = "Hell-bent on exacting revenge and proving he was framed for his sister's murder, Álex sets out to unearth much more than the crime's real culprit.",
                    imgPoster = "/o7uk5ChRt3quPIv8PcvPfzyXdMw.jpg",
                    imgBackground = "/dYvIUzdh6TUv4IFRq8UBkX7bNNu.jpg",
                    released = "2021-03-24",
                )
            )
            add(
                DataEntitasTv(
                    id = 60735,
                    title = "The Flash",
                    rating = 7.7,
                    overview = "After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and falls into a coma. Months later he awakens with the power of super speed, granting him the ability to move through Central City like an unseen guardian angel. Though initially excited by his newfound powers, Barry is shocked to discover he is not the only \"meta-human\" who was created in the wake of the accelerator explosion -- and not everyone is using their new powers for good. Barry partners with S.T.A.R. Labs and dedicates his life to protect the innocent. For now, only a few close friends and associates know that Barry is literally the fastest man alive, but it won't be long before the world learns what Barry Allen has become...The Flash.",
                    imgPoster = "/lJA2RCMfsWoskqlQhXPSLFQGXEJ.jpg",
                    imgBackground = "/jeruqNWhqRqOR1QyqdQdHunrvU5.jpg",
                    released = "2014-10-07",
                )
            )
            add(
                DataEntitasTv(
                    id = 120168,
                    title = "Who Killed Sara?",
                    rating = 7.8,
                    overview = "Hell-bent on exacting revenge and proving he was framed for his sister's murder, Álex sets out to unearth much more than the crime's real culprit.",
                    imgPoster = "/o7uk5ChRt3quPIv8PcvPfzyXdMw.jpg",
                    imgBackground = "/dYvIUzdh6TUv4IFRq8UBkX7bNNu.jpg",
                    released = "2021-03-24",
                )
            )
            add(
                DataEntitasTv(
                    id = 60735,
                    title = "The Flash",
                    rating = 7.7,
                    overview = "After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and falls into a coma. Months later he awakens with the power of super speed, granting him the ability to move through Central City like an unseen guardian angel. Though initially excited by his newfound powers, Barry is shocked to discover he is not the only \"meta-human\" who was created in the wake of the accelerator explosion -- and not everyone is using their new powers for good. Barry partners with S.T.A.R. Labs and dedicates his life to protect the innocent. For now, only a few close friends and associates know that Barry is literally the fastest man alive, but it won't be long before the world learns what Barry Allen has become...The Flash.",
                    imgPoster = "/lJA2RCMfsWoskqlQhXPSLFQGXEJ.jpg",
                    imgBackground = "/jeruqNWhqRqOR1QyqdQdHunrvU5.jpg",
                    released = "2014-10-07",
                )
            )
            add(
                DataEntitasTv(
                    id = 120168,
                    title = "Who Killed Sara?",
                    rating = 7.8,
                    overview = "Hell-bent on exacting revenge and proving he was framed for his sister's murder, Álex sets out to unearth much more than the crime's real culprit.",
                    imgPoster = "/o7uk5ChRt3quPIv8PcvPfzyXdMw.jpg",
                    imgBackground = "/dYvIUzdh6TUv4IFRq8UBkX7bNNu.jpg",
                    released = "2021-03-24",
                )
            )
            add(
                DataEntitasTv(
                    id = 60735,
                    title = "The Flash",
                    rating = 7.7,
                    overview = "After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and falls into a coma. Months later he awakens with the power of super speed, granting him the ability to move through Central City like an unseen guardian angel. Though initially excited by his newfound powers, Barry is shocked to discover he is not the only \"meta-human\" who was created in the wake of the accelerator explosion -- and not everyone is using their new powers for good. Barry partners with S.T.A.R. Labs and dedicates his life to protect the innocent. For now, only a few close friends and associates know that Barry is literally the fastest man alive, but it won't be long before the world learns what Barry Allen has become...The Flash.",
                    imgPoster = "/lJA2RCMfsWoskqlQhXPSLFQGXEJ.jpg",
                    imgBackground = "/jeruqNWhqRqOR1QyqdQdHunrvU5.jpg",
                    released = "2014-10-07",
                )
            )
            add(
                DataEntitasTv(
                    id = 120168,
                    title = "Who Killed Sara?",
                    rating = 7.8,
                    overview = "Hell-bent on exacting revenge and proving he was framed for his sister's murder, Álex sets out to unearth much more than the crime's real culprit.",
                    imgPoster = "/o7uk5ChRt3quPIv8PcvPfzyXdMw.jpg",
                    imgBackground = "/dYvIUzdh6TUv4IFRq8UBkX7bNNu.jpg",
                    released = "2021-03-24",
                )
            )
            add(
                DataEntitasTv(
                    id = 60735,
                    title = "The Flash",
                    rating = 7.7,
                    overview = "After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and falls into a coma. Months later he awakens with the power of super speed, granting him the ability to move through Central City like an unseen guardian angel. Though initially excited by his newfound powers, Barry is shocked to discover he is not the only \"meta-human\" who was created in the wake of the accelerator explosion -- and not everyone is using their new powers for good. Barry partners with S.T.A.R. Labs and dedicates his life to protect the innocent. For now, only a few close friends and associates know that Barry is literally the fastest man alive, but it won't be long before the world learns what Barry Allen has become...The Flash.",
                    imgPoster = "/lJA2RCMfsWoskqlQhXPSLFQGXEJ.jpg",
                    imgBackground = "/jeruqNWhqRqOR1QyqdQdHunrvU5.jpg",
                    released = "2014-10-07",
                )
            )
            add(
                DataEntitasTv(
                    id = 120168,
                    title = "Who Killed Sara?",
                    rating = 7.8,
                    overview = "Hell-bent on exacting revenge and proving he was framed for his sister's murder, Álex sets out to unearth much more than the crime's real culprit.",
                    imgPoster = "/o7uk5ChRt3quPIv8PcvPfzyXdMw.jpg",
                    imgBackground = "/dYvIUzdh6TUv4IFRq8UBkX7bNNu.jpg",
                    released = "2021-03-24",
                )
            )
        }
        return listTvShows
    }

    fun getRemoteDataTV(): ArrayList<DataEntitasTv> {

        val tv = ArrayList<DataEntitasTv>()

        tv.apply {
            add(
                DataEntitasTv(
                    id = 1,
                    title = "Yowis ben"
                )
            )
        }

        return tv
    }

    fun getRemoteDetailDataTV(id: Int): DetailTvShow {
        return DetailTvShow(id)
    }
}