package com.example.zverek.treasure;

import android.os.Bundle;
import ru.yandex.yandexmapkit.MapActivity;
import ru.yandex.yandexmapkit.MapController;
import ru.yandex.yandexmapkit.MapView;
import ru.yandex.yandexmapkit.utils.GeoPoint;

public class MyYandexMap extends MapActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_yandex_map);
        final MapView mMapView = (MapView) findViewById(R.id.map);

// Получаем MapController
        MapController mMapController = mMapView.getMapController();

// Перемещаем карту на заданные координаты
        mMapController.setPositionAnimationTo(new GeoPoint(60.113337, 55.151317));

        mMapController.setZoomCurrent(15);
    }
}
