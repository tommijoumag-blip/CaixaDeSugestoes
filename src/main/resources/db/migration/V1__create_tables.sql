CREATE TABLE courses (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL UNIQUE
);
CREATE TABLE categories (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL UNIQUE
);
CREATE TABLE suggestions (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    title TEXT NOT NULL,
    content TEXT NOT NULL,
    author TEXT,
    created_at TIMESTAMP(6) NOT NULL,
    course_id BIGINT NOT NULL,
    category_id BIGINT NOT NULL,
    FOREIGN KEY (course_id) REFERENCES courses(id),
    FOREIGN KEY (category_id) REFERENCES categories(id)
);
CREATE INDEX suggestions_course_idx ON suggestions(course_id);
CREATE INDEX suggestions_category_idx ON suggestions(category_id);
CREATE INDEX suggestions_created_idx ON suggestions(created_at DESC, id DESC);