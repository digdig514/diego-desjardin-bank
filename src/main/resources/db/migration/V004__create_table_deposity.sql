
CREATE TABLE public.deposity (
	amount numeric(38, 2) NULL,
	"date" timestamp(6) NULL,
	destination_account_id int8 NULL,
	id bigserial NOT NULL,
	description varchar(255) NULL,
	CONSTRAINT deposity_pkey PRIMARY KEY (id)
);

ALTER TABLE public.deposity ADD CONSTRAINT fk6qc7eqoj5yknekjgjdmhs42r9 FOREIGN KEY (destination_account_id) REFERENCES public.account(id);