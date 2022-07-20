-- SQL156
select a.video_id,
       round(avg(if(TIMESTAMPDIFF(SECOND, start_time, end_time)>=duration, 1, 0)), 3) as avg_comp_play_rate
from tb_user_video_log a left join tb_video_info b
on a.video_id = b.video_id
where year(start_time)=2021
group by a.video_id
order by avg_comp_play_rate desc;

-- SQL157
select tag, concat(avg_play_progress, '%') as avg_play_progress
from (
         select tag,
                round(avg(
                        if(TIMESTAMPDIFF(second, start_time, end_time) >= duration, 1,
                            TIMESTAMPDIFF(second, start_time, end_time) / duration)
                    ) * 100, 2) as avg_play_progress
         from tb_user_video_log join tb_video_info using (video_id)
         group by tag
         having avg_play_progress > 60
         order by avg_play_progress desc
     )
as t_progress;

-- SQL158
select tag, sum(if_retweet) as retweet_cnt,
       round(sum(if_retweet) / count(1), 3) as retweet_rate
from tb_user_video_log a join tb_video_info b using (video_id)
where datediff(date((select max(start_time) from tb_user_video_log)), date(a.start_time)) <= 29
group by tag
order by retweet_rate desc;
-- where date(start_time) > (
--     select date_sub(max(start_time), interval 30 DAY )
--     from tb_user_video_log
--     )

-- SQL159
select author,
       date_format(start_time, '%Y-%m') month,
       round(sum(case when if_follow=1 then 1 when if_follow=2 then -1 else 0 end) / count(uid), 3) fans_growth_rate,
       -- 外壳的sum和over是对应的！
       sum(sum(case when if_follow=1 then 1 when if_follow=2 then -1 else 0 end))
           over (partition by author order by date_format(start_time, '%Y-%m')) total_fans
from tb_user_video_log left join tb_video_info using (video_id)
where year(start_time)=2021
group by author, month
order by author, total_fans

-- 160
select *
from(
    select t1.tag, t1.d,
           sum(t1.if_like_sum) over (partition by t1.tag order by t1.d rows 6 preceding),
           max(t1.if_retweet_sum) over (partition by t1.tag order by t1.d rows 6 preceding),
    from(
        select tag, date(start_time) d, sum(if_like) if_like_sum, sum(if_retweet) if_retweet_sum
        from tb_user_video_log join tb_video_info using (video_id)
        group by tag, d
            ) as t1
        ) as t2
where t2.d between '2021-10-01' and '2021-10-03'
order by t2.tag desc, t2.d




















