/* AssentSoftware (C)2021 */
package com.greek.main.populator;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.Properties;
import java.util.TreeMap;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

@Slf4j
public class PostalCodesDataPopulator implements Runnable {

    private static Properties prop = new Properties();
    private static BasicDataSource dataSource;

    public static void main(String[] args) throws IOException {
        log.info("Populating postal code for Spain");

        loadProperties();
        dataSource = loadDataSource();

        PostalCodesDataPopulator fakeDataPopulator = new PostalCodesDataPopulator();

        for (int x = 0; x < 1; ++x) {
            Thread thread = new Thread(fakeDataPopulator);
            thread.start();
        }
    }

    @Override
    public void run() {
        //		populate();
        try {
            readPostalCodes();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void readPostalCodes() throws IOException, InvalidFormatException, SQLException {
        FileInputStream file =
                new FileInputStream(
                        getClass().getClassLoader().getResource("postalCodes.xls").getFile());
        //		OPCPackage pkg = OPCPackage
        //				.open(new File(getClass().getClassLoader().getResource("postalCodes.xls").getFile()));
        try (Workbook workbook = new HSSFWorkbook(file)) {
            Sheet sheet = workbook.getSheetAt(0);
            TreeMap<String, Tipo1> provincias = new TreeMap<>();
            TreeMap<String, Tipo1> poblaciones = new TreeMap<>();

            int fila = 0;
            long provinciaId = 0;
            long poblacionId = 0;
            long codigoPostalId = 0;

            Tipo1 provincia = null;
            Tipo1 poblacion = null;
            for (Row row : sheet) {
                fila++;

                if (fila == 1) { // Skip the header
                    continue;
                }

                // if (fila == 50) {
                // break;
                // }

                for (Cell cell : row) {
                    log.debug("cell:{} type:{}", cell.getColumnIndex(), cell.getCellType());

                    switch (cell.getCellType()) {
                        case STRING:
                            log.trace("Value:{}", cell.getStringCellValue());

                            if (cell.getColumnIndex() == 1) {
                                provincia = new Tipo1();
                                provincia.setNombre(cell.getStringCellValue());

                                Tipo1 added =
                                        provincias.putIfAbsent(provincia.getNombre(), provincia);

                                if (added == null) {
                                    provincia.setId(++provinciaId);
                                    saveProvincia(provincia, "es");
                                }

                                log.trace(
                                        "Provincia created:{}",
                                        provincias.get(provincia.getNombre()));
                            }

                            if (cell.getColumnIndex() == 2) {
                                poblacion = new Tipo1();
                                poblacion.setNombre(cell.getStringCellValue());

                                Tipo1 added =
                                        poblaciones.putIfAbsent(poblacion.getNombre(), poblacion);

                                if (added == null) {
                                    poblacion.setId(++poblacionId);
                                    savePoblacion(poblacion, "es");
                                }

                                log.trace(
                                        "Poblacion created:{}",
                                        poblaciones.get(poblacion.getNombre()));
                            }

                            break;
                        case NUMERIC:
                            log.trace(
                                    "Value:{}, {}",
                                    cell.getNumericCellValue(),
                                    StringUtils.leftPad(
                                            String.valueOf((int) cell.getNumericCellValue()),
                                            5, // @formatter:off
                                            "0"));

                            saveCodigoPostal(
                                    StringUtils.leftPad(
                                            String.valueOf((int) cell.getNumericCellValue()),
                                            5,
                                            "0"),
                                    provincias.get(provincia.getNombre()),
                                    poblaciones.get(poblacion.getNombre()),
                                    ++codigoPostalId,
                                    12);

                            break;
                        default:
                            log.trace("Value:{}", cell.getRichStringCellValue());
                    }
                }

                log.debug("****************************");
            }
        }
    }

    private void saveCodigoPostal(
            String codigoPostal,
            Tipo1 provincia,
            Tipo1 poblacion,
            long codigoPostalId,
            int ubicacionGeograficaId)
            throws SQLException {
        QueryRunner run = new QueryRunner(dataSource);

        run.update(
                "insert into codigo_postal (id,codigo_postal,id_ubicacion_geografica,id_provincia,id_poblacion,usuario_creacion) "
                        + "values (?,?,?,?,?,'initial')",
                codigoPostalId,
                codigoPostal,
                ubicacionGeograficaId,
                provincia.getId(),
                poblacion.getId());
    }

    private void saveProvincia(Tipo1 provincia, String codPais) throws SQLException {
        QueryRunner run = new QueryRunner(dataSource);

        run.update(
                "insert into provincia (id,codigo_provincia,nombre_provincia,usuario_creacion) "
                        + "values (?,?,?,'initial')",
                provincia.getId(),
                "pro" + codPais + StringUtils.leftPad(String.valueOf(provincia.getId()), 5, "0"),
                provincia.getNombre());
    }

    private void savePoblacion(Tipo1 poblacion, String codPais) throws SQLException {
        QueryRunner run = new QueryRunner(dataSource);

        run.update(
                "insert into poblacion (id,codigo_poblacion,nombre_poblacion,usuario_creacion) "
                        + "values (?,?,?,'initial')",
                poblacion.getId(),
                "pob" + codPais + StringUtils.leftPad(String.valueOf(poblacion.getId()), 5, "0"),
                poblacion.getNombre());
    }

    private static BasicDataSource loadDataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(prop.getProperty("hibernate.connection.driver_class"));
        dataSource.setUrl(prop.getProperty("hibernate.connection.url"));
        dataSource.setUsername(prop.getProperty("hibernate.connection.username"));
        dataSource.setPassword(prop.getProperty("hibernate.connection.password"));

        return dataSource;
    }

    private static void loadProperties() throws IOException {
        try (InputStream input =
                PostalCodesDataPopulator.class
                        .getClassLoader()
                        .getResourceAsStream("domain.properties")) {
            if (input == null) {
                log.debug("Sorry, unable to find config.properties");
                return;
            }

            // load a properties file from class path, inside static method
            prop.load(input);

            // get the property value and print it out
            log.debug(prop.getProperty("hibernate.connection.driver_class"));
            log.debug(prop.getProperty("hibernate.connection.url"));
            log.debug(prop.getProperty("hibernate.connection.username"));
            log.debug(prop.getProperty("hibernate.connection.password"));
        }
    }

    class Tipo1 {
        private Long id;
        private String nombre;

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        @Override
        public String toString() {
            return "Tipo1 [id=" + id + ", nombre=" + nombre + "]";
        }
    }
}
