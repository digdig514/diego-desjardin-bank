
CREATE TABLE public."transaction" (
	amount numeric(38, 2) NULL,
	"date" timestamp(6) NULL,
	destination_account_id int8 NULL,
	id bigserial NOT NULL,
	source_account_id int8 NULL,
	description varchar(255) NULL,
	CONSTRAINT transaction_pkey PRIMARY KEY (id)
);


ALTER TABLE public."transaction" ADD CONSTRAINT fk25e716ukpqahttjt6c487lrer FOREIGN KEY (source_account_id) REFERENCES public.account(id);
ALTER TABLE public."transaction" ADD CONSTRAINT fkan2cq79w1pqavplm9nbu5aef0 FOREIGN KEY (destination_account_id) REFERENCES public.account(id);