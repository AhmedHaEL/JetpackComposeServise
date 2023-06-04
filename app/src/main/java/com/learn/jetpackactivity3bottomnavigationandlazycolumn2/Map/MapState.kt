package com.learn.jetpackactivity3bottomnavigationandlazycolumn2.Map

import android.location.Location

data class MapState(
    val lastKnownLocation: Location?,
    val clusterItems: List<ZoneClusterItem>,
)