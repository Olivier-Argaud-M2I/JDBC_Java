CREATE TABLE `todobis` (
                           `id` int NOT NULL AUTO_INCREMENT,
                           `nom` text,
                           `description` text,
                           `date` datetime DEFAULT NULL,
                           PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci