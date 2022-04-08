package ch.so.arp.digiplanweb.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import ch.so.arp.digiplanweb.model.Dokument;

public class DokumentRowMapper implements RowMapper<Dokument> {

    @Override
    public Dokument mapRow(ResultSet rs, int rowNum) throws SQLException {
        Dokument dokument = new Dokument(
                    rs.getInt("t_id"),
                    rs.getString("t_ili_tid"),
                    rs.getString("titel"),
                    rs.getString("offiziellertitel"),
                    rs.getString("offiziellenummer"),
                    rs.getString("rrbnr"),
                    rs.getString("typ"),
                    rs.getString("typ_txt"),
                    rs.getString("textimweb"),
                    rs.getString("abkuerzung"),
                    rs.getInt("bfsnr"),
                    rs.getString("gemeindename"),
                    rs.getDate("publiziertab"),
                    rs.getDate("publiziertbis"),
                    rs.getString("rechtsstatus"),
                    rs.getInt("minx"),
                    rs.getInt("miny"),
                    rs.getInt("maxx"),
                    rs.getInt("maxy")
                );
        return dokument;
    }

}
