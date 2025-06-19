create table assessment (
	id bigint not null auto_increment,
	vehicle_id bigint not null,
	description text not null,
	fine_amount decimal(10,2) not null,
	date_occurrence datetime not null,
	primary key (id)
);

alter table assessment add constraint fk_assessment_vehicle foreign key (vehicle_id) references vehicle (id);