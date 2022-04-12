package ch.so.arp.digiplanweb.repository;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import ch.so.arp.digiplanweb.model.Dokument;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

@Repository
public class DokumentRepository {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    
    @Autowired
    private NamedParameterJdbcTemplate jdbcParamTemplate;
    
    // TODO:
    // Clean code (1x sql stmt herstellen)
    
    public int count(HashMap<String,String> filters) {        
        MapSqlParameterSource params = new MapSqlParameterSource();

        String sql = "SELECT count(*) FROM arp_digiplan_pub_v1.dokument WHERE 1=1 ";

        if (filters != null) {
            for (Map.Entry<String, String> entry : filters.entrySet()) {
                if (entry.getKey().equalsIgnoreCase("gemeindename")) {
                    sql += "AND gemeindename = :gemeindename ";
                    params.addValue("gemeindename", entry.getValue());
                } else if (entry.getKey().equalsIgnoreCase("typ")) {
                    sql += "AND typ = :typ ";
                    params.addValue("typ", entry.getValue());
                } else if (entry.getKey().equalsIgnoreCase("searchtext")) {
                    String[] tokens = entry.getValue().trim().split(" ");
                    for (int i=0; i< tokens.length; i++) {
                        sql += "AND (searchtext ILIKE :token" + i +") ";
                        params.addValue("token"+i, "%"+tokens[i].trim()+"%");
                    }
                }
            }   
        }

        logger.info(sql);

        int result = jdbcParamTemplate.queryForObject(sql, params, Integer.class);
        return result;
    }
        
    public List<Dokument> findAll(int limit, int offset, HashMap<String,String> filters) {        
        MapSqlParameterSource params = new MapSqlParameterSource();

        String sql = "SELECT * FROM arp_digiplan_pub_v1.dokument WHERE 1=1 ";
        
        if (filters != null) {
            for (Map.Entry<String, String> entry : filters.entrySet()) {
                if (entry.getKey().equalsIgnoreCase("gemeindename")) {
                    sql += "AND gemeindename = :gemeindename ";
                    params.addValue("gemeindename", entry.getValue());
                } else if (entry.getKey().equalsIgnoreCase("typ")) {
                    sql += "AND typ = :typ ";
                    params.addValue("typ", entry.getValue());
                } else if (entry.getKey().equalsIgnoreCase("searchtext")) {
                    String[] tokens = entry.getValue().trim().split(" ");
                    for (int i=0; i< tokens.length; i++) {
                        sql += "AND (searchtext ILIKE :token" + i +") ";
                        params.addValue("token"+i, "%"+tokens[i].trim()+"%");
                    }
                }
            }   
        }
        
        sql += "ORDER BY gemeindename, offiziellertitel ";
        sql += "LIMIT :limit OFFSET :offset";
        params.addValue("limit", limit);
        params.addValue("offset", offset);

        logger.info(sql);
        
        return jdbcParamTemplate.query(sql, params, new DokumentRowMapper());        
    }     
}
