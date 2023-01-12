package com.example.threadsample.service;


import com.example.threadsample.data.dto.PortFolioDto;

import java.util.List;

public interface PortfolioService {

    List<PortFolioDto> getAllDataList();

    PortFolioDto getOneData(Long idx);
}
