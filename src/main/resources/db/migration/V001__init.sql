create table users
(
    id                 UUID         not null primary key,
    birth_date         DATE         not null,
    created_at         TIMESTAMP,
    deleted_at         TIMESTAMP,
    email              VARCHAR(255) not null,
    is_allowed_to_play BOOLEAN      not null,
    password           VARCHAR(255) not null,
    updated_at         TIMESTAMP,
    username           VARCHAR(255) not null
);
