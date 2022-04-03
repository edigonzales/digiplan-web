package ch.so.arp.digiplanweb.model;

import java.util.Date;

public record Dokument(
            int tid,
            String tilitid,
            String titel,
            String offiziellerTitel,
            String offizielleNummer,
            String rrbNr,
            String typ,
            String typTxt,
            String textImWeb,
            String abkuerzung,
            int bfsnr,
            String gemeindename,
            Date publiziertAb,
            Date publiziertBis,
            String rechtsstatus,
            int minX,
            int minY,
            int maxX,
            int maxY
        ) {}
