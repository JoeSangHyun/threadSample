package com.example.threadsample.service.impl;

import com.example.threadsample.data.dto.PortFolioDto;
import com.example.threadsample.data.entity.PortFolio;
import com.example.threadsample.data.repository.PortFolioRepository;
import com.example.threadsample.service.PortfolioService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class PortFolioImpl implements PortfolioService {

    private final PortFolioRepository portFolioRepository;
    private String string;

    @Override
    public List<PortFolioDto> getAllDataList() {

        List<PortFolio> portFolios = portFolioRepository.findAll();

        List<PortFolioDto> portFolioDtos = new ArrayList<>();

        for(int i=0;i<portFolios.size();i++) {
            PortFolioDto portFolioDto = new PortFolioDto();

            portFolioDto.setIdx(portFolios.get(i).getIdx());
            portFolioDto.setDeadline(portFolios.get(i).getDeadline());
            portFolioDto.setStart_date(portFolios.get(i).getStart_date());
            portFolioDto.setHeader(portFolios.get(i).getHeader());
            portFolioDto.setImage_path(portFolios.get(i).getImage_path());
            portFolioDtos.add(portFolioDto);
        }

         return portFolioDtos;
    }

    @Override
    public PortFolioDto getOneData(Long idx) {

        PortFolioDto portFolioDto = new PortFolioDto();

        try {
            Optional<PortFolio> portFolio = portFolioRepository.findByIdx(idx);

            if(portFolio.isPresent()) {
                portFolioDto.setIdx(portFolio.get().getIdx());
                portFolioDto.setStart_date(portFolio.get().getStart_date());
                portFolioDto.setDeadline(portFolio.get().getDeadline());
                portFolioDto.setHeader(portFolio.get().getHeader());
                portFolioDto.setDescription(portFolio.get().getDescription());
                portFolioDto.setImage_path(portFolio.get().getImage_path());
            } else {
                portFolioDto.setIdx(0L);
                portFolioDto.setStart_date("");
                portFolioDto.setDeadline("");
                portFolioDto.setHeader("");
                portFolioDto.setDescription("");
                portFolioDto.setImage_path("");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return portFolioDto;

    }

    public void print(int n, String string) throws InterruptedException {
        this.string = string;
        log.info("number : {}, {} service start!", n , this.string);
        Thread.sleep(3000);
        log.info("number : {}, {} service end!",n, this.string);
    }
}
