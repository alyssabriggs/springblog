use posts_db;

# truncate table users;
# truncate table post_details;
# truncate table posts;

INSERT into post_details(history_of_post, is_awesome, topic_description)
VALUES
       ('created on JAN 1st', true, 'This really is post 1'),
       ('created on JAN 1st', true, 'This really is post 2'),
       ('created on JAN 1st', true, 'This really is post 3'),
       ('created on JAN 1st', true, 'This really is post 4');

INSERT into posts(body, title, post_details_id)
VALUES
('Here is post 1', 'Post 1', 1),
('Here is post 2', 'Post 2', 2),
('Here is post 3', 'Post 3', 3),
('Here is post 4', 'Post 4', 4);