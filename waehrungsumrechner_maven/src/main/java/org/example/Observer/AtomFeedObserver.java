package org.example.Observer;

import com.sun.syndication.feed.atom.Content;
import com.sun.syndication.feed.atom.Entry;
import com.sun.syndication.feed.atom.Feed;
import com.sun.syndication.io.FeedException;
import com.sun.syndication.io.WireFeedOutput;

import java.util.Date;


public class AtomFeedObserver implements Observer {

    private Feed feed;

    public AtomFeedObserver() {
        this.feed = new Feed();
        this.feed.setFeedType("atom_1.0");
        this.feed.setTitle("Währungsrechnungen");

    }

    @Override
    public void update(String message) {
        Entry entry = new Entry();
        entry.setTitle("Aktualisierung der Währungsrechner");
        entry.setUpdated(new Date());

        Content summary = new Content();
        summary.setValue(message);
        entry.setSummary(summary);

        this.feed.getEntries().add(entry);
        outputFeed();
    }

    private void outputFeed(){
        WireFeedOutput output = new WireFeedOutput();
        try {
            String atomXml = output.outputString(feed);
            System.out.println(atomXml);
        } catch (FeedException e) {
            e.printStackTrace();
        }

    }
}
