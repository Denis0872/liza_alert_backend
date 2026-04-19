package com.example.lizaalertbackend.domain.model;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.Instant;

@Entity
@Table(name = "sighting_report")
public class SightingReport extends AuditableEntity {

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "lost_case_id", nullable = false)
    private LostCase lostCase;

    @Column(name = "reporter_name", nullable = false, length = 150)
    private String reporterName;

    @Column(name = "reporter_phone", length = 40)
    private String reporterPhone;

    @Column(name = "seen_at", nullable = false)
    private Instant seenAt;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false, length = 40)
    private ReportStatus status;

    @Column(name = "confidence_score")
    private Integer confidenceScore;

    @Embedded
    @AttributeOverrides({
        @AttributeOverride(name = "city", column = @Column(name = "sighting_city", length = 120)),
        @AttributeOverride(name = "district", column = @Column(name = "sighting_district", length = 120)),
        @AttributeOverride(name = "address", column = @Column(name = "sighting_address", length = 255)),
        @AttributeOverride(name = "latitude", column = @Column(name = "sighting_latitude", precision = 9, scale = 6)),
        @AttributeOverride(name = "longitude", column = @Column(name = "sighting_longitude", precision = 9, scale = 6)),
        @AttributeOverride(name = "notes", column = @Column(name = "sighting_notes", length = 1000))
    })
    private SearchLocation location;

    @Column(name = "notes", nullable = false, length = 2000)
    private String notes;

    public SightingReport() {
    }

    public LostCase getLostCase() {
        return lostCase;
    }

    public void setLostCase(LostCase lostCase) {
        this.lostCase = lostCase;
    }

    public String getReporterName() {
        return reporterName;
    }

    public void setReporterName(String reporterName) {
        this.reporterName = reporterName;
    }

    public String getReporterPhone() {
        return reporterPhone;
    }

    public void setReporterPhone(String reporterPhone) {
        this.reporterPhone = reporterPhone;
    }

    public Instant getSeenAt() {
        return seenAt;
    }

    public void setSeenAt(Instant seenAt) {
        this.seenAt = seenAt;
    }

    public ReportStatus getStatus() {
        return status;
    }

    public void setStatus(ReportStatus status) {
        this.status = status;
    }

    public Integer getConfidenceScore() {
        return confidenceScore;
    }

    public void setConfidenceScore(Integer confidenceScore) {
        this.confidenceScore = confidenceScore;
    }

    public SearchLocation getLocation() {
        return location;
    }

    public void setLocation(SearchLocation location) {
        this.location = location;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}

