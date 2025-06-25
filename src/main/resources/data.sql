-- Categorii simple - fara diacritice
INSERT INTO categories (name, description) VALUES
                                               ('Electronice', 'Produse electronice'),
                                               ('Birotica', 'Echipamente de birou'),
                                               ('Software', 'Aplicatii software'),
                                               ('Gaming', 'Produse gaming'),
                                               ('Mobilier', 'Mobilier de birou'),
                                               ('Networking', 'Echipamente de retea');

-- Persoane extinse pentru testarea paginarii
INSERT INTO persons (first_name, last_name, email, birth_date) VALUES
                                                                   ('Ion', 'Popescu', 'ion.popescu@email.com', '1985-03-15'),
                                                                   ('Maria', 'Ionescu', 'maria.ionescu@email.com', '1990-07-22'),
                                                                   ('Andrei', 'Georgescu', 'andrei.georgescu@email.com', '1988-12-01'),
                                                                   ('Elena', 'Marinescu', 'elena.marinescu@email.com', '1992-05-18'),
                                                                   ('Mihai', 'Radulescu', 'mihai.radulescu@email.com', '1987-09-30'),
                                                                   ('Ana', 'Stoica', 'ana.stoica@email.com', '1991-01-12'),
                                                                   ('Cristian', 'Dumitrescu', 'cristian.dumitrescu@email.com', '1986-11-25'),
                                                                   ('Alexandra', 'Popa', 'alexandra.popa@email.com', '1993-04-08'),
                                                                   ('Gabriel', 'Constantin', 'gabriel.constantin@email.com', '1989-08-14'),
                                                                   ('Diana', 'Munteanu', 'diana.munteanu@email.com', '1994-02-28'),
                                                                   ('Vlad', 'Radu', 'vlad.radu@email.com', '1986-06-10'),
                                                                   ('Simona', 'Nistor', 'simona.nistor@email.com', '1991-09-17'),
                                                                   ('Adrian', 'Tudor', 'adrian.tudor@email.com', '1988-12-03'),
                                                                   ('Carmen', 'Dima', 'carmen.dima@email.com', '1992-11-21'),
                                                                   ('Razvan', 'Ilie', 'razvan.ilie@email.com', '1985-08-15');

-- Companii simple - fara diacritice
INSERT INTO companies (name, address, email, phone) VALUES
                                                        ('TechSoft SRL', 'Str. Tehnologiei nr. 123, Bucuresti', 'contact@techsoft.ro', '021-123-4567'),
                                                        ('Digital Solutions SA', 'Bd. Revolutiei nr. 45, Cluj-Napoca', 'info@digitalsolutions.ro', '0264-567-890'),
                                                        ('Innovation Hub SRL', 'Str. Inovatiei nr. 67, Timisoara', 'office@innovationhub.ro', '0256-234-567'),
                                                        ('Green Energy SA', 'Calea Victoriei nr. 89, Bucuresti', 'contact@greenenergy.ro', '021-345-6789'),
                                                        ('Smart Systems SRL', 'Str. Inteligenta nr. 34, Iasi', 'hello@smartsystems.ro', '0232-456-789');

-- Produse extinse pentru testarea paginarii - fara diacritice
INSERT INTO products (name, description, price, stock, category_id) VALUES
                                                                        ('Laptop Professional', 'Laptop pentru profesionisti', 3499.99, 25, 1),
                                                                        ('Smartphone Advanced', 'Telefon inteligent', 1299.50, 50, 1),
                                                                        ('Tastatura Gaming', 'Tastatura pentru gaming', 299.99, 75, 4),
                                                                        ('Mouse Wireless', 'Mouse fara fir', 149.50, 100, 2),
                                                                        ('Monitor 4K', 'Monitor ultra HD', 1899.99, 15, 4),
                                                                        ('Imprimanta Laser', 'Imprimanta laser color', 2199.00, 12, 2),
                                                                        ('Webcam HD', 'Camera web full HD', 189.99, 45, 1),
                                                                        ('Router WiFi', 'Router wireless', 449.99, 35, 6),
                                                                        ('SSD 1TB', 'Disc solid state', 399.99, 60, 1),
                                                                        ('Scaun Gaming', 'Scaun ergonomic gaming', 899.99, 15, 5),
                                                                        ('Birou Reglabil', 'Birou cu inaltime reglabila', 1299.99, 8, 5),
                                                                        ('Casti Premium', 'Casti cu anulare zgomot', 599.99, 40, 1),
                                                                        ('Tableta Ultra', 'Tableta performanta', 899.00, 30, 1),
                                                                        ('Powerbank 20000mAh', 'Baterie externa', 129.99, 80, 1),
                                                                        ('Switch Gigabit', 'Switch de retea', 259.99, 25, 6),
                                                                        ('UPS 1500VA', 'Sursa neintreruptibila', 699.99, 18, 1),
                                                                        ('Proiector HD', 'Proiector pentru prezentari', 1499.99, 10, 1),
                                                                        ('Dock Station', 'Statie de andocare laptop', 349.99, 22, 2);

-- Adrese simple - fara diacritice
INSERT INTO addresses (street, city, postal_code, country, person_id) VALUES
                                                                          ('Str. Florilor nr. 25', 'Bucuresti', '012345', 'Romania', 1),
                                                                          ('Bd. Magheru nr. 18', 'Bucuresti', '010234', 'Romania', 2),
                                                                          ('Str. Mihai Viteazu nr. 45', 'Cluj-Napoca', '400123', 'Romania', 3),
                                                                          ('Calea Dorobantilor nr. 78', 'Cluj-Napoca', '400567', 'Romania', 4),
                                                                          ('Str. Universitatii nr. 12', 'Timisoara', '300234', 'Romania', 5),
                                                                          ('Bd. Revolutiei nr. 33', 'Timisoara', '300456', 'Romania', 6),
                                                                          ('Str. Stefan cel Mare nr. 67', 'Iasi', '700123', 'Romania', 7);

-- Comenzi simple - folosind CURRENT_TIMESTAMP pentru H2
INSERT INTO orders (order_number, order_date, status, total_amount, customer_id) VALUES
                                                                                     ('ORD-001', CURRENT_TIMESTAMP, 'PENDING', 3799.48, 1),
                                                                                     ('ORD-002', CURRENT_TIMESTAMP, 'COMPLETED', 1449.49, 2),
                                                                                     ('ORD-003', CURRENT_TIMESTAMP, 'PENDING', 449.49, 3),
                                                                                     ('ORD-004', CURRENT_TIMESTAMP, 'COMPLETED', 2599.98, 4),
                                                                                     ('ORD-005', CURRENT_TIMESTAMP, 'SHIPPED', 1829.98, 5),
                                                                                     ('ORD-006', CURRENT_TIMESTAMP, 'PENDING', 939.98, 6),
                                                                                     ('ORD-007', CURRENT_TIMESTAMP, 'COMPLETED', 1199.99, 7);