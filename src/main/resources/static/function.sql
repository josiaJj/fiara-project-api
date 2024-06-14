
--delete image
CREATE OR REPLACE FUNCTION DeleteImage(p_image_id INTEGER)
RETURNS VOID AS $$
BEGIN
    UPDATE car
    SET image_id = NULL
    WHERE image_id = p_image_id;
    UPDATE brand
    SET image_id = NULL
    WHERE image_id = p_image_id;
    DELETE FROM image
    WHERE image_id = p_image_id;
END;
$$ LANGUAGE plpgsql;

--delete car

CREATE OR REPLACE FUNCTION DeleteCar(p_car_id INTEGER)
RETURNS VOID AS $$
BEGIN
    DELETE FROM appointment
    WHERE car_id = p_car_id;
    DELETE FROM car
    WHERE car_id = p_car_id;
END;
$$ LANGUAGE plpgsql;