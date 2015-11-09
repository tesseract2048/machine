#
# Test register
curl "http://localhost:8080/api/v1/machine/register?city=shijiazhuang&deviceId=%22%22&stationInfo=%E5%8C%97%E4%BA%AC%E5%8D%97%E7%AB%99&sequenceNumber=1&provice=%22hubei%22"

# Test id card query
curl "http://localhost:8080/api/v1/ticket/query_ticket?cardId=1234688"
