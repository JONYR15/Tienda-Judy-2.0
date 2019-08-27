USE `Tienda JUDY`;
 
/****** Object:  Table [dbo].[Cliente]    Script Date: 26/08/2019 12:12:28 ******/
/* SET ANSI_NULLS ON */
 
/* SET QUOTED_IDENTIFIER ON */
 
/* SET ANSI_PADDING ON */
 
CREATE TABLE Cliente(
	`IdCliente` int AUTO_INCREMENT NOT NULL,
	`Nombre` varchar(100) NOT NULL,
	`Apellido1` varchar(100) NOT NULL,
	`Apellido2` varchar(100) NOT NULL,
	`Telefono` varchar(50) NOT NULL,
	`Correo` varchar(250) NOT NULL,
 CONSTRAINT `PK_Cliente` PRIMARY KEY 
(
	`IdCliente` ASC
) 
);

/* SET ANSI_PADDING OFF */
 
/****** Object:  Table [dbo].[DetalleFactura]    Script Date: 26/08/2019 12:12:28 ******/
/* SET ANSI_NULLS ON */
 
/* SET QUOTED_IDENTIFIER ON */
 
CREATE TABLE DetalleFactura(
	`IdDetalleFactura` int NOT NULL,
	`IdEncabezadoFactura` int NULL,
	`IdProducto` int NULL,
	`Cantidad` int NULL,
 CONSTRAINT `PK_DetalleFactura` PRIMARY KEY 
(
	`IdDetalleFactura` ASC
) 
);

/****** Object:  Table [dbo].[Empleado]    Script Date: 26/08/2019 12:12:28 ******/
/* SET ANSI_NULLS ON */
 
/* SET QUOTED_IDENTIFIER ON */
 
/* SET ANSI_PADDING ON */
 
CREATE TABLE Empleado(
	`IdEmpleado` int AUTO_INCREMENT NOT NULL,
	`Nombre` varchar(50) NULL,
	`Apellido1` varchar(50) NULL,
	`Apellido2` varchar(50) NULL,
	`Telefono` varchar(50) NULL,
	`Correo` varchar(250) NULL,
	`Salario` int NULL,
 CONSTRAINT `PK_Empleado` PRIMARY KEY 
(
	`IdEmpleado` ASC
) 
);

/* SET ANSI_PADDING OFF */
 
/****** Object:  Table [dbo].[EncabezadoFactura]    Script Date: 26/08/2019 12:12:28 ******/
/* SET ANSI_NULLS ON */
 
/* SET QUOTED_IDENTIFIER ON */
 
CREATE TABLE EncabezadoFactura(
	`IdEncabezadoFactura` int NOT NULL,
	`ValorVenta` int NOT NULL,
	`Descuento` int NOT NULL,
	`SubTotal` int NOT NULL,
	`IVA` int NOT NULL,
	`TotalVenta` int NOT NULL,
	`IdCliente` int NULL,
 CONSTRAINT `PK_EncabezadoFactura` PRIMARY KEY 
(
	`IdEncabezadoFactura` ASC
) 
);

/****** Object:  Table [dbo].[Producto]    Script Date: 26/08/2019 12:12:28 ******/
/* SET ANSI_NULLS ON */
 
/* SET QUOTED_IDENTIFIER ON */
 
/* SET ANSI_PADDING ON */
 
CREATE TABLE Producto(
	`IdProducto` int AUTO_INCREMENT NOT NULL,
	`Nombre` varchar(50) NOT NULL,
	`Descripcion` varchar(500) NOT NULL,
	`Talla` varchar(5) NOT NULL,
	`Cantidad` int NOT NULL,
	`PrecioCompra` int NOT NULL,
	`PrecioVenta` int NOT NULL,
	`IdCliente` int NOT NULL,
	`IdEmpleado` int NOT NULL,
 CONSTRAINT `PK_Producto` PRIMARY KEY 
(
	`IdProducto` ASC
) 
);

/* SET ANSI_PADDING OFF */
 
ALTER TABLE `dbo`.`DetalleFactura`  WITH CHECK ADD  CONSTRAINT `FK__EncabezadoFactura_DetalleFactura` FOREIGN KEY(`IdEncabezadoFactura`)
REFERENCES [dbo].[EncabezadoFactura] (`IdEncabezadoFactura`)
GO
ALTER TABLE `dbo`.`DetalleFactura` CHECK CONSTRAINT `FK__EncabezadoFactura_DetalleFactura`
GO
ALTER TABLE `dbo`.`EncabezadoFactura`  WITH CHECK ADD  CONSTRAINT `FK_EncabezadoFactura_Cliente` FOREIGN KEY(`IdEncabezadoFactura`)
REFERENCES [dbo].[EncabezadoFactura] (`IdEncabezadoFactura`)
GO
ALTER TABLE `dbo`.`EncabezadoFactura` CHECK CONSTRAINT `FK_EncabezadoFactura_Cliente`
GO
ALTER TABLE `dbo`.`Producto`  WITH CHECK ADD  CONSTRAINT `FK_Empleado` FOREIGN KEY(`IdEmpleado`)
REFERENCES [dbo].[Empleado] (`IdEmpleado`)
GO
ALTER TABLE `dbo`.`Producto` CHECK CONSTRAINT `FK_Empleado`
GO
