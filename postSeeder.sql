use posts_db;

# truncate table posts;

INSERT into users(email, password, username)
VALUES
       ('a@mail.com', 'password', 'a'),
       ('e@mail.com', 'password', 'b');

INSERT into posts(body, title, user_id)
VALUES
       ('Here is post 1', 'Post 1', 1),
       ('Here is post 2', 'Post 2', 1),
       ('Here is post 3', 'Post 3', 2),
       ('Here is post 4', 'Post 4', 2);