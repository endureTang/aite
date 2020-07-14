/*
 * 获取当前sequence
 */
create function currval(v_seq_name VARCHAR(50))   
returns integer 
begin     
    declare value integer;       
    set value = 0;       
    select current_val into value  from nj_id_sequence where seq_name = v_seq_name; 
   return value; 
end;
/*
 * 获取下一个sequence
 */
create function nextval (v_seq_name VARCHAR(50))
    returns integer
begin
    update nj_id_sequence set current_val = current_val + increment_val  where seq_name = v_seq_name;
    return currval(v_seq_name);
end;

/*
 * 产品codetrigger
 */
CREATE TRIGGER `TRI_PRODUCT_CODE` BEFORE INSERT ON `nj_product` FOR EACH ROW BEGIN
set NEW.product_code = nextval('PRODUCT_CODE');
END;

CREATE TRIGGER `TRI_CHANNEL_ID` BEFORE INSERT ON `nj_product_channel` FOR EACH ROW BEGIN
set NEW.channel_id = nextval('CHANNEL_ID');
END;
/*
 * 配置产品代码生成逻辑
 */
insert into nj_id_sequence values('PRODUCT_CODE',1000,1);
insert into nj_id_sequence values('CHANNEL_ID',1,1);