package org.matsim.teaching;

import org.matsim.api.core.v01.events.PersonArrivalEvent;
import org.matsim.api.core.v01.events.PersonDepartureEvent;
import org.matsim.api.core.v01.events.handler.PersonArrivalEventHandler;
import org.matsim.api.core.v01.events.handler.PersonDepartureEventHandler;

public class SimpleEventHandler implements PersonDepartureEventHandler, PersonArrivalEventHandler {

    @Override
    public void handleEvent(PersonDepartureEvent event) {
        System.out.println("Departure event; time " + event.getTime() + " -- linkId: " + event.getLinkId()
        + " personId: " + event.getPersonId());
    }

    @Override
    public void handleEvent(PersonArrivalEvent event) {

    }
}