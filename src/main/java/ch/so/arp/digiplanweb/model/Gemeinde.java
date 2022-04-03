package ch.so.arp.digiplanweb.model;

public record Gemeinde(
            int tid,
            String tilitid,
            String name,
            int bfsnr,
            String kanton,
            String kantonskuerzel
        ) {}
