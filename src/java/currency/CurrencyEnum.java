//package com.gameteclabs.bizlogic.enumeration;

/**
 *
 * @author Francisco Franco
 * @version %I%, %G%
 * @since 1.0
 */

public enum CurrencyEnum {
  USD(1, "USD"),
	KHR(2, "KHR"),
	THB(3, "THB"),
	VND(4, "VND"),
	MYR(5, "MYR"),
  IDR(6, "IDR");

	private final int id;
  private final String name;

  private CurrencyEnum(int id, String name) {
    this.id = id;
    this.name = name;
  }
	
	// ==========================
	// Public  methods
	// ==========================
	
	public int getId() {
		return id;
  }
	
  public String getName() {
		return name;
  }
	
	public static CurrencyEnum getById(int id) {
		for(CurrencyEnum e : values()) {
			if (e.id == id) 
				return e;
		}
		return null;
	}
}
