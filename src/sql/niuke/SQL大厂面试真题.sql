-- SQL156
select a.video_id,
       round(avg(if(TIMESTAMPDIFF(SECOND, start_time, end_time)>=duration, 1, 0)), 3) as avg_comp_play_rate
from tb_user_video_log a left join tb_video_info b
on a.video_id = b.video_id
where year(start_time)=2021
group by a.video_id
order by avg_comp_play_rate desc