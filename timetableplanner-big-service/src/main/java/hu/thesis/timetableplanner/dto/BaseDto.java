package hu.thesis.timetableplanner.dto;

public class BaseDto implements AbstractDto<Long> {

	private Long id;

	@Override
	public void setId(Long id) {
		this.id = id;

	}

	@Override
	public Long getId() {
		return this.id;
	}

}