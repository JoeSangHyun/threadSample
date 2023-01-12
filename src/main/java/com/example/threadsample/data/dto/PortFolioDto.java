package com.example.threadsample.data.dto;

import lombok.Data;

@Data
public class PortFolioDto {

    private Long idx;

    private String start_date;

    private String deadline;

    private String header;

    private String description;

    private String image_path;
}
