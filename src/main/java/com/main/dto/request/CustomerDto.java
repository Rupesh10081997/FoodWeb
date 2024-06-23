package com.main.dto.request;

import com.main.enums.Status;
import lombok.Data;
import org.springframework.context.annotation.Configuration;

import javax.naming.Name;
import java.time.LocalDateTime;
import java.util.Date;

@Data
public class CustomerDto {
    private String name;
    private String status;
    private String contactNo;
    private String startDate;
    private String endDate;

    public CustomerDto(String name, String status, String contactNo, String startDate, String endDate) {
        this.name = name;
        this.status = status;
        this.contactNo = contactNo;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "CustomerDto{" +
                "name='" + name + '\'' +
                ", status='" + status + '\'' +
                ", contactNo='" + contactNo + '\'' +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                '}';
    }
}
