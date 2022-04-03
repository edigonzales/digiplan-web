package ch.so.arp.digiplanweb.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import ch.so.arp.digiplanweb.model.Gemeinde;

public class GemeindeRowMapper implements RowMapper<Gemeinde> {

    @Override
    public Gemeinde mapRow(ResultSet rs, int rowNum) throws SQLException {
        Gemeinde gemeinde = new Gemeinde (
                rs.getInt("t_id"),
                rs.getString("t_ili_tid"),
                rs.getString("aname"),
                rs.getInt("bfsnr"),
                rs.getString("kanton"),
                rs.getString("kantonskuerzel")
                );
        return gemeinde;
    }
}
