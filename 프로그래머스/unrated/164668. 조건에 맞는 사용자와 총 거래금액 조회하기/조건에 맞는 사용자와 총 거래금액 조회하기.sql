

SELECT USER_ID, NICKNAME, sum(price) as TOTAL_SALES
from used_goods_board join used_goods_user
on used_goods_board.writer_id = used_goods_user.user_id
where status='DONE'
group by writer_id
having sum(price) >= 700000
order by TOTAL_SALES;