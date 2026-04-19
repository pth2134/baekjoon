select t.ITEM_ID, ITEM_NAME, RARITY
from (
    select t.ITEM_ID
    from item_tree t
    left join item_info i
    on t.parent_item_id = i.item_id
    where i.rarity = 'RARE'
 ) t left join item_info i
 on t.item_id = i.item_id
 order by t.item_id desc