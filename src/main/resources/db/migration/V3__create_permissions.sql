CREATE TABLE t_user (
                        id SERIAL PRIMARY KEY,
                        name TEXT NOT NULL,
                        email TEXT NOT NULL,
                        password TEXT NOT NULL
);

CREATE TABLE t_permission (
                              id BIGSERIAL PRIMARY KEY,
                              name VARCHAR(255) NOT NULL
);

CREATE TABLE t_user_permissions (
                                    user_id BIGINT NOT NULL,
                                    permissions_id BIGINT NOT NULL,
                                    PRIMARY KEY (user_id, permissions_id),

                                    CONSTRAINT fk_user_permissions_user
                                        FOREIGN KEY (user_id) REFERENCES t_user(id) ON DELETE CASCADE,

                                    CONSTRAINT fk_user_permissions_permission
                                        FOREIGN KEY (permissions_id) REFERENCES t_permission(id) ON DELETE CASCADE
);