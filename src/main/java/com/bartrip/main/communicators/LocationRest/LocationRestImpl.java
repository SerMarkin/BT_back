package com.bartrip.main.communicators.LocationRest;

import javax.xml.stream.Location;


import com.bartrip.main.communicators.AbstractRest;

public class LocationRestImpl extends AbstractRest implements LocationRest {

    protected final String BASE_URL = " https://api.openstreetmap.org/";

    public LocationRestImpl() {
        webClient = createWebClient(BASE_URL);

    }

    @Override
    public String getFullAddressName(Location location) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getFullAddressName'");
    }

}
