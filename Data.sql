Use QL_CAPHE
Go
--Thêm bảng chức vụ
insert into ChucVu values ('NVK',N'Nhân viên kho');
insert into ChucVu values ('NVPC',N'Nhân viên pha chế');
insert into ChucVu values ('NVTN',N'Nhân viên thu ngân');
insert into ChucVu values ('QLK',N'Quản lý kho');
insert into ChucVu values ('QLNV',N'Quản lý nhân viên');
--Thêm bảng bàn
insert into Ban(MaBan) values ('B01');
insert into Ban(MaBan) values ('B02');
insert into Ban(MaBan) values ('B03');
insert into Ban(MaBan) values ('B04');
insert into Ban(MaBan) values ('B05');
insert into Ban(MaBan) values ('B06');

--Thêm nhân viên
SET DATEFORMAT DMY;
Insert into NhanVien values ('NV01',N'Trần Thị My An', '19-09-1999','0347893234','098678456213', 'NVTN',N'Nữ');
Insert into NhanVien values ('NV02',N'Nguyễn Đông Phương', '19-09-1999','0347893234','098678456213', 'QLK','Nam');
Insert into NhanVien values ('NV03',N'Trần Ngọc Thành', '19-09-1999','0347893234','098678456213', 'QLNV',N'Nữ');
Insert into NhanVien values ('NV04',N'Tống Như An', '19-09-1999','0347893234','098678456213', 'NVPC',N'Nữ');
Insert into NhanVien values ('NV05',N'Hồ Như Hà', '19-09-1999','0347893234','098678456213', 'NVK',N'Nam');
Insert into NhanVien values ('NV06',N'Dương Thị Phương Thi', '19-09-1999','0347893234','098678456213', 'NVK',N'Nữ');
Insert into NhanVien values ('NV07',N'Trần Ngọc Hiếu Thảo', '19-09-1999','0347893234','098678456213', 'NVPC',N'Nam');
Insert into NhanVien values ('NV08',N'Nguyễn Tô Bảo Ngọc', '19-09-1999','0347893234','098678456213', 'NVTN',N'Nữ');
--Thêm Nhà cung cấp
Insert into NhaCungCap(TenNCC) values (N'Nhà cung cấp Vinamilk');
Insert into NhaCungCap(TenNCC) values (N'Nhà cung cấp Thanh Xuân');
Insert into NhaCungCap(TenNCC) values (N'Nhà cung cấp Tuổi trẻ');
Insert into NhaCungCap(TenNCC) values (N'Nhà cung cấp Farm');
Insert into NhaCungCap(TenNCC) values (N'Nhà cung cấp Cà phê Hoàng');
--Thêm phân loại
Insert into PhanLoai values ('L1',N'Sinh Tố');
Insert into PhanLoai values ('L2',N'Cà phê');
Insert into PhanLoai values ('L3',N'Bánh ngọt');
Insert into PhanLoai values ('L4',N'Topping');
--Thêm kho Nguyên liệu
Insert into Kho_Nguyen_Lieu values ('NL01',N'Sữa Ngôi Sao',0,N'Hộp');
Insert into Kho_Nguyen_Lieu values ('NL02',N'Đường phèn',0,N'Hộp');
Insert into Kho_Nguyen_Lieu values ('NL03',N'Hạt cà phê Thái Lan',0,N'Hộp');
Insert into Kho_Nguyen_Lieu values ('NL04',N'Hạt cà phê Mỹ',0,N'Bịch');
Insert into Kho_Nguyen_Lieu values ('NL05',N'Bột cà phê Thái Lan',0,N'Bịch');
--Thêm Khuyến mãi
Insert into KhuyenMai values ('KM01',N'Khuyến mãi khách hàng đồng',GETDATE(),'2100-12-12',0.1);
Insert into KhuyenMai values ('KM02',N'Khuyến mãi thứ ba vui vẻ',GETDATE(),'2100-12-12',0.2);
Insert into KhuyenMai values ('KM03',N'Khuyến mãi tháng 9',GETDATE(),'2100-12-12',0.2);
Insert into KhuyenMai values ('KM04',N'Khuyến mãi khách hàng bạc',GETDATE(),'2100-12-12',0.2);
Insert into KhuyenMai values ('KM05',N'Khuyến mãi upsize miễn phí',GETDATE(),'2100-12-12',0.1);
Insert into KhuyenMai values ('KM06',N'Khuyến mãi mua 2 ly tặng 1 ly',GETDATE(),'2100-12-12',0.1);
				-- Thêm tầm 5 dòng khuyến mãi ( Khuyến mãi tháng 6, khách bạc)



--Thêm Loại sự cố
Insert into LoaiSuCo(TenLoai) values (N'Sự cố khách hàng');
Insert into LoaiSuCo(TenLoai) values (N'Sự cố Nhân viên');
Insert into LoaiSuCo(TenLoai) values (N'Sự cố quán');
--thêm ThucDon
Insert into ThucDon values ('M01', N'Cà phê capuchino', 'M', 30000, 'L2');
Insert into ThucDon values ('M02', N'Cà phê capuchino', 'L', 35000, 'L2');
Insert into ThucDon values ('M03', N'Bạc xĩu đá', 'M', 25000, 'L2');
Insert into ThucDon values ('M04', N'Bạc xĩu đá', 'L', 30000, 'L2');
Insert into ThucDon values ('M05', N'Sinh tố mãng cầu', 'M', 35000, 'L1');
Insert into ThucDon values ('M06', N'Sinh tố mãng cầu', 'L', 40000, 'L1');
Insert into ThucDon values ('M07', N'Sinh tố dâu', 'M', 35000, 'L1');
Insert into ThucDon values ('M08', N'Sinh tố dâu', 'L', 40000, 'L1');
Insert into ThucDon values ('M09', N'Tiramisu', 'M', 40000, 'L3');
Insert into ThucDon values ('M10', N'Tiramisu', 'L', 45000, 'L3');
Insert into ThucDon values ('M11', N'Mouse Matcha', 'M', 35000, 'L3');
Insert into ThucDon values ('M12', N'Mouse Matcha', 'L', 40000, 'L3');
Insert into ThucDon values ('M13', N'Thạch cà phê', 'M', 10000, 'L4');
Insert into ThucDon values ('M14', N'Thạch cà phê', 'L', 15000, 'L4');
Insert into ThucDon values ('M15', N'Thạch củ năng', 'M', 10000, 'L4');
Insert into ThucDon values ('M16', N'Thạch củ năng', 'L', 15000, 'L4');
			--Thêm mỗi loại 2 món, mỗi món phải có 2 size M L

