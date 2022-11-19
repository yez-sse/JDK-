delimiter $
create procedure empProc()
begin
    select * from employees;
end$

call empProc();

# select name from mysql.proc where db='travel3'

show procedure status;

delimiter $
create procedure empProc2()
begin
    declare sum int;
    select count(*) into sum from employees;
    select sum;
end$

call empProc2();

drop procedure if exists empProc3;
delimiter $
create procedure empProc3()
begin
    declare salary int default 8000;
    declare words varchar(20) default 10;
    if salary<8000 then
        set words='低收入';
    elseif salary>=8000 and salary<12000 then
        set words='中等收入';
    elseif salary>=12000 then
        set words='高收入';
    end if;
    select concat('年龄：', salary, '，属于：', words);
end $;

call empProc3();

delimiter $
create procedure test04(in salary int, out words varchar(10))
begin
    if salary<8000 then
        set words='低收入';
    elseif salary>=8000 and salary<12000 then
        set words='中等收入';
    elseif salary>=12000 then
        set words='高收入';
    end if;
end $;

# set @words=''; -- no need
call test04(8000, @words);
select @words;

delimiter $
create procedure test05(in salary int, out words varchar(10))
begin
    case
    when salary<8000 then
        set words='低收入';
    when salary>=8000 and salary<12000 then
        set words='中等收入';
    when salary>=12000 then
        set words='高收入';
    end case;
end $;

# set @words=''; -- no need
call test05(8000, @words);
select @words;  # 类似于全局变量可以拿出来用


drop procedure if exists test06;
delimiter $
create procedure test06(in n int, out total int, in num int)
begin
#     declare total int default 0;
#     declare num int default 1;
    declare temp int default 0;
    while num <= n do
        set temp = temp + num;
        set num = num + 1;
    end while;
    set total = temp;
#     select total;
end $;

# set @total = 0;
call test06(100,@total, 1);
select @total;

# set @total2 = 0;
drop procedure if exists test07;
create procedure test07(in n int, out total2 int, in num int)
begin
    declare temp int default 0;
    repeat
        set temp = temp + num;
        set num = num + 1;
    until num=n+1 end repeat;
    set total2 = temp;
end;
call test07(100, @total2, 1);
select @total2
