use posts_db;

truncate table posts;

INSERT into posts(body, title)
VALUES
       ('Here is post 1', 'Post 1'),
       ('Here is post 2', 'Post 2'),
       ('Here is post 3', 'Post 3'),
       ('Here is post 4', 'Post 4');