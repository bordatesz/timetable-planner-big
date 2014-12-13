package hu.thesis.timetableplanner.pagination;

import java.util.List;

import org.springframework.data.domain.Page;

public class Pagination <D> {

    public static final int PAGE_SIZE = 50;

    private int pageSize;
    private int currentIndex;
    private int beginIndex;
    private int endIndex;
    private int totalPages;
    private List<D> content;
    private String pageName;

    /**
     * Constructor for the class.
     * E is for Entity, D is for Dto.
     *
     * @param page constains the page informations (eg.: totalpages)
     * @param content the data we want to store
     */
    public <E> Pagination(Page<E> page, List<D> content) {
        this.currentIndex = page.getNumber() + 1;
        this.beginIndex = Math.max(1, currentIndex - 5);
        this.endIndex = Math.min(beginIndex + 10, page.getTotalPages());
        this.totalPages = page.getTotalPages();
        this.content = content;
        this.pageSize = PAGE_SIZE;
    }

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getCurrentIndex() {
		return currentIndex;
	}

	public void setCurrentIndex(int currentIndex) {
		this.currentIndex = currentIndex;
	}

	public int getBeginIndex() {
		return beginIndex;
	}

	public void setBeginIndex(int beginIndex) {
		this.beginIndex = beginIndex;
	}

	public int getEndIndex() {
		return endIndex;
	}

	public void setEndIndex(int endIndex) {
		this.endIndex = endIndex;
	}

	public int getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

	public List<D> getContent() {
		return content;
	}

	public void setContent(List<D> content) {
		this.content = content;
	}

	public String getPageName() {
		return pageName;
	}

	public void setPageName(String pageName) {
		this.pageName = pageName;
	}

    
}