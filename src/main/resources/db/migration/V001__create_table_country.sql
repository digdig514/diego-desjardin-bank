
CREATE TABLE public.country (
	id bigserial NOT NULL,
	coins varchar(255) NULL,
	country varchar(255) NULL,
	CONSTRAINT country_pkey PRIMARY KEY (id)
);
