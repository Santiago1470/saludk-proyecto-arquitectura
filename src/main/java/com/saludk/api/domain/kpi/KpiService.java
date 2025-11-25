package com.saludk.api.domain.kpi;

import com.saludk.api.domain.alerta.AlertaCriticaRepository;
import com.saludk.api.domain.cita.CitaRepository;
import com.saludk.api.domain.compra.CompraItemRepository;
import com.saludk.api.domain.compra.CompraRepository;
import com.saludk.api.domain.medico.MedicoRepository;
import com.saludk.api.domain.paciente.PacienteRepository;
import com.saludk.api.domain.producto.ProductoRepository;
import com.saludk.api.domain.suscripcion.SuscripcionPacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class KpiService {

    @Autowired
    private MedicoRepository medicoRepository;

    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private CitaRepository citaRepo;

    @Autowired
    private CompraItemRepository compraItemRepo;

    @Autowired
    private SuscripcionPacienteRepository suscripcionRepo;

    @Autowired
    private PacienteRepository pacienteRepo;

    @Autowired
    private CompraRepository compraRepo;

    @Autowired
    private AlertaCriticaRepository alertaRepo;

    public Map<String, Object> obtenerKpis() {

        Map<String, Object> kpis = new HashMap<>();

        kpis.put("producto_disponibles", productoRepository.findAll());

        kpis.put("consultas_mas_demandadas", citaRepo.kpiConsultasMasDemandadas());

        kpis.put("productos_mas_vendidos", compraItemRepo.kpiProductosMasVendidos());

        Long totalPacientes = pacienteRepo.totalPacientes();
        Long totalSuscripciones = suscripcionRepo.cantidadSuscripciones();

        double tasa = totalPacientes == 0 ? 0 : (double) totalSuscripciones / totalPacientes;

        kpis.put("tasa_suscripcion", tasa);

        kpis.put("total_pacientes", totalPacientes);

        kpis.put("pacientes_recurrentes", citaRepo.kpiPacientesRecurrentes().size());

        kpis.put("total_medicos", medicoRepository.totalMedicos());

        kpis.put("medicos_mas_solicitados", citaRepo.kpiMedicosMasSolicitados());

        kpis.put("ingresos_totales", compraRepo.kpiIngresosTotales());

        kpis.put("alertas_criticas", alertaRepo.kpiAlertasCriticas());

        return kpis;
    }
}
