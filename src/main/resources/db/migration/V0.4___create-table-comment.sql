create table comment (
	id bigint not null auto_increment,
    service_order_id bigint not null,
    description text not null,
    creation_date datetime not null,
    
    primary key (id)
);

alter table comment add constraint fk_comment_service_order
foreign key (service_order_id) references service_order (id);