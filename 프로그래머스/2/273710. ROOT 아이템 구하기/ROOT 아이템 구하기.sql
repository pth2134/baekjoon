-- 코드를 작성해주세요
select t.ITEM_ID, ITEM_NAME
from ( select item_id
     from item_tree
     where parent_item_id is null) t
left join item_info i on t.item_id = i.item_id
order by t.item_id