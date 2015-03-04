-- --------------------------------------------------------
-- Хост:                         127.0.0.1
-- Версия сервера:               5.6.19 - MySQL Community Server (GPL)
-- ОС Сервера:                   Win64
-- HeidiSQL Версия:              8.3.0.4694
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Дамп структуры базы данных shopbase
CREATE DATABASE IF NOT EXISTS `shopbase` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `shopbase`;


-- Дамп структуры для таблица shopbase.blacklist
CREATE TABLE IF NOT EXISTS `blacklist` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `user` varchar(50) DEFAULT NULL,
  `ban` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_blacklist_user` (`user`),
  CONSTRAINT `FK_blacklist_user` FOREIGN KEY (`user`) REFERENCES `user` (`Login`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

-- Дамп данных таблицы shopbase.blacklist: ~2 rows (приблизительно)
/*!40000 ALTER TABLE `blacklist` DISABLE KEYS */;
REPLACE INTO `blacklist` (`ID`, `user`, `ban`) VALUES
	(19, 'user2', 'true'),
	(20, 'user5', 'true');
/*!40000 ALTER TABLE `blacklist` ENABLE KEYS */;


-- Дамп структуры для таблица shopbase.category
CREATE TABLE IF NOT EXISTS `category` (
  `id` int(11) NOT NULL,
  `categoryName` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Дамп данных таблицы shopbase.category: ~6 rows (приблизительно)
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
REPLACE INTO `category` (`id`, `categoryName`) VALUES
	(1, 'Мобильные телефоны'),
	(2, 'Фотоаппараты'),
	(3, 'Планшеты'),
	(4, 'Ноутбуки'),
	(5, 'Электронные книги'),
	(6, 'MP3-плееры'),
	(7, 'Игровые приставки');
/*!40000 ALTER TABLE `category` ENABLE KEYS */;


-- Дамп структуры для таблица shopbase.goods
CREATE TABLE IF NOT EXISTS `goods` (
  `number_goods` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `product_name` varchar(100) DEFAULT NULL,
  `category_number` int(11) NOT NULL,
  `description` text,
  `price` int(11) DEFAULT NULL,
  `img` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`number_goods`),
  KEY `FK_goods_category` (`category_number`),
  KEY `product_name` (`product_name`),
  CONSTRAINT `FK_goods_category` FOREIGN KEY (`category_number`) REFERENCES `category` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- Дамп данных таблицы shopbase.goods: ~11 rows (приблизительно)
/*!40000 ALTER TABLE `goods` DISABLE KEYS */;
REPLACE INTO `goods` (`number_goods`, `product_name`, `category_number`, `description`, `price`, `img`) VALUES
	(1, 'Смартфон HTC One (M8) (16Gb)', 1, '					Флагман от компании HTC в первой половине 2014 года. Пришел на смену HTC One.\r\nАппарат получил косметические изменения — сенсорные клавиши стали частью экрана, а корпус из металла более матовым. Диагональ экрана увеличилась и теперь составляет 5". Камера в смартфоне осталась с тем же разрешением пикселя, но сам модуль стал двойным, появилась вспышка двух цветов и новый чип по обработке снимков HTC ImageChip 2. На лицевой панели камера теперь 5Мп, никуда не делись и стереодинамики.\r\n					\r\n					\r\n					', 700, '/images/goods/HTConeM8.jpg'),
	(2, 'Canon EOS 1100D Kit 18-55mm III', 2, 'Canon EOS 1100D — зеркальная камера начального уровня. От других зеркалок EOS модель отличается самой низкой ценой, но при этом наиболее простыми техническими характеристиками и возможностями съемки. В первую очередь устройство будет интересно начинающим фотографам.', 100, '/images/goods/canon1100.jpg'),
	(4, 'Смартфон Apple iPhone 6 (16Gb)', 1, '					Cмартфон от компании Apple 2014 года — iPhone 6. Корпус стал тоньше, а кнопка включения сместилась на правую грань. Дисплей увеличился до 4.7".\r\n\r\nСмартфон получил новый 64-битный процессор второго поколения Apple A8 с сопроцессором M8, который теперь имеет возможность следить за изменением высоты. Поддерживает VoLTE и подключение к интернету через LTE на скорости до 150 Мбит/с. Улучшилась камера, для замедленных видео появилась съемка 240 кадров в секунду, панораму можно снять в разрешении 43 Мп.\r\n					', 1000, '/images/goods/iphone6.jpg'),
	(5, 'Canon EOS 5D Mark III Body', 2, 'Полнокадровая цифровая зеркальная камера, предназначенная для опытных любителей, профессиональных фотографов и видеооператоров. Преемник успешной модели EOS 5D Mark II. Фотоаппарат имеет 22.3 Мп. CMOS-сенсор размером 36 х 24 мм, 14-битный процессор DIGIC 5+, 61-точечный автофокус. Для контроля за съемкой используется большой экран 3.2" с разрешением 1040000 пикселей и оптический видоискатель со 100% покрытием кадра. Диапазон обрабатываемой камерой чувствительности составляет 100–102400 ISO, режим серийной съемки со скоростью 6 кадров/сек. Камера умеет снимать видео в формате Full-HD с полным ручным управлением — от частоты кадров до звуковой дорожки, что делает ее мощным инструментом даже для профессиональной съемки видеороликов. Имеется два слота для карт памяти CF и SD. Корпус выполнен из магниевого сплава. Комплект без объектива.', 2000, '/images/goods/cannon5dmark3.jpg'),
	(6, 'Планшет Xiaomi Mi Pad 7.9 Mi515 16GB White', 3, '7.9 - дюймовый планшет, снабженный IPS матрицей с разрешением 2048 x 1536 точек, 2GB оперативной памяти, пластиковым корпусом и четырехъядерным процессором от NVIDIA Tegra K1. Работает устройство под управлением операционной системы Android 4.4.', 380, '/images/goods/XiaomiMiPad.jpg'),
	(7, 'Amazon Kindle Paperwhite', 5, 'Обновленная модель электронной книги Paperwhite от компании Amazon. Среди улучшений: новый процессор, новый высококонтрастный дисплей, подсветка следующего поколения. Также изменения коснулись программной части устройства. Среди них интеграция с сервисом Goodreaders (самое большое мировое сообщество любителей книг). Kindle FreeTime - предоставляет простую возможность для родителей по развитию читательского интереса у детей.', 150, '/images/goods/AmazonKindle2.jpg'),
	(8, 'Ноутбук Lenovo B590', 4, 'Обновленная версия бюджетного ноутбука. Аппарат имеет характерный угловатый дизайн, оснащен процессором Intel третьего поколения, встроенной или переключаемой (бюджетного класса) видеокартой, стандартным набором интерфейсов и портов.', 600, '/images/goods/LenovoB590.jpg'),
	(9, 'Ноутбук Apple MacBook Air 13"', 4, 'Обновленная старшая модель популярного устройства от компании Apple. Ноутбук получил процессор Intel четвертого поколения, твердотельный накопитель и увеличенное время автономной работы.\r\nПроизводитель: Apple Inc. 1 Infinite Loop Cupertino, CA 95014.', 1500, '/images/goods/AppleMacBookAir13.jpg'),
	(10, 'MP3 плеер Apple iPod touch 32Gb (5th generation)', 6, 'Поддержка аудио форматов  MP3, AAC, Audible, Apple Lossless, WAV, AIFF\r\nОбъем памяти 32 ГБ\r\nВерсия операционной системы iOS 6\r\nРазмер экрана 4\r\nВстроенная камера 2\r\nКоличество точек матрицы 5 Мп', 300, '/images/goods/IpodTouch.jpg'),
	(11, 'Игровая приставка Microsoft Xbox 360 E 250GB', 7, 'Обновленная версия Xbox 360 E имеет переработанный дизайн и иное расположение портов.\r\n\r\nПользователям Xbox LIVE Gold будут доступны бесплатно игры для платформы текущего поколения. Halo 3 и Assassin\'s Creed 2 станут первыми среди них, но далеко не последними.', 300, '/images/goods/xbox360E.jpg'),
	(12, 'Игровая приставка Microsoft Xbox One', 7, 'Американская корпорация Microsoft представила новую версию своей игровой консоли Xbox One. Устройством можно управлять голосом, оно оснащено такими функциями, как Skype и интерактивным телевидением. Также представлен новый контроллер Kinect. Xbox One представляет собой универсальную развлекательную систему, объединяющую игры, музыку, фильмы и ТВ. Унифицированный программная платформа сочетает код ядра Windows Phone, Xbox и Windows 8.', 400, '/images/goods/XBOxOne.jpg');
/*!40000 ALTER TABLE `goods` ENABLE KEYS */;


-- Дамп структуры для таблица shopbase.order_info
CREATE TABLE IF NOT EXISTS `order_info` (
  `number_order` int(11) NOT NULL AUTO_INCREMENT,
  `sum` varchar(20) DEFAULT NULL,
  `date_order` varchar(50) DEFAULT NULL,
  `quantity_goods` int(11) NOT NULL,
  `login_customer` varchar(50) NOT NULL,
  `name_goods` varchar(50) NOT NULL,
  `payment` enum('Y','N') NOT NULL DEFAULT 'N',
  PRIMARY KEY (`number_order`),
  KEY `user` (`login_customer`),
  CONSTRAINT `FK_order_info_user` FOREIGN KEY (`login_customer`) REFERENCES `user` (`Login`)
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=utf8;

-- Дамп данных таблицы shopbase.order_info: ~12 rows (приблизительно)
/*!40000 ALTER TABLE `order_info` DISABLE KEYS */;
REPLACE INTO `order_info` (`number_order`, `sum`, `date_order`, `quantity_goods`, `login_customer`, `name_goods`, `payment`) VALUES
	(19, '200', '02.02.2015', 1, 'user3', 'Смартфон HTC One (M8) (16Gb)', 'Y'),
	(21, '200', '02.02.2015', 1, 'user4', 'Смартфон HTC One (M8) (16Gb)', 'Y'),
	(22, '6000', '02.02.2015', 6, 'user4', 'Смартфон Apple iPhone 6 (16Gb)', 'Y'),
	(29, '200', '02.02.2015', 1, 'user1', 'Смартфон HTC One (M8) (16Gb)', 'Y'),
	(30, '6000', '02.02.2015', 6, 'user3', 'Смартфон Apple iPhone 6 (16Gb)', 'Y'),
	(31, '1000', '02.02.2015', 1, 'user3', 'Смартфон Apple iPhone 6 (16Gb)', 'Y'),
	(32, '200', '02.02.2015', 1, 'user3', 'Смартфон HTC One (M8) (16Gb)', 'Y'),
	(33, '200', '02.02.2015', 1, 'user3', 'Смартфон HTC One (M8) (16Gb)', 'Y'),
	(34, '1000', '08.02.2015', 1, 'user3', 'Смартфон HTC One (M8) (16Gb)', 'Y'),
	(35, '700', '09.02.2015', 1, 'user1', 'Смартфон HTC One (M8) (16Gb)', 'Y'),
	(36, '2000', '09.02.2015', 1, 'user6', 'Canon EOS 5D Mark III Body', 'Y'),
	(37, '100', '09.02.2015', 1, 'user4', 'Canon EOS 1100D Kit 18-55mm III', 'Y'),
	(38, '700', '11.02.2015', 1, 'user4', 'Смартфон HTC One (M8) (16Gb)', 'Y'),
	(39, '5600', '13.02.2015', 8, 'user1', 'Смартфон HTC One (M8) (16Gb)', 'Y');
/*!40000 ALTER TABLE `order_info` ENABLE KEYS */;


-- Дамп структуры для таблица shopbase.user
CREATE TABLE IF NOT EXISTS `user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `login` varchar(20) NOT NULL,
  `password` varchar(20) DEFAULT NULL,
  `role` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`login`),
  KEY `ID` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- Дамп данных таблицы shopbase.user: ~10 rows (приблизительно)
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
REPLACE INTO `user` (`user_id`, `login`, `password`, `role`) VALUES
	(1, 'user1', 'user1', 'admin'),
	(11, 'user11', 'user11', 'user'),
	(2, 'user2', 'user2', 'user'),
	(3, 'user3', 'user3', 'user'),
	(4, 'user4', 'user4', 'user'),
	(5, 'user5', 'user5', 'user'),
	(6, 'user6', 'user6', 'user'),
	(8, 'user7', 'user7', 'user'),
	(9, 'user8', 'user8', 'admin'),
	(10, 'user9', 'user9', 'user');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;


-- Дамп структуры для таблица shopbase.user_description
CREATE TABLE IF NOT EXISTS `user_description` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(50) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `last_name` varchar(50) DEFAULT NULL,
  `telephone` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `FK_user_description_user` FOREIGN KEY (`id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- Дамп данных таблицы shopbase.user_description: ~7 rows (приблизительно)
/*!40000 ALTER TABLE `user_description` DISABLE KEYS */;
REPLACE INTO `user_description` (`id`, `first_name`, `email`, `last_name`, `telephone`) VALUES
	(1, 'Романов', 'romanov@gmail.com', 'Евгений', 7636732),
	(2, 'Петров', 'petrov@gmail.com', 'Петр', 1265462),
	(3, 'Иванов', 'ivanov@gmail.com', 'Иван', 6564637),
	(4, 'Сидоров', 'sidor@gmail.com', 'Дима', 6754365),
	(5, 'Бабаев', 'bb@gmail.com', 'Николай', 2465346),
	(6, 'Мамаев', 'mama@gmail.com', 'Генадий', 3142711),
	(8, 'Андреев', 'andrey@gmail.com', 'Антон', 1524361);
/*!40000 ALTER TABLE `user_description` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
