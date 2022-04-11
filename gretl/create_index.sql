CREATE EXTENSION  IF NOT EXISTS pg_trgm;

CREATE INDEX searchtext_trgm_idx ON arp_digiplan_pub_v1.dokument USING gist (searchtext gist_trgm_ops);
