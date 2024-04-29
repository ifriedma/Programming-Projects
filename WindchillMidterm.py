temp = float(input('Enter current air temperature that must be a value >= -58 and <= 50 degrees: '))
windspeed = float(input('Enter the current air wind speed that must be >= 3 mph: '))
tem_valid = True
wind_valid = True

windchill = 35.74 + 0.6215 * temp - 35.75 * (windspeed ** 0.16) + 0.4275 * temp * (windspeed ** 0.16)

if temp < -58 or temp > 50:
    tem_valid = False

if windspeed < 3:
    wind_valid = False

if tem_valid == True and wind_valid == True:
    print(f'The wind-chill is currently calculated to be: {windchill:.2f}')
    if windchill <= -18:
        print('WARNING: Frostbite can occur in less than 30 minutes')

if tem_valid == True and wind_valid == False:
    print('Input Error: entered wind speed must be >= 3 mph')

if tem_valid == False and wind_valid == True:
    print('Input Error: entered air temperature must be >= -58 and <= 50 degrees')

if tem_valid == False and wind_valid == False:
    print('Input Error: entered air temperature and entered air wind speed are both outside of valid ranges')
