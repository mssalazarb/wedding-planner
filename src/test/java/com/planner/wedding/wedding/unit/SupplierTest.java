package com.planner.wedding.wedding.unit;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.planner.wedding.wedding.domain.model.Supplier;
import com.planner.wedding.wedding.domain.ports.in.SupplierService;
import com.planner.wedding.wedding.domain.ports.out.SupplierRepository;

@SpringBootTest
public class SupplierTest {
    @MockBean
    private SupplierRepository repository;

    @Autowired
    private SupplierService service;

    @Test
    @DisplayName("ST-001 Create Supplier")
    void testCreateSupplier() {
        Supplier newSupplier = new Supplier(null, 1L, "1234567890", "test@test.com", "High Street", "Side Street", null,
                null);
        Supplier savedSupplier = new Supplier(1L, 1L, "1234567890", "test@test.com", "High Street", "Side Street", null,
                null);

        when(repository.save(newSupplier)).thenReturn(savedSupplier);

        Supplier created = service.createSupplier(newSupplier);

        assertNotNull(created.getId());
        assertEquals(savedSupplier.getId(), created.getId());
        assertEquals(newSupplier.getSupplierTypeId(), created.getSupplierTypeId());
        assertEquals(newSupplier.getPhone(), created.getPhone());
        assertEquals(newSupplier.getEmail(), created.getEmail());
        assertEquals(newSupplier.getHighStreet(), created.getHighStreet());
        assertEquals(newSupplier.getSideStreet(), created.getSideStreet());
        verify(repository, times(1)).save(newSupplier);
    }

    @Test
    @DisplayName("ST-002 Search Supplier by id")
    void testGetSupplierByIdExisting() {
        Long supplierId = 1L;
        Supplier existingSupplier = new Supplier(supplierId, 1L, "1234567890", "test@test.com", "High Street",
                "Side Street", null, null);

        when(repository.findById(supplierId)).thenReturn(existingSupplier);

        Supplier found = service.getSupplierById(supplierId);

        assertNotNull(found);
        assertEquals(existingSupplier.getId(), found.getId());
        assertEquals(existingSupplier.getSupplierTypeId(), found.getSupplierTypeId());
        assertEquals(existingSupplier.getPhone(), found.getPhone());
        assertEquals(existingSupplier.getEmail(), found.getEmail());
        assertEquals(existingSupplier.getHighStreet(), found.getHighStreet());
        assertEquals(existingSupplier.getSideStreet(), found.getSideStreet());
    }

    @Test
    @DisplayName("ST-003 Search Supplier by undefined id")
    void testGetSupplierByIdNotExisting() {
        Long supplierId = 999L;

        when(repository.findById(supplierId)).thenReturn(null);

        Supplier found = service.getSupplierById(supplierId);

        assertNull(found);
    }

    @Test
    @DisplayName("ST-004 Search all Suppliers")
    void testGetAllSuppliers() {
        List<Supplier> suppliers = new ArrayList<>();
        suppliers.add(new Supplier(1L, 1L, "1234567890", "test@test.com", "High Street", "Side Street", null, null));
        suppliers.add(
                new Supplier(2L, 2L, "0987654321", "example@example.com", "Main Street", "Cross Street", null, null));

        when(repository.findAll()).thenReturn(suppliers);

        List<Supplier> foundList = service.getAllSuppliers();

        assertFalse(foundList.isEmpty());
        assertEquals(suppliers.size(), foundList.size());
        assertEquals(suppliers.get(0).getId(), foundList.get(0).getId());
        assertEquals(suppliers.get(1).getId(), foundList.get(1).getId());
    }

    @Test
    @DisplayName("ST-005 Update Supplier")
    void testUpdateSupplier() {
        Long supplierId = 1L;
        Supplier existingSupplier = new Supplier(supplierId, 1L, "1234567890", "test@test.com", "High Street",
                "Side Street", null, null);
        Supplier updatedSupplier = new Supplier(supplierId, 1L, "0987654321", "updated@example.com", "New Street",
                "Updated Street", null, null);

        when(repository.save(updatedSupplier)).thenReturn(updatedSupplier);
        when(repository.findById(supplierId)).thenReturn(existingSupplier);

        Supplier updated = service.updateSupplier(updatedSupplier);

        assertNotNull(updated);
        assertEquals(existingSupplier.getId(), updated.getId());
        assertEquals(updatedSupplier.getPhone(), updated.getPhone());
        assertEquals(updatedSupplier.getEmail(), updated.getEmail());
        assertEquals(updatedSupplier.getHighStreet(), updated.getHighStreet());
        assertEquals(updatedSupplier.getSideStreet(), updated.getSideStreet());
        verify(repository, times(1)).save(updatedSupplier);
    }

    @Test
    @DisplayName("ST-006 Delete Supplier by id")
    void testDeleteSupplier() {
        Long supplierId = 1L;
        Supplier existingSupplier = new Supplier(supplierId, 1L, "1234567890", "test@test.com", "High Street",
                "Side Street", null, null);

        when(repository.findById(supplierId)).thenReturn(existingSupplier);

        service.deleteSupplier(supplierId);

        verify(repository, times(1)).deleteById(supplierId);
    }
}
