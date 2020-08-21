package com.academy.stikompoltek.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.academy.stikompoltek.data.base.BaseViewModel
import com.academy.stikompoltek.data.local.ListSchedule
import com.academy.stikompoltek.data.local.Schedule
import javax.inject.Inject

class HomeViewModel @Inject constructor() : BaseViewModel() {

    private val _schedule = MutableLiveData<List<Schedule>>()
    val schedule: LiveData<List<Schedule>> get() = _schedule

    init {
        _schedule.postValue(
            mutableListOf(
                Schedule(
                    day = "Monday",
                    listSchedule = listOf(
                        ListSchedule(
                            "08.00 AM - 10.00 AM",
                            "Algoritma Pemrograman"
                        ),
                        ListSchedule(
                            "01.00 PM - 02.00 PM",
                            "Jaringan Komputer"
                        ),
                        ListSchedule(
                            "02.00 PM - 04.00 PM",
                            "Visual Basic"
                        )
                    )
                ),
                Schedule(
                    day = "Tuesday",
                    listSchedule = listOf(
                        ListSchedule(
                            "08.AM - 10.AM",
                            "Pemrograman Berorientasi Objek"
                        )
                    )
                ),
                Schedule(
                    day = "Wednesday",
                    listSchedule = listOf(
                        ListSchedule(
                            "08.AM - 10.AM",
                            "Pemrograman Berorientasi Objek"
                        ),
                        ListSchedule(
                            "08.AM - 10.AM",
                            "Pemrograman Berorientasi Objek"
                        )
                    )
                ),
                Schedule(
                    day = "Thursday",
                    listSchedule = listOf(
                        ListSchedule(
                            "08.00 AM - 10.00 AM",
                            "Algoritma Pemrograman"
                        ),
                        ListSchedule(
                            "01.00 PM - 02.00 PM",
                            "Jaringan Komputer"
                        ),
                        ListSchedule(
                            "02.00 PM - 04.00 PM",
                            "Visual Basic"
                        )
                    )
                ),
                Schedule(
                    day = "Friday",
                    listSchedule = null
                ),
                Schedule(
                    day = "Saturday",
                    listSchedule = listOf(
                        ListSchedule(
                            "08.AM - 10.AM",
                            "Pemrograman Berorientasi Objek"
                        )
                    )
                ),
                Schedule(
                    day = "Sunday",
                    listSchedule = null
                ),
            )
        )
    }
}