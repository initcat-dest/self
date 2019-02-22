package com.base.self.model;

import com.google.gson.Gson;

/**
 * 数据类型 		   大小  范围 												默认值
 * shot(短整型) 		16 	-32768 - 32768 										0
 * int(整型) 		32 	-2147483648-2147483648  								0
 * long(长整型) 		64 	-9233372036854477808-9233372036854477808 			0
 * float(浮点型) 		32 	-3.40292347E+38-3.40292347E+38 						0.0f
 * double(双精度) 	64 	-1.79769313486231570E+308-1.79769313486231570E+308 	0.0d
 * char(字符型) 		16 	‘ \u0000 - u\ffff ’ 									‘\u0000 ’
 * boolean(布尔型) 	1 	true/false 											false
 * byte(字节) 		8 	-128 - 127 											0
 */
public class BaseTestModel {
	public short _short;
	public int _int;
	public long _long;
	public float _float;
	public double _double;
	public char _char;
	public boolean _boolean;
	public byte _byte;
	
	public Short _Short;
	public Integer _Integer;
	public Long _Long;
	public Float _Float;
	public Double _Double;
	public Character _Character;
	public Boolean _Boolean;
	public Byte _Byte;
	
	public String string;
	public Object object;
	public Gson gson;
	
	public BaseTestModel() {
		super();
	} 
	
	
}
