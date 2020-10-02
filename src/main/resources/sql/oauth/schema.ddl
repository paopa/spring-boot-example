create table if not exists account
(
    id                  bigserial   not null primary key,
    username            varchar(30) not null,
    password            text        not null,
    enabled             bool,
    expired             bool,
    locked              bool,
    credentials_expired bool,
    create_date         timestamp,
    create_by           bigint,
    last_modified_date  timestamp,
    last_modified_by    bigint
);

create table if not exists role
(
    id                 bigserial not null primary key,
    code               varchar(30),
    label              varchar(30),
    create_date        timestamp,
    create_by          bigint,
    last_modified_date timestamp,
    last_modified_by   bigint
);

create table if not exists account_role
(
    id                 bigserial not null primary key,
    account_id         bigint references account (id),
    role_id            bigint references role (id),
    create_date        timestamp,
    create_by          bigint,
    last_modified_date timestamp,
    last_modified_by   bigint
);

create table if not exists oauth_token
(
    id                 bigserial   not null primary key,
    token_id           text,
    refresh_id         text,
    client_id          text,
    grant_type         text,
    resources_ids      text,
    scopes             text,
    username           varchar(30) not null,
    redirect_uri       text,
    access_token       text,
    refresh_token      text,
    refreshed          bool,
    locked             bool,
    authentication     text,
    create_date        timestamp,
    create_by          bigint,
    last_modified_date timestamp,
    last_modified_by   bigint
)