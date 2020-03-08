
-- 전체 주가 52주 RS계산하기.
UPDATE es_stock_historic_data ori
		, (
			SELECT test.date, (
			SELECT SUM(cc.close) / COUNT(cc.seq) AS rs_52w
			FROM es_stock_historic_data cc
			WHERE cc.date >= FROM_UNIXTIME (UNIX_TIMESTAMP(STR_TO_DATE(test.date, '%Y%m%d')) -(365 * 60 * 60 * 24), '%Y%m%d') AND cc.date <= test.date
			ORDER BY cc.date DESC
							) AS rs_52w
			FROM es_stock_historic_data test
					) base 
SET ori.rs_52w = base.rs_52w
WHERE ori.date = base.date


-- 각각 주가 52주 RS계산하기.
UPDATE es_stock_historic_data ori
		, (
			SELECT test.date, (
			SELECT SUM(cc.close) / COUNT(cc.seq) AS rs_52w
			FROM es_stock_historic_data cc
			WHERE cc.date >= FROM_UNIXTIME (UNIX_TIMESTAMP(STR_TO_DATE(test.date, '%Y%m%d')) -(365 * 60 * 60 * 24), '%Y%m%d') AND cc.date <= test.date
			ORDER BY cc.date DESC
							) AS rs_52w
			FROM es_stock_historic_data test
					) base 
SET ori.rs_52w = base.rs_52w
WHERE ori.date = base.date