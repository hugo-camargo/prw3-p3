ALTER TABLE consertos
ADD COLUMN uuid VARCHAR(36) NOT NULL DEFAULT RANDOM_UUID();

-- Atualiza registros existentes, atribuindo um UUID único para cada linha
UPDATE consertos
SET uuid = RANDOM_UUID()
WHERE uuid IS NULL;

-- Garante unicidade
ALTER TABLE consertos
ADD CONSTRAINT uk_consertos_uuid UNIQUE (uuid);