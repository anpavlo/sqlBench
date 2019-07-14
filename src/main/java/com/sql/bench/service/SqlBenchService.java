package com.sql.bench.service;

import com.sql.bench.dto.MeasureResultDTO;

public interface SqlBenchService {
    MeasureResultDTO runBench(int exeQuantity);
}
