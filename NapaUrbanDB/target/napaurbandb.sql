-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 20-04-2023 a las 21:44:14
-- Versión del servidor: 10.4.24-MariaDB
-- Versión de PHP: 8.1.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `napaurbandb`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `clientes`
--

CREATE TABLE `clientes` (
  `id-cliente` int(11) NOT NULL,
  `email` varchar(255) NOT NULL,
  `compras` int(3) DEFAULT NULL,
  `gastado` int(7) DEFAULT NULL COMMENT 'dinero gastado en total'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `clientes`
--

INSERT INTO `clientes` (`id-cliente`, `email`, `compras`, `gastado`) VALUES
(5, 'test@test.com', NULL, NULL),
(13, 'francocabreradev@gmail.com', NULL, NULL),
(14, '', NULL, NULL),
(15, 'natypapalia@yahoo.com.ar', NULL, NULL),
(16, 'test2@test.com', NULL, NULL),
(17, 'asd', 14, 16);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `factura_venta`
--

CREATE TABLE `factura_venta` (
  `id-factura` int(255) NOT NULL,
  `id-cliente` int(255) NOT NULL,
  `nombre-producto` varchar(255) NOT NULL,
  `precio-unitario` int(11) NOT NULL,
  `cantidad` int(5) NOT NULL,
  `precio-final` int(11) NOT NULL,
  `id-tipo_de_pago` int(40) NOT NULL,
  `id-vendedora` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `factura_venta`
--

INSERT INTO `factura_venta` (`id-factura`, `id-cliente`, `nombre-producto`, `precio-unitario`, `cantidad`, `precio-final`, `id-tipo_de_pago`, `id-vendedora`) VALUES
(2, 14, '6', 1500, 1, 1500, 1, 2),
(3, 5, '8', 3600, 1, 3600, 1, 2),
(4, 5, '6', 1500, 1, 1500, 1, 2),
(14, 5, '6', 1500, 1, 1500, 1, 2),
(15, 5, 'remerita to linda to bella', 1500, 1, 1500, 1, 2),
(16, 5, 'KArsadian ts', 3600, 3, 10800, 1, 2),
(17, 5, 'KArsadian ts', 3600, 3, 10800, 1, 2),
(18, 5, 'KArsadian ts', 3600, 3, 10800, 1, 2),
(19, 15, 'KArsadian ts', 3600, 2, 7400, 1, 4),
(20, 15, 'Wolf', 3800, 2, 7400, 1, 4),
(21, 17, 'test', 4000, 1, 4000, 1, 2),
(22, 17, 'tes', 1, 1, 1, 1, 2),
(23, 17, 'test', 1, 1, 1, 1, 2),
(24, 17, 'test', 1, 2, 2, 1, 2),
(25, 17, 'test', 1, 2, 2, 1, 2),
(26, 17, 'test', 1, 1, 1, 1, 4),
(27, 5, 'error', -1, 1, 1500, 1, 2),
(28, 5, 'error', -1, 1, 1500, 1, 2),
(29, 5, 'test', 1500, 1, 1500, 1, 2),
(30, 5, 'error', -1, 1, 1500, 1, 2),
(31, 14, 'test', 1500, 1, 1500, 1, 2),
(32, 14, 'test', 1, 1, 1, 1, 2),
(33, 14, 'test', 1, 1, 1, 1, 2),
(34, 14, 'test', 1, 1, 1, 1, 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `proveedores`
--

CREATE TABLE `proveedores` (
  `id-proveedor` int(10) NOT NULL,
  `nombre` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `proveedores`
--

INSERT INTO `proveedores` (`id-proveedor`, `nombre`) VALUES
(5, 'De Los Cojones'),
(6, 'St. Marie'),
(7, 'tuerelinda comolapapaya'),
(8, 'District'),
(9, 'Felisa'),
(10, 'Valvinna');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `stock`
--

CREATE TABLE `stock` (
  `id-stock` varchar(255) NOT NULL,
  `nombre` varchar(255) NOT NULL,
  `tipo` varchar(20) NOT NULL,
  `color` varchar(40) NOT NULL,
  `talle` varchar(40) NOT NULL,
  `id-proveedor` int(40) NOT NULL,
  `precio_unitario` int(10) NOT NULL,
  `precio_original` int(6) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `stock`
--

INSERT INTO `stock` (`id-stock`, `nombre`, `tipo`, `color`, `talle`, `id-proveedor`, `precio_unitario`, `precio_original`) VALUES
('18', 'test', 'Remera', 'test', 'test', 5, 1, 1),
('19', 'Remera a rayas', 'Remera', 'Negro', 'L', 5, 3800, 2000),
('20', 'Remera a rayas', 'Remera', 'Negro', 'L', 5, 3800, 2000),
('21', 'Remera a rayas', 'Remera', 'Negro', 'L', 5, 3800, 2000),
('22', 'Remera a rayas', 'Remera', 'Negro', 'L', 5, 3800, 2000),
('23', 'Remera a rayas', 'Remera', 'Negro', 'L', 5, 3800, 2000),
('24', 'Remera a rayas', 'Remera', 'Negro', 'L', 5, 3800, 2000);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipo_de_pago`
--

CREATE TABLE `tipo_de_pago` (
  `id` int(40) NOT NULL,
  `nombre` varchar(40) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `tipo_de_pago`
--

INSERT INTO `tipo_de_pago` (`id`, `nombre`) VALUES
(1, 'Mercado Pago');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `vendedores`
--

CREATE TABLE `vendedores` (
  `id-vendedora` int(10) NOT NULL,
  `nombre` varchar(20) NOT NULL,
  `ventas` int(11) DEFAULT NULL,
  `dineroGenerado` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `vendedores`
--

INSERT INTO `vendedores` (`id-vendedora`, `nombre`, `ventas`, `dineroGenerado`) VALUES
(2, 'Naty', NULL, 23418),
(3, 'Pelusa', NULL, 0),
(4, 'patata', 2, 7401);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `vendido`
--

CREATE TABLE `vendido` (
  `id` varchar(255) NOT NULL,
  `nombre` varchar(255) NOT NULL,
  `tipo` varchar(40) NOT NULL,
  `color` varchar(40) NOT NULL,
  `talle` varchar(5) NOT NULL,
  `id-proveedor` int(10) NOT NULL,
  `precio_unitario` int(6) NOT NULL,
  `precio_original` int(6) NOT NULL,
  `fecha` date NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `vendido`
--

INSERT INTO `vendido` (`id`, `nombre`, `tipo`, `color`, `talle`, `id-proveedor`, `precio_unitario`, `precio_original`, `fecha`) VALUES
('13', 'tes', 'Remera', 'test', 'test', 5, 1, 1, '2022-12-31'),
('15', 'test', 'Remera', 'test', 'test', 5, 1, 1, '2022-12-31'),
('16', 'test', 'Remera', 'test', 'test', 5, 1, 1, '2022-12-31'),
('17', 'test', 'Remera', 'test', 'test', 5, 1, 1, '2022-12-31'),
('asdasda', 'test', 'Remera', 'test', 'test', 5, 1, 1, '2023-04-20'),
('K3213I53', 'test', 'Remera', 'test', 'test', 5, 1, 1, '2023-04-20'),
('K8103I23', 'test', 'Remera', 'test', 'test', 5, 1500, 1000, '2023-04-20');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `clientes`
--
ALTER TABLE `clientes`
  ADD PRIMARY KEY (`id-cliente`),
  ADD UNIQUE KEY `email` (`email`);

--
-- Indices de la tabla `factura_venta`
--
ALTER TABLE `factura_venta`
  ADD PRIMARY KEY (`id-factura`),
  ADD KEY `id-cliente` (`id-cliente`),
  ADD KEY `id-stock` (`nombre-producto`),
  ADD KEY `id-tipo_de_pago` (`id-tipo_de_pago`),
  ADD KEY `id-vendedora` (`id-vendedora`);

--
-- Indices de la tabla `proveedores`
--
ALTER TABLE `proveedores`
  ADD PRIMARY KEY (`id-proveedor`);

--
-- Indices de la tabla `stock`
--
ALTER TABLE `stock`
  ADD PRIMARY KEY (`id-stock`),
  ADD KEY `id-marca` (`id-proveedor`);

--
-- Indices de la tabla `tipo_de_pago`
--
ALTER TABLE `tipo_de_pago`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `vendedores`
--
ALTER TABLE `vendedores`
  ADD PRIMARY KEY (`id-vendedora`);

--
-- Indices de la tabla `vendido`
--
ALTER TABLE `vendido`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `clientes`
--
ALTER TABLE `clientes`
  MODIFY `id-cliente` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;

--
-- AUTO_INCREMENT de la tabla `factura_venta`
--
ALTER TABLE `factura_venta`
  MODIFY `id-factura` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=35;

--
-- AUTO_INCREMENT de la tabla `proveedores`
--
ALTER TABLE `proveedores`
  MODIFY `id-proveedor` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT de la tabla `tipo_de_pago`
--
ALTER TABLE `tipo_de_pago`
  MODIFY `id` int(40) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `vendedores`
--
ALTER TABLE `vendedores`
  MODIFY `id-vendedora` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `factura_venta`
--
ALTER TABLE `factura_venta`
  ADD CONSTRAINT `factura_venta_ibfk_2` FOREIGN KEY (`id-cliente`) REFERENCES `clientes` (`id-cliente`),
  ADD CONSTRAINT `factura_venta_ibfk_3` FOREIGN KEY (`id-tipo_de_pago`) REFERENCES `tipo_de_pago` (`id`),
  ADD CONSTRAINT `factura_venta_ibfk_4` FOREIGN KEY (`id-vendedora`) REFERENCES `vendedores` (`id-vendedora`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `stock`
--
ALTER TABLE `stock`
  ADD CONSTRAINT `stock_ibfk_1` FOREIGN KEY (`id-proveedor`) REFERENCES `proveedores` (`id-proveedor`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
