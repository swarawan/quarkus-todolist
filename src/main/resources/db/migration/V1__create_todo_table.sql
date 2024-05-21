CREATE TABLE IF NOT EXISTS `todo`
(
    `id`         bigint primary key auto_increment not null,
    `title`      varchar(256)                      not null,
    `content`    text                              not null,
    `created_at` datetime                          not null default current_timestamp,
    `updated_at` datetime on update current_timestamp
);