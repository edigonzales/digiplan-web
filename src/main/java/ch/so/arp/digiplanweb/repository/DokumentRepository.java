package ch.so.arp.digiplanweb.repository;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import ch.so.arp.digiplanweb.model.Dokument;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

@Repository
public class DokumentRepository {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    public int count() {
        int result = jdbcTemplate.queryForObject("SELECT count(*) FROM dokument", Integer.class);
        return result;
    }
    
    public List<Dokument> findAll() {
        String sql = "SELECT * FROM dokument ORDER BY gemeindename, offiziellertitel";
        return jdbcTemplate.query(sql, new DokumentRowMapper());        
    }
    
    public List<Dokument> findAll(int limit, int offset) {
        String sql = "SELECT * FROM dokument ORDER BY gemeindename, offiziellertitel LIMIT ? OFFSET ?";
        System.out.println(sql);
        return jdbcTemplate.query(sql, new DokumentRowMapper(), limit, offset);        
        
    }
     
    public LinkedList<Dokument> findByFilter(HashMap<String, String> filter) {
        return null;
    }
}
