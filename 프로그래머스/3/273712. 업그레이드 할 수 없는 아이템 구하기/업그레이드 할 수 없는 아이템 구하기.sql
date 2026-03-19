-- 코드를 작성해주세요
select i.ITEM_ID, ITEM_NAME, RARITY
from item_info i left join item_tree t on i.item_id = t.parent_item_id
where t.item_id is null
order by i.item_id desc