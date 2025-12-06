INSERT INTO muscle_group (name) VALUES
 ('shoulders'),
 ('back'),
 ('chest'),
 ('biceps'),
 ('triceps'),
 ('abs'),
 ('quadriceps'),
 ('hamstrings'),
 ('buttocks'),
 ('calfs');

-- Ejemplos de ejercicios (PUEDES MODIFICARLOS MÁS ADELANTE)

INSERT INTO exercise_templates (name, muscle_group_id) VALUES
 ('Overhead Press', 1),
 ('Lateral Raises', 1),

 ('Pull-ups', 2),
 ('Lat Pulldown', 2),

 ('Bench Press', 3),
 ('Chest Fly', 3),

 ('Bicep Curl', 4),
 ('Hammer Curl', 4),

 ('Tricep Pushdown', 5),
 ('Overhead Extension', 5),

 ('Crunches', 6),
 ('Plank', 6),

 ('Squats', 7),
 ('Leg Press', 7),

 ('Romanian Deadlift', 8),
 ('Leg Curl', 8),

 ('Hip Thrust', 9),
 ('Glute Bridge', 9),

 ('Calf Raise', 10),
 ('Seated Calf Raise', 10);
