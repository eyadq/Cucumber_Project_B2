select * from postgres.document.users where first_name = 'Smitty' and last_name = 'Werbenjagermanjensen';

select * from postgres.identity.users where first_name = 'Smitty' and last_name = 'Werbenjagermanjensen';

delete from postgres.document.users where first_name = 'Smitty' and last_name = 'Werbenjagermanjensen';

delete from postgres.identity.users where first_name = 'Smitty' and last_name = 'Werbenjagermanjensen';

commit;