use ken_test;
create table test_data
(
	id INT not null AUTO_INCREMENT primary key,
    str_val nvarchar(50),
    time_val timestamp,
    is_valid boolean,
    version int
);

create index test_data_str_val_indx on test_data (is_valid, str_val);

drop table test_data;