# Test register
curl "http://localhost:8080/api/v1/machine/register?city=beijing&province=beijing&stationInfo=nanzhan&deviceId=18"

# Test id card query
curl "http://localhost:8080/api/ticket/query_ticket?cardId=1234688"
