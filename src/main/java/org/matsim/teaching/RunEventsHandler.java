package org.matsim.teaching;

import org.matsim.core.api.experimental.events.EventsManager;
import org.matsim.core.events.EventsUtils;
import org.matsim.core.events.MatsimEventsReader;

public class RunEventsHandler {

    public static void main(String[] args) {

        String inputFile = "output/output_events.xml.gz";

        EventsManager eventsManager = EventsUtils.createEventsManager();

        SimpleEventHandler eventHandler = new SimpleEventHandler();
        eventsManager.addHandler(eventHandler);

        MatsimEventsReader eventsReader = new MatsimEventsReader(eventsManager);
        eventsReader.readFile(inputFile);
    }
}