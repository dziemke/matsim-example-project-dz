package org.matsim.teaching;

import org.matsim.api.core.v01.Id;
import org.matsim.api.core.v01.events.LinkEnterEvent;
import org.matsim.api.core.v01.events.LinkLeaveEvent;
import org.matsim.api.core.v01.events.PersonArrivalEvent;
import org.matsim.api.core.v01.events.PersonDepartureEvent;
import org.matsim.api.core.v01.events.handler.LinkEnterEventHandler;
import org.matsim.api.core.v01.events.handler.LinkLeaveEventHandler;
import org.matsim.api.core.v01.events.handler.PersonArrivalEventHandler;
import org.matsim.api.core.v01.events.handler.PersonDepartureEventHandler;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class LinkEventHandler implements LinkEnterEventHandler {

    private final BufferedWriter bufferedWriter;

    public LinkEventHandler(String outputFile) {
        try {
            FileWriter fileWriter = new FileWriter(outputFile);
            bufferedWriter = new BufferedWriter(fileWriter);
        } catch (IOException ee) {
            throw new RuntimeException(ee);
        }
    }

    private double[] volumeLink6 = new double[200];

    private int getSlot(double time) {
        return (int) time/3600;
    }

    @Override
    public void handleEvent(LinkEnterEvent event) {
        if (event.getLinkId().equals(Id.createLinkId("6"))) {
            int slot = getSlot(event.getTime());
            this.volumeLink6[slot]++;
        }
    }

    public void printResult() {
        try {
            bufferedWriter.write("Hour \t Volume");
            bufferedWriter.newLine();
            for (int i=0; i<200; i++) {
                double volume = this.volumeLink6[i];
                bufferedWriter.write(i + "\t" + volume);
                bufferedWriter.newLine();
                //System.out.println("Volume on link 6 from " + i + " to " + (i + 1) + " o'clock = " + volume);
            }
            bufferedWriter.close();
        } catch (IOException ee) {
            throw new RuntimeException(ee);
        }
    }
}