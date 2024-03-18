package com.example.pma.dao;

import com.example.pma.dataTransferObject.ChartData;
import com.example.pma.entities.Project;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

// CrudRepository<Project, Long> second argument is the primary key of the table
// We defined a ID for each project so the PK is type Long
public interface ProjectRepository extends CrudRepository<Project, Long> {
    @Override
    public List<Project> findAll();

    @Query(nativeQuery = true, value = "SELECT stage as label, COUNT(*) as value FROM project GROUP BY stage")
    public List<ChartData> getProjectStatus();
}
