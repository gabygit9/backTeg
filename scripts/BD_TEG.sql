USE [master]
GO
/****** Object:  Database [BD_TEG]    Script Date: 10/05/2025 12:40:38 ******/
CREATE DATABASE [BD_TEG]
GO
USE BD_TEG
GO
ALTER DATABASE [BD_TEG] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [BD_TEG] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [BD_TEG] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [BD_TEG] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [BD_TEG] SET ARITHABORT OFF 
GO
ALTER DATABASE [BD_TEG] SET AUTO_CLOSE ON 
GO
ALTER DATABASE [BD_TEG] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [BD_TEG] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [BD_TEG] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [BD_TEG] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [BD_TEG] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [BD_TEG] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [BD_TEG] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [BD_TEG] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [BD_TEG] SET  ENABLE_BROKER 
GO
ALTER DATABASE [BD_TEG] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [BD_TEG] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [BD_TEG] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [BD_TEG] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [BD_TEG] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [BD_TEG] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [BD_TEG] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [BD_TEG] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [BD_TEG] SET  MULTI_USER 
GO
ALTER DATABASE [BD_TEG] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [BD_TEG] SET DB_CHAINING OFF 
GO
ALTER DATABASE [BD_TEG] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [BD_TEG] SET TARGET_RECOVERY_TIME = 0 SECONDS 
GO
ALTER DATABASE [BD_TEG] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [BD_TEG] SET ACCELERATED_DATABASE_RECOVERY = OFF  
GO
ALTER DATABASE [BD_TEG] SET QUERY_STORE = ON
GO
ALTER DATABASE [BD_TEG] SET QUERY_STORE (OPERATION_MODE = READ_WRITE, CLEANUP_POLICY = (STALE_QUERY_THRESHOLD_DAYS = 30), DATA_FLUSH_INTERVAL_SECONDS = 900, INTERVAL_LENGTH_MINUTES = 60, MAX_STORAGE_SIZE_MB = 1000, QUERY_CAPTURE_MODE = AUTO, SIZE_BASED_CLEANUP_MODE = AUTO, MAX_PLANS_PER_QUERY = 200, WAIT_STATS_CAPTURE_MODE = ON)
GO
USE [BD_TEG]
GO
/****** Object:  User [admin]    Script Date: 10/05/2025 12:40:38 ******/
CREATE USER [admin] FOR LOGIN [admin] WITH DEFAULT_SCHEMA=[dbo]
GO
/****** Object:  Table [dbo].[Canje_tarjetas]    Script Date: 10/05/2025 12:40:38 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Canje_tarjetas](
	[canje_id] [int] NOT NULL,
	[tarjeta_jugador_id] [int] NOT NULL,
 CONSTRAINT [pk_canje_cartas] PRIMARY KEY CLUSTERED 
(
	[canje_id] ASC,
	[tarjeta_jugador_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Canjes]    Script Date: 10/05/2025 12:40:38 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Canjes](
	[canje_id] [int] IDENTITY(1,1) NOT NULL,
	[jugador_partida_canje_id] [int] NOT NULL,
	[fecha_hora_canje] [datetime] NOT NULL,
	[cantidad_ejercito] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[canje_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Colores]    Script Date: 10/05/2025 12:40:38 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Colores](
	[color_id] [int] IDENTITY(1,1) NOT NULL,
	[nombre] [varchar](50) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[color_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Conexion_paises]    Script Date: 10/05/2025 12:40:38 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Conexion_paises](
	[pais_origen_id] [int] NOT NULL,
	[pais_destino_id] [int] NOT NULL,
 CONSTRAINT [pk_conexion] PRIMARY KEY CLUSTERED 
(
	[pais_origen_id] ASC,
	[pais_destino_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Continentes]    Script Date: 10/05/2025 12:40:38 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Continentes](
	[continente_id] [int] IDENTITY(1,1) NOT NULL,
	[nombre] [varchar](50) NOT NULL,
	[ejercito_bonus] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[continente_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Denuncias]    Script Date: 10/05/2025 12:40:38 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Denuncias](
	[denuncia_id] [int] IDENTITY(1,1) NOT NULL,
	[denuncia_partida_id] [int] NOT NULL,
	[acusado_id] [int] NOT NULL,
	[acusador_id] [int] NOT NULL,
	[motivo] [varchar](100) NOT NULL,
	[fecha_hora_denuncia] [datetime] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[denuncia_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Estado_partidas]    Script Date: 10/05/2025 12:40:38 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Estado_partidas](
	[estado_id] [int] IDENTITY(1,1) NOT NULL,
	[descripcion] [varchar](50) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[estado_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Historial_eventos]    Script Date: 10/05/2025 12:40:38 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Historial_eventos](
	[historial_id] [int] IDENTITY(1,1) NOT NULL,
	[historial_partida_id] [int] NOT NULL,
	[descripcion] [varchar](100) NOT NULL,
	[fecha_hora_evento] [datetime] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[historial_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Jugador_partidas]    Script Date: 10/05/2025 12:40:38 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Jugador_partidas](
	[jugador_id] [int] IDENTITY(1,1) NOT NULL,
	[partida_id] [int] NOT NULL,
	[jugador_base_id] [int] NOT NULL,
	[color_id] [int] NOT NULL,
	[objetivo_id] [int] NOT NULL,
	[objetivo_cumplido] [bit] NOT NULL,
	[orden_turno] [int] NOT NULL,
	[es_turno] [bit] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[jugador_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Jugadores_base]    Script Date: 10/05/2025 12:40:38 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Jugadores_base](
	[jugador_base_id] [int] IDENTITY(1,1) NOT NULL,
	[nombre] [varchar](50) NOT NULL,
	[ejercito_disponible] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[jugador_base_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Jugadores_bot]    Script Date: 10/05/2025 12:40:38 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Jugadores_bot](
	[jugador_base_id] [int] NOT NULL,
	[nivel_bot_id] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[jugador_base_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Jugadores_humanos]    Script Date: 10/05/2025 12:40:38 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Jugadores_humanos](
	[jugador_humano_id] [int] NOT NULL,
	[usuario_jugador_id] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[jugador_humano_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Mensajes]    Script Date: 10/05/2025 12:40:38 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Mensajes](
	[mensaje_id] [int] IDENTITY(1,1) NOT NULL,
	[mensaje_partida_id] [int] NOT NULL,
	[emisor_id] [int] NOT NULL,
	[contenido] [varchar](100) NOT NULL,
	[fecha_hora_mensaje] [datetime] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[mensaje_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Niveles_bot]    Script Date: 10/05/2025 12:40:38 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Niveles_bot](
	[nivel_id] [int] IDENTITY(1,1) NOT NULL,
	[nombre] [varchar](20) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[nivel_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Objetivo_secretos]    Script Date: 10/05/2025 12:40:38 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Objetivo_secretos](
	[objetivo_id] [int] IDENTITY(1,1) NOT NULL,
	[descripcion] [varchar](200) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[objetivo_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Pacto_jugadores]    Script Date: 10/05/2025 12:40:38 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Pacto_jugadores](
	[pacto_id] [int] NOT NULL,
	[jugador_base_id] [int] NOT NULL,
 CONSTRAINT [pk_pacto_jugadores] PRIMARY KEY CLUSTERED 
(
	[pacto_id] ASC,
	[jugador_base_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Pacto_paises]    Script Date: 10/05/2025 12:40:38 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Pacto_paises](
	[pacto_id] [int] NOT NULL,
	[pais_id] [int] NOT NULL,
 CONSTRAINT [pk_pacto_paises] PRIMARY KEY CLUSTERED 
(
	[pacto_id] ASC,
	[pais_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Pactos]    Script Date: 10/05/2025 12:40:38 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Pactos](
	[pacto_id] [int] IDENTITY(1,1) NOT NULL,
	[pacto_partida_id] [int] NOT NULL,
	[tipo_pacto_id] [int] NOT NULL,
	[jugador_creador_id] [int] NOT NULL,
	[activo] [bit] NOT NULL,
	[fecha_hora_pacto] [datetime] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[pacto_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Paises]    Script Date: 10/05/2025 12:40:38 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Paises](
	[pais_id] [int] IDENTITY(1,1) NOT NULL,
	[nombre] [varchar](50) NOT NULL,
	[continente_pais_id] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[pais_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Paises_partida]    Script Date: 10/05/2025 12:40:38 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Paises_partida](
	[pais_id] [int] NOT NULL,
	[partida_pais_id] [int] NOT NULL,
	[jugador_pais_id] [int] NOT NULL,
	[cantidad_ejercito] [int] NOT NULL,
 CONSTRAINT [pk_pais_partida] PRIMARY KEY CLUSTERED 
(
	[partida_pais_id] ASC,
	[pais_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Partidas]    Script Date: 10/05/2025 12:40:38 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Partidas](
	[partida_id] [int] IDENTITY(1,1) NOT NULL,
	[fecha_inicio_partida] [datetime] NOT NULL,
	[estado_id] [int] NOT NULL,
	[tipo_comunicacion_id] [int] NOT NULL,
	[objetivo_comun_id] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[partida_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Roles]    Script Date: 10/05/2025 12:40:38 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Roles](
	[rol_id] [int] IDENTITY(1,1) NOT NULL,
	[descripcion] [varchar](50) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[rol_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Simbolos]    Script Date: 10/05/2025 12:40:38 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Simbolos](
	[simbolo_id] [int] IDENTITY(1,1) NOT NULL,
	[tipo] [varchar](50) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[simbolo_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Tarjeta_jugadores]    Script Date: 10/05/2025 12:40:38 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Tarjeta_jugadores](
	[tarjeta_jugador_id] [int] IDENTITY(1,1) NOT NULL,
	[tarjeta_pais_id] [int] NOT NULL,
	[jugador_partida_id] [int] NOT NULL,
	[usada] [bit] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[tarjeta_jugador_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Tarjeta_paises]    Script Date: 10/05/2025 12:40:38 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Tarjeta_paises](
	[tarjeta_pais_id] [int] IDENTITY(1,1) NOT NULL,
	[pais_id] [int] NOT NULL,
	[simbolo_id] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[tarjeta_pais_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Tipo_comunicaciones]    Script Date: 10/05/2025 12:40:38 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Tipo_comunicaciones](
	[comunicacion_id] [int] IDENTITY(1,1) NOT NULL,
	[descripcion] [varchar](50) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[comunicacion_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Tipo_pactos]    Script Date: 10/05/2025 12:40:38 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Tipo_pactos](
	[tipo_pacto_id] [int] IDENTITY(1,1) NOT NULL,
	[descripcion] [varchar](50) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[tipo_pacto_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Turnos]    Script Date: 10/05/2025 12:40:38 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Turnos](
	[turno_id] [int] IDENTITY(1,1) NOT NULL,
	[turno_jugador_partida_id] [int] NOT NULL,
	[turno_partida_id] [int] NOT NULL,
	[fecha_inicio_turno] [datetime] NOT NULL,
	[duracion_maxima] [int] NOT NULL,
	[ejercito_disponible] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[turno_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Usuarios]    Script Date: 10/05/2025 12:40:38 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Usuarios](
	[usuario_id] [int] IDENTITY(1,1) NOT NULL,
	[nombre] [varchar](50) NOT NULL,
	[email] [varchar](50) NOT NULL,
	[password] [varchar](255) NOT NULL,
	[usuario_rol_id] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[usuario_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[Colores] ON 
GO
INSERT [dbo].[Colores] ([color_id], [nombre]) VALUES (1, N'rojo')
GO
INSERT [dbo].[Colores] ([color_id], [nombre]) VALUES (2, N'azul')
GO
INSERT [dbo].[Colores] ([color_id], [nombre]) VALUES (3, N'verde')
GO
INSERT [dbo].[Colores] ([color_id], [nombre]) VALUES (4, N'amarillo')
GO
INSERT [dbo].[Colores] ([color_id], [nombre]) VALUES (5, N'negro')
GO
INSERT [dbo].[Colores] ([color_id], [nombre]) VALUES (6, N'magenta')
GO
SET IDENTITY_INSERT [dbo].[Colores] OFF
GO
INSERT [dbo].[Conexion_paises] ([pais_origen_id], [pais_destino_id]) VALUES (1, 4)
GO
INSERT [dbo].[Conexion_paises] ([pais_origen_id], [pais_destino_id]) VALUES (1, 6)
GO
INSERT [dbo].[Conexion_paises] ([pais_origen_id], [pais_destino_id]) VALUES (1, 8)
GO
INSERT [dbo].[Conexion_paises] ([pais_origen_id], [pais_destino_id]) VALUES (1, 25)
GO
INSERT [dbo].[Conexion_paises] ([pais_origen_id], [pais_destino_id]) VALUES (2, 15)
GO
INSERT [dbo].[Conexion_paises] ([pais_origen_id], [pais_destino_id]) VALUES (3, 4)
GO
INSERT [dbo].[Conexion_paises] ([pais_origen_id], [pais_destino_id]) VALUES (3, 5)
GO
INSERT [dbo].[Conexion_paises] ([pais_origen_id], [pais_destino_id]) VALUES (4, 2)
GO
INSERT [dbo].[Conexion_paises] ([pais_origen_id], [pais_destino_id]) VALUES (4, 8)
GO
INSERT [dbo].[Conexion_paises] ([pais_origen_id], [pais_destino_id]) VALUES (5, 30)
GO
INSERT [dbo].[Conexion_paises] ([pais_origen_id], [pais_destino_id]) VALUES (6, 3)
GO
INSERT [dbo].[Conexion_paises] ([pais_origen_id], [pais_destino_id]) VALUES (6, 4)
GO
INSERT [dbo].[Conexion_paises] ([pais_origen_id], [pais_destino_id]) VALUES (7, 2)
GO
INSERT [dbo].[Conexion_paises] ([pais_origen_id], [pais_destino_id]) VALUES (8, 7)
GO
INSERT [dbo].[Conexion_paises] ([pais_origen_id], [pais_destino_id]) VALUES (9, 6)
GO
INSERT [dbo].[Conexion_paises] ([pais_origen_id], [pais_destino_id]) VALUES (9, 43)
GO
INSERT [dbo].[Conexion_paises] ([pais_origen_id], [pais_destino_id]) VALUES (11, 12)
GO
INSERT [dbo].[Conexion_paises] ([pais_origen_id], [pais_destino_id]) VALUES (11, 14)
GO
INSERT [dbo].[Conexion_paises] ([pais_origen_id], [pais_destino_id]) VALUES (12, 13)
GO
INSERT [dbo].[Conexion_paises] ([pais_origen_id], [pais_destino_id]) VALUES (12, 29)
GO
INSERT [dbo].[Conexion_paises] ([pais_origen_id], [pais_destino_id]) VALUES (14, 12)
GO
INSERT [dbo].[Conexion_paises] ([pais_origen_id], [pais_destino_id]) VALUES (14, 46)
GO
INSERT [dbo].[Conexion_paises] ([pais_origen_id], [pais_destino_id]) VALUES (15, 23)
GO
INSERT [dbo].[Conexion_paises] ([pais_origen_id], [pais_destino_id]) VALUES (16, 15)
GO
INSERT [dbo].[Conexion_paises] ([pais_origen_id], [pais_destino_id]) VALUES (16, 17)
GO
INSERT [dbo].[Conexion_paises] ([pais_origen_id], [pais_destino_id]) VALUES (17, 19)
GO
INSERT [dbo].[Conexion_paises] ([pais_origen_id], [pais_destino_id]) VALUES (17, 20)
GO
INSERT [dbo].[Conexion_paises] ([pais_origen_id], [pais_destino_id]) VALUES (18, 16)
GO
INSERT [dbo].[Conexion_paises] ([pais_origen_id], [pais_destino_id]) VALUES (18, 19)
GO
INSERT [dbo].[Conexion_paises] ([pais_origen_id], [pais_destino_id]) VALUES (20, 19)
GO
INSERT [dbo].[Conexion_paises] ([pais_origen_id], [pais_destino_id]) VALUES (21, 22)
GO
INSERT [dbo].[Conexion_paises] ([pais_origen_id], [pais_destino_id]) VALUES (21, 32)
GO
INSERT [dbo].[Conexion_paises] ([pais_origen_id], [pais_destino_id]) VALUES (21, 33)
GO
INSERT [dbo].[Conexion_paises] ([pais_origen_id], [pais_destino_id]) VALUES (21, 48)
GO
INSERT [dbo].[Conexion_paises] ([pais_origen_id], [pais_destino_id]) VALUES (22, 17)
GO
INSERT [dbo].[Conexion_paises] ([pais_origen_id], [pais_destino_id]) VALUES (22, 32)
GO
INSERT [dbo].[Conexion_paises] ([pais_origen_id], [pais_destino_id]) VALUES (23, 21)
GO
INSERT [dbo].[Conexion_paises] ([pais_origen_id], [pais_destino_id]) VALUES (24, 26)
GO
INSERT [dbo].[Conexion_paises] ([pais_origen_id], [pais_destino_id]) VALUES (24, 27)
GO
INSERT [dbo].[Conexion_paises] ([pais_origen_id], [pais_destino_id]) VALUES (24, 28)
GO
INSERT [dbo].[Conexion_paises] ([pais_origen_id], [pais_destino_id]) VALUES (25, 6)
GO
INSERT [dbo].[Conexion_paises] ([pais_origen_id], [pais_destino_id]) VALUES (25, 9)
GO
INSERT [dbo].[Conexion_paises] ([pais_origen_id], [pais_destino_id]) VALUES (26, 44)
GO
INSERT [dbo].[Conexion_paises] ([pais_origen_id], [pais_destino_id]) VALUES (27, 26)
GO
INSERT [dbo].[Conexion_paises] ([pais_origen_id], [pais_destino_id]) VALUES (29, 11)
GO
INSERT [dbo].[Conexion_paises] ([pais_origen_id], [pais_destino_id]) VALUES (29, 13)
GO
INSERT [dbo].[Conexion_paises] ([pais_origen_id], [pais_destino_id]) VALUES (29, 47)
GO
INSERT [dbo].[Conexion_paises] ([pais_origen_id], [pais_destino_id]) VALUES (30, 11)
GO
INSERT [dbo].[Conexion_paises] ([pais_origen_id], [pais_destino_id]) VALUES (30, 29)
GO
INSERT [dbo].[Conexion_paises] ([pais_origen_id], [pais_destino_id]) VALUES (31, 46)
GO
INSERT [dbo].[Conexion_paises] ([pais_origen_id], [pais_destino_id]) VALUES (32, 42)
GO
INSERT [dbo].[Conexion_paises] ([pais_origen_id], [pais_destino_id]) VALUES (32, 45)
GO
INSERT [dbo].[Conexion_paises] ([pais_origen_id], [pais_destino_id]) VALUES (33, 32)
GO
INSERT [dbo].[Conexion_paises] ([pais_origen_id], [pais_destino_id]) VALUES (33, 35)
GO
INSERT [dbo].[Conexion_paises] ([pais_origen_id], [pais_destino_id]) VALUES (33, 36)
GO
INSERT [dbo].[Conexion_paises] ([pais_origen_id], [pais_destino_id]) VALUES (33, 37)
GO
INSERT [dbo].[Conexion_paises] ([pais_origen_id], [pais_destino_id]) VALUES (33, 49)
GO
INSERT [dbo].[Conexion_paises] ([pais_origen_id], [pais_destino_id]) VALUES (34, 38)
GO
INSERT [dbo].[Conexion_paises] ([pais_origen_id], [pais_destino_id]) VALUES (34, 41)
GO
INSERT [dbo].[Conexion_paises] ([pais_origen_id], [pais_destino_id]) VALUES (35, 31)
GO
INSERT [dbo].[Conexion_paises] ([pais_origen_id], [pais_destino_id]) VALUES (35, 40)
GO
INSERT [dbo].[Conexion_paises] ([pais_origen_id], [pais_destino_id]) VALUES (36, 35)
GO
INSERT [dbo].[Conexion_paises] ([pais_origen_id], [pais_destino_id]) VALUES (36, 37)
GO
INSERT [dbo].[Conexion_paises] ([pais_origen_id], [pais_destino_id]) VALUES (36, 39)
GO
INSERT [dbo].[Conexion_paises] ([pais_origen_id], [pais_destino_id]) VALUES (36, 40)
GO
INSERT [dbo].[Conexion_paises] ([pais_origen_id], [pais_destino_id]) VALUES (37, 48)
GO
INSERT [dbo].[Conexion_paises] ([pais_origen_id], [pais_destino_id]) VALUES (38, 36)
GO
INSERT [dbo].[Conexion_paises] ([pais_origen_id], [pais_destino_id]) VALUES (38, 37)
GO
INSERT [dbo].[Conexion_paises] ([pais_origen_id], [pais_destino_id]) VALUES (38, 43)
GO
INSERT [dbo].[Conexion_paises] ([pais_origen_id], [pais_destino_id]) VALUES (40, 50)
GO
INSERT [dbo].[Conexion_paises] ([pais_origen_id], [pais_destino_id]) VALUES (41, 38)
GO
INSERT [dbo].[Conexion_paises] ([pais_origen_id], [pais_destino_id]) VALUES (43, 36)
GO
INSERT [dbo].[Conexion_paises] ([pais_origen_id], [pais_destino_id]) VALUES (43, 39)
GO
INSERT [dbo].[Conexion_paises] ([pais_origen_id], [pais_destino_id]) VALUES (44, 22)
GO
INSERT [dbo].[Conexion_paises] ([pais_origen_id], [pais_destino_id]) VALUES (44, 28)
GO
INSERT [dbo].[Conexion_paises] ([pais_origen_id], [pais_destino_id]) VALUES (44, 32)
GO
INSERT [dbo].[Conexion_paises] ([pais_origen_id], [pais_destino_id]) VALUES (44, 42)
GO
INSERT [dbo].[Conexion_paises] ([pais_origen_id], [pais_destino_id]) VALUES (45, 42)
GO
INSERT [dbo].[Conexion_paises] ([pais_origen_id], [pais_destino_id]) VALUES (46, 10)
GO
INSERT [dbo].[Conexion_paises] ([pais_origen_id], [pais_destino_id]) VALUES (46, 50)
GO
INSERT [dbo].[Conexion_paises] ([pais_origen_id], [pais_destino_id]) VALUES (47, 18)
GO
INSERT [dbo].[Conexion_paises] ([pais_origen_id], [pais_destino_id]) VALUES (47, 24)
GO
INSERT [dbo].[Conexion_paises] ([pais_origen_id], [pais_destino_id]) VALUES (47, 26)
GO
INSERT [dbo].[Conexion_paises] ([pais_origen_id], [pais_destino_id]) VALUES (47, 44)
GO
INSERT [dbo].[Conexion_paises] ([pais_origen_id], [pais_destino_id]) VALUES (48, 33)
GO
INSERT [dbo].[Conexion_paises] ([pais_origen_id], [pais_destino_id]) VALUES (48, 34)
GO
INSERT [dbo].[Conexion_paises] ([pais_origen_id], [pais_destino_id]) VALUES (48, 38)
GO
INSERT [dbo].[Conexion_paises] ([pais_origen_id], [pais_destino_id]) VALUES (49, 36)
GO
INSERT [dbo].[Conexion_paises] ([pais_origen_id], [pais_destino_id]) VALUES (49, 37)
GO
SET IDENTITY_INSERT [dbo].[Continentes] ON 
GO
INSERT [dbo].[Continentes] ([continente_id], [nombre], [ejercito_bonus]) VALUES (1, N'america_del_norte', 5)
GO
INSERT [dbo].[Continentes] ([continente_id], [nombre], [ejercito_bonus]) VALUES (2, N'america_del_sur', 3)
GO
INSERT [dbo].[Continentes] ([continente_id], [nombre], [ejercito_bonus]) VALUES (3, N'europa', 5)
GO
INSERT [dbo].[Continentes] ([continente_id], [nombre], [ejercito_bonus]) VALUES (4, N'africa', 3)
GO
INSERT [dbo].[Continentes] ([continente_id], [nombre], [ejercito_bonus]) VALUES (5, N'asia', 7)
GO
INSERT [dbo].[Continentes] ([continente_id], [nombre], [ejercito_bonus]) VALUES (6, N'oceania', 2)
GO
SET IDENTITY_INSERT [dbo].[Continentes] OFF
GO
SET IDENTITY_INSERT [dbo].[Estado_partidas] ON 
GO
INSERT [dbo].[Estado_partidas] ([estado_id], [descripcion]) VALUES (1, N'pausada')
GO
INSERT [dbo].[Estado_partidas] ([estado_id], [descripcion]) VALUES (2, N'en_curso')
GO
INSERT [dbo].[Estado_partidas] ([estado_id], [descripcion]) VALUES (3, N'cancelada')
GO
INSERT [dbo].[Estado_partidas] ([estado_id], [descripcion]) VALUES (4, N'finalizada')
GO
SET IDENTITY_INSERT [dbo].[Estado_partidas] OFF
GO
SET IDENTITY_INSERT [dbo].[Niveles_bot] ON 
GO
INSERT [dbo].[Niveles_bot] ([nivel_id], [nombre]) VALUES (1, N'novato')
GO
INSERT [dbo].[Niveles_bot] ([nivel_id], [nombre]) VALUES (2, N'balanceado')
GO
INSERT [dbo].[Niveles_bot] ([nivel_id], [nombre]) VALUES (3, N'experto')
GO
SET IDENTITY_INSERT [dbo].[Niveles_bot] OFF
GO
SET IDENTITY_INSERT [dbo].[Objetivo_secretos] ON 
GO
INSERT [dbo].[Objetivo_secretos] ([objetivo_id], [descripcion]) VALUES (1, N'Ocupar África, 5 países de América del Norte y 4 países de Europa')
GO
INSERT [dbo].[Objetivo_secretos] ([objetivo_id], [descripcion]) VALUES (2, N'Ocupar América del Sur, 7 países de Europa y 3 países limítrofes entre sí en cualquier lugar del mapa')
GO
INSERT [dbo].[Objetivo_secretos] ([objetivo_id], [descripcion]) VALUES (3, N'Ocupar Asia y 2 países de América del Sur')
GO
INSERT [dbo].[Objetivo_secretos] ([objetivo_id], [descripcion]) VALUES (4, N'Ocupar Europa, 4 países de Asia y 2 países de América del Sur')
GO
INSERT [dbo].[Objetivo_secretos] ([objetivo_id], [descripcion]) VALUES (5, N'Ocupar América del Norte, 2 países de Oceanía y 4 de Asia')
GO
INSERT [dbo].[Objetivo_secretos] ([objetivo_id], [descripcion]) VALUES (6, N'Ocupar 2 países de Oceanía, 2 países de África, 2 países de América del Sur, 3 países de Europa, 4 de América del Norte y 3 de Asia')
GO
INSERT [dbo].[Objetivo_secretos] ([objetivo_id], [descripcion]) VALUES (7, N'Ocupar Oceanía, América del Norte y 2 países de Europa')
GO
INSERT [dbo].[Objetivo_secretos] ([objetivo_id], [descripcion]) VALUES (8, N'Ocupar América del Sur, África y 4 países de Asia')
GO
INSERT [dbo].[Objetivo_secretos] ([objetivo_id], [descripcion]) VALUES (9, N'Ocupar Oceanía, África y 5 países de América del Norte')
GO
INSERT [dbo].[Objetivo_secretos] ([objetivo_id], [descripcion]) VALUES (10, N'Destruir el ejército azul, de ser imposible al jugador de la derecha')
GO
INSERT [dbo].[Objetivo_secretos] ([objetivo_id], [descripcion]) VALUES (11, N'Destruir al ejército rojo, de ser imposible al jugador de la derecha')
GO
INSERT [dbo].[Objetivo_secretos] ([objetivo_id], [descripcion]) VALUES (12, N'Destruir al ejército negro, de ser imposible al jugador de la derecha')
GO
INSERT [dbo].[Objetivo_secretos] ([objetivo_id], [descripcion]) VALUES (13, N'Destruir al ejército amarillo, de ser imposible al jugador de la derecha')
GO
INSERT [dbo].[Objetivo_secretos] ([objetivo_id], [descripcion]) VALUES (14, N'Destruir al ejército verde, de ser imposible al jugador de la derecha')
GO
INSERT [dbo].[Objetivo_secretos] ([objetivo_id], [descripcion]) VALUES (15, N'Destruir al ejército magenta, de ser imposible al jugador de la derecha')
GO
SET IDENTITY_INSERT [dbo].[Objetivo_secretos] OFF
GO
SET IDENTITY_INSERT [dbo].[Paises] ON 
GO
INSERT [dbo].[Paises] ([pais_id], [nombre], [continente_pais_id]) VALUES (1, N'canada', 1)
GO
INSERT [dbo].[Paises] ([pais_id], [nombre], [continente_pais_id]) VALUES (2, N'groenlandia', 1)
GO
INSERT [dbo].[Paises] ([pais_id], [nombre], [continente_pais_id]) VALUES (3, N'california', 1)
GO
INSERT [dbo].[Paises] ([pais_id], [nombre], [continente_pais_id]) VALUES (4, N'nueva_york', 1)
GO
INSERT [dbo].[Paises] ([pais_id], [nombre], [continente_pais_id]) VALUES (5, N'mexico', 1)
GO
INSERT [dbo].[Paises] ([pais_id], [nombre], [continente_pais_id]) VALUES (6, N'oregon', 1)
GO
INSERT [dbo].[Paises] ([pais_id], [nombre], [continente_pais_id]) VALUES (7, N'labrador', 1)
GO
INSERT [dbo].[Paises] ([pais_id], [nombre], [continente_pais_id]) VALUES (8, N'terranova', 1)
GO
INSERT [dbo].[Paises] ([pais_id], [nombre], [continente_pais_id]) VALUES (9, N'alaska', 1)
GO
INSERT [dbo].[Paises] ([pais_id], [nombre], [continente_pais_id]) VALUES (10, N'java', 6)
GO
INSERT [dbo].[Paises] ([pais_id], [nombre], [continente_pais_id]) VALUES (11, N'peru', 2)
GO
INSERT [dbo].[Paises] ([pais_id], [nombre], [continente_pais_id]) VALUES (12, N'argentina', 2)
GO
INSERT [dbo].[Paises] ([pais_id], [nombre], [continente_pais_id]) VALUES (13, N'uruguay', 2)
GO
INSERT [dbo].[Paises] ([pais_id], [nombre], [continente_pais_id]) VALUES (14, N'chile', 2)
GO
INSERT [dbo].[Paises] ([pais_id], [nombre], [continente_pais_id]) VALUES (15, N'islandia', 3)
GO
INSERT [dbo].[Paises] ([pais_id], [nombre], [continente_pais_id]) VALUES (16, N'gran_bretaña', 3)
GO
INSERT [dbo].[Paises] ([pais_id], [nombre], [continente_pais_id]) VALUES (17, N'alemania', 3)
GO
INSERT [dbo].[Paises] ([pais_id], [nombre], [continente_pais_id]) VALUES (18, N'españa', 3)
GO
INSERT [dbo].[Paises] ([pais_id], [nombre], [continente_pais_id]) VALUES (19, N'francia', 3)
GO
INSERT [dbo].[Paises] ([pais_id], [nombre], [continente_pais_id]) VALUES (20, N'italia', 3)
GO
INSERT [dbo].[Paises] ([pais_id], [nombre], [continente_pais_id]) VALUES (21, N'rusia', 3)
GO
INSERT [dbo].[Paises] ([pais_id], [nombre], [continente_pais_id]) VALUES (22, N'polonia', 3)
GO
INSERT [dbo].[Paises] ([pais_id], [nombre], [continente_pais_id]) VALUES (23, N'suecia', 3)
GO
INSERT [dbo].[Paises] ([pais_id], [nombre], [continente_pais_id]) VALUES (24, N'zaire', 4)
GO
INSERT [dbo].[Paises] ([pais_id], [nombre], [continente_pais_id]) VALUES (25, N'yukon', 1)
GO
INSERT [dbo].[Paises] ([pais_id], [nombre], [continente_pais_id]) VALUES (26, N'etiopia', 4)
GO
INSERT [dbo].[Paises] ([pais_id], [nombre], [continente_pais_id]) VALUES (27, N'sudafrica', 4)
GO
INSERT [dbo].[Paises] ([pais_id], [nombre], [continente_pais_id]) VALUES (28, N'madagascar', 4)
GO
INSERT [dbo].[Paises] ([pais_id], [nombre], [continente_pais_id]) VALUES (29, N'brasil', 2)
GO
INSERT [dbo].[Paises] ([pais_id], [nombre], [continente_pais_id]) VALUES (30, N'colombia', 2)
GO
INSERT [dbo].[Paises] ([pais_id], [nombre], [continente_pais_id]) VALUES (31, N'sumatra', 6)
GO
INSERT [dbo].[Paises] ([pais_id], [nombre], [continente_pais_id]) VALUES (32, N'turquia', 5)
GO
INSERT [dbo].[Paises] ([pais_id], [nombre], [continente_pais_id]) VALUES (33, N'iran', 5)
GO
INSERT [dbo].[Paises] ([pais_id], [nombre], [continente_pais_id]) VALUES (34, N'tartaria', 5)
GO
INSERT [dbo].[Paises] ([pais_id], [nombre], [continente_pais_id]) VALUES (35, N'india', 5)
GO
INSERT [dbo].[Paises] ([pais_id], [nombre], [continente_pais_id]) VALUES (36, N'china', 5)
GO
INSERT [dbo].[Paises] ([pais_id], [nombre], [continente_pais_id]) VALUES (37, N'mongolia', 5)
GO
INSERT [dbo].[Paises] ([pais_id], [nombre], [continente_pais_id]) VALUES (38, N'siberia', 5)
GO
INSERT [dbo].[Paises] ([pais_id], [nombre], [continente_pais_id]) VALUES (39, N'japon', 5)
GO
INSERT [dbo].[Paises] ([pais_id], [nombre], [continente_pais_id]) VALUES (40, N'malasia', 5)
GO
INSERT [dbo].[Paises] ([pais_id], [nombre], [continente_pais_id]) VALUES (41, N'taimir', 5)
GO
INSERT [dbo].[Paises] ([pais_id], [nombre], [continente_pais_id]) VALUES (42, N'israel', 5)
GO
INSERT [dbo].[Paises] ([pais_id], [nombre], [continente_pais_id]) VALUES (43, N'kamtchatka', 5)
GO
INSERT [dbo].[Paises] ([pais_id], [nombre], [continente_pais_id]) VALUES (44, N'egipto', 4)
GO
INSERT [dbo].[Paises] ([pais_id], [nombre], [continente_pais_id]) VALUES (45, N'arabia', 5)
GO
INSERT [dbo].[Paises] ([pais_id], [nombre], [continente_pais_id]) VALUES (46, N'australia', 6)
GO
INSERT [dbo].[Paises] ([pais_id], [nombre], [continente_pais_id]) VALUES (47, N'sahara', 4)
GO
INSERT [dbo].[Paises] ([pais_id], [nombre], [continente_pais_id]) VALUES (48, N'aral', 5)
GO
INSERT [dbo].[Paises] ([pais_id], [nombre], [continente_pais_id]) VALUES (49, N'gobi', 5)
GO
INSERT [dbo].[Paises] ([pais_id], [nombre], [continente_pais_id]) VALUES (50, N'borneo', 6)
GO
SET IDENTITY_INSERT [dbo].[Paises] OFF
GO
SET IDENTITY_INSERT [dbo].[Roles] ON 
GO
INSERT [dbo].[Roles] ([rol_id], [descripcion]) VALUES (1, N'administrador')
GO
INSERT [dbo].[Roles] ([rol_id], [descripcion]) VALUES (2, N'jugador')
GO
SET IDENTITY_INSERT [dbo].[Roles] OFF
GO
SET IDENTITY_INSERT [dbo].[Simbolos] ON 
GO
INSERT [dbo].[Simbolos] ([simbolo_id], [tipo]) VALUES (1, N'Infanteria')
GO
INSERT [dbo].[Simbolos] ([simbolo_id], [tipo]) VALUES (2, N'Caballeria')
GO
INSERT [dbo].[Simbolos] ([simbolo_id], [tipo]) VALUES (3, N'Artilleria')
GO
INSERT [dbo].[Simbolos] ([simbolo_id], [tipo]) VALUES (4, N'Comodin')
GO
SET IDENTITY_INSERT [dbo].[Simbolos] OFF
GO
SET IDENTITY_INSERT [dbo].[Tipo_comunicaciones] ON 
GO
INSERT [dbo].[Tipo_comunicaciones] ([comunicacion_id], [descripcion]) VALUES (1, N'fair_play')
GO
INSERT [dbo].[Tipo_comunicaciones] ([comunicacion_id], [descripcion]) VALUES (2, N'vale_todo')
GO
INSERT [dbo].[Tipo_comunicaciones] ([comunicacion_id], [descripcion]) VALUES (3, N'no_intervencion')
GO
SET IDENTITY_INSERT [dbo].[Tipo_comunicaciones] OFF
GO
SET IDENTITY_INSERT [dbo].[Tipo_pactos] ON 
GO
INSERT [dbo].[Tipo_pactos] ([tipo_pacto_id], [descripcion]) VALUES (1, N'no_agresion')
GO
INSERT [dbo].[Tipo_pactos] ([tipo_pacto_id], [descripcion]) VALUES (2, N'entre_paises')
GO
INSERT [dbo].[Tipo_pactos] ([tipo_pacto_id], [descripcion]) VALUES (3, N'zona_internacional')
GO
SET IDENTITY_INSERT [dbo].[Tipo_pactos] OFF
GO
/****** Object:  Index [UQ__Jugadore__DC75C67FD95A91FA]    Script Date: 10/05/2025 12:40:38 ******/
ALTER TABLE [dbo].[Jugadores_humanos] ADD UNIQUE NONCLUSTERED 
(
	[usuario_jugador_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO
/****** Object:  Index [UQ__Jugadore__DC75C67FE1F2AF2E]    Script Date: 10/05/2025 12:40:38 ******/
ALTER TABLE [dbo].[Jugadores_humanos] ADD UNIQUE NONCLUSTERED 
(
	[usuario_jugador_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO
/****** Object:  Index [UQ__Jugadore__DC75C67FEAE41945]    Script Date: 10/05/2025 12:40:38 ******/
ALTER TABLE [dbo].[Jugadores_humanos] ADD UNIQUE NONCLUSTERED 
(
	[usuario_jugador_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO
ALTER TABLE [dbo].[Canje_tarjetas]  WITH CHECK ADD  CONSTRAINT [fk_canje] FOREIGN KEY([canje_id])
REFERENCES [dbo].[Canjes] ([canje_id])
GO
ALTER TABLE [dbo].[Canje_tarjetas] CHECK CONSTRAINT [fk_canje]
GO
ALTER TABLE [dbo].[Canje_tarjetas]  WITH CHECK ADD  CONSTRAINT [fk_tarjeta_jugador] FOREIGN KEY([tarjeta_jugador_id])
REFERENCES [dbo].[Tarjeta_jugadores] ([tarjeta_jugador_id])
GO
ALTER TABLE [dbo].[Canje_tarjetas] CHECK CONSTRAINT [fk_tarjeta_jugador]
GO
ALTER TABLE [dbo].[Canjes]  WITH CHECK ADD  CONSTRAINT [fk_jugador_partida_canje] FOREIGN KEY([jugador_partida_canje_id])
REFERENCES [dbo].[Jugador_partidas] ([jugador_id])
GO
ALTER TABLE [dbo].[Canjes] CHECK CONSTRAINT [fk_jugador_partida_canje]
GO
ALTER TABLE [dbo].[Conexion_paises]  WITH CHECK ADD  CONSTRAINT [fk_pais_destino] FOREIGN KEY([pais_destino_id])
REFERENCES [dbo].[Paises] ([pais_id])
GO
ALTER TABLE [dbo].[Conexion_paises] CHECK CONSTRAINT [fk_pais_destino]
GO
ALTER TABLE [dbo].[Conexion_paises]  WITH CHECK ADD  CONSTRAINT [fk_pais_origen] FOREIGN KEY([pais_origen_id])
REFERENCES [dbo].[Paises] ([pais_id])
GO
ALTER TABLE [dbo].[Conexion_paises] CHECK CONSTRAINT [fk_pais_origen]
GO
ALTER TABLE [dbo].[Denuncias]  WITH CHECK ADD  CONSTRAINT [fk_denuncia_acusado] FOREIGN KEY([acusado_id])
REFERENCES [dbo].[Jugadores_base] ([jugador_base_id])
GO
ALTER TABLE [dbo].[Denuncias] CHECK CONSTRAINT [fk_denuncia_acusado]
GO
ALTER TABLE [dbo].[Denuncias]  WITH CHECK ADD  CONSTRAINT [fk_denuncia_acusador] FOREIGN KEY([acusador_id])
REFERENCES [dbo].[Jugadores_base] ([jugador_base_id])
GO
ALTER TABLE [dbo].[Denuncias] CHECK CONSTRAINT [fk_denuncia_acusador]
GO
ALTER TABLE [dbo].[Denuncias]  WITH CHECK ADD  CONSTRAINT [fk_partida_denuncia] FOREIGN KEY([denuncia_partida_id])
REFERENCES [dbo].[Partidas] ([partida_id])
GO
ALTER TABLE [dbo].[Denuncias] CHECK CONSTRAINT [fk_partida_denuncia]
GO
ALTER TABLE [dbo].[Historial_eventos]  WITH CHECK ADD  CONSTRAINT [fk_evento_partida] FOREIGN KEY([historial_partida_id])
REFERENCES [dbo].[Partidas] ([partida_id])
GO
ALTER TABLE [dbo].[Historial_eventos] CHECK CONSTRAINT [fk_evento_partida]
GO
ALTER TABLE [dbo].[Jugador_partidas]  WITH CHECK ADD  CONSTRAINT [fk_color] FOREIGN KEY([color_id])
REFERENCES [dbo].[Colores] ([color_id])
GO
ALTER TABLE [dbo].[Jugador_partidas] CHECK CONSTRAINT [fk_color]
GO
ALTER TABLE [dbo].[Jugador_partidas]  WITH CHECK ADD  CONSTRAINT [fk_jugador_base_partida] FOREIGN KEY([jugador_base_id])
REFERENCES [dbo].[Jugadores_base] ([jugador_base_id])
GO
ALTER TABLE [dbo].[Jugador_partidas] CHECK CONSTRAINT [fk_jugador_base_partida]
GO
ALTER TABLE [dbo].[Jugador_partidas]  WITH CHECK ADD  CONSTRAINT [fk_objetivo] FOREIGN KEY([objetivo_id])
REFERENCES [dbo].[Objetivo_secretos] ([objetivo_id])
GO
ALTER TABLE [dbo].[Jugador_partidas] CHECK CONSTRAINT [fk_objetivo]
GO
ALTER TABLE [dbo].[Jugador_partidas]  WITH CHECK ADD  CONSTRAINT [fk_partida_jugador] FOREIGN KEY([partida_id])
REFERENCES [dbo].[Partidas] ([partida_id])
GO
ALTER TABLE [dbo].[Jugador_partidas] CHECK CONSTRAINT [fk_partida_jugador]
GO
ALTER TABLE [dbo].[Jugadores_bot]  WITH CHECK ADD  CONSTRAINT [fk_jugador_base] FOREIGN KEY([jugador_base_id])
REFERENCES [dbo].[Jugadores_base] ([jugador_base_id])
GO
ALTER TABLE [dbo].[Jugadores_bot] CHECK CONSTRAINT [fk_jugador_base]
GO
ALTER TABLE [dbo].[Jugadores_bot]  WITH CHECK ADD  CONSTRAINT [fk_nivel_bot] FOREIGN KEY([nivel_bot_id])
REFERENCES [dbo].[Niveles_bot] ([nivel_id])
GO
ALTER TABLE [dbo].[Jugadores_bot] CHECK CONSTRAINT [fk_nivel_bot]
GO
ALTER TABLE [dbo].[Jugadores_humanos]  WITH CHECK ADD  CONSTRAINT [fk_jugador_base_humano] FOREIGN KEY([jugador_humano_id])
REFERENCES [dbo].[Jugadores_base] ([jugador_base_id])
GO
ALTER TABLE [dbo].[Jugadores_humanos] CHECK CONSTRAINT [fk_jugador_base_humano]
GO
ALTER TABLE [dbo].[Jugadores_humanos]  WITH CHECK ADD  CONSTRAINT [fk_jugador_humano_usuario] FOREIGN KEY([usuario_jugador_id])
REFERENCES [dbo].[Usuarios] ([usuario_id])
GO
ALTER TABLE [dbo].[Jugadores_humanos] CHECK CONSTRAINT [fk_jugador_humano_usuario]
GO
ALTER TABLE [dbo].[Mensajes]  WITH CHECK ADD  CONSTRAINT [fk_emisor_mensaje] FOREIGN KEY([emisor_id])
REFERENCES [dbo].[Jugadores_base] ([jugador_base_id])
GO
ALTER TABLE [dbo].[Mensajes] CHECK CONSTRAINT [fk_emisor_mensaje]
GO
ALTER TABLE [dbo].[Mensajes]  WITH CHECK ADD  CONSTRAINT [fk_mensaje_partida] FOREIGN KEY([mensaje_partida_id])
REFERENCES [dbo].[Partidas] ([partida_id])
GO
ALTER TABLE [dbo].[Mensajes] CHECK CONSTRAINT [fk_mensaje_partida]
GO
ALTER TABLE [dbo].[Pacto_jugadores]  WITH CHECK ADD  CONSTRAINT [fk_jugador] FOREIGN KEY([jugador_base_id])
REFERENCES [dbo].[Jugadores_base] ([jugador_base_id])
GO
ALTER TABLE [dbo].[Pacto_jugadores] CHECK CONSTRAINT [fk_jugador]
GO
ALTER TABLE [dbo].[Pacto_jugadores]  WITH CHECK ADD  CONSTRAINT [fk_pacto_jugador] FOREIGN KEY([pacto_id])
REFERENCES [dbo].[Pactos] ([pacto_id])
GO
ALTER TABLE [dbo].[Pacto_jugadores] CHECK CONSTRAINT [fk_pacto_jugador]
GO
ALTER TABLE [dbo].[Pacto_paises]  WITH CHECK ADD  CONSTRAINT [fk_pacto_pais] FOREIGN KEY([pacto_id])
REFERENCES [dbo].[Pactos] ([pacto_id])
GO
ALTER TABLE [dbo].[Pacto_paises] CHECK CONSTRAINT [fk_pacto_pais]
GO
ALTER TABLE [dbo].[Pacto_paises]  WITH CHECK ADD  CONSTRAINT [fk_pais_pacto] FOREIGN KEY([pais_id])
REFERENCES [dbo].[Paises] ([pais_id])
GO
ALTER TABLE [dbo].[Pacto_paises] CHECK CONSTRAINT [fk_pais_pacto]
GO
ALTER TABLE [dbo].[Pactos]  WITH CHECK ADD  CONSTRAINT [fk_creador_pacto] FOREIGN KEY([jugador_creador_id])
REFERENCES [dbo].[Jugadores_base] ([jugador_base_id])
GO
ALTER TABLE [dbo].[Pactos] CHECK CONSTRAINT [fk_creador_pacto]
GO
ALTER TABLE [dbo].[Pactos]  WITH CHECK ADD  CONSTRAINT [fk_pacto_partida] FOREIGN KEY([pacto_partida_id])
REFERENCES [dbo].[Partidas] ([partida_id])
GO
ALTER TABLE [dbo].[Pactos] CHECK CONSTRAINT [fk_pacto_partida]
GO
ALTER TABLE [dbo].[Pactos]  WITH CHECK ADD  CONSTRAINT [fk_tipo_pacto] FOREIGN KEY([tipo_pacto_id])
REFERENCES [dbo].[Tipo_pactos] ([tipo_pacto_id])
GO
ALTER TABLE [dbo].[Pactos] CHECK CONSTRAINT [fk_tipo_pacto]
GO
ALTER TABLE [dbo].[Paises]  WITH CHECK ADD  CONSTRAINT [fk_continente_pais] FOREIGN KEY([continente_pais_id])
REFERENCES [dbo].[Continentes] ([continente_id])
GO
ALTER TABLE [dbo].[Paises] CHECK CONSTRAINT [fk_continente_pais]
GO
ALTER TABLE [dbo].[Paises_partida]  WITH CHECK ADD  CONSTRAINT [fk_jugador_pais] FOREIGN KEY([jugador_pais_id])
REFERENCES [dbo].[Jugadores_base] ([jugador_base_id])
GO
ALTER TABLE [dbo].[Paises_partida] CHECK CONSTRAINT [fk_jugador_pais]
GO
ALTER TABLE [dbo].[Paises_partida]  WITH CHECK ADD  CONSTRAINT [fk_pais_partida] FOREIGN KEY([pais_id])
REFERENCES [dbo].[Paises] ([pais_id])
GO
ALTER TABLE [dbo].[Paises_partida] CHECK CONSTRAINT [fk_pais_partida]
GO
ALTER TABLE [dbo].[Paises_partida]  WITH CHECK ADD  CONSTRAINT [fk_partida_pais] FOREIGN KEY([partida_pais_id])
REFERENCES [dbo].[Partidas] ([partida_id])
GO
ALTER TABLE [dbo].[Paises_partida] CHECK CONSTRAINT [fk_partida_pais]
GO
ALTER TABLE [dbo].[Partidas]  WITH CHECK ADD  CONSTRAINT [fk_estado_partida] FOREIGN KEY([estado_id])
REFERENCES [dbo].[Estado_partidas] ([estado_id])
GO
ALTER TABLE [dbo].[Partidas] CHECK CONSTRAINT [fk_estado_partida]
GO
ALTER TABLE [dbo].[Partidas]  WITH CHECK ADD  CONSTRAINT [fk_objetivo_comun] FOREIGN KEY([objetivo_comun_id])
REFERENCES [dbo].[Objetivo_secretos] ([objetivo_id])
GO
ALTER TABLE [dbo].[Partidas] CHECK CONSTRAINT [fk_objetivo_comun]
GO
ALTER TABLE [dbo].[Partidas]  WITH CHECK ADD  CONSTRAINT [fk_tipo_comunicacion_partida] FOREIGN KEY([tipo_comunicacion_id])
REFERENCES [dbo].[Tipo_comunicaciones] ([comunicacion_id])
GO
ALTER TABLE [dbo].[Partidas] CHECK CONSTRAINT [fk_tipo_comunicacion_partida]
GO
ALTER TABLE [dbo].[Tarjeta_jugadores]  WITH CHECK ADD  CONSTRAINT [fk_jugador_partida] FOREIGN KEY([jugador_partida_id])
REFERENCES [dbo].[Jugador_partidas] ([jugador_id])
GO
ALTER TABLE [dbo].[Tarjeta_jugadores] CHECK CONSTRAINT [fk_jugador_partida]
GO
ALTER TABLE [dbo].[Tarjeta_jugadores]  WITH CHECK ADD  CONSTRAINT [fk_tarjeta_pais] FOREIGN KEY([tarjeta_pais_id])
REFERENCES [dbo].[Tarjeta_paises] ([tarjeta_pais_id])
GO
ALTER TABLE [dbo].[Tarjeta_jugadores] CHECK CONSTRAINT [fk_tarjeta_pais]
GO
ALTER TABLE [dbo].[Tarjeta_paises]  WITH CHECK ADD  CONSTRAINT [fk_pais] FOREIGN KEY([pais_id])
REFERENCES [dbo].[Paises] ([pais_id])
GO
ALTER TABLE [dbo].[Tarjeta_paises] CHECK CONSTRAINT [fk_pais]
GO
ALTER TABLE [dbo].[Tarjeta_paises]  WITH CHECK ADD  CONSTRAINT [fk_simbolo] FOREIGN KEY([simbolo_id])
REFERENCES [dbo].[Simbolos] ([simbolo_id])
GO
ALTER TABLE [dbo].[Tarjeta_paises] CHECK CONSTRAINT [fk_simbolo]
GO
ALTER TABLE [dbo].[Turnos]  WITH CHECK ADD  CONSTRAINT [fk_turno_jugador_partida] FOREIGN KEY([turno_jugador_partida_id])
REFERENCES [dbo].[Jugador_partidas] ([jugador_id])
GO
ALTER TABLE [dbo].[Turnos] CHECK CONSTRAINT [fk_turno_jugador_partida]
GO
ALTER TABLE [dbo].[Turnos]  WITH CHECK ADD  CONSTRAINT [fk_turno_partida] FOREIGN KEY([turno_partida_id])
REFERENCES [dbo].[Partidas] ([partida_id])
GO
ALTER TABLE [dbo].[Turnos] CHECK CONSTRAINT [fk_turno_partida]
GO
ALTER TABLE [dbo].[Usuarios]  WITH CHECK ADD  CONSTRAINT [fk_usuario_rol] FOREIGN KEY([usuario_rol_id])
REFERENCES [dbo].[Roles] ([rol_id])
GO
ALTER TABLE [dbo].[Usuarios] CHECK CONSTRAINT [fk_usuario_rol]
GO
USE [master]
GO
ALTER DATABASE [BD_TEG] SET  READ_WRITE 
GO
