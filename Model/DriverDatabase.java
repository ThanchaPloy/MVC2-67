package Model;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class DriverDatabase {
    
    private Map<String,Driver> drivers;
    private Random random = new Random();
    
    public DriverDatabase() {
        drivers = new HashMap<>();
        createSampleData();
    }
    //สร้างsample509y;
    private void createSampleData(){
        //สร้างlistมาใช้ในการเก็บชุดข้อมูลของผู้ขับขี่
        List<Driver> sample = new ArrayList<>();

        for(int i=1; i<=50; i++){
            String licenseId = generateId(random);
            String licenseType = generateType(random);
            LocalDate diverBirth = generateBD();
            String licenseStatus = generateStatus(random);
            
            Driver driver = new Driver(licenseId, licenseType, diverBirth, licenseStatus);
            sample.add(driver);
            drivers.put(licenseId,driver);
        }
    }
    //Generatr id by random
    private String generateId(Random random){
        int firstDigit = random.nextInt(9)+1; //เลขตัวแรกที่เป็น1-9
        int remainingDigit = random.nextInt(100_000_000);
        return String.format("%d%08d", firstDigit, remainingDigit);//%08dเพื่อให้มีเลข8หลักอยู่ตลอด
    }
    //random license type
    private String generateType(Random random){
        int rand = random.nextInt(3);
        if (rand==0) {return "General";}
        else if(rand==1) {return "New Driver";}
        else if(rand==2) {return "Public Driver";}
        else{return "Error";}
    }
    //Generate Birthday
    private LocalDate generateBD(){

        LocalDate today = LocalDate.now();
        LocalDate minDate = today.minusYears(80); // อายุสูงสุด 80 ปี
        LocalDate maxDate = today.minusYears(15); // อายุขั้นต่ำ 15 ปี

        long randomDays = ChronoUnit.DAYS.between(minDate, maxDate);
        return minDate.plusDays(random.nextInt((int) randomDays));
    }
    //Random status
    private String generateStatus(Random random){
        int rand = random.nextInt(3);
        if (rand==0) {return "Normal";}
        else if(rand==1) {return "Expired";}
        else if(rand==2) {return "suspended";}
        else{return "Error";}
    }

    public Map<String, Driver> getDrivers() {
        return drivers;
    }
    public Driver getDriver(String licenseId) {
        if (licenseId == null || licenseId.isEmpty()) return null;
        return drivers.get(licenseId);
    }
}
