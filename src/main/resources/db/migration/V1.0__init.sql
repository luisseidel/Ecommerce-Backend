CREATE TABLE IF NOT EXISTS public.users (
     id SERIAL PRIMARY KEY,
     email VARCHAR(255) NOT NULL,
     name VARCHAR(255) NOT NULL,
     password VARCHAR(255) NOT NULL,
     role INTEGER NOT NULL
);
CREATE SEQUENCE public.seq_users increment 1 start 1 OWNED BY users.id;

CREATE TABLE IF NOT EXISTS public.citizens (
    id SERIAL PRIMARY KEY,
    cpf VARCHAR(11) NOT NULL,
    nome VARCHAR(255) NOT NULL,
    endereco VARCHAR(300) NOT NULL,
    sexo INTEGER NOT NULL
);

CREATE SEQUENCE public.seq_citizens increment 1 start 1 OWNED BY citizens.id;

INSERT INTO public.users(id, email, name, password, role) VALUES (nextval(seq_users),  'luis.seidel@example.com', 'Luis Seidel', '$2a$10$lT9BaejoLYWg2Fz9QALdke4cDtggYVgjSdTwbwRtR5WUrVeakG20a', 1);
INSERT INTO public.citizens(id, cpf, nome, endereco, sexo) VALUES (nextval(seq_citizens), '65368026242', 'Teste 1', 'Teste endereço', 1);