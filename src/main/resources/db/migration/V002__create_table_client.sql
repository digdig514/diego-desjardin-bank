

CREATE TABLE public.client (
	country_id int8 NULL,
	id bigserial NOT NULL,
	email varchar(255) NULL,
	"name" varchar(255) NULL,
	phone varchar(255) NULL,
	CONSTRAINT client_pkey PRIMARY KEY (id)
);

ALTER TABLE public.client ADD CONSTRAINT fkevdwlrxhbct07e6dighauj6er FOREIGN KEY (country_id) REFERENCES public.country(id);