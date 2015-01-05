package hu.thesis.timetableplanner.model;

public interface AbstractEntity<ID> {

	ID getId();

	void setId(ID id);
}
