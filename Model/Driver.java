package Model;

import java.time.LocalDate;

public class Driver {
    
    private String licenseId;
    private String licenseType;
    private LocalDate driverBirth;
    private String licenseStatus;

    //Driver data
    public Driver(String licenseId, String licenseType, LocalDate driverBirth, String licenseStatus){
        this.licenseId = licenseId;
        this.licenseType = licenseType;
        this.driverBirth = driverBirth;
        this.licenseStatus = licenseStatus;
    }

    public String getLicenseId() {
        return licenseId;
    }

    public String getLicenseType() {
        return licenseType;
    }

    public LocalDate getDriverBirth() {
        return driverBirth;
    }

    public String getLicenseStatus() {
        return licenseStatus;
    } 

    public void setLicenseId(String licenseId) {
        this.licenseId = licenseId;
    }

    public void setLicenseType(String licenseType) {
        this.licenseType = licenseType;
    }

    public void setDriverBirth(LocalDate driverBirth) {
        this.driverBirth = driverBirth;
    }

    public void setLicenseStatus(String licenseStatus) {
        this.licenseStatus = licenseStatus;
    }

    public boolean isValidId(){
        return licenseId != null && !licenseId.isEmpty() && licenseId.charAt(0) != '0';
    }
    
}
