from vuonghao import tuyen, phu, val, bieuthuc, VuongHao

menhde1 = tuyen(phu(val('p')), val('q'))
menhde2 = tuyen(phu(val('q')), val('r'))
menhde3 = tuyen(phu(val('p')), val('r'))
mybieuthuc = bieuthuc([menhde1, menhde2], [menhde3])
VuongHao(mybieuthuc).run()
