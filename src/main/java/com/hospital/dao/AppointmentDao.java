package com.hospital.dao;

import java.util.List;

import com.hospital.entities.Appointment;

public interface AppointmentDao {
	
	public boolean addAppointment(Appointment appointment);
	
	public List<Appointment> getAllAppointments(int userId);
	public List<Appointment> getAllAppointmentsOfLoginDoctor(int doctorId);
    public Appointment getAppointmentById(int appointmentId);
    public boolean updateCommentStatus(int id,int doctorId,String comment);
    public List<Appointment> getAllAppointments();
    public int countAppointments();
    public boolean updateBill(int id);
}
