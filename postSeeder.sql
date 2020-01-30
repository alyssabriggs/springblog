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
('Here is post 1', 'Happy Cat', 1),
('Here is post 2', 'Sad Cat', 2),
('Here is post 3', 'Mean Cat', 3),
('Here is post 4', 'Sleepy Cat', 4);


INSERT into post_image(image_title, url, post_id)
VALUES
('Happy Cat', 'https://images.pexels.com/photos/399647/pexels-photo-399647.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260', 1),
('Sad Cat', 'https://images.pexels.com/photos/209037/pexels-photo-209037.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260', 2),
('Mean Cat', 'https://images.pexels.com/photos/208984/pexels-photo-208984.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260', 3),
('Sleepy Cat', 'https://images.pexels.com/photos/416160/pexels-photo-416160.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260', 4);