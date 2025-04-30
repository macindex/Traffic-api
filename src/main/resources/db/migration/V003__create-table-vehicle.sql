create table vehicle(
id bigint not null auto_increment,
owner_id bigint not null,
brand varchar(20) not null,
model varchar(20) not null,
plate varchar(7) not null,
status varchar(20) not null,
date_register datetime not null,
date_seizure datetime,
primary key (id)
);
alter table vehicle add constraint fk_vehicle_owner foreign key (owner_id) references owner (id);
alter table vehicle add constraint uk_vehicle unique (plate);