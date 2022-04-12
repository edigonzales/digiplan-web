package ch.so.arp.digiplanweb.repository;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import ch.so.arp.digiplanweb.model.Gemeinde;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

@Repository
public class GemeindeRepository {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    
    @Autowired
    private JdbcTemplate jdbcTemplate;
        
    public List<Gemeinde> findAll() {
        String sql = "SELECT * FROM arp_digiplan_pub_v1.gemeinde ORDER BY aname";
        return jdbcTemplate.query(sql, new GemeindeRowMapper());        
    }
}
