-- CREATE DATABASE `ielts_practice`

CREATE TABLE `cambridge_listening_article` (
                                               `id` int NOT NULL,
                                               `book_num` int DEFAULT NULL,
                                               `part_num` int DEFAULT NULL,
                                               `test_num` int DEFAULT NULL,
                                               `video_path` varchar(255) DEFAULT NULL,
                                               PRIMARY KEY (`id`)
);

CREATE TABLE `cambridge_listening_item` (
                                            `id` int NOT NULL,
                                            `article_id` int DEFAULT NULL,
                                            `chinese` varchar(4096) DEFAULT NULL,
                                            `end_time` bigint DEFAULT NULL,
                                            `english` varchar(4096) DEFAULT NULL,
                                            `item_type` tinyint DEFAULT NULL,
                                            `start_time` bigint DEFAULT NULL,
                                            PRIMARY KEY (`id`)
);