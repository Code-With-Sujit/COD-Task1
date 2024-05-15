package com.hospital.dao;

import java.util.List;

import com.hospital.entities.Specialist;

public interface SpecialistDao 
{
     public boolean addSpecialist(String specialistName);
     public List<Specialist>  getAllSpecialist();
     public int countSpecialists();
}
