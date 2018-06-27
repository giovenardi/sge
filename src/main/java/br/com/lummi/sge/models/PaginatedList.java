package br.com.lummi.sge.models;

import java.util.List;

public class PaginatedList {
	
	 private final List<?> currentList;
	 public static final int TAMANHO_PAGINA_DEFAULT = 10;
	   private final Number count;
	   private int pageSize = TAMANHO_PAGINA_DEFAULT;

	   public PaginatedList(List<?> currentList, Number count)
	   {
	      this.currentList = currentList;
	      this.count = count;
	   }

	   public PaginatedList(List<?> currentList, Number count, int max)
	   {
	      this(currentList, count);
	      if (max != 0) {
	    	  this.pageSize = max;
	      }
	   }

	   public List<?> getCurrentList()
	   {
	      return currentList;
	   }

	   public int getCount()
	   {
	      return count.intValue();
	   }

	   public int getNumberOfPages()
	   {
	      int total = getCount();
	      int pages = total / pageSize;

	      if (total % pageSize > 0)
	      {
	         pages++;
	      }
	      return pages == 0 ? 1 : pages;
	   }

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

}
