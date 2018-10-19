-- phpMyAdmin SQL Dump
-- version 4.0.10.15
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generación: 10-10-2018 a las 10:09:32
-- Versión del servidor: 5.6.41-log
-- Versión de PHP: 5.2.17

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `c1380841_sanfran`
--
CREATE DATABASE IF NOT EXISTS `c1380841_sanfran` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `c1380841_sanfran`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `categorias`
--

DROP TABLE IF EXISTS `categorias`;
CREATE TABLE IF NOT EXISTS `categorias` (
  `idCategorias` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(100) NOT NULL,
  `idEstado` int(11) NOT NULL,
  `fechaAlta` datetime NOT NULL,
  `fechaModificacion` datetime DEFAULT NULL,
  `fechaVaja` datetime DEFAULT NULL,
  PRIMARY KEY (`idCategorias`),
  KEY `estados_categorias_fk` (`idEstado`),
  KEY `idcategorias` (`idCategorias`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=9 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `codigocostovehiculo`
--

DROP TABLE IF EXISTS `codigocostovehiculo`;
CREATE TABLE IF NOT EXISTS `codigocostovehiculo` (
  `idCodigoCostoVehiculo` int(11) NOT NULL AUTO_INCREMENT,
  `idEstado` int(11) NOT NULL,
  `fechaAlta` datetime NOT NULL,
  `fechaModificacion` datetime DEFAULT NULL,
  `fechaBaja` datetime DEFAULT NULL,
  `fecha` datetime NOT NULL,
  PRIMARY KEY (`idCodigoCostoVehiculo`),
  KEY `estados_codigocostovehiculo_fk` (`idEstado`),
  KEY `idCodigoCostoVehiculo` (`idCodigoCostoVehiculo`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=99 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `color`
--

DROP TABLE IF EXISTS `color`;
CREATE TABLE IF NOT EXISTS `color` (
  `idColor` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(50) NOT NULL,
  `fechaAlta` datetime NOT NULL,
  `fechaModificacion` datetime DEFAULT NULL,
  `fechaBaka` datetime DEFAULT NULL,
  `idEstado` int(11) NOT NULL,
  PRIMARY KEY (`idColor`),
  KEY `estados_color_fk` (`idEstado`),
  KEY `idcolor` (`idColor`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=10 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `comisiones`
--

DROP TABLE IF EXISTS `comisiones`;
CREATE TABLE IF NOT EXISTS `comisiones` (
  `idComision` int(11) NOT NULL AUTO_INCREMENT,
  `idVentasDet` bigint(20) NOT NULL,
  `idInsumo` int(11) NOT NULL,
  `porcentaje` decimal(10,2) NOT NULL,
  PRIMARY KEY (`idComision`),
  KEY `insumos_comisiones_fk` (`idInsumo`),
  KEY `ventasdet_comisiones_fk` (`idVentasDet`),
  KEY `idcomisiones` (`idComision`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `comisionista`
--

DROP TABLE IF EXISTS `comisionista`;
CREATE TABLE IF NOT EXISTS `comisionista` (
  `idComisionista` int(11) NOT NULL AUTO_INCREMENT,
  `cuit` varchar(50) NOT NULL,
  `descripcion` varchar(100) NOT NULL,
  `celular` varchar(20) NOT NULL,
  `telefono` varchar(20) NOT NULL,
  `domicilio` varchar(150) NOT NULL,
  `email` varchar(30) NOT NULL,
  `saldo` decimal(10,2) NOT NULL,
  `saldoInicial` decimal(10,2) NOT NULL,
  `idEstado` int(11) NOT NULL,
  `fechaAlta` datetime NOT NULL,
  `fechaBaja` datetime DEFAULT NULL,
  `fechaModificacion` datetime DEFAULT NULL,
  PRIMARY KEY (`idComisionista`),
  KEY `estados_comisionista_fk` (`idEstado`),
  KEY `idcomisionista` (`idComisionista`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=35 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `condicion`
--

DROP TABLE IF EXISTS `condicion`;
CREATE TABLE IF NOT EXISTS `condicion` (
  `idCondicion` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(50) NOT NULL,
  `idEstado` int(11) NOT NULL,
  `fechaAlta` datetime NOT NULL,
  `fechaBaja` datetime DEFAULT NULL,
  `fechaModificacion` datetime DEFAULT NULL,
  PRIMARY KEY (`idCondicion`),
  KEY `estados_condicion_fk` (`idEstado`),
  KEY `idcondicion` (`idCondicion`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `conductor`
--

DROP TABLE IF EXISTS `conductor`;
CREATE TABLE IF NOT EXISTS `conductor` (
  `idConductor` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(60) NOT NULL,
  `apellido` varchar(60) NOT NULL,
  `cuit` varchar(20) NOT NULL,
  `dni` varchar(20) NOT NULL,
  `fechaNac` date NOT NULL,
  `celular` varchar(20) NOT NULL,
  `telefono` varchar(20) NOT NULL,
  `fechaAlta` datetime DEFAULT NULL,
  `fechaModificacion` datetime DEFAULT NULL,
  `fechaIngreso` date DEFAULT NULL,
  `fechaBaja` datetime DEFAULT NULL,
  `idOperadora` int(11) NOT NULL,
  `idUsuario` int(11) NOT NULL,
  `idEstado` int(11) NOT NULL,
  PRIMARY KEY (`idConductor`),
  KEY `estados_conductor_fk` (`idEstado`),
  KEY `operadoras_conductor_fk` (`idOperadora`),
  KEY `usuarios_conductor_fk` (`idUsuario`),
  KEY `idconductor` (`idConductor`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=8 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `consignatario`
--

DROP TABLE IF EXISTS `consignatario`;
CREATE TABLE IF NOT EXISTS `consignatario` (
  `idConsignatario` int(11) NOT NULL AUTO_INCREMENT,
  `cuit` varchar(30) NOT NULL,
  `descripcion` varchar(50) NOT NULL,
  `celular` varchar(20) NOT NULL,
  `telefono` varchar(50) NOT NULL,
  `domicilio` varchar(100) NOT NULL,
  `email` varchar(50) NOT NULL,
  `fechaAlta` datetime NOT NULL,
  `fechaModificacion` datetime DEFAULT NULL,
  `fechaBaja` datetime DEFAULT NULL,
  `idEstado` int(11) NOT NULL,
  PRIMARY KEY (`idConsignatario`),
  KEY `estados_consignatario_fk` (`idEstado`),
  KEY `idconsignatario` (`idConsignatario`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=21 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `costovehiculo`
--

DROP TABLE IF EXISTS `costovehiculo`;
CREATE TABLE IF NOT EXISTS `costovehiculo` (
  `idCostoVehiculo` int(11) NOT NULL AUTO_INCREMENT,
  `idInsumo` int(11) NOT NULL,
  `cantidad` decimal(10,2) NOT NULL,
  `precio` decimal(10,2) NOT NULL,
  `fechaAlta` datetime DEFAULT NULL,
  `fechaModificacion` datetime DEFAULT NULL,
  `fechaBaja` datetime DEFAULT NULL,
  `idEstado` int(11) NOT NULL,
  `idMovil` int(11) NOT NULL DEFAULT '1',
  `idCodigoCostoVehiculo` int(11) NOT NULL DEFAULT '1',
  `fechaCompra` date DEFAULT NULL,
  PRIMARY KEY (`idCostoVehiculo`),
  KEY `fk_costovehiculo_estados` (`idEstado`),
  KEY `fk_costovehiculo_insumo` (`idInsumo`),
  KEY `idcostovehiculo` (`idCostoVehiculo`),
  KEY `fk_costovehiculo_idmovil` (`idMovil`),
  KEY `fk_costovehiculo_codigocostovehiculo` (`idCodigoCostoVehiculo`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=106 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `costovehiculodet`
--

DROP TABLE IF EXISTS `costovehiculodet`;
CREATE TABLE IF NOT EXISTS `costovehiculodet` (
  `idCostoVehiculoDet` int(11) NOT NULL AUTO_INCREMENT,
  `idCostoVehiculo` int(11) NOT NULL,
  `idImpuesto` int(11) NOT NULL,
  `saldo` decimal(10,2) NOT NULL,
  `fechaAlta` datetime DEFAULT NULL,
  `fechaModificacion` datetime DEFAULT NULL,
  `fechaBaja` datetime DEFAULT NULL,
  `idEstado` int(11) NOT NULL,
  PRIMARY KEY (`idCostoVehiculoDet`),
  KEY `fk_costovehiculodet_costovehiculo` (`idCostoVehiculo`),
  KEY `fk_costovehiculodet_impuesto` (`idImpuesto`),
  KEY `fk_costovehiculodet_estados` (`idEstado`),
  KEY `idcostovehiculodet` (`idCostoVehiculoDet`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=363 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cueros`
--

DROP TABLE IF EXISTS `cueros`;
CREATE TABLE IF NOT EXISTS `cueros` (
  `idCueros` int(11) NOT NULL AUTO_INCREMENT,
  `idUsuario` int(11) NOT NULL,
  `fechaAlta` datetime NOT NULL,
  `fechaBaja` datetime DEFAULT NULL,
  `fechaModificacion` datetime DEFAULT NULL,
  `idEstado` int(11) NOT NULL,
  PRIMARY KEY (`idCueros`),
  KEY `estados_cueros_fk` (`idEstado`),
  KEY `usuarios_cueros_fk` (`idUsuario`),
  KEY `idcueros` (`idCueros`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cuerosdet`
--

DROP TABLE IF EXISTS `cuerosdet`;
CREATE TABLE IF NOT EXISTS `cuerosdet` (
  `idCuerosDet` int(11) NOT NULL AUTO_INCREMENT,
  `idCueros` int(11) NOT NULL,
  `idInsumo` int(11) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `cantidad` decimal(10,2) NOT NULL,
  `subtotal` decimal(10,2) NOT NULL,
  `precio` decimal(10,2) NOT NULL,
  `fechaAlta` datetime NOT NULL,
  `fechaBaja` datetime DEFAULT NULL,
  `fechaModificacion` datetime DEFAULT NULL,
  `idEstado` int(11) NOT NULL,
  PRIMARY KEY (`idCuerosDet`),
  KEY `cueros_cuerosdet_fk` (`idCueros`),
  KEY `estados_cuerosdet_fk` (`idEstado`),
  KEY `insumos_cuerosdet_fk` (`idInsumo`),
  KEY `idcuerosdet` (`idCuerosDet`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `despostecab`
--

DROP TABLE IF EXISTS `despostecab`;
CREATE TABLE IF NOT EXISTS `despostecab` (
  `idDesposte` int(11) NOT NULL AUTO_INCREMENT,
  `idUsuario` int(11) NOT NULL,
  `fechaAlta` datetime NOT NULL,
  `fechaBaja` datetime DEFAULT NULL,
  `fechaModificacion` datetime DEFAULT NULL,
  `idEstado` int(11) NOT NULL,
  PRIMARY KEY (`idDesposte`),
  KEY `estados_despostecab_fk` (`idEstado`),
  KEY `usuarios_despostecab_fk` (`idUsuario`),
  KEY `iddesposte` (`idDesposte`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `despostedet`
--

DROP TABLE IF EXISTS `despostedet`;
CREATE TABLE IF NOT EXISTS `despostedet` (
  `idDesposteDet` int(11) NOT NULL AUTO_INCREMENT,
  `idDesposte` int(11) NOT NULL,
  `idInsumo` int(11) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `cantidad` decimal(10,2) NOT NULL,
  `subtotal` decimal(10,2) NOT NULL,
  `precio` decimal(10,2) NOT NULL,
  `fechaAlta` datetime NOT NULL,
  `fechaBaja` datetime DEFAULT NULL,
  `fechaModificacion` datetime DEFAULT NULL,
  `idEstado` int(11) NOT NULL,
  PRIMARY KEY (`idDesposteDet`),
  KEY `despostecab_despostedet_fk` (`idDesposte`),
  KEY `estados_despostedet_fk` (`idEstado`),
  KEY `insumos_despostedet_fk` (`idInsumo`),
  KEY `iddespostedet` (`idDesposteDet`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `documento`
--

DROP TABLE IF EXISTS `documento`;
CREATE TABLE IF NOT EXISTS `documento` (
  `idDocumento` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) NOT NULL,
  `idEstado` int(11) NOT NULL,
  `fechaAlta` datetime NOT NULL,
  `fechaModificacion` datetime DEFAULT NULL,
  `fechaBaja` datetime DEFAULT NULL,
  `descripcion` varchar(50) NOT NULL,
  PRIMARY KEY (`idDocumento`),
  KEY `documento_estado_fk` (`idEstado`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=39 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `dte`
--

DROP TABLE IF EXISTS `dte`;
CREATE TABLE IF NOT EXISTS `dte` (
  `idDte` int(11) NOT NULL AUTO_INCREMENT,
  `idOrigen` int(11) NOT NULL,
  `origen` varchar(100) NOT NULL,
  `idDestino` int(11) NOT NULL,
  `destino` varchar(100) NOT NULL,
  `tipoRenspa` varchar(50) NOT NULL,
  `idConductor` int(11) NOT NULL,
  `idMovil` int(11) NOT NULL,
  `cantidad` decimal(10,2) DEFAULT NULL,
  `especie` varchar(30) DEFAULT NULL,
  `peso` decimal(10,2) DEFAULT NULL,
  `entrega` decimal(10,2) NOT NULL,
  `total` decimal(10,2) NOT NULL,
  `ajustes` decimal(10,2) NOT NULL,
  `numTropa` varchar(50) DEFAULT NULL,
  `fechaCarga` date NOT NULL,
  `fechaVencimiento` date NOT NULL,
  `idConsignatario` int(11) NOT NULL,
  `idComisionista` int(11) NOT NULL,
  `idUsuario` int(11) NOT NULL,
  `idProductor` int(11) NOT NULL,
  `fechaAlta` datetime NOT NULL,
  `fechaBaja` datetime DEFAULT NULL,
  `fechaModificacion` datetime DEFAULT NULL,
  `idEstado` int(11) NOT NULL,
  `kmDep` decimal(10,2) DEFAULT NULL,
  `kmArr` decimal(10,2) DEFAULT NULL,
  `domJaula` varchar(20) DEFAULT NULL,
  `titular` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`idDte`),
  KEY `conductor_dte_fk` (`idConductor`),
  KEY `estados_dte_fk` (`idEstado`),
  KEY `movil_dte_fk` (`idMovil`),
  KEY `usuarios_dte_fk` (`idUsuario`),
  KEY `consignatario_dte_fk` (`idConsignatario`),
  KEY `comisionista_dte_fk` (`idComisionista`),
  KEY `productor_dte_fk` (`idProductor`),
  KEY `iddte` (`idDte`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=82 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `dtedet`
--

DROP TABLE IF EXISTS `dtedet`;
CREATE TABLE IF NOT EXISTS `dtedet` (
  `idDteDet` int(11) NOT NULL AUTO_INCREMENT,
  `idDte` int(11) NOT NULL,
  `idInsumo` int(11) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `cantidad` decimal(10,2) NOT NULL,
  `precio` decimal(10,2) NOT NULL,
  `subtotal` decimal(10,2) NOT NULL,
  `fechaAlta` datetime NOT NULL,
  `fechaBaja` datetime DEFAULT NULL,
  `fechaModificacion` datetime DEFAULT NULL,
  `idEstado` int(11) NOT NULL,
  PRIMARY KEY (`idDteDet`),
  KEY `dte_dtedet_fk` (`idDte`),
  KEY `estados_dtedet_fk` (`idEstado`),
  KEY `insumos_dtedet_fk` (`idInsumo`),
  KEY `iddtedet` (`idDteDet`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=164 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `dtedetcat`
--

DROP TABLE IF EXISTS `dtedetcat`;
CREATE TABLE IF NOT EXISTS `dtedetcat` (
  `idDteDetCat` int(11) NOT NULL AUTO_INCREMENT,
  `idDte` int(11) NOT NULL,
  `idCategorias` int(11) NOT NULL,
  `cantidad` int(11) NOT NULL,
  `ksVivo` decimal(10,2) NOT NULL,
  `precioKgVivo` decimal(10,2) NOT NULL,
  `porcComis` decimal(10,2) NOT NULL,
  `kgCarne` decimal(10,2) NOT NULL,
  `rendimiento` decimal(10,2) NOT NULL,
  `porcentaje` decimal(10,2) NOT NULL,
  `idEstado` int(11) NOT NULL,
  `fechaAlta` datetime NOT NULL,
  `fechaBaja` datetime DEFAULT NULL,
  `fechaModificacion` datetime DEFAULT NULL,
  PRIMARY KEY (`idDteDetCat`),
  KEY `categorias_dtedetcat_fk` (`idCategorias`),
  KEY `dte_dtedetcat_fk` (`idDte`),
  KEY `estados_dtedetcat_fk` (`idEstado`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=117 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `dtedetimp`
--

DROP TABLE IF EXISTS `dtedetimp`;
CREATE TABLE IF NOT EXISTS `dtedetimp` (
  `idDteDetImp` int(11) NOT NULL AUTO_INCREMENT,
  `idDte` int(11) NOT NULL,
  `idImpuesto` int(11) NOT NULL,
  `descripcion` varchar(50) NOT NULL,
  `saldo` decimal(10,2) NOT NULL,
  `fechaAlta` datetime NOT NULL,
  `fechaModificacion` datetime DEFAULT NULL,
  `fechaBaja` datetime DEFAULT NULL,
  `idEstado` int(11) NOT NULL,
  PRIMARY KEY (`idDteDetImp`),
  KEY `dte_dtedetimp_fk` (`idDte`),
  KEY `estados_dtedetimp_fk` (`idEstado`),
  KEY `impuestos_dtedetimp_fk` (`idImpuesto`),
  KEY `iddteimp` (`idDteDetImp`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=56 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `estados`
--

DROP TABLE IF EXISTS `estados`;
CREATE TABLE IF NOT EXISTS `estados` (
  `idEstado` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(50) NOT NULL,
  `fechaAlta` datetime NOT NULL,
  `fechaBaja` datetime DEFAULT NULL,
  `fechaModificacion` datetime DEFAULT NULL,
  PRIMARY KEY (`idEstado`),
  KEY `idestados` (`idEstado`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `estadosmovil`
--

DROP TABLE IF EXISTS `estadosmovil`;
CREATE TABLE IF NOT EXISTS `estadosmovil` (
  `idEstadoMovil` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(50) NOT NULL,
  `fechaAlta` datetime NOT NULL,
  `fechaModificacion` datetime DEFAULT NULL,
  `fechaBaja` datetime DEFAULT NULL,
  `idEstado` int(11) NOT NULL,
  PRIMARY KEY (`idEstadoMovil`),
  KEY `estados_estadosmovil_fk` (`idEstado`),
  KEY `idestadosmovil` (`idEstadoMovil`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=6 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `faena`
--

DROP TABLE IF EXISTS `faena`;
CREATE TABLE IF NOT EXISTS `faena` (
  `idFaena` int(11) NOT NULL AUTO_INCREMENT,
  `idUsuario` int(11) NOT NULL,
  `fechaAlta` datetime NOT NULL,
  `fechaBaja` datetime DEFAULT NULL,
  `fechaModificacion` datetime DEFAULT NULL,
  `idEstado` int(11) NOT NULL,
  PRIMARY KEY (`idFaena`),
  KEY `usuarios_faena_fk` (`idUsuario`),
  KEY `estados_faena_fk` (`idEstado`),
  KEY `idfaena` (`idFaena`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `faenadet`
--

DROP TABLE IF EXISTS `faenadet`;
CREATE TABLE IF NOT EXISTS `faenadet` (
  `idDetFaena` int(11) NOT NULL AUTO_INCREMENT,
  `idFaena` int(11) NOT NULL,
  `idInsumo` int(11) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `cantidad` decimal(10,2) NOT NULL,
  `precio` decimal(10,2) NOT NULL,
  `subTotal` decimal(10,2) NOT NULL,
  `fechaAlta` datetime NOT NULL,
  `fechaModificacion` datetime DEFAULT NULL,
  `fechaBaja` datetime DEFAULT NULL,
  `idEstado` int(11) NOT NULL,
  PRIMARY KEY (`idDetFaena`),
  KEY `estados_faenadet_fk` (`idEstado`),
  KEY `faena_faenadet_fk` (`idFaena`),
  KEY `insumos_faenadet_fk` (`idInsumo`),
  KEY `idfaenadet` (`idDetFaena`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `graseria`
--

DROP TABLE IF EXISTS `graseria`;
CREATE TABLE IF NOT EXISTS `graseria` (
  `idGraseria` int(11) NOT NULL AUTO_INCREMENT,
  `idUsuario` int(11) NOT NULL,
  `fechaAlta` datetime NOT NULL,
  `fechaBaja` datetime DEFAULT NULL,
  `fechaModificacion` datetime DEFAULT NULL,
  `idEstado` int(11) NOT NULL,
  PRIMARY KEY (`idGraseria`),
  KEY `estados_graseria_fk` (`idEstado`),
  KEY `usuarios_graseria_fk` (`idUsuario`),
  KEY `idgraseria` (`idGraseria`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `graseriadet`
--

DROP TABLE IF EXISTS `graseriadet`;
CREATE TABLE IF NOT EXISTS `graseriadet` (
  `idGraseriaDet` int(11) NOT NULL AUTO_INCREMENT,
  `idGraseria` int(11) NOT NULL,
  `idInsumo` int(11) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `cantidad` decimal(10,2) NOT NULL,
  `subtotal` decimal(10,2) NOT NULL,
  `precio` decimal(10,1) NOT NULL,
  `fechaAlta` datetime NOT NULL,
  `fechaBaja` datetime DEFAULT NULL,
  `fechaModificacion` datetime DEFAULT NULL,
  `idEstado` int(11) NOT NULL,
  PRIMARY KEY (`idGraseriaDet`),
  KEY `estados_graseriadet_fk` (`idEstado`),
  KEY `graseria_graseriadet_fk` (`idGraseria`),
  KEY `insumos_graseriadet_fk` (`idInsumo`),
  KEY `idgraseriadet` (`idGraseriaDet`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `impuestos`
--

DROP TABLE IF EXISTS `impuestos`;
CREATE TABLE IF NOT EXISTS `impuestos` (
  `idImpuesto` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(50) NOT NULL,
  `porcentaje` decimal(10,2) NOT NULL,
  `fechaAlta` datetime DEFAULT NULL,
  `fechaModificacion` datetime DEFAULT NULL,
  `fechaBaja` datetime DEFAULT NULL,
  `idEstado` int(11) NOT NULL,
  PRIMARY KEY (`idImpuesto`),
  KEY `estados_impuestos_fk` (`idEstado`),
  KEY `idimpuesto` (`idImpuesto`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=8 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `insumos`
--

DROP TABLE IF EXISTS `insumos`;
CREATE TABLE IF NOT EXISTS `insumos` (
  `idInsumo` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(100) NOT NULL,
  `idTipoInsumo` int(11) NOT NULL,
  `idUnidad` int(11) NOT NULL,
  `idEstado` int(11) NOT NULL,
  `fechaAlta` datetime NOT NULL,
  `fechaBaja` datetime DEFAULT NULL,
  `fechaModificacion` datetime DEFAULT NULL,
  PRIMARY KEY (`idInsumo`),
  KEY `tipoinsumo_insumos_fk` (`idTipoInsumo`),
  KEY `estados_insumos_fk` (`idEstado`),
  KEY `unidad_insumos_fk` (`idUnidad`),
  KEY `idinsumos` (`idInsumo`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=32 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `lavadero`
--

DROP TABLE IF EXISTS `lavadero`;
CREATE TABLE IF NOT EXISTS `lavadero` (
  `idLavado` int(11) NOT NULL AUTO_INCREMENT,
  `idUsuario` int(11) NOT NULL,
  `idMovil` int(11) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `dominio` varchar(20) NOT NULL,
  `fechaAlta` datetime NOT NULL,
  `fechaBaja` datetime DEFAULT NULL,
  `fechaModificacion` datetime DEFAULT NULL,
  `idEstado` int(11) NOT NULL,
  PRIMARY KEY (`idLavado`),
  KEY `estados_lavadero_fk` (`idEstado`),
  KEY `movil_lavadero_fk` (`idMovil`),
  KEY `usuarios_lavadero_fk` (`idUsuario`),
  KEY `lavadero` (`idLavado`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `lavaderodet`
--

DROP TABLE IF EXISTS `lavaderodet`;
CREATE TABLE IF NOT EXISTS `lavaderodet` (
  `idLavaderoDet` int(11) NOT NULL AUTO_INCREMENT,
  `idLavado` int(11) NOT NULL,
  `idInsumo` int(11) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `cantidad` decimal(10,2) NOT NULL,
  `subtotal` decimal(10,2) NOT NULL,
  `precio` decimal(10,2) NOT NULL,
  `fechaAlta` datetime NOT NULL,
  `fechaBaja` datetime DEFAULT NULL,
  `fechaModificacion` datetime DEFAULT NULL,
  `idEstado` int(11) NOT NULL,
  PRIMARY KEY (`idLavaderoDet`),
  KEY `estados_lavaderodet_fk` (`idEstado`),
  KEY `insumos_lavaderodet_fk` (`idInsumo`),
  KEY `lavadero_lavaderodet_fk` (`idLavado`),
  KEY `idlavaderodet` (`idLavaderoDet`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `licencias`
--

DROP TABLE IF EXISTS `licencias`;
CREATE TABLE IF NOT EXISTS `licencias` (
  `idLicencias` int(11) NOT NULL AUTO_INCREMENT,
  `idTipoLicencias` int(11) NOT NULL,
  `vencimiento` datetime DEFAULT NULL,
  `licenciacarga` varchar(50) NOT NULL,
  `vencimientonac` datetime NOT NULL,
  `vencimientocurso` datetime NOT NULL,
  `fechaAlta` datetime NOT NULL,
  `fechaModificacion` datetime NOT NULL,
  `fechaBaja` datetime NOT NULL,
  `idEstado` int(11) NOT NULL,
  `idConductor` int(11) NOT NULL,
  PRIMARY KEY (`idLicencias`),
  KEY `estados_licencias_fk` (`idEstado`),
  KEY `tipolicencias_licencias_fk` (`idTipoLicencias`),
  KEY `conductor_licencias_fk` (`idConductor`),
  KEY `idlicencias` (`idLicencias`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `localidad`
--

DROP TABLE IF EXISTS `localidad`;
CREATE TABLE IF NOT EXISTS `localidad` (
  `idLocalidad` int(11) NOT NULL AUTO_INCREMENT,
  `idProvincia` int(11) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `cp` varchar(20) NOT NULL,
  `fechaAlta` datetime NOT NULL,
  `fechaBaja` datetime DEFAULT NULL,
  `fechaModificacion` datetime DEFAULT NULL,
  `idEstado` int(11) NOT NULL,
  PRIMARY KEY (`idLocalidad`),
  KEY `estados_localidad_fk` (`idEstado`),
  KEY `provincias_localidad_fk` (`idProvincia`),
  KEY `idlocalidad` (`idLocalidad`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=27858 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `log`
--

DROP TABLE IF EXISTS `log`;
CREATE TABLE IF NOT EXISTS `log` (
  `idLog` bigint(20) NOT NULL AUTO_INCREMENT,
  `idLogOper` int(11) NOT NULL,
  `idUsuario` int(11) NOT NULL,
  `fecha` datetime NOT NULL,
  `descripcion` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`idLog`),
  KEY `logoper_log_fk` (`idLogOper`),
  KEY `usuarios_log_fk` (`idUsuario`),
  KEY `idlog` (`idLog`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2269 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `logoper`
--

DROP TABLE IF EXISTS `logoper`;
CREATE TABLE IF NOT EXISTS `logoper` (
  `idLogOper` int(11) NOT NULL AUTO_INCREMENT,
  `tipoOper` varchar(50) NOT NULL,
  PRIMARY KEY (`idLogOper`),
  KEY `idlogoper` (`idLogOper`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=6 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `mantenimiento`
--

DROP TABLE IF EXISTS `mantenimiento`;
CREATE TABLE IF NOT EXISTS `mantenimiento` (
  `idMantenimiento` int(11) NOT NULL AUTO_INCREMENT,
  `idMovil` int(11) NOT NULL,
  `idUsuario` int(11) NOT NULL,
  `fechaAlta` datetime NOT NULL,
  `fechaBaja` datetime DEFAULT NULL,
  `fechaModificacion` datetime DEFAULT NULL,
  `idEstado` int(11) NOT NULL,
  PRIMARY KEY (`idMantenimiento`),
  KEY `estados_mantenimiento_fk` (`idEstado`),
  KEY `movil_mantenimiento_fk` (`idMovil`),
  KEY `usuarios_mantenimiento_fk` (`idUsuario`),
  KEY `idmantenimiento` (`idMantenimiento`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `mantenimientodet`
--

DROP TABLE IF EXISTS `mantenimientodet`;
CREATE TABLE IF NOT EXISTS `mantenimientodet` (
  `idMantenimientoDet` int(11) NOT NULL AUTO_INCREMENT,
  `idMantenimiento` int(11) NOT NULL,
  `idInsumo` int(11) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `cantidad` decimal(10,2) NOT NULL,
  `subtotal` decimal(10,2) NOT NULL,
  `precio` decimal(10,2) NOT NULL,
  `fechaAlta` datetime NOT NULL,
  `fechaBaja` datetime NOT NULL,
  `fechaModificacion` datetime NOT NULL,
  `idEstado` int(11) NOT NULL,
  PRIMARY KEY (`idMantenimientoDet`),
  KEY `insumos_mantenimientodet_fk` (`idInsumo`),
  KEY `mantenimiento_mantenimientodet_fk` (`idMantenimiento`),
  KEY `estados_mantenimientodet_fk` (`idEstado`),
  KEY `idmantenimientodet` (`idMantenimientoDet`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `marca`
--

DROP TABLE IF EXISTS `marca`;
CREATE TABLE IF NOT EXISTS `marca` (
  `idMarca` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(100) NOT NULL,
  `fechaAlta` datetime NOT NULL,
  `fechaModificacion` datetime DEFAULT NULL,
  `fechaBaja` datetime DEFAULT NULL,
  `idEstado` int(11) NOT NULL,
  PRIMARY KEY (`idMarca`),
  KEY `estados_marca_fk` (`idEstado`),
  KEY `marca` (`idMarca`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=8 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `vehiculo`
--

DROP TABLE IF EXISTS `vehiculo`;
CREATE TABLE IF NOT EXISTS `vehiculo` (
  `idMovil` int(11) NOT NULL AUTO_INCREMENT,
  `modelo` varchar(100) NOT NULL,
  `dominio` varchar(50) NOT NULL,
  `idTipoCombustible` int(11) NOT NULL,
  `color` varchar(50) NOT NULL,
  `maxcabezas` decimal(10,2) NOT NULL,
  `tara` decimal(10,2) NOT NULL,
  `cargaMax` decimal(10,2) NOT NULL,
  `consumo` decimal(10,2) NOT NULL,
  `alto` decimal(10,2) NOT NULL,
  `largo` decimal(10,2) NOT NULL,
  `ancho` decimal(10,2) NOT NULL,
  `volumen` decimal(10,2) NOT NULL,
  `numeromotor` varchar(60) DEFAULT NULL,
  `numerochasis` varchar(50) NOT NULL,
  `idMarca` int(11) NOT NULL,
  `idEstadoMovil` int(11) NOT NULL,
  `idEstado` int(11) NOT NULL,
  `fechaAlta` datetime NOT NULL,
  `fechaBaja` datetime DEFAULT NULL,
  `fechaModificacion` datetime DEFAULT NULL,
  `anno` date NOT NULL,
  `fecha` date NOT NULL,
  `idTipoMovil` int(11) NOT NULL DEFAULT '1',
  PRIMARY KEY (`idMovil`),
  KEY `estados_movil_fk` (`idEstado`),
  KEY `marca_movil_fk` (`idMarca`),
  KEY `estadosmovil_movil_fk` (`idEstadoMovil`),
  KEY `tipocombustible_movil_fk` (`idTipoCombustible`),
  KEY `idmovil` (`idMovil`),
  KEY `fk_movil_idtipomovil` (`idTipoMovil`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=40 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `numerodte`
--

DROP TABLE IF EXISTS `numerodte`;
CREATE TABLE IF NOT EXISTS `numerodte` (
  `idNumDte` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(50) NOT NULL,
  `idDte` int(11) NOT NULL,
  PRIMARY KEY (`idNumDte`),
  KEY `dte_numerodte_fk` (`idDte`),
  KEY `iddte` (`idNumDte`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=102 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `operadoras`
--

DROP TABLE IF EXISTS `operadoras`;
CREATE TABLE IF NOT EXISTS `operadoras` (
  `idOperadora` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(50) NOT NULL,
  `fechaAlta` datetime NOT NULL,
  `fechaBaja` datetime DEFAULT NULL,
  `fechaModificacion` datetime DEFAULT NULL,
  `idEstado` int(11) NOT NULL,
  PRIMARY KEY (`idOperadora`),
  KEY `estados_operadoras_fk` (`idEstado`),
  KEY `idoperadoras` (`idOperadora`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=4 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `paises`
--

DROP TABLE IF EXISTS `paises`;
CREATE TABLE IF NOT EXISTS `paises` (
  `idPais` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(100) NOT NULL,
  `fechaAlta` datetime NOT NULL,
  `fechaBaja` datetime DEFAULT NULL,
  `fechaModificacion` datetime DEFAULT NULL,
  `idEstado` int(11) NOT NULL,
  PRIMARY KEY (`idPais`),
  KEY `estados_paises_fk` (`idEstado`),
  KEY `idpaises` (`idPais`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=341 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `productor`
--

DROP TABLE IF EXISTS `productor`;
CREATE TABLE IF NOT EXISTS `productor` (
  `idProductor` int(11) NOT NULL AUTO_INCREMENT,
  `cuit` varchar(50) NOT NULL,
  `descripcion` varchar(100) NOT NULL,
  `celular` varchar(50) NOT NULL,
  `telefono` varchar(50) NOT NULL,
  `domicilio` varchar(150) NOT NULL,
  `email` varchar(100) NOT NULL,
  `renspa` varchar(50) DEFAULT NULL,
  `idCondicion` int(11) NOT NULL,
  `idEstado` int(11) NOT NULL,
  `fechaAlta` datetime NOT NULL,
  `fechaBaja` datetime DEFAULT NULL,
  `fechaModificacion` datetime DEFAULT NULL,
  PRIMARY KEY (`idProductor`),
  KEY `condicion_productor_fk` (`idCondicion`),
  KEY `estados_productor_fk` (`idEstado`),
  KEY `idproductor` (`idProductor`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=56 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `provincias`
--

DROP TABLE IF EXISTS `provincias`;
CREATE TABLE IF NOT EXISTS `provincias` (
  `idProvincia` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(50) NOT NULL,
  `fechaAlta` datetime NOT NULL,
  `fechaBaja` datetime DEFAULT NULL,
  `fechaModificacion` datetime DEFAULT NULL,
  `idPais` int(11) NOT NULL,
  `idEstado` int(11) NOT NULL,
  PRIMARY KEY (`idProvincia`),
  KEY `estados_provincias_fk` (`idEstado`),
  KEY `paises_provincias_fk` (`idPais`),
  KEY `idprovincias` (`idProvincia`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=25 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `renspa`
--

DROP TABLE IF EXISTS `renspa`;
CREATE TABLE IF NOT EXISTS `renspa` (
  `idRenspa` int(11) NOT NULL AUTO_INCREMENT,
  `idProductor` int(11) NOT NULL,
  `descripcion` varchar(50) NOT NULL,
  `fechaAlta` datetime NOT NULL,
  `fechaBaja` datetime DEFAULT NULL,
  `fechaModificacion` datetime DEFAULT NULL,
  `idEstado` int(11) NOT NULL,
  PRIMARY KEY (`idRenspa`),
  KEY `estados_renspa_fk` (`idEstado`),
  KEY `productor_renspa_fk` (`idProductor`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=71 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `roles`
--

DROP TABLE IF EXISTS `roles`;
CREATE TABLE IF NOT EXISTS `roles` (
  `idRol` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(50) NOT NULL,
  `fechaAlta` datetime NOT NULL,
  `fechaBaja` datetime DEFAULT NULL,
  `fechaModificacion` datetime DEFAULT NULL,
  `idEstado` int(11) NOT NULL,
  PRIMARY KEY (`idRol`),
  KEY `estados_roles_fk` (`idEstado`),
  KEY `idrol` (`idRol`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=9 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `stock`
--

DROP TABLE IF EXISTS `stock`;
CREATE TABLE IF NOT EXISTS `stock` (
  `idStock` int(11) NOT NULL AUTO_INCREMENT,
  `stock` decimal(10,2) NOT NULL,
  `idInsumo` int(11) NOT NULL,
  `fechaAlta` datetime NOT NULL,
  `fechaBaja` datetime DEFAULT NULL,
  `fechaModificacion` datetime DEFAULT NULL,
  `idEstado` int(11) NOT NULL,
  PRIMARY KEY (`idStock`),
  KEY `estados_stock_fk` (`idEstado`),
  KEY `insumos_stock_fk` (`idInsumo`),
  KEY `stock` (`idStock`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipocombustible`
--

DROP TABLE IF EXISTS `tipocombustible`;
CREATE TABLE IF NOT EXISTS `tipocombustible` (
  `idTipoCombustible` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(50) DEFAULT NULL,
  `fechaAlta` datetime NOT NULL,
  `fechaModificacion` datetime DEFAULT NULL,
  `fechaBaja` datetime DEFAULT NULL,
  `idEstado` int(11) NOT NULL,
  PRIMARY KEY (`idTipoCombustible`),
  KEY `estados_tipocombustible_fk` (`idEstado`),
  KEY `tipocombustible` (`idTipoCombustible`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=15 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipoinsumo`
--

DROP TABLE IF EXISTS `tipoinsumo`;
CREATE TABLE IF NOT EXISTS `tipoinsumo` (
  `idTipoInsumo` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(50) NOT NULL,
  `fechaAlta` datetime NOT NULL,
  `fechaBaja` datetime DEFAULT NULL,
  `fechaModificacion` datetime DEFAULT NULL,
  `idEstado` int(11) NOT NULL,
  PRIMARY KEY (`idTipoInsumo`),
  KEY `estados_tipoinsumo_fk` (`idEstado`),
  KEY `idtipoinsumo` (`idTipoInsumo`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=8 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipolicencias`
--

DROP TABLE IF EXISTS `tipolicencias`;
CREATE TABLE IF NOT EXISTS `tipolicencias` (
  `idTipoLicencias` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(30) NOT NULL,
  `fechaAlta` datetime NOT NULL,
  `fechaModificacion` datetime DEFAULT NULL,
  `fechaBaja` datetime DEFAULT NULL,
  `idEstado` int(11) NOT NULL,
  PRIMARY KEY (`idTipoLicencias`),
  KEY `estados_tipolicencias_fk` (`idEstado`),
  KEY `idtipolicencias` (`idTipoLicencias`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=4 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipomovil`
--

DROP TABLE IF EXISTS `tipomovil`;
CREATE TABLE IF NOT EXISTS `tipomovil` (
  `idTipoMovil` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(100) NOT NULL,
  `fechaAlta` datetime NOT NULL,
  `fechaModificacion` datetime DEFAULT NULL,
  `fechaBaja` datetime DEFAULT NULL,
  `idEstado` int(11) NOT NULL,
  PRIMARY KEY (`idTipoMovil`),
  KEY `estados_modelo_fk` (`idEstado`),
  KEY `idtipomovil` (`idTipoMovil`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=6 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `unidad`
--

DROP TABLE IF EXISTS `unidad`;
CREATE TABLE IF NOT EXISTS `unidad` (
  `idUnidad` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(100) NOT NULL,
  `fechaAlta` datetime NOT NULL,
  `fechaBaja` datetime DEFAULT NULL,
  `fechaModificacion` datetime DEFAULT NULL,
  `idEstado` int(11) NOT NULL,
  PRIMARY KEY (`idUnidad`),
  KEY `estados_unidad_fk` (`idEstado`),
  KEY `idunidad` (`idUnidad`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
CREATE TABLE IF NOT EXISTS `usuarios` (
  `idUsuario` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL,
  `apellido` varchar(50) NOT NULL,
  `domilicio` varchar(200) NOT NULL,
  `cuit` varchar(20) NOT NULL,
  `dni` varchar(30) NOT NULL,
  `celular` varchar(30) NOT NULL,
  `telefono` varchar(20) DEFAULT NULL,
  `usuario` varchar(50) NOT NULL,
  `passWord` varchar(250) NOT NULL,
  `eMail` varchar(150) NOT NULL,
  `fechaAlta` datetime NOT NULL,
  `fechaBaja` datetime DEFAULT NULL,
  `fechaModificacion` datetime DEFAULT NULL,
  `idEstado` int(11) NOT NULL,
  PRIMARY KEY (`idUsuario`),
  KEY `estados_usuarios_fk` (`idEstado`),
  KEY `idusuarios` (`idUsuario`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=20 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios_roles`
--

DROP TABLE IF EXISTS `usuarios_roles`;
CREATE TABLE IF NOT EXISTS `usuarios_roles` (
  `idUsuRol` int(11) NOT NULL AUTO_INCREMENT,
  `idRol` int(11) NOT NULL,
  `idUsuario` int(11) NOT NULL,
  PRIMARY KEY (`idUsuRol`),
  KEY `roles_usuarios_roles_fk` (`idRol`),
  KEY `usuarios_usuarios_roles_fk` (`idUsuario`),
  KEY `idusurol` (`idUsuRol`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=16 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ventascab`
--

DROP TABLE IF EXISTS `ventascab`;
CREATE TABLE IF NOT EXISTS `ventascab` (
  `idVentaCab` bigint(20) NOT NULL AUTO_INCREMENT,
  `idUsuario` int(11) NOT NULL,
  `fechaAlta` datetime NOT NULL,
  `fechaBaja` datetime DEFAULT NULL,
  `fechaModificacion` datetime DEFAULT NULL,
  PRIMARY KEY (`idVentaCab`),
  KEY `usuarios_ventascab_fk` (`idUsuario`),
  KEY `idventascab` (`idVentaCab`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ventasdet`
--

DROP TABLE IF EXISTS `ventasdet`;
CREATE TABLE IF NOT EXISTS `ventasdet` (
  `idVentasDet` bigint(20) NOT NULL AUTO_INCREMENT,
  `idVentaCab` bigint(20) NOT NULL,
  `descripcion` varchar(120) NOT NULL,
  `cantidad` decimal(10,2) NOT NULL,
  `subtotal` decimal(10,2) NOT NULL,
  `precio` decimal(10,2) NOT NULL,
  `fechaAlta` datetime NOT NULL,
  `fechaBaja` datetime DEFAULT NULL,
  `fechaModificacion` datetime DEFAULT NULL,
  PRIMARY KEY (`idVentasDet`),
  KEY `ventascab_ventasdet_fk` (`idVentaCab`),
  KEY `idventasdet` (`idVentasDet`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `visceras`
--

DROP TABLE IF EXISTS `visceras`;
CREATE TABLE IF NOT EXISTS `visceras` (
  `idVisceras` int(11) NOT NULL AUTO_INCREMENT,
  `idUsuario` int(11) NOT NULL,
  `fechaAlta` datetime NOT NULL,
  `fechaBaja` datetime DEFAULT NULL,
  `fechaModficacion` datetime DEFAULT NULL,
  `idEstado` int(11) NOT NULL,
  PRIMARY KEY (`idVisceras`),
  KEY `usuarios_visceras_fk` (`idUsuario`),
  KEY `estados_visceras_fk` (`idEstado`),
  KEY `idvisceras` (`idVisceras`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `viscerasdet`
--

DROP TABLE IF EXISTS `viscerasdet`;
CREATE TABLE IF NOT EXISTS `viscerasdet` (
  `idViscerasDet` int(11) NOT NULL AUTO_INCREMENT,
  `idVisceras` int(11) NOT NULL,
  `idInsumo` int(11) NOT NULL,
  `nombre` varchar(60) NOT NULL,
  `cantidad` decimal(10,2) NOT NULL,
  `subtotal` decimal(10,2) NOT NULL,
  `precio` decimal(10,2) NOT NULL,
  `fechaAlta` datetime NOT NULL,
  `fechaBaja` datetime DEFAULT NULL,
  `fechaModificacion` datetime DEFAULT NULL,
  `idEstado` int(11) NOT NULL,
  PRIMARY KEY (`idViscerasDet`),
  KEY `estados_viscerasdet_fk` (`idEstado`),
  KEY `insumos_viscerasdet_fk` (`idInsumo`),
  KEY `visceras_viscerasdet_fk` (`idVisceras`),
  KEY `idviscerasdet` (`idViscerasDet`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `xdtedocumento`
--

DROP TABLE IF EXISTS `xdtedocumento`;
CREATE TABLE IF NOT EXISTS `xdtedocumento` (
  `idXDteDocumento` int(11) NOT NULL AUTO_INCREMENT,
  `idDte` int(11) NOT NULL,
  `idDocumento` int(11) NOT NULL,
  PRIMARY KEY (`idXDteDocumento`),
  KEY `xdtedocumento_dte_fk` (`idDte`),
  KEY `xdtedocumento_documento_fk` (`idDocumento`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=34 ;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `categorias`
--
ALTER TABLE `categorias`
  ADD CONSTRAINT `estados_categorias_fk` FOREIGN KEY (`idEstado`) REFERENCES `estados` (`idEstado`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `codigocostovehiculo`
--
ALTER TABLE `codigocostovehiculo`
  ADD CONSTRAINT `estados_codigocostovehiculo_fk` FOREIGN KEY (`idEstado`) REFERENCES `estados` (`idEstado`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `color`
--
ALTER TABLE `color`
  ADD CONSTRAINT `estados_color_fk` FOREIGN KEY (`idEstado`) REFERENCES `estados` (`idEstado`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `comisiones`
--
ALTER TABLE `comisiones`
  ADD CONSTRAINT `insumos_comisiones_fk` FOREIGN KEY (`idInsumo`) REFERENCES `insumos` (`idInsumo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `ventasdet_comisiones_fk` FOREIGN KEY (`idVentasDet`) REFERENCES `ventasdet` (`idVentasDet`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `comisionista`
--
ALTER TABLE `comisionista`
  ADD CONSTRAINT `estados_comisionista_fk` FOREIGN KEY (`idEstado`) REFERENCES `estados` (`idEstado`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `condicion`
--
ALTER TABLE `condicion`
  ADD CONSTRAINT `estados_condicion_fk` FOREIGN KEY (`idEstado`) REFERENCES `estados` (`idEstado`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `conductor`
--
ALTER TABLE `conductor`
  ADD CONSTRAINT `estados_conductor_fk` FOREIGN KEY (`idEstado`) REFERENCES `estados` (`idEstado`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `operadoras_conductor_fk` FOREIGN KEY (`idOperadora`) REFERENCES `operadoras` (`idOperadora`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `usuarios_conductor_fk` FOREIGN KEY (`idUsuario`) REFERENCES `usuarios` (`idUsuario`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `consignatario`
--
ALTER TABLE `consignatario`
  ADD CONSTRAINT `estados_consignatario_fk` FOREIGN KEY (`idEstado`) REFERENCES `estados` (`idEstado`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `costovehiculo`
--
ALTER TABLE `costovehiculo`
  ADD CONSTRAINT `fk_costovehiculo_codigocostovehiculo` FOREIGN KEY (`idCodigoCostoVehiculo`) REFERENCES `codigocostovehiculo` (`idCodigoCostoVehiculo`),
  ADD CONSTRAINT `fk_costovehiculo_estados` FOREIGN KEY (`idEstado`) REFERENCES `estados` (`idEstado`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_costovehiculo_idmovil` FOREIGN KEY (`idMovil`) REFERENCES `vehiculo` (`idMovil`),
  ADD CONSTRAINT `fk_costovehiculo_insumo` FOREIGN KEY (`idInsumo`) REFERENCES `insumos` (`idInsumo`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `costovehiculodet`
--
ALTER TABLE `costovehiculodet`
  ADD CONSTRAINT `fk_costovehiculodet_costovehiculo` FOREIGN KEY (`idCostoVehiculo`) REFERENCES `costovehiculo` (`idCostoVehiculo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_costovehiculodet_estados` FOREIGN KEY (`idEstado`) REFERENCES `estados` (`idEstado`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_costovehiculodet_impuesto` FOREIGN KEY (`idImpuesto`) REFERENCES `impuestos` (`idImpuesto`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `cueros`
--
ALTER TABLE `cueros`
  ADD CONSTRAINT `estados_cueros_fk` FOREIGN KEY (`idEstado`) REFERENCES `estados` (`idEstado`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `usuarios_cueros_fk` FOREIGN KEY (`idUsuario`) REFERENCES `usuarios` (`idUsuario`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `cuerosdet`
--
ALTER TABLE `cuerosdet`
  ADD CONSTRAINT `cueros_cuerosdet_fk` FOREIGN KEY (`idCueros`) REFERENCES `cueros` (`idCueros`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `estados_cuerosdet_fk` FOREIGN KEY (`idEstado`) REFERENCES `estados` (`idEstado`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `insumos_cuerosdet_fk` FOREIGN KEY (`idInsumo`) REFERENCES `insumos` (`idInsumo`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `despostecab`
--
ALTER TABLE `despostecab`
  ADD CONSTRAINT `estados_despostecab_fk` FOREIGN KEY (`idEstado`) REFERENCES `estados` (`idEstado`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `usuarios_despostecab_fk` FOREIGN KEY (`idUsuario`) REFERENCES `usuarios` (`idUsuario`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `despostedet`
--
ALTER TABLE `despostedet`
  ADD CONSTRAINT `despostecab_despostedet_fk` FOREIGN KEY (`idDesposte`) REFERENCES `despostecab` (`idDesposte`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `estados_despostedet_fk` FOREIGN KEY (`idEstado`) REFERENCES `estados` (`idEstado`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `insumos_despostedet_fk` FOREIGN KEY (`idInsumo`) REFERENCES `insumos` (`idInsumo`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `documento`
--
ALTER TABLE `documento`
  ADD CONSTRAINT `documento_estado_fk` FOREIGN KEY (`idEstado`) REFERENCES `estados` (`idEstado`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `dte`
--
ALTER TABLE `dte`
  ADD CONSTRAINT `comisionista_dte_fk` FOREIGN KEY (`idComisionista`) REFERENCES `comisionista` (`idComisionista`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `conductor_dte_fk` FOREIGN KEY (`idConductor`) REFERENCES `conductor` (`idConductor`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `consignatario_dte_fk` FOREIGN KEY (`idConsignatario`) REFERENCES `consignatario` (`idConsignatario`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `estados_dte_fk` FOREIGN KEY (`idEstado`) REFERENCES `estados` (`idEstado`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `movil_dte_fk` FOREIGN KEY (`idMovil`) REFERENCES `vehiculo` (`idMovil`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `productor_dte_fk` FOREIGN KEY (`idProductor`) REFERENCES `productor` (`idProductor`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `usuarios_dte_fk` FOREIGN KEY (`idUsuario`) REFERENCES `usuarios` (`idUsuario`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `dtedet`
--
ALTER TABLE `dtedet`
  ADD CONSTRAINT `dte_dtedet_fk` FOREIGN KEY (`idDte`) REFERENCES `dte` (`idDte`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `estados_dtedet_fk` FOREIGN KEY (`idEstado`) REFERENCES `estados` (`idEstado`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `insumos_dtedet_fk` FOREIGN KEY (`idInsumo`) REFERENCES `insumos` (`idInsumo`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `dtedetcat`
--
ALTER TABLE `dtedetcat`
  ADD CONSTRAINT `categorias_dtedetcat_fk` FOREIGN KEY (`idCategorias`) REFERENCES `categorias` (`idCategorias`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `dte_dtedetcat_fk` FOREIGN KEY (`idDte`) REFERENCES `dte` (`idDte`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `estados_dtedetcat_fk` FOREIGN KEY (`idEstado`) REFERENCES `estados` (`idEstado`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `dtedetimp`
--
ALTER TABLE `dtedetimp`
  ADD CONSTRAINT `dte_dtedetimp_fk` FOREIGN KEY (`idDte`) REFERENCES `dte` (`idDte`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `estados_dtedetimp_fk` FOREIGN KEY (`idEstado`) REFERENCES `estados` (`idEstado`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `impuestos_dtedetimp_fk` FOREIGN KEY (`idImpuesto`) REFERENCES `impuestos` (`idImpuesto`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `estadosmovil`
--
ALTER TABLE `estadosmovil`
  ADD CONSTRAINT `estados_estadosmovil_fk` FOREIGN KEY (`idEstado`) REFERENCES `estados` (`idEstado`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `faena`
--
ALTER TABLE `faena`
  ADD CONSTRAINT `estados_faena_fk` FOREIGN KEY (`idEstado`) REFERENCES `estados` (`idEstado`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `usuarios_faena_fk` FOREIGN KEY (`idUsuario`) REFERENCES `usuarios` (`idUsuario`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `faenadet`
--
ALTER TABLE `faenadet`
  ADD CONSTRAINT `estados_faenadet_fk` FOREIGN KEY (`idEstado`) REFERENCES `estados` (`idEstado`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `faena_faenadet_fk` FOREIGN KEY (`idFaena`) REFERENCES `faena` (`idFaena`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `insumos_faenadet_fk` FOREIGN KEY (`idInsumo`) REFERENCES `insumos` (`idInsumo`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `graseria`
--
ALTER TABLE `graseria`
  ADD CONSTRAINT `estados_graseria_fk` FOREIGN KEY (`idEstado`) REFERENCES `estados` (`idEstado`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `usuarios_graseria_fk` FOREIGN KEY (`idUsuario`) REFERENCES `usuarios` (`idUsuario`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `graseriadet`
--
ALTER TABLE `graseriadet`
  ADD CONSTRAINT `estados_graseriadet_fk` FOREIGN KEY (`idEstado`) REFERENCES `estados` (`idEstado`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `graseria_graseriadet_fk` FOREIGN KEY (`idGraseria`) REFERENCES `graseria` (`idGraseria`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `insumos_graseriadet_fk` FOREIGN KEY (`idInsumo`) REFERENCES `insumos` (`idInsumo`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `impuestos`
--
ALTER TABLE `impuestos`
  ADD CONSTRAINT `estados_impuestos_fk` FOREIGN KEY (`idEstado`) REFERENCES `estados` (`idEstado`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `insumos`
--
ALTER TABLE `insumos`
  ADD CONSTRAINT `estados_insumos_fk` FOREIGN KEY (`idEstado`) REFERENCES `estados` (`idEstado`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `tipoinsumo_insumos_fk` FOREIGN KEY (`idTipoInsumo`) REFERENCES `tipoinsumo` (`idTipoInsumo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `unidad_insumos_fk` FOREIGN KEY (`idUnidad`) REFERENCES `unidad` (`idUnidad`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `lavadero`
--
ALTER TABLE `lavadero`
  ADD CONSTRAINT `estados_lavadero_fk` FOREIGN KEY (`idEstado`) REFERENCES `estados` (`idEstado`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `movil_lavadero_fk` FOREIGN KEY (`idMovil`) REFERENCES `vehiculo` (`idMovil`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `usuarios_lavadero_fk` FOREIGN KEY (`idUsuario`) REFERENCES `usuarios` (`idUsuario`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `lavaderodet`
--
ALTER TABLE `lavaderodet`
  ADD CONSTRAINT `estados_lavaderodet_fk` FOREIGN KEY (`idEstado`) REFERENCES `estados` (`idEstado`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `insumos_lavaderodet_fk` FOREIGN KEY (`idInsumo`) REFERENCES `insumos` (`idInsumo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `lavadero_lavaderodet_fk` FOREIGN KEY (`idLavado`) REFERENCES `lavadero` (`idLavado`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `licencias`
--
ALTER TABLE `licencias`
  ADD CONSTRAINT `conductor_licencias_fk` FOREIGN KEY (`idConductor`) REFERENCES `conductor` (`idConductor`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `estados_licencias_fk` FOREIGN KEY (`idEstado`) REFERENCES `estados` (`idEstado`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `tipolicencias_licencias_fk` FOREIGN KEY (`idTipoLicencias`) REFERENCES `tipolicencias` (`idTipoLicencias`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `localidad`
--
ALTER TABLE `localidad`
  ADD CONSTRAINT `estados_localidad_fk` FOREIGN KEY (`idEstado`) REFERENCES `estados` (`idEstado`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `provincias_localidad_fk` FOREIGN KEY (`idProvincia`) REFERENCES `provincias` (`idProvincia`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `log`
--
ALTER TABLE `log`
  ADD CONSTRAINT `logoper_log_fk` FOREIGN KEY (`idLogOper`) REFERENCES `logoper` (`idLogOper`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `usuarios_log_fk` FOREIGN KEY (`idUsuario`) REFERENCES `usuarios` (`idUsuario`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `mantenimiento`
--
ALTER TABLE `mantenimiento`
  ADD CONSTRAINT `estados_mantenimiento_fk` FOREIGN KEY (`idEstado`) REFERENCES `estados` (`idEstado`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `movil_mantenimiento_fk` FOREIGN KEY (`idMovil`) REFERENCES `vehiculo` (`idMovil`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `usuarios_mantenimiento_fk` FOREIGN KEY (`idUsuario`) REFERENCES `usuarios` (`idUsuario`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `mantenimientodet`
--
ALTER TABLE `mantenimientodet`
  ADD CONSTRAINT `estados_mantenimientodet_fk` FOREIGN KEY (`idEstado`) REFERENCES `estados` (`idEstado`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `insumos_mantenimientodet_fk` FOREIGN KEY (`idInsumo`) REFERENCES `insumos` (`idInsumo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `mantenimiento_mantenimientodet_fk` FOREIGN KEY (`idMantenimiento`) REFERENCES `mantenimiento` (`idMantenimiento`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `marca`
--
ALTER TABLE `marca`
  ADD CONSTRAINT `estados_marca_fk` FOREIGN KEY (`idEstado`) REFERENCES `estados` (`idEstado`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `vehiculo`
--
ALTER TABLE `vehiculo`
  ADD CONSTRAINT `estados_movil_fk` FOREIGN KEY (`idEstado`) REFERENCES `estados` (`idEstado`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `estadosmovil_movil_fk` FOREIGN KEY (`idEstadoMovil`) REFERENCES `estadosmovil` (`idEstadoMovil`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_movil_idtipomovil` FOREIGN KEY (`idTipoMovil`) REFERENCES `tipomovil` (`idTipoMovil`),
  ADD CONSTRAINT `marca_movil_fk` FOREIGN KEY (`idMarca`) REFERENCES `marca` (`idMarca`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `tipocombustible_movil_fk` FOREIGN KEY (`idTipoCombustible`) REFERENCES `tipocombustible` (`idTipoCombustible`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `numerodte`
--
ALTER TABLE `numerodte`
  ADD CONSTRAINT `dte_numerodte_fk` FOREIGN KEY (`idDte`) REFERENCES `dte` (`idDte`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `operadoras`
--
ALTER TABLE `operadoras`
  ADD CONSTRAINT `estados_operadoras_fk` FOREIGN KEY (`idEstado`) REFERENCES `estados` (`idEstado`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `paises`
--
ALTER TABLE `paises`
  ADD CONSTRAINT `estados_paises_fk` FOREIGN KEY (`idEstado`) REFERENCES `estados` (`idEstado`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `productor`
--
ALTER TABLE `productor`
  ADD CONSTRAINT `condicion_productor_fk` FOREIGN KEY (`idCondicion`) REFERENCES `condicion` (`idCondicion`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `estados_productor_fk` FOREIGN KEY (`idEstado`) REFERENCES `estados` (`idEstado`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `provincias`
--
ALTER TABLE `provincias`
  ADD CONSTRAINT `estados_provincias_fk` FOREIGN KEY (`idEstado`) REFERENCES `estados` (`idEstado`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `paises_provincias_fk` FOREIGN KEY (`idPais`) REFERENCES `paises` (`idPais`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `renspa`
--
ALTER TABLE `renspa`
  ADD CONSTRAINT `estados_renspa_fk` FOREIGN KEY (`idEstado`) REFERENCES `estados` (`idEstado`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `productor_renspa_fk` FOREIGN KEY (`idProductor`) REFERENCES `productor` (`idProductor`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `roles`
--
ALTER TABLE `roles`
  ADD CONSTRAINT `estados_roles_fk` FOREIGN KEY (`idEstado`) REFERENCES `estados` (`idEstado`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `stock`
--
ALTER TABLE `stock`
  ADD CONSTRAINT `estados_stock_fk` FOREIGN KEY (`idEstado`) REFERENCES `estados` (`idEstado`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `insumos_stock_fk` FOREIGN KEY (`idInsumo`) REFERENCES `insumos` (`idInsumo`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `tipocombustible`
--
ALTER TABLE `tipocombustible`
  ADD CONSTRAINT `estados_tipocombustible_fk` FOREIGN KEY (`idEstado`) REFERENCES `estados` (`idEstado`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `tipoinsumo`
--
ALTER TABLE `tipoinsumo`
  ADD CONSTRAINT `estados_tipoinsumo_fk` FOREIGN KEY (`idEstado`) REFERENCES `estados` (`idEstado`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `tipolicencias`
--
ALTER TABLE `tipolicencias`
  ADD CONSTRAINT `estados_tipolicencias_fk` FOREIGN KEY (`idEstado`) REFERENCES `estados` (`idEstado`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `tipomovil`
--
ALTER TABLE `tipomovil`
  ADD CONSTRAINT `estados_modelo_fk` FOREIGN KEY (`idEstado`) REFERENCES `estados` (`idEstado`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `unidad`
--
ALTER TABLE `unidad`
  ADD CONSTRAINT `estados_unidad_fk` FOREIGN KEY (`idEstado`) REFERENCES `estados` (`idEstado`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD CONSTRAINT `estados_usuarios_fk` FOREIGN KEY (`idEstado`) REFERENCES `estados` (`idEstado`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `usuarios_roles`
--
ALTER TABLE `usuarios_roles`
  ADD CONSTRAINT `roles_usuarios_roles_fk` FOREIGN KEY (`idRol`) REFERENCES `roles` (`idRol`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `usuarios_usuarios_roles_fk` FOREIGN KEY (`idUsuario`) REFERENCES `usuarios` (`idUsuario`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `ventascab`
--
ALTER TABLE `ventascab`
  ADD CONSTRAINT `usuarios_ventascab_fk` FOREIGN KEY (`idUsuario`) REFERENCES `usuarios` (`idUsuario`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `ventasdet`
--
ALTER TABLE `ventasdet`
  ADD CONSTRAINT `ventascab_ventasdet_fk` FOREIGN KEY (`idVentaCab`) REFERENCES `ventascab` (`idVentaCab`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `visceras`
--
ALTER TABLE `visceras`
  ADD CONSTRAINT `estados_visceras_fk` FOREIGN KEY (`idEstado`) REFERENCES `estados` (`idEstado`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `usuarios_visceras_fk` FOREIGN KEY (`idUsuario`) REFERENCES `usuarios` (`idUsuario`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `viscerasdet`
--
ALTER TABLE `viscerasdet`
  ADD CONSTRAINT `estados_viscerasdet_fk` FOREIGN KEY (`idEstado`) REFERENCES `estados` (`idEstado`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `insumos_viscerasdet_fk` FOREIGN KEY (`idInsumo`) REFERENCES `insumos` (`idInsumo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `visceras_viscerasdet_fk` FOREIGN KEY (`idVisceras`) REFERENCES `visceras` (`idVisceras`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `xdtedocumento`
--
ALTER TABLE `xdtedocumento`
  ADD CONSTRAINT `xdtedocumento_documento_fk` FOREIGN KEY (`idDocumento`) REFERENCES `documento` (`idDocumento`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `xdtedocumento_dte_fk` FOREIGN KEY (`idDte`) REFERENCES `dte` (`idDte`) ON DELETE NO ACTION ON UPDATE NO ACTION;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
