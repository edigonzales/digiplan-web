package ch.so.arp.digiplanweb.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import ch.so.arp.digiplanweb.model.Dokument;

public class DokumentRowMapper implements RowMapper<Dokument> {

    @Override
    public Dokument mapRow(ResultSet rs, int rowNum) throws SQLException {
        Dokument dokument = new Dokument();
        dokument.setTid(rs.getInt("t_id"));
        dokument.setTilitid(rs.getString("t_ili_tid"));
        dokument.setTitel(rs.getString("titel"));
        dokument.setOffiziellerTitel(rs.getString("offiziellertitel"));
        dokument.setOffizielleNummer(rs.getString("offiziellenummer"));
        dokument.setRrbNr(rs.getString("rrbnr"));
        dokument.setTyp(rs.getString("typ"));
        dokument.setTypTxt(rs.getString("typ_txt"));
        dokument.setTextImWeb(rs.getString("textimweb"));
        dokument.setAbkuerzung(rs.getString("abkuerzung"));
        dokument.setBfsnr(rs.getInt("bfsnr"));
        dokument.setGemeindename(rs.getString("gemeindename"));
        dokument.setPubliziertAb(rs.getDate("publiziertab"));
        dokument.setPubliziertBis(rs.getDate("publiziertbis"));
        dokument.setRechtsstatus(rs.getString("rechtsstatus"));
        dokument.setMinX(rs.getInt("minx"));
        dokument.setMinY(rs.getInt("miny"));
        dokument.setMaxX(rs.getInt("maxx"));
        dokument.setMaxY(rs.getInt("maxy"));  
        dokument.setAvgX(rs.getInt("avgx"));
        dokument.setAvgY(rs.getInt("avgy"));
        dokument.setScale(rs.getInt("ascale"));
        return dokument;
    }

}
