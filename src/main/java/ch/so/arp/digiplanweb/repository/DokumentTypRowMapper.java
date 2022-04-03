package ch.so.arp.digiplanweb.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import ch.so.arp.digiplanweb.model.DokumentTyp;

public class DokumentTypRowMapper implements RowMapper<DokumentTyp> {

    @Override
    public DokumentTyp mapRow(ResultSet rs, int rowNum) throws SQLException {
        DokumentTyp dokumentTyp = new DokumentTyp(
                    rs.getString("ilicode"),
                    rs.getString("dispname")
                );
        return dokumentTyp;
    }
}
