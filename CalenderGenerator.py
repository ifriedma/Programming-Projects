# Generates a calendar when given the year, as well as the first day of the year

def get_first_day_year():
    first_day = int(input('Enter the first day of the year, (ex. Sunday = 0, Monday = 1, Tuesday = 2, etc.):'))
    while first_day < 0 or first_day > 6:
        first_day = int(input('Enter the first day of the year, (ex. Sunday = 0, Monday = 1, Tuesday = 2, etc.):'))
    return first_day

def print_month(year, month, weekDay):
    next_month_start = 0
    month = month_name(month)
    day_first = 1
    printnow = False
    month_print = str(month) + ' - ' + str(year)
    print(f'{month_print:^28}')
    print('-' * 28)
    print(f'{"Sun":>4}{"Mon":>4}{"Tue":>4}{"Wed":>4}{"Thu":>4}{"Fri":>4}{"Sat":>4}')
    for week in range(6):
        for day in range(7):
            if day == weekDay:
                printnow = True
            if day_first > days_in_month(month_to_print, calender_year):
                printnow = False
            if printnow == True:
                print(f'{day_first:>4}', end='')
                day_first += 1
            else:
                print('    ', end='')
        print('')
    if days_in_month(month_to_print, calender_year) == int(30):
        next_month_start = int(weekDay + 2)
        if next_month_start > 6:
            next_month_start -= 7
    elif days_in_month(month_to_print, calender_year) == int(31):
        next_month_start = int(weekDay + 3)
        if next_month_start > 6:
            next_month_start -= 7
    elif days_in_month(month_to_print, calender_year) == int(29):
        next_month_start = int(weekDay + 1)
        if next_month_start > 6:
            next_month_start -= 7
    elif days_in_month(month_to_print, calender_year) == int(28):
        next_month_start = int(weekDay)
    return next_month_start

def month_name(month_int):
    if month_int == 1:
        return 'January'
    elif month_int == 2:
        return 'Febuary'
    elif month_int == 3:
        return 'March'
    elif month_int == 4:
        return 'April'
    elif month_int == 5:
        return 'May'
    elif month_int == 6:
        return 'June'
    elif month_int == 7:
        return 'July'
    elif month_int == 8:
        return 'August'
    elif month_int == 9:
        return 'September'
    elif month_int == 10:
        return 'October'
    elif month_int == 11:
        return 'November'
    elif month_int == 12:
        return 'December'

def days_in_month(month_int, year_int):
    if month_int == 1 or month_int == 3 or month_int == 5 or month_int == 7 or month_int == 8 or month_int == 10 or month_int == 12:
        return int(31)
    elif month_int == 2:
        is_leap_year = False   
        if year_int % 4 == 0:
            is_leap_year == True
            if year_int % 100 == 0:
                if year_int % 400 == 0:
                    is_leap_year = True
                else:
                    is_leap_year = False
        else:
            is_leap_year = True
        if is_leap_year == True:
            return int(28)
        elif is_leap_year == False:
            return int(29)
    elif month_int == 4 or month_int == 6 or month_int == 9 or month_int == 11:
        return int(30)

if __name__ == '__main__':
    num_printed = 1
    month_to_print = 1
    Jan_start = get_first_day_year()
    calender_year = int(input('Enter a year for calendar:'))
    print(f'==Calendar for {calender_year}===')
    print()
    while num_printed <=12:
        Jan_start = print_month(calender_year, month_to_print, Jan_start)
        month_to_print += 1
        num_printed += 1
