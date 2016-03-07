-- -----------------------------------------------------
-- Table `produto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `produto` (
  `nomeProduto` VARCHAR(150) NOT NULL,
  `descricaoProduto` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`nomeProduto`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `filial`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `filial` (
  `nomeFilial` VARCHAR(150) NOT NULL,
  `descricaoFilial` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`nomeFilial`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `estoque`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `estoque` (
  `filial` VARCHAR(150) NOT NULL,
  `produto` VARCHAR(150) NOT NULL,
  `qtde` INT NOT NULL,
  PRIMARY KEY (`filial`, `produto`) ,
    FOREIGN KEY (`filial`) REFERENCES `filial` (`nomeFilial`),
    FOREIGN KEY (`produto`) REFERENCES `produto` (`nomeProduto`))
ENGINE = InnoDB;
