
CREATE TABLE public.account (
	id bigserial NOT NULL,
	owner_id int8 NULL,
	account_number varchar(255) NULL,
	CONSTRAINT account_account_number_key UNIQUE (account_number),
	CONSTRAINT account_pkey PRIMARY KEY (id)
);

ALTER TABLE public.account ADD CONSTRAINT fkqjl6giaj0918wm6afxu9epxfy FOREIGN KEY (owner_id) REFERENCES public.client(id);