ALTER TABLE profile ADD COLUMN calendar_type INTEGER;
ALTER TABLE profile ADD COLUMN client_type TEXT;
ALTER TABLE tariffs ADD COLUMN client_types TEXT;
ALTER TABLE tariffs ADD COLUMN client_companies TEXT;