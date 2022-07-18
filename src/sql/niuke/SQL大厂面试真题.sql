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