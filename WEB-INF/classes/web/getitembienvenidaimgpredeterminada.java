package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getitembienvenidaimgpredeterminada extends GXProcedure
{
   public getitembienvenidaimgpredeterminada( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getitembienvenidaimgpredeterminada.class ), "" );
   }

   public getitembienvenidaimgpredeterminada( int remoteHandle ,
                                              ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( String aP0 )
   {
      getitembienvenidaimgpredeterminada.this.aP1 = new String[] {""};
      execute_int(aP0, aP1);
      return aP1[0];
   }

   public void execute( String aP0 ,
                        String[] aP1 )
   {
      execute_int(aP0, aP1);
   }

   private void execute_int( String aP0 ,
                             String[] aP1 )
   {
      getitembienvenidaimgpredeterminada.this.AV8MenuItemId = aP0;
      getitembienvenidaimgpredeterminada.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      if ( GXutil.strcmp(AV8MenuItemId, httpContext.getMessage( "Conceptos", "")) == 0 )
      {
         AV9palabra = httpContext.getMessage( "Welcome_img_00_Liquidacion_conceptos_Small.png", "") ;
      }
      else if ( GXutil.strcmp(AV8MenuItemId, httpContext.getMessage( "AFIPConcepto", "")) == 0 )
      {
         AV9palabra = httpContext.getMessage( "Welcome_img_51_Configuracion_Parametros_de_Pais_AFIP_Conceptos_01_Small.png", "") ;
      }
      else if ( GXutil.strcmp(AV8MenuItemId, httpContext.getMessage( "Exportar liquidaciones", "")) == 0 )
      {
         AV9palabra = httpContext.getMessage( "Welcome_img_02_Liquidacion_Importar_Exportar_01_Small.png", "") ;
      }
      else if ( GXutil.strcmp(AV8MenuItemId, httpContext.getMessage( "Formulario 1357", "")) == 0 )
      {
         AV9palabra = httpContext.getMessage( "Welcome_img_76_AFIP_Formulario_1357_01_Small.png", "") ;
      }
      else if ( ( GXutil.strcmp(AV8MenuItemId, httpContext.getMessage( "Periodos", "")) == 0 ) || ( GXutil.strcmp(AV8MenuItemId, httpContext.getMessage( "Liquidaciones", "")) == 0 ) )
      {
         AV9palabra = httpContext.getMessage( "Welcome_img_03_Liquidacion_Periodos_Small.png", "") ;
      }
      else if ( GXutil.strcmp(AV8MenuItemId, httpContext.getMessage( "Legajos", "")) == 0 )
      {
         AV9palabra = httpContext.getMessage( "Welcome_img_05_Legajos_Legajos_01_Small.png", "") ;
      }
      else if ( GXutil.strcmp(AV8MenuItemId, httpContext.getMessage( "LegajoINS", "")) == 0 )
      {
         AV9palabra = httpContext.getMessage( "Welcome_img_04_Legajos_Legajo_Small.png", "") ;
      }
      else if ( GXutil.strcmp(AV8MenuItemId, httpContext.getMessage( "LegajoUPD", "")) == 0 )
      {
         AV9palabra = httpContext.getMessage( "Welcome_img_04_Legajos_Legajo_Small.png", "") ;
      }
      else if ( GXutil.strcmp(AV8MenuItemId, httpContext.getMessage( "LegajoDLT", "")) == 0 )
      {
         AV9palabra = httpContext.getMessage( "Welcome_img_04_Legajos_Legajo_Small.png", "") ;
      }
      else if ( GXutil.strcmp(AV8MenuItemId, httpContext.getMessage( "LegajoDSP", "")) == 0 )
      {
         AV9palabra = httpContext.getMessage( "Welcome_img_04_Legajos_Legajo_Small.png", "") ;
      }
      else if ( GXutil.strcmp(AV8MenuItemId, httpContext.getMessage( "Horas extras extraordinarias", "")) == 0 )
      {
         AV9palabra = httpContext.getMessage( "Welcome_img_17_Configuracion_Empresa_Horas_Extraordinarias_01_Small.png", "") ;
      }
      else if ( ( GXutil.strcmp(AV8MenuItemId, httpContext.getMessage( "Horas extras", "")) == 0 ) || ( GXutil.strcmp(AV8MenuItemId, httpContext.getMessage( "Hora normal en clase jornal", "")) == 0 ) || ( GXutil.strcmp(AV8MenuItemId, httpContext.getMessage( "Hora normal en clase mensual", "")) == 0 ) )
      {
         AV9palabra = httpContext.getMessage( "Welcome_img_16_Configuracion_Empresa_Horas_Extra_01_Small.png", "") ;
      }
      else if ( GXutil.strcmp(AV8MenuItemId, httpContext.getMessage( "Faltas y llegadas tarde", "")) == 0 )
      {
         AV9palabra = httpContext.getMessage( "Welcome_img_08_Novedades_Horas_y llegadas_tarde_02_Small.png", "") ;
      }
      else if ( GXutil.strcmp(AV8MenuItemId, httpContext.getMessage( "Obligaciones", "")) == 0 )
      {
         AV9palabra = httpContext.getMessage( "Welcome_img_10_Novedades_Obligaciones_02_Small.png", "") ;
      }
      else if ( GXutil.strcmp(AV8MenuItemId, httpContext.getMessage( "Deducciones y reintegros", "")) == 0 )
      {
         AV9palabra = httpContext.getMessage( "Welcome_img_11_Novedades_Deducciones_y_Reintegros_01_Small.png", "") ;
      }
      else if ( GXutil.strcmp(AV8MenuItemId, httpContext.getMessage( "Vacaciones y licencias", "")) == 0 )
      {
         AV9palabra = httpContext.getMessage( "Welcome_img_13_Novedades_Vacaciones_y_Licencias_01_Small.png", "") ;
      }
      else if ( GXutil.strcmp(AV8MenuItemId, httpContext.getMessage( "Reportes", "")) == 0 )
      {
         AV9palabra = httpContext.getMessage( "Welcome_img_14_Reportes_Reportes_01_Small.png", "") ;
      }
      else if ( GXutil.strcmp(AV8MenuItemId, httpContext.getMessage( "Datos principales", "")) == 0 )
      {
         AV9palabra = httpContext.getMessage( "Welcome_img_15_Configuracion_Empresa_Datos_Principales_Small.png", "") ;
      }
      else if ( ( GXutil.strcmp(AV8MenuItemId, httpContext.getMessage( "Licencias en clase jornal", "")) == 0 ) || ( GXutil.strcmp(AV8MenuItemId, httpContext.getMessage( "Licencias en clase mensual", "")) == 0 ) )
      {
         AV9palabra = httpContext.getMessage( "Welcome_img_20_Configuracion_Empresa_Base_de_Calculo_Licencia_02_Small.png", "") ;
      }
      else if ( ( GXutil.strcmp(AV8MenuItemId, httpContext.getMessage( "Feriados en clase jornal", "")) == 0 ) || ( GXutil.strcmp(AV8MenuItemId, httpContext.getMessage( "Feriados en clase mensual", "")) == 0 ) )
      {
         AV9palabra = httpContext.getMessage( "Welcome_img_18_Configuracion_Empresa_Base_de_Calculo_Feriado_01_Small.png", "") ;
      }
      else if ( ( GXutil.strcmp(AV8MenuItemId, httpContext.getMessage( "ReligionesEmpresa", "")) == 0 ) || ( GXutil.strcmp(AV8MenuItemId, httpContext.getMessage( "Religiones", "")) == 0 ) )
      {
         AV9palabra = httpContext.getMessage( "Welcome_img_22_Configuracion_Empresa_Otros_Religiones_01_Small.png", "") ;
      }
      else if ( ( GXutil.strcmp(AV8MenuItemId, httpContext.getMessage( "OrigenesEmpresa", "")) == 0 ) || ( GXutil.strcmp(AV8MenuItemId, httpContext.getMessage( "Origenes", "")) == 0 ) )
      {
         AV9palabra = httpContext.getMessage( "Welcome_img_23_Configuracion_Empresa_Otros_Origenes_01_Small.png", "") ;
      }
      else if ( GXutil.strcmp(AV8MenuItemId, httpContext.getMessage( "Convenios", "")) == 0 )
      {
         AV9palabra = httpContext.getMessage( "Welcome_img_26_Configuracion_Convenios_01_Small.png", "") ;
      }
      else if ( GXutil.strcmp(AV8MenuItemId, httpContext.getMessage( "Cálculos", "")) == 0 )
      {
         AV9palabra = httpContext.getMessage( "Welcome_img_30_Configuracion_Parametros_de_Concepto_Calulos_01_Small.png", "") ;
      }
      else if ( GXutil.strcmp(AV8MenuItemId, httpContext.getMessage( "Variables", "")) == 0 )
      {
         AV9palabra = httpContext.getMessage( "Welcome_img_32_Configuracion_Parametros_de_Concepto_Variables_01_Small.png", "") ;
      }
      else if ( GXutil.strcmp(AV8MenuItemId, httpContext.getMessage( "Usuarios", "")) == 0 )
      {
         AV9palabra = httpContext.getMessage( "Welcome_img_36_Configuracion_Usuarios_04_Small.png", "") ;
      }
      else if ( GXutil.strcmp(AV8MenuItemId, httpContext.getMessage( "Sindicatos", "")) == 0 )
      {
         AV9palabra = httpContext.getMessage( "Welcome_img_40_Configuracion_Sindicatos_01_Small.png", "") ;
      }
      else if ( GXutil.strcmp(AV8MenuItemId, httpContext.getMessage( "Puestos", "")) == 0 )
      {
         AV9palabra = httpContext.getMessage( "Welcome_img_44_Configuracion_Puestos_01_Small.png", "") ;
      }
      else if ( GXutil.strcmp(AV8MenuItemId, httpContext.getMessage( "Áreas", "")) == 0 )
      {
         AV9palabra = httpContext.getMessage( "Welcome_img_43_Configuracion_Areas_03_Small.png", "") ;
      }
      else if ( GXutil.strcmp(AV8MenuItemId, httpContext.getMessage( "Motivos de egreso", "")) == 0 )
      {
         AV9palabra = httpContext.getMessage( "Welcome_img_45_Configuracion_Motivos_de_Egreso_01_Small.png", "") ;
      }
      else if ( GXutil.strcmp(AV8MenuItemId, httpContext.getMessage( "Parámetros", "")) == 0 )
      {
         AV9palabra = httpContext.getMessage( "Welcome_img_47_Configuracion_Parametros_02_Small.png", "") ;
      }
      else if ( GXutil.strcmp(AV8MenuItemId, httpContext.getMessage( "Modalidades de contratación", "")) == 0 )
      {
         AV9palabra = httpContext.getMessage( "Welcome_img_53_Configuracion_Parametros_de_Pais_AFIP_Modalidades_de_Contratacion_01_Small.png", "") ;
      }
      else if ( GXutil.strcmp(AV8MenuItemId, httpContext.getMessage( "A.R.T.", "")) == 0 )
      {
         AV9palabra = httpContext.getMessage( "Welcome_img_49_Configuracion_Parametros_de_Pais_ART_01_Small.png", "") ;
      }
      else if ( GXutil.strcmp(AV8MenuItemId, httpContext.getMessage( "Actividades", "")) == 0 )
      {
         AV9palabra = httpContext.getMessage( "Welcome_img_50_Configuracion_Parametros_de_Pais_AFIP_Actividades_01_Small.png", "") ;
      }
      else if ( GXutil.strcmp(AV8MenuItemId, httpContext.getMessage( "Condiciones", "")) == 0 )
      {
         AV9palabra = httpContext.getMessage( "Welcome_img_52_Configuracion_Parametros_de_Pais_AFIP_Condicion_01_Small.png", "") ;
      }
      else if ( GXutil.strcmp(AV8MenuItemId, httpContext.getMessage( "Tipos de empleador", "")) == 0 )
      {
         AV9palabra = httpContext.getMessage( "Welcome_img_56_Configuracion_Parametros_de_Pais_AFIP_Tipos_de_Empleador_01_Small.png", "") ;
      }
      else if ( GXutil.strcmp(AV8MenuItemId, httpContext.getMessage( "Siniestrados", "")) == 0 )
      {
         AV9palabra = httpContext.getMessage( "Welcome_img_54_Configuracion_Parametros_de_Pais_AFIP_Siniestrados_01_Small.png", "") ;
      }
      else if ( GXutil.strcmp(AV8MenuItemId, httpContext.getMessage( "Situaciones de revista", "")) == 0 )
      {
         AV9palabra = httpContext.getMessage( "Welcome_img_55_Configuracion_Parametros_de_Pais_AFIP_Situaciones_de_Revista_01_Small.png", "") ;
      }
      else if ( GXutil.strcmp(AV8MenuItemId, httpContext.getMessage( "Agenda de feriados", "")) == 0 )
      {
         AV9palabra = httpContext.getMessage( "Welcome_img_57_Configuracion_Parametros_de_Pais_Agenda_de_Feriados_01_Small.png", "") ;
      }
      else if ( GXutil.strcmp(AV8MenuItemId, httpContext.getMessage( "Embargabilidad", "")) == 0 )
      {
         AV9palabra = httpContext.getMessage( "Welcome_img_58_Configuracion_Parametros_de_Pais_Embargabilidad_01_Small.png", "") ;
      }
      else if ( GXutil.strcmp(AV8MenuItemId, httpContext.getMessage( "Estados / Licencias", "")) == 0 )
      {
         AV9palabra = httpContext.getMessage( "Welcome_img_59_Configuracion_Parametros_de_Pais_Licencia_01_Small.png", "") ;
      }
      else if ( GXutil.strcmp(AV8MenuItemId, httpContext.getMessage( "Estados civiles", "")) == 0 )
      {
         AV9palabra = httpContext.getMessage( "Welcome_img_62_Configuracion_Parametros_de_Pais_Estados_Civiles_01_Small.png", "") ;
      }
      else if ( GXutil.strcmp(AV8MenuItemId, httpContext.getMessage( "Localidades", "")) == 0 )
      {
         AV9palabra = httpContext.getMessage( "Welcome_img_63_Configuracion_Parametros_de_Pais_Estados_Localidades_01_Small.png", "") ;
      }
      else if ( GXutil.strcmp(AV8MenuItemId, httpContext.getMessage( "Provincias", "")) == 0 )
      {
         AV9palabra = httpContext.getMessage( "Welcome_img_64_Configuracion_Parametros_de_Pais_Estados_Provincias_01_Small.png", "") ;
      }
      else if ( GXutil.strcmp(AV8MenuItemId, httpContext.getMessage( "Sexos", "")) == 0 )
      {
         AV9palabra = httpContext.getMessage( "Welcome_img_65_Configuracion_Parametros_de_Pais_Estados_Sexos_01_Small.png", "") ;
      }
      else if ( GXutil.strcmp(AV8MenuItemId, httpContext.getMessage( "Tipos de obligación", "")) == 0 )
      {
         AV9palabra = httpContext.getMessage( "Welcome_img_66_Configuracion_Parametros_de_Pais_Estados_Tipos_de_Obligacion_01_Small.png", "") ;
      }
      else if ( GXutil.strcmp(AV8MenuItemId, httpContext.getMessage( "Tratamientos de exención IIGG", "")) == 0 )
      {
         AV9palabra = httpContext.getMessage( "Welcome_img_67_Configuracion_Impuesto_a_las_Ganancias_Tratamientos_de_Exencion_01_Small.png", "") ;
      }
      else if ( GXutil.strcmp(AV8MenuItemId, httpContext.getMessage( "Condiciones de exención", "")) == 0 )
      {
         AV9palabra = httpContext.getMessage( "Welcome_img_68_Configuracion_Impuesto_a_las_Ganancias_Condiciones_de_Exencion_01_Small.png", "") ;
      }
      else if ( GXutil.strcmp(AV8MenuItemId, httpContext.getMessage( "Códigos SIRADIG", "")) == 0 )
      {
         AV9palabra = httpContext.getMessage( "Welcome_img_69_Configuracion_Impuesto_a_las_Ganancias_Codigos_SIRADIG_01_Small.png", "") ;
      }
      else if ( GXutil.strcmp(AV8MenuItemId, httpContext.getMessage( "Importar legajos", "")) == 0 )
      {
         AV9palabra = httpContext.getMessage( "Welcome_img_70_Importacion_01_Small.png", "") ;
      }
      else if ( GXutil.strcmp(AV8MenuItemId, httpContext.getMessage( "Actualizaciones", "")) == 0 )
      {
         AV9palabra = httpContext.getMessage( "Welcome_img_73_Actualizaciones_01_Small.png", "") ;
      }
      else if ( ( GXutil.strcmp(AV8MenuItemId, httpContext.getMessage( "Libro de Sueldos Digital", "")) == 0 ) || ( GXutil.strcmp(AV8MenuItemId, httpContext.getMessage( "PeriodoLSD", "")) == 0 ) || ( GXutil.strcmp(AV8MenuItemId, httpContext.getMessage( "LiquidacionLSD", "")) == 0 ) )
      {
         AV9palabra = httpContext.getMessage( "Welcome_img_75_AFIP_Libro_Sueldo_Digital_01_Small.png", "") ;
      }
      else if ( GXutil.strcmp(AV8MenuItemId, httpContext.getMessage( "Importar liquidaciones históricas", "")) == 0 )
      {
         AV9palabra = httpContext.getMessage( "Welcome_img_72_Importacion_03_Small.png", "") ;
      }
      else if ( ( GXutil.strcmp(AV8MenuItemId, httpContext.getMessage( "Bancos", "")) == 0 ) || ( GXutil.strcmp(AV8MenuItemId, httpContext.getMessage( "EmpBancos", "")) == 0 ) )
      {
         AV9palabra = httpContext.getMessage( "Welcome_img_38_Configuracion_Bancos_02_Small.png", "") ;
      }
      else if ( GXutil.strcmp(AV8MenuItemId, httpContext.getMessage( "Obras sociales", "")) == 0 )
      {
         AV9palabra = httpContext.getMessage( "Welcome_img_39_Configuracion_Obras_Sociales_01_Small.png", "") ;
      }
      else
      {
         AV9palabra = httpContext.getMessage( "png_convenio.png", "") ;
      }
      if ( GXutil.strSearch( AV9palabra, httpContext.getMessage( ".png", ""), 1) == 0 )
      {
         AV9palabra += httpContext.getMessage( ".png", "") ;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP1[0] = getitembienvenidaimgpredeterminada.this.AV9palabra;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV9palabra = "" ;
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private String AV9palabra ;
   private String AV8MenuItemId ;
   private String[] aP1 ;
}

