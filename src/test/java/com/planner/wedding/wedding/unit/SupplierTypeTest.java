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

import com.planner.wedding.wedding.domain.model.SupplierType;
import com.planner.wedding.wedding.domain.ports.in.SupplierTypeService;
import com.planner.wedding.wedding.domain.ports.out.SupplierTypeRepository;

@SpringBootTest
class SupplierTypeTest {

    @MockBean
    private SupplierTypeRepository repository;

    @Autowired
    private SupplierTypeService service;

    @Test
    @DisplayName("STT-001 Create Supplier Type")
    void testCreateSupplierType() {
        SupplierType newSupplierType = new SupplierType(null, "Wholesale", "Wholesale Supplier", null, null);
        SupplierType savedSupplierType = new SupplierType(1L, "Wholesale", "Wholesale Supplier", null, null);

        when(repository.save(newSupplierType)).thenReturn(savedSupplierType);

        SupplierType created = service.createSupplierType(newSupplierType);

        assertNotNull(created.getId());
        assertEquals(savedSupplierType.getId(), created.getId());
        assertEquals(newSupplierType.getType(), created.getType());
        assertEquals(newSupplierType.getSupplierName(), created.getSupplierName());
        verify(repository, times(1)).save(newSupplierType);
    }

    @Test
    @DisplayName("STT-002 Search supplier type by id")
    void testGetSupplierTypeByIdExisting() {
        Long typeId = 1L;
        SupplierType existingSupplierType = new SupplierType(typeId, "Retail", "Retail Supplier", null, null);

        when(repository.findById(typeId)).thenReturn(existingSupplierType);

        SupplierType found = service.getSupplierTypeById(typeId);

        assertNotNull(found);
        assertEquals(existingSupplierType.getId(), found.getId());
        assertEquals(existingSupplierType.getType(), found.getType());
        assertEquals(existingSupplierType.getSupplierName(), found.getSupplierName());
    }

    @Test
    @DisplayName("STT-003 Search supplier type by undefined id")
    void testGetSupplierTypeByIdNotExisting() {
        Long typeId = 999L;

        when(repository.findById(typeId)).thenReturn(null);

        SupplierType found = service.getSupplierTypeById(typeId);

        assertNull(found);
    }

    @Test
    @DisplayName("STT-004 Search all supplier types")
    void testGetAllSupplierTypes() {
        List<SupplierType> supplierTypes = new ArrayList<>();
        supplierTypes.add(new SupplierType(1L, "Wholesale", "Wholesale Supplier", null, null));
        supplierTypes.add(new SupplierType(2L, "Retail", "Retail Supplier", null, null));

        when(repository.findAll()).thenReturn(supplierTypes);

        List<SupplierType> foundList = service.getAllSupplierTypes();

        assertFalse(foundList.isEmpty());
        assertEquals(supplierTypes.size(), foundList.size());
        assertEquals(supplierTypes.get(0).getId(), foundList.get(0).getId());
        assertEquals(supplierTypes.get(1).getId(), foundList.get(1).getId());
    }

    @Test
    @DisplayName("STT-004 Update Supplier type")
    void testUpdateSupplierType() {
        Long typeId = 1L;
        SupplierType existingSupplierType = new SupplierType(typeId, "Retail", "Retail Supplier", null, null);
        SupplierType updatedSupplierType = new SupplierType(typeId, "Retail", "Updated Retail Supplier", null, null);

        when(repository.save(updatedSupplierType)).thenReturn(updatedSupplierType);
        when(repository.findById(typeId)).thenReturn(existingSupplierType);

        SupplierType updated = service.updateSupplierType(updatedSupplierType);

        assertNotNull(updated);
        assertEquals(existingSupplierType.getId(), updated.getId());
        assertEquals(updatedSupplierType.getSupplierName(), updated.getSupplierName());
        verify(repository, times(1)).save(updatedSupplierType);
    }

    @Test
    @DisplayName("STT-005 Delete Supplier type by id")
    void testDeleteSupplierType() {
        Long typeId = 1L;
        SupplierType existingSupplierType = new SupplierType(typeId, "Retail", "Retail Supplier", null, null);

        when(repository.findById(typeId)).thenReturn(existingSupplierType);

        service.deleteSupplierType(typeId);

        verify(repository, times(1)).deleteById(typeId);
    }

}
