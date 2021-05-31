#language: ru
Функционал: Погода

  Структура сценария: Погода в городе: <City>
    И отправили запрос на URL - "http://api.weatherstack.com/", эндпоинт - "current", метод = GET с параметрами:
      | access_key | 6d028dcb2cec32ce561ba70d36734c78 |
      | query      | <City>                           |
      | units      | m                                |

    И проверили полученный ответ:
      | location.name    | <City>      |
      | location.country | <Country>   |
      | location.region  | <Region>    |
      | location.lat     | <Latitude>  |
      | location.lon     | <Longitude> |
    Примеры:
      | City     | Country                  | Region    | Latitude | Longitude |
      | Izhevsk  | Russia                   | Udmurt    | 56.850   | 53.233    |
      | Kazan    | Russia                   | Tatarstan | 55.750   | 49.133    |
      | New York | United States of America | New York  | 40.714   | -74.006   |

  Сценарий: Error 105
    И отправили запрос на URL - "http://api.weatherstack.com/", эндпоинт - "current", метод = GET с параметрами:
      | access_key | 6d028dcb2cec32ce561ba70d36734c78 |
      | query      | Kazan                            |
      | units      | m                                |
      | language   | ru                               |
    И проверили полученный ответ:
      | error.code | 105                                                                                    |
      | error.info | Access Restricted - Your current Subscription Plan does not support this API Function. |

  Сценарий: Error 601
    И отправили запрос на URL - "http://api.weatherstack.com/", эндпоинт - "current", метод = GET с параметрами:
      | access_key | 6d028dcb2cec32ce561ba70d36734c78 |
      | query      |                                  |
      | units      | m                                |
    И проверили полученный ответ:
      | error.code | 601                                                                   |
      | error.info | Please specify a valid location identifier using the query parameter. |

  Сценарий: Error 103
    И отправили запрос на URL - "http://api.weatherstack.com/", эндпоинт - "qwerrt", метод = GET с параметрами:
      | access_key | 6d028dcb2cec32ce561ba70d36734c78 |
      | query      | Kazan                            |
      | units      | m                                |
    И проверили полученный ответ:
      | error.code | 103                               |
      | error.info | This API Function does not exist. |

  Сценарий: Error 101
    И отправили запрос на URL - "http://api.weatherstack.com/", эндпоинт - "current", метод = GET с параметрами:
      | access_key | 0     |
      | query      | Kazan |
      | units      | m     |
    И проверили полученный ответ:
      | error.code | 101                                                                                     |
      | error.info | You have not supplied a valid API Access Key. [Technical Support: support@apilayer.com] |



