package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class inimenuitemsusuario extends GXProcedure
{
   public inimenuitemsusuario( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( inimenuitemsusuario.class ), "" );
   }

   public inimenuitemsusuario( int remoteHandle ,
                               ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( )
   {
      execute_int();
   }

   private void execute_int( )
   {
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      new web.newmenuitem(remoteHandle, context).execute( (byte)(4), httpContext.getMessage( "Pruebas", ""), "", false, "", false) ;
      new web.newmenuitem(remoteHandle, context).execute( (byte)(4), httpContext.getMessage( "Liquidación", ""), "", true, "", false) ;
      new web.newmenuitem(remoteHandle, context).execute( (byte)(4), httpContext.getMessage( "Conceptos", ""), "", false, httpContext.getMessage( "Liquidación", ""), false) ;
      new web.newmenuitem(remoteHandle, context).execute( (byte)(4), httpContext.getMessage( "Fórmula", ""), "", false, httpContext.getMessage( "Conceptos", ""), false) ;
      new web.newmenuitem(remoteHandle, context).execute( (byte)(4), httpContext.getMessage( "Periodos", ""), "", false, httpContext.getMessage( "Liquidación", ""), false) ;
      new web.newmenuitem(remoteHandle, context).execute( (byte)(4), httpContext.getMessage( "Liquidaciones", ""), "", false, httpContext.getMessage( "Periodos", ""), true) ;
      new web.newmenuitem(remoteHandle, context).execute( (byte)(4), httpContext.getMessage( "LiquidacionLegajo", ""), httpContext.getMessage( "Recibos", ""), false, httpContext.getMessage( "Liquidaciones", ""), true) ;
      new web.newmenuitem(remoteHandle, context).execute( (byte)(4), httpContext.getMessage( "LiquidacionRecibo", ""), httpContext.getMessage( "Detalle", ""), false, httpContext.getMessage( "LiquidacionLegajo", ""), true) ;
      new web.newmenuitem(remoteHandle, context).execute( (byte)(4), httpContext.getMessage( "LiquidacionAjustes", ""), httpContext.getMessage( "Ajustes de liquidación", ""), false, httpContext.getMessage( "LiquidacionLegajo", ""), true) ;
      new web.newmenuitem(remoteHandle, context).execute( (byte)(4), httpContext.getMessage( "LiquidacionLSD", ""), httpContext.getMessage( "Libro de Sueldos Digital", ""), false, httpContext.getMessage( "Liquidaciones", ""), true) ;
      new web.newmenuitem(remoteHandle, context).execute( (byte)(4), httpContext.getMessage( "PeriodoLSD", ""), httpContext.getMessage( "Libro de Sueldos Digital", ""), false, httpContext.getMessage( "Periodos", ""), true) ;
      new web.newmenuitem(remoteHandle, context).execute( (byte)(4), httpContext.getMessage( "Exportar liquidaciones", ""), "", false, httpContext.getMessage( "Liquidación", ""), false) ;
      new web.newmenuitem(remoteHandle, context).execute( (byte)(4), httpContext.getMessage( "Nómina", ""), "", true, "", false) ;
      new web.newmenuitem(remoteHandle, context).execute( (byte)(4), httpContext.getMessage( "Legajos", ""), "", false, httpContext.getMessage( "Nómina", ""), true) ;
      new web.newmenuitem(remoteHandle, context).execute( (byte)(4), httpContext.getMessage( "LegajoINS", ""), httpContext.getMessage( "Alta de legajo", ""), false, httpContext.getMessage( "Legajos", ""), true) ;
      new web.newmenuitem(remoteHandle, context).execute( (byte)(4), httpContext.getMessage( "LegajoUPD", ""), httpContext.getMessage( "Modificación de legajo", ""), false, httpContext.getMessage( "Legajos", ""), true) ;
      new web.newmenuitem(remoteHandle, context).execute( (byte)(4), httpContext.getMessage( "LegajoDLT", ""), httpContext.getMessage( "Eliminación de legajo", ""), false, httpContext.getMessage( "Legajos", ""), true) ;
      new web.newmenuitem(remoteHandle, context).execute( (byte)(4), httpContext.getMessage( "LegajoDSP", ""), httpContext.getMessage( "Visualización de legajo", ""), false, httpContext.getMessage( "Legajos", ""), true) ;
      new web.newmenuitem(remoteHandle, context).execute( (byte)(4), httpContext.getMessage( "Ajuste de sueldos por inflación", ""), "", false, httpContext.getMessage( "Nómina", ""), true) ;
      new web.newmenuitem(remoteHandle, context).execute( (byte)(4), httpContext.getMessage( "Cuenta corriente de vacaciones", ""), "", false, httpContext.getMessage( "Nómina", ""), true) ;
      new web.newmenuitem(remoteHandle, context).execute( (byte)(4), httpContext.getMessage( "Egresos / Permanencias", ""), httpContext.getMessage( "Antiguedad / Permanencias", ""), false, httpContext.getMessage( "Nómina", ""), true) ;
      new web.newmenuitem(remoteHandle, context).execute( (byte)(4), httpContext.getMessage( "Novedades", ""), "", true, "", false) ;
      new web.newmenuitem(remoteHandle, context).execute( (byte)(4), httpContext.getMessage( "Horas trabajadas y conceptos adicionales", ""), "", false, httpContext.getMessage( "Novedades", ""), false) ;
      new web.newmenuitem(remoteHandle, context).execute( (byte)(4), httpContext.getMessage( "Faltas y llegadas tarde", ""), "", false, httpContext.getMessage( "Novedades", ""), false) ;
      new web.newmenuitem(remoteHandle, context).execute( (byte)(4), httpContext.getMessage( "Vacaciones y licencias", ""), "", false, httpContext.getMessage( "Novedades", ""), false) ;
      new web.newmenuitem(remoteHandle, context).execute( (byte)(4), httpContext.getMessage( "Deducciones y reintegros", ""), "", false, httpContext.getMessage( "Novedades", ""), false) ;
      new web.newmenuitem(remoteHandle, context).execute( (byte)(4), httpContext.getMessage( "Obligaciones", ""), httpContext.getMessage( "Cuotas descuentos y acreditaciones", ""), false, httpContext.getMessage( "Novedades", ""), false) ;
      new web.newmenuitem(remoteHandle, context).execute( (byte)(4), httpContext.getMessage( "Reportes", ""), "", true, "", false) ;
      new web.newmenuitem(remoteHandle, context).execute( (byte)(4), httpContext.getMessage( "Reporte", ""), "", false, httpContext.getMessage( "Reportes", ""), false) ;
      new web.newmenuitem(remoteHandle, context).execute( (byte)(4), httpContext.getMessage( "AFIP", ""), "", true, "", false) ;
      new web.newmenuitem(remoteHandle, context).execute( (byte)(4), httpContext.getMessage( "Libro de Sueldos Digital", ""), "", false, httpContext.getMessage( "AFIP", ""), false) ;
      new web.newmenuitem(remoteHandle, context).execute( (byte)(4), httpContext.getMessage( "Formulario 1357", ""), "", false, httpContext.getMessage( "AFIP", ""), false) ;
      new web.newmenuitem(remoteHandle, context).execute( (byte)(4), httpContext.getMessage( "Importación", ""), httpContext.getMessage( "Migración", ""), true, "", false) ;
      new web.newmenuitem(remoteHandle, context).execute( (byte)(4), httpContext.getMessage( "Importar legajos", ""), "", false, httpContext.getMessage( "Importación", ""), false) ;
      new web.newmenuitem(remoteHandle, context).execute( (byte)(4), httpContext.getMessage( "Importar liquidaciones históricas", ""), "", false, httpContext.getMessage( "Importación", ""), false) ;
      new web.newmenuitem(remoteHandle, context).execute( (byte)(4), httpContext.getMessage( "Actualizaciones", ""), "", false, "", false) ;
      new web.newmenuitem(remoteHandle, context).execute( (byte)(4), httpContext.getMessage( "Configuración", ""), "", true, "", false) ;
      new web.newmenuitem(remoteHandle, context).execute( (byte)(4), httpContext.getMessage( "Parámetros país", ""), "", true, httpContext.getMessage( "Configuración", ""), false) ;
      new web.newmenuitem(remoteHandle, context).execute( (byte)(4), httpContext.getMessage( "Parámetros backend", ""), "", false, httpContext.getMessage( "Configuración", ""), false) ;
      new web.newmenuitem(remoteHandle, context).execute( (byte)(4), httpContext.getMessage( "Provincias", ""), "", false, httpContext.getMessage( "Parámetros país", ""), false) ;
      new web.newmenuitem(remoteHandle, context).execute( (byte)(4), httpContext.getMessage( "Localidades", ""), "", false, httpContext.getMessage( "Parámetros país", ""), false) ;
      new web.newmenuitem(remoteHandle, context).execute( (byte)(4), httpContext.getMessage( "Agenda de feriados", ""), "", false, httpContext.getMessage( "Parámetros país", ""), false) ;
      new web.newmenuitem(remoteHandle, context).execute( (byte)(4), httpContext.getMessage( "Estados / Licencias", ""), "", false, httpContext.getMessage( "Parámetros país", ""), false) ;
      new web.newmenuitem(remoteHandle, context).execute( (byte)(4), httpContext.getMessage( "Embargabilidad", ""), "", false, httpContext.getMessage( "Parámetros país", ""), false) ;
      new web.newmenuitem(remoteHandle, context).execute( (byte)(4), httpContext.getMessage( "Tipos de obligación", ""), "", false, httpContext.getMessage( "Parámetros país", ""), false) ;
      new web.newmenuitem(remoteHandle, context).execute( (byte)(4), httpContext.getMessage( "Sexos", ""), "", false, httpContext.getMessage( "Parámetros país", ""), false) ;
      new web.newmenuitem(remoteHandle, context).execute( (byte)(4), httpContext.getMessage( "Estados civiles", ""), "", false, httpContext.getMessage( "Parámetros país", ""), false) ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV11Pgmname, httpContext.getMessage( "arte", "")) ;
      new web.newmenuitem(remoteHandle, context).execute( (byte)(4), httpContext.getMessage( "A.R.T.", ""), "", false, httpContext.getMessage( "Parámetros país", ""), false) ;
      new web.newmenuitem(remoteHandle, context).execute( (byte)(4), httpContext.getMessage( "AFIP_Tablas", ""), httpContext.getMessage( "AFIP", ""), true, httpContext.getMessage( "Parámetros país", ""), false) ;
      new web.newmenuitem(remoteHandle, context).execute( (byte)(4), httpContext.getMessage( "Situaciones de revista", ""), "", false, httpContext.getMessage( "AFIP_Tablas", ""), false) ;
      new web.newmenuitem(remoteHandle, context).execute( (byte)(4), httpContext.getMessage( "Actividades", ""), "", false, httpContext.getMessage( "AFIP_Tablas", ""), false) ;
      new web.newmenuitem(remoteHandle, context).execute( (byte)(4), httpContext.getMessage( "Tipos de empleador", ""), "", false, httpContext.getMessage( "AFIP_Tablas", ""), false) ;
      new web.newmenuitem(remoteHandle, context).execute( (byte)(4), httpContext.getMessage( "Zonas", ""), "", false, httpContext.getMessage( "AFIP_Tablas", ""), false) ;
      new web.newmenuitem(remoteHandle, context).execute( (byte)(4), httpContext.getMessage( "Siniestrados", ""), "", false, httpContext.getMessage( "AFIP_Tablas", ""), false) ;
      new web.newmenuitem(remoteHandle, context).execute( (byte)(4), httpContext.getMessage( "Condiciones", ""), "", false, httpContext.getMessage( "AFIP_Tablas", ""), false) ;
      new web.newmenuitem(remoteHandle, context).execute( (byte)(4), httpContext.getMessage( "Modalidades de contratación", ""), "", false, httpContext.getMessage( "AFIP_Tablas", ""), false) ;
      new web.newmenuitem(remoteHandle, context).execute( (byte)(4), httpContext.getMessage( "AFIPConcepto", ""), httpContext.getMessage( "Conceptos", ""), false, httpContext.getMessage( "AFIP_Tablas", ""), false) ;
      new web.newmenuitem(remoteHandle, context).execute( (byte)(4), httpContext.getMessage( "Usuarios", ""), "", false, httpContext.getMessage( "Configuración", ""), false) ;
      new web.newmenuitem(remoteHandle, context).execute( (byte)(4), httpContext.getMessage( "Bancos", ""), "", false, httpContext.getMessage( "Configuración", ""), false) ;
      new web.newmenuitem(remoteHandle, context).execute( (byte)(4), httpContext.getMessage( "Obras sociales", ""), "", false, httpContext.getMessage( "Configuración", ""), false) ;
      new web.newmenuitem(remoteHandle, context).execute( (byte)(4), httpContext.getMessage( "Sindicatos", ""), "", false, httpContext.getMessage( "Configuración", ""), false) ;
      new web.newmenuitem(remoteHandle, context).execute( (byte)(4), httpContext.getMessage( "Áreas", ""), "", false, httpContext.getMessage( "Configuración", ""), false) ;
      new web.newmenuitem(remoteHandle, context).execute( (byte)(4), httpContext.getMessage( "Puestos", ""), "", false, httpContext.getMessage( "Configuración", ""), false) ;
      new web.newmenuitem(remoteHandle, context).execute( (byte)(4), httpContext.getMessage( "Motivos de egreso", ""), "", false, httpContext.getMessage( "Configuración", ""), false) ;
      new web.newmenuitem(remoteHandle, context).execute( (byte)(4), httpContext.getMessage( "Parámetros", ""), "", false, httpContext.getMessage( "Configuración", ""), false) ;
      new web.newmenuitem(remoteHandle, context).execute( (byte)(4), httpContext.getMessage( "Parámetros todos", ""), "", false, httpContext.getMessage( "Configuración", ""), false) ;
      new web.newmenuitem(remoteHandle, context).execute( (byte)(4), httpContext.getMessage( "Componentes de fórmula", ""), httpContext.getMessage( "Componentes de fórmula", ""), true, httpContext.getMessage( "Configuración", ""), false) ;
      new web.newmenuitem(remoteHandle, context).execute( (byte)(4), httpContext.getMessage( "Variables", ""), httpContext.getMessage( "Variables", ""), false, httpContext.getMessage( "Componentes de fórmula", ""), false) ;
      new web.newmenuitem(remoteHandle, context).execute( (byte)(4), httpContext.getMessage( "Valores", ""), "", false, httpContext.getMessage( "Variables", ""), true) ;
      new web.newmenuitem(remoteHandle, context).execute( (byte)(4), httpContext.getMessage( "Cálculos", ""), httpContext.getMessage( "Cálculos", ""), false, httpContext.getMessage( "Componentes de fórmula", ""), false) ;
      new web.newmenuitem(remoteHandle, context).execute( (byte)(4), httpContext.getMessage( "Convenios", ""), "", false, httpContext.getMessage( "Configuración", ""), false) ;
      new web.newmenuitem(remoteHandle, context).execute( (byte)(4), httpContext.getMessage( "Conexiones SOAP", ""), "", false, httpContext.getMessage( "Configuración", ""), false) ;
      new web.newmenuitem(remoteHandle, context).execute( (byte)(4), httpContext.getMessage( "Conexiones REST", ""), "", false, httpContext.getMessage( "Configuración", ""), false) ;
      new web.newmenuitem(remoteHandle, context).execute( (byte)(4), httpContext.getMessage( "Impuesto a las ganancias", ""), "", true, httpContext.getMessage( "Configuración", ""), false) ;
      new web.newmenuitem(remoteHandle, context).execute( (byte)(4), httpContext.getMessage( "Tratamientos de exención IIGG", ""), "", false, httpContext.getMessage( "Impuesto a las ganancias", ""), false) ;
      new web.newmenuitem(remoteHandle, context).execute( (byte)(4), httpContext.getMessage( "Condiciones de exención", ""), "", false, httpContext.getMessage( "Impuesto a las ganancias", ""), false) ;
      new web.newmenuitem(remoteHandle, context).execute( (byte)(4), httpContext.getMessage( "Códigos SIRADIG", ""), "", false, httpContext.getMessage( "Impuesto a las ganancias", ""), false) ;
      new web.newmenuitem(remoteHandle, context).execute( (byte)(4), httpContext.getMessage( "Empresa", ""), "", true, httpContext.getMessage( "Configuración", ""), false) ;
      new web.newmenuitem(remoteHandle, context).execute( (byte)(4), httpContext.getMessage( "Datos principales", ""), "", false, httpContext.getMessage( "Empresa", ""), true) ;
      new web.newmenuitem(remoteHandle, context).execute( (byte)(4), httpContext.getMessage( "EmpBancos", ""), httpContext.getMessage( "Bancos", ""), false, httpContext.getMessage( "Empresa", ""), true) ;
      new web.newmenuitem(remoteHandle, context).execute( (byte)(4), httpContext.getMessage( "Bases de cálculo", ""), "", true, httpContext.getMessage( "Empresa", ""), true) ;
      new web.newmenuitem(remoteHandle, context).execute( (byte)(4), httpContext.getMessage( "EmpBaseCal clase jornal", ""), httpContext.getMessage( "Clase jornal", ""), true, httpContext.getMessage( "Bases de cálculo", ""), true) ;
      new web.newmenuitem(remoteHandle, context).execute( (byte)(4), httpContext.getMessage( "Licencias en clase jornal", ""), httpContext.getMessage( "Licencias", ""), false, httpContext.getMessage( "EmpBaseCal clase jornal", ""), true) ;
      new web.newmenuitem(remoteHandle, context).execute( (byte)(4), httpContext.getMessage( "Feriados en clase jornal", ""), httpContext.getMessage( "Feriados", ""), false, httpContext.getMessage( "EmpBaseCal clase jornal", ""), true) ;
      new web.newmenuitem(remoteHandle, context).execute( (byte)(4), httpContext.getMessage( "Hora normal en clase jornal", ""), httpContext.getMessage( "Hora normal", ""), false, httpContext.getMessage( "EmpBaseCal clase jornal", ""), true) ;
      new web.newmenuitem(remoteHandle, context).execute( (byte)(4), httpContext.getMessage( "EmpBaseCal clase mensual", ""), httpContext.getMessage( "Clase mensual", ""), true, httpContext.getMessage( "Bases de cálculo", ""), true) ;
      new web.newmenuitem(remoteHandle, context).execute( (byte)(4), httpContext.getMessage( "Licencias en clase mensual", ""), httpContext.getMessage( "Licencias", ""), false, httpContext.getMessage( "EmpBaseCal clase mensual", ""), true) ;
      new web.newmenuitem(remoteHandle, context).execute( (byte)(4), httpContext.getMessage( "Feriados en clase mensual", ""), httpContext.getMessage( "Feriados", ""), false, httpContext.getMessage( "EmpBaseCal clase mensual", ""), true) ;
      new web.newmenuitem(remoteHandle, context).execute( (byte)(4), httpContext.getMessage( "Hora normal en clase mensual", ""), httpContext.getMessage( "Hora normal", ""), false, httpContext.getMessage( "EmpBaseCal clase mensual", ""), true) ;
      new web.newmenuitem(remoteHandle, context).execute( (byte)(4), httpContext.getMessage( "Horas extras", ""), "", false, httpContext.getMessage( "Empresa", ""), true) ;
      new web.newmenuitem(remoteHandle, context).execute( (byte)(4), httpContext.getMessage( "Horas extras extraordinarias", ""), "", false, httpContext.getMessage( "Empresa", ""), true) ;
      new web.newmenuitem(remoteHandle, context).execute( (byte)(4), httpContext.getMessage( "Otros", ""), "", true, httpContext.getMessage( "Empresa", ""), true) ;
      new web.newmenuitem(remoteHandle, context).execute( (byte)(4), httpContext.getMessage( "ReligionesEmpresa", ""), httpContext.getMessage( "Religiones reconocidas para días no laborables", ""), false, httpContext.getMessage( "Otros", ""), true) ;
      new web.newmenuitem(remoteHandle, context).execute( (byte)(4), httpContext.getMessage( "OrigenesEmpresa", ""), httpContext.getMessage( "Origenes reconocidos para días no laborables", ""), false, httpContext.getMessage( "Otros", ""), true) ;
      cleanup();
   }

   protected void cleanup( )
   {
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV11Pgmname = "" ;
      AV11Pgmname = "iniMenuItemsUsuario" ;
      /* GeneXus formulas. */
      AV11Pgmname = "iniMenuItemsUsuario" ;
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private String AV11Pgmname ;
}

