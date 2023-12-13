-- Create roles
INSERT INTO `roles` (`id`, `name`) VALUES
(1, 'ROLE_USER'),
(2, 'ROLE_ADMIN');

-- Create a user
INSERT INTO `users` (`id`, `password`, `username`) VALUES
(1, '$2a$10$EYO9rV0a1Dnyi9sXpGCQD.pvebZwXdbE12AJnfeumk3qijXXKv.wK', 'admin');

-- Tie the role to the user
INSERT INTO `user_roles` (`user_id`, `role_id`) VALUES
(1, 2);
