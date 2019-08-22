package com.massoftware.service;

public class AbstractFilter extends Entity {

	// ---------------------------------------------------------------------------------------------------------------------------

//	protected int _levelDefault = 0;

	private Boolean unlimited = false;

	private Integer limit;

	private Integer offset;

	private Integer orderBy = 1;

	private Boolean orderByDesc = false;

//	private Integer level;

	// ---------------------------------------------------------------------------------------------------------------------------

	// GET Unlimited
	public Boolean getUnlimited() {
		return this.unlimited;
	}

	// SET Unlimited
	public void setUnlimited(Boolean unlimited) {
		unlimited = (unlimited == null) ? false : unlimited;
		this.unlimited = unlimited;
	}

	// GET Limit
	public Integer getLimit() {
		return this.limit;
	}

	// SET Limit
	public void setLimit(Integer limit) {
		limit = (limit == null || limit < 1) ? 50 : limit;
		this.limit = limit;
	}

	// GET Offset
	public Integer getOffset() {
		return this.offset;
	}

	// SET Offset
	public void setOffset(Integer offset) {
		offset = (offset == null || offset < 0) ? 0 : offset;
		this.offset = offset;
	}

	// GET Order by att
	public Integer getOrderBy() {
		return this.orderBy;
	}

	// SET Order by att
	public void setOrderBy(Integer orderBy) {
		this.orderBy = (orderBy == null) ? 1 : orderBy;
	}

	// GET Order by desc
	public Boolean getOrderByDesc() {
		return this.orderByDesc;
	}

	// SET Order by desc
	public void setOrderByDesc(Boolean orderByDesc) {
		orderByDesc = (orderByDesc == null) ? false : orderByDesc;
		this.orderByDesc = orderByDesc;
	}

//	// GET Level
//	public Integer getLevel() {
//		level = (level == null || level < 0) ? _levelDefault : level;
//		level = (level != null && level > 3) ? _levelDefault : level;
//		return this.level;
//	}

//	// SET Level
//	public void setLevel(Integer level) {
//		level = (level == null || level < 0) ? _levelDefault : level;
//		level = (level != null && level > 3) ? _levelDefault : level;
//		this.level = level;
//	}

	@Override
	public boolean equals(Object obj) {

		if (obj == null) {
			return false;
		}

		if (obj == this) {
			return true;
		}

		if (obj instanceof AbstractFilter == false) {
			return false;
		}

		AbstractFilter other = (AbstractFilter) obj;

		// -------------------------------------------------------------------

		if (other.getUnlimited() == null && this.getUnlimited() != null) {
			return false;
		}

		if (other.getUnlimited() != null && this.getUnlimited() == null) {
			return false;
		}

		if (other.getUnlimited() != null && this.getUnlimited() != null) {

			if (other.getUnlimited().equals(this.getUnlimited()) == false) {
				return false;
			}

		}

		// -------------------------------------------------------------------

		if (other.getLimit() == null && this.getLimit() != null) {
			return false;
		}

		if (other.getLimit() != null && this.getLimit() == null) {
			return false;
		}

		if (other.getLimit() != null && this.getLimit() != null) {

			if (other.getLimit().equals(this.getLimit()) == false) {
				return false;
			}

		}

		// -------------------------------------------------------------------

		if (other.getOffset() == null && this.getOffset() != null) {
			return false;
		}

		if (other.getOffset() != null && this.getOffset() == null) {
			return false;
		}

		if (other.getOffset() != null && this.getOffset() != null) {

			if (other.getOffset().equals(this.getOffset()) == false) {
				return false;
			}

		}

		// -------------------------------------------------------------------

		if (other.getOrderBy() == null && this.getOrderBy() != null) {
			return false;
		}

		if (other.getOrderBy() != null && this.getOrderBy() == null) {
			return false;
		}

		if (other.getOrderBy() != null && this.getOrderBy() != null) {

			if (other.getOrderBy().equals(this.getOrderBy()) == false) {
				return false;
			}

		}

		// -------------------------------------------------------------------

		if (other.getOrderByDesc() == null && this.getOrderByDesc() != null) {
			return false;
		}

		if (other.getOrderByDesc() != null && this.getOrderByDesc() == null) {
			return false;
		}

		if (other.getOrderByDesc() != null && this.getOrderByDesc() != null) {

			if (other.getOrderByDesc().equals(this.getOrderByDesc()) == false) {
				return false;
			}

		}

		// -------------------------------------------------------------------

//		if (other.getLevel() == null && this.getLevel() != null) {
//			return false;
//		}
//
//		if (other.getLevel() != null && this.getLevel() == null) {
//			return false;
//		}
//
//		if (other.getLevel() != null && this.getLevel() != null) {
//
//			if (other.getLevel().equals(this.getLevel()) == false) {
//				return false;
//			}
//
//		}

		// -------------------------------------------------------------------

		return true;
	}

}
