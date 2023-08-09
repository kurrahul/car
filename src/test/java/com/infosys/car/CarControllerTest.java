/*
 * package com.infosys.car;
 * 
 * import static org.hamcrest.CoreMatchers.any; import static
 * org.mockito.Mockito.verify; import static org.mockito.Mockito.when; import
 * static
 * org.springframework.test.web.client.match.MockRestRequestMatchers.content;
 * import static
 * org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
 * import static
 * org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
 * import static
 * org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
 * import static
 * org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
 * import static
 * org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
 * import static
 * org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
 * import static
 * org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
 * 
 * import java.util.ArrayList; import java.util.List; import java.util.Optional;
 * 
 * import org.junit.jupiter.api.Test; import
 * org.junit.jupiter.api.extension.ExtendWith; import
 * org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
 * import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
 * import org.springframework.boot.test.context.SpringBootTest; import
 * org.springframework.boot.test.mock.mockito.MockBean; import
 * org.springframework.context.annotation.Bean; import
 * org.springframework.context.annotation.Configuration; import
 * org.springframework.http.MediaType; import
 * org.springframework.test.context.ContextConfiguration; import
 * org.springframework.test.context.junit.jupiter.SpringJUnitConfig; import
 * org.springframework.test.web.servlet.MockMvc; import
 * org.springframework.test.web.servlet.request.MockMvcRequestBuilders; import
 * org.springframework.test.web.servlet.result.MockMvcResultMatchers;
 * 
 * import com.car.controller.CarController; import com.car.entity.Car; import
 * com.car.service.CarService;
 * 
 * @WebMvcTest
 * 
 * @ContextConfiguration(classes = CarController.class)
 * 
 * public class CarControllerTest {
 * 
 * @Autowired private MockMvc mockMvc;
 * 
 * @MockBean private CarService carService;
 * 
 * @Test public void testGetAllCars() throws Exception { List<Car> cars = new
 * ArrayList<>(); cars.add(new Car("001", "Corolla", "2022")); cars.add(new
 * Car("002", "Civic", "2022"));
 * 
 * when(carService.getAllCars()).thenReturn(cars);
 * 
 * mockMvc.perform(get("/api/cars")) .andExpect(status().isOk())
 * //.andExpect(content().contentType(MediaType.APPLICATION_JSON))
 * .andExpect(jsonPath("$.size()").value(2));
 * 
 * 
 * mockMvc.perform(MockMvcRequestBuilders .get("/api/cars")
 * .accept(MediaType.APPLICATION_JSON)) .andDo(print())
 * .andExpect(status().isOk())
 * //.andExpect(MockMvcResultMatchers.jsonPath("$.employees").exists())
 * .andExpect(MockMvcResultMatchers.jsonPath("$.size()").value(1));
 * 
 * 
 * }
 * 
 * 
 * @Test public void testGetCarById_ExistingCar() throws Exception { Car car =
 * new Car("001", "Corolla", "2022");
 * 
 * when(carService.getCarById(1L)).thenReturn(Optional.of(car));
 * 
 * mockMvc.perform(get("/api/cars/1")) .andExpect(status().isOk())
 * .andExpect(jsonPath("$.model").value("Corolla"))
 * .andExpect(jsonPath("$.year").value(2022)); }
 * 
 * @Test public void testGetCarById_NonExistingCar() throws Exception {
 * when(carService.getCarById(99L)).thenReturn(Optional.empty());
 * 
 * mockMvc.perform(get("/api/cars/99")) .andExpect(status().isNotFound()); }
 * 
 * @Test public void testCreateCar() throws Exception { Car car = new Car("001",
 * "Corolla", "2022"); Car savedCar = new Car("001", "Corolla", "2022");
 * 
 * when(carService.saveCar(car)).thenReturn(savedCar);
 * 
 * mockMvc.perform(post("/api/cars") .contentType(MediaType.APPLICATION_JSON)
 * .content("{\"id\":\"001\",\"model\":\"Corolla\",\"year\":2022}"))
 * .andExpect(status().isCreated())
 * //.andExpect(content().contentType(MediaType.APPLICATION_JSON))
 * .andExpect(jsonPath("$.id").value("001"))
 * .andExpect(jsonPath("$.model").value("Corolla"))
 * .andExpect(jsonPath("$.year").value("2022")); }
 * 
 * @Test public void testUpdateCar() throws Exception { Car car = new Car("001",
 * "Corolla", "2022"); Car updatedCar = new Car("002", "Camry", "2023");
 * 
 * when(carService.saveCar(car)).thenReturn(updatedCar);
 * 
 * mockMvc.perform(put("/api/cars/1") .contentType(MediaType.APPLICATION_JSON)
 * .content("{\"model\":\"Camry\",\"year\":2023}")) .andExpect(status().isOk())
 * //.andExpect(content().contentType(MediaType.APPLICATION_JSON))
 * //.andExpect(jsonPath("$.id").value(1L))
 * .andExpect(jsonPath("$.id").value("001"))
 * .andExpect(jsonPath("$.model").value("Corolla"))
 * .andExpect(jsonPath("$.year").value("2022")); }
 * 
 * @Test public void testDeleteCar() throws Exception {
 * mockMvc.perform(delete("/api/cars/1")) .andExpect(status().isNoContent());
 * 
 * // Verify that the deleteCar method was called in the carService
 * //verify(carService).deleteCar(1L); }
 * 
 * }
 */