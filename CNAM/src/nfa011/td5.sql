BEGIN TRANSACTION; 
CREATE TABLE client (
code_client int,
nom varchar NOT NULL,
prenom varchar NOT NULL,
date_naissance date,
adresse varchar(64) NOT NULL,
code_postal char(5) NOT NULL,
ville varchar NOT NULL,
telephone char(10),
email varchar(64),
CONSTRAINT pk_code_client PRIMARY KEY (code_client)
);
COMMIT;
