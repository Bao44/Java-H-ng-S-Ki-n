create database QuanLiXe
use QuanLiXe
CREATE TABLE sanpham(
	maLoaiXe varchar (10) NOT NULL,
	loaiXe nvarchar (100) NOT NULL,	
	Nuocsx varchar(10) NOT NULL,
	GiaBan bigint,
	Soluong int,
	Sosuon varchar(10),
	soKhung varchar(10),
	soPK int,
	Primary key(maLoaiXe));
drop database QuanLiXe