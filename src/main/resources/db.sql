CREATE TABLE CURRENCY_CONVERSION (
    id INT PRIMARY KEY,
    country_code VARCHAR(10) NOT NULL,
    conversion_factor float NOT NULL
);