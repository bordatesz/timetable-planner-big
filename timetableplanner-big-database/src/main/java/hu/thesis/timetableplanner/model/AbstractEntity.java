package hu.thesis.timetableplanner.model;

public interface AbstractEntity<ID> {

	void setId(ID id);
	ID getId();
}
