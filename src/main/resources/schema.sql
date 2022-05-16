DROP TABLE if EXISTS authorities;
DROP TABLE if EXISTS job_group;
DROP TABLE if EXISTS USER;
DROP TABLE if EXISTS group_user;

CREATE TABLE authorities
(
  seq      bigint NOT NULL PRIMARY KEY,
  user_seq bigint NOT NULL
);

CREATE TABLE job_group
(
  seq         bigint       NOT NULL PRIMARY KEY,
  name        VARCHAR(255) NOT NULL UNIQUE,
  created_at  DATE(6) DEFAULT now(),
  last_update DATE(6) NOT NULL DEFAULT now(),
  ended_at    DATE(6) NOT NULL,
  members     bigint,
  FOREIGN KEY (members) REFERENCES group_user (user_seq, group_seq)
);

CREATE TABLE job_user
(
  seq             bigint       NOT NULL PRIMARY KEY,
  id              VARCHAR(255) NOT NULL,
  password        VARCHAR(255) NOT NULL,
  name            VARCHAR(255) NOT NULL,
  is_admin        BIT DEFAULT FALSE,
  authorities_seq bigint,
  created_at      DATE(6) NOT NULL DEFAULT now(),
  updated_at      DATE(6) NOT NULL DEFAULT now(),
  group_user_seq  bigint,
  FOREIGN KEY (authorities_seq) REFERENCES authorities (seq),
  FOREIGN KEY (group_user_seq) REFERENCES group_user (user_seq, group_seq)
);

CREATE TABLE group_user
(
  user_seq  bigint NOT NULL,
  group_seq bigint NOT NULL,
  PRIMARY KEY (user_seq, group_seq),
  FOREIGN KEY (user_seq) REFERENCES job_user (seq),
  FOREIGN KEY (group_seq) REFERENCES job_group (seq)
);

-- ALTER TABLE group
--   ADD FOREIGN KEY (members) REFERENCES group_user (group_seq);
--
-- ALTER TABLE user
--   ADD FOREIGN KEY join_groups REFERENCES group_user(user_seq);

ALTER TABLE authorities
  ADD FOREIGN KEY (user_seq) REFERENCES  job_user(seq)