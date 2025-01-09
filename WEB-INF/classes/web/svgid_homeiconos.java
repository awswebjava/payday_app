package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class svgid_homeiconos extends GXProcedure
{
   public svgid_homeiconos( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( svgid_homeiconos.class ), "" );
   }

   public svgid_homeiconos( int remoteHandle ,
                            ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( String aP0 )
   {
      svgid_homeiconos.this.aP1 = new String[] {""};
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
      svgid_homeiconos.this.AV9que = aP0;
      svgid_homeiconos.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      if ( GXutil.strcmp(AV9que, httpContext.getMessage( "Libro de sueldos digital", "")) == 0 )
      {
         AV8SVGId = httpContext.getMessage( "LSD_home", "") ;
      }
      else if ( GXutil.strcmp(AV9que, httpContext.getMessage( "Importar liquidaciones históricas", "")) == 0 )
      {
         AV8SVGId = httpContext.getMessage( "Imp_Liqui_Hist_home", "") ;
      }
      else if ( GXutil.strcmp(AV9que, httpContext.getMessage( "Importar legajos", "")) == 0 )
      {
         AV8SVGId = httpContext.getMessage( "Imp_Legajos_home", "") ;
      }
      else if ( GXutil.strcmp(AV9que, httpContext.getMessage( "Formulario 1357", "")) == 0 )
      {
         AV8SVGId = httpContext.getMessage( "Form_1357_home", "") ;
      }
      else if ( ( GXutil.strcmp(AV9que, httpContext.getMessage( "Liquidación", "")) == 0 ) || ( GXutil.strcmp(AV9que, httpContext.getMessage( "Liquidaciones", "")) == 0 ) || ( GXutil.strcmp(AV9que, httpContext.getMessage( "Periodos", "")) == 0 ) )
      {
         AV8SVGId = httpContext.getMessage( "liquidacion_home", "") ;
      }
      else if ( GXutil.strcmp(AV9que, httpContext.getMessage( "Actualizaciones", "")) == 0 )
      {
         AV8SVGId = httpContext.getMessage( "actualiz_home", "") ;
      }
      else if ( GXutil.strcmp(AV9que, httpContext.getMessage( "AFIP", "")) == 0 )
      {
         AV8SVGId = httpContext.getMessage( "afip_home", "") ;
      }
      else if ( GXutil.strcmp(AV9que, httpContext.getMessage( "AFIP_Tablas", "")) == 0 )
      {
         AV8SVGId = httpContext.getMessage( "afip_home_entero", "") ;
      }
      else if ( GXutil.strcmp(AV9que, httpContext.getMessage( "AFIP2", "")) == 0 )
      {
         AV8SVGId = httpContext.getMessage( "afip_home_2", "") ;
      }
      else if ( GXutil.strcmp(AV9que, httpContext.getMessage( "Configuración", "")) == 0 )
      {
         AV8SVGId = httpContext.getMessage( "config_home", "") ;
      }
      else if ( GXutil.strcmp(AV9que, httpContext.getMessage( "Importación", "")) == 0 )
      {
         AV8SVGId = httpContext.getMessage( "importacion_home", "") ;
      }
      else if ( ( GXutil.strcmp(AV9que, httpContext.getMessage( "Reportes", "")) == 0 ) || ( GXutil.strcmp(AV9que, httpContext.getMessage( "Reporte", "")) == 0 ) )
      {
         AV8SVGId = httpContext.getMessage( "informes_home", "") ;
      }
      else if ( GXutil.strcmp(AV9que, httpContext.getMessage( "Exportar liquidaciones", "")) == 0 )
      {
         AV8SVGId = httpContext.getMessage( "exportar_liq", "") ;
      }
      else if ( ( GXutil.strcmp(AV9que, httpContext.getMessage( "Legajos", "")) == 0 ) || ( GXutil.strcmp(AV9que, httpContext.getMessage( "Nómina", "")) == 0 ) )
      {
         AV8SVGId = httpContext.getMessage( "legajos", "") ;
      }
      else if ( GXutil.strcmp(AV9que, httpContext.getMessage( "Novedades", "")) == 0 )
      {
         AV8SVGId = httpContext.getMessage( "novedades_home", "") ;
      }
      else if ( ( GXutil.strcmp(AV9que, httpContext.getMessage( "Conceptos", "")) == 0 ) || ( GXutil.strcmp(AV9que, httpContext.getMessage( "AFIPConcepto", "")) == 0 ) )
      {
         AV8SVGId = httpContext.getMessage( "conceptos", "") ;
      }
      else if ( GXutil.strcmp(AV9que, httpContext.getMessage( "Horas trabajadas y conceptos adicionales", "")) == 0 )
      {
         AV8SVGId = httpContext.getMessage( "novedad_horas", "") ;
      }
      else if ( GXutil.strcmp(AV9que, httpContext.getMessage( "Faltas y llegadas tarde", "")) == 0 )
      {
         AV8SVGId = httpContext.getMessage( "faltas", "") ;
      }
      else if ( GXutil.strcmp(AV9que, httpContext.getMessage( "Vacaciones y licencias", "")) == 0 )
      {
         AV8SVGId = httpContext.getMessage( "vaca_lic", "") ;
      }
      else if ( GXutil.strcmp(AV9que, httpContext.getMessage( "Deducciones y reintegros", "")) == 0 )
      {
         AV8SVGId = httpContext.getMessage( "ded_reinteg", "") ;
      }
      else if ( ( GXutil.strcmp(AV9que, httpContext.getMessage( "Obligaciones", "")) == 0 ) || ( GXutil.strcmp(AV9que, httpContext.getMessage( "Tipos de obligación", "")) == 0 ) )
      {
         AV8SVGId = httpContext.getMessage( "obligaciones", "") ;
      }
      else if ( GXutil.strcmp(AV9que, httpContext.getMessage( "Cog", "")) == 0 )
      {
         AV8SVGId = httpContext.getMessage( "cog", "") ;
      }
      else if ( GXutil.strcmp(AV9que, httpContext.getMessage( "Empresa", "")) == 0 )
      {
         AV8SVGId = httpContext.getMessage( "Empresa", "") ;
      }
      else if ( GXutil.strcmp(AV9que, httpContext.getMessage( "Datos principales", "")) == 0 )
      {
         AV8SVGId = httpContext.getMessage( "Emp_principal", "") ;
      }
      else if ( GXutil.strcmp(AV9que, httpContext.getMessage( "Convenios", "")) == 0 )
      {
         AV8SVGId = httpContext.getMessage( "Convenios", "") ;
      }
      else if ( GXutil.strcmp(AV9que, httpContext.getMessage( "Cálculos", "")) == 0 )
      {
         AV8SVGId = httpContext.getMessage( "Calculos", "") ;
      }
      else if ( GXutil.strcmp(AV9que, httpContext.getMessage( "Variables", "")) == 0 )
      {
         AV8SVGId = httpContext.getMessage( "Variables", "") ;
      }
      else if ( GXutil.strcmp(AV9que, httpContext.getMessage( "Usuarios", "")) == 0 )
      {
         AV8SVGId = httpContext.getMessage( "Usuarios", "") ;
      }
      else if ( ( GXutil.strcmp(AV9que, httpContext.getMessage( "Bancos", "")) == 0 ) || ( GXutil.strcmp(AV9que, httpContext.getMessage( "EmpBancos", "")) == 0 ) )
      {
         AV8SVGId = httpContext.getMessage( "Bancos", "") ;
      }
      else if ( GXutil.strcmp(AV9que, httpContext.getMessage( "Obras sociales", "")) == 0 )
      {
         AV8SVGId = httpContext.getMessage( "Obras_Sociales", "") ;
      }
      else if ( GXutil.strcmp(AV9que, httpContext.getMessage( "Sindicatos", "")) == 0 )
      {
         AV8SVGId = httpContext.getMessage( "Sindicatos", "") ;
      }
      else if ( GXutil.strcmp(AV9que, httpContext.getMessage( "Áreas", "")) == 0 )
      {
         AV8SVGId = httpContext.getMessage( "Areas", "") ;
      }
      else if ( GXutil.strcmp(AV9que, httpContext.getMessage( "Puestos", "")) == 0 )
      {
         AV8SVGId = httpContext.getMessage( "Puestos", "") ;
      }
      else if ( GXutil.strcmp(AV9que, httpContext.getMessage( "Motivos de egreso", "")) == 0 )
      {
         AV8SVGId = httpContext.getMessage( "svg_mot_de_egr", "") ;
      }
      else if ( GXutil.strcmp(AV9que, httpContext.getMessage( "Parámetros país", "")) == 0 )
      {
         AV8SVGId = httpContext.getMessage( "Param_Pais", "") ;
      }
      else if ( GXutil.strcmp(AV9que, httpContext.getMessage( "Impuesto a las ganancias", "")) == 0 )
      {
         AV8SVGId = httpContext.getMessage( "Imp_Gcias_home", "") ;
      }
      else if ( GXutil.strcmp(AV9que, httpContext.getMessage( "Componentes de fórmula", "")) == 0 )
      {
         AV8SVGId = httpContext.getMessage( "Cmp_Formulas", "") ;
      }
      else if ( GXutil.strcmp(AV9que, httpContext.getMessage( "Religiones", "")) == 0 )
      {
         AV8SVGId = httpContext.getMessage( "Religiones", "") ;
      }
      else if ( GXutil.strcmp(AV9que, httpContext.getMessage( "A.R.T.", "")) == 0 )
      {
         AV8SVGId = httpContext.getMessage( "art_trauma", "") ;
      }
      else if ( GXutil.strcmp(AV9que, httpContext.getMessage( "Estados civiles", "")) == 0 )
      {
         AV8SVGId = httpContext.getMessage( "est_civ_rings", "") ;
      }
      else if ( GXutil.strcmp(AV9que, httpContext.getMessage( "Sexos", "")) == 0 )
      {
         AV8SVGId = httpContext.getMessage( "sexos_reproductive", "") ;
      }
      else if ( GXutil.strcmp(AV9que, httpContext.getMessage( "Bases de cálculo", "")) == 0 )
      {
         AV8SVGId = httpContext.getMessage( "emp_base_calc", "") ;
      }
      else if ( GXutil.strcmp(AV9que, httpContext.getMessage( "Horas extras", "")) == 0 )
      {
         AV8SVGId = httpContext.getMessage( "emp_horas_ext", "") ;
      }
      else if ( GXutil.strcmp(AV9que, httpContext.getMessage( "Horas extras extraordinarias", "")) == 0 )
      {
         AV8SVGId = httpContext.getMessage( "emp_horas_ext_ord", "") ;
      }
      else if ( GXutil.strcmp(AV9que, httpContext.getMessage( "Otros", "")) == 0 )
      {
         AV8SVGId = httpContext.getMessage( "emp_otros", "") ;
      }
      else if ( GXutil.strcmp(AV9que, httpContext.getMessage( "EmpBaseCal clase jornal", "")) == 0 )
      {
         AV8SVGId = httpContext.getMessage( "emp_base_jornal", "") ;
      }
      else if ( GXutil.strcmp(AV9que, httpContext.getMessage( "EmpBaseCal clase mensual", "")) == 0 )
      {
         AV8SVGId = httpContext.getMessage( "emp_base_mensual", "") ;
      }
      else if ( ( GXutil.strcmp(AV9que, httpContext.getMessage( "Licencias en clase mensual", "")) == 0 ) || ( GXutil.strcmp(AV9que, httpContext.getMessage( "Licencias en clase jornal", "")) == 0 ) || ( GXutil.strcmp(AV9que, httpContext.getMessage( "Estados / Licencias", "")) == 0 ) )
      {
         AV8SVGId = httpContext.getMessage( "emp_lic", "") ;
      }
      else if ( ( GXutil.strcmp(AV9que, httpContext.getMessage( "Feriados en clase mensual", "")) == 0 ) || ( GXutil.strcmp(AV9que, httpContext.getMessage( "Feriados en clase jornal", "")) == 0 ) || ( GXutil.strcmp(AV9que, httpContext.getMessage( "Agenda de feriados", "")) == 0 ) )
      {
         AV8SVGId = httpContext.getMessage( "emp_fer", "") ;
      }
      else if ( ( GXutil.strcmp(AV9que, httpContext.getMessage( "Hora normal en clase mensual", "")) == 0 ) || ( GXutil.strcmp(AV9que, httpContext.getMessage( "Hora normal en clase jornal", "")) == 0 ) )
      {
         AV8SVGId = httpContext.getMessage( "emp_hornor", "") ;
      }
      else if ( GXutil.strcmp(AV9que, httpContext.getMessage( "ReligionesEmpresa", "")) == 0 )
      {
         AV8SVGId = httpContext.getMessage( "emp_otr_reg", "") ;
      }
      else if ( ( GXutil.strcmp(AV9que, httpContext.getMessage( "OrigenesEmpresa", "")) == 0 ) || ( GXutil.strcmp(AV9que, httpContext.getMessage( "Provincias", "")) == 0 ) )
      {
         AV8SVGId = httpContext.getMessage( "regiones", "") ;
      }
      else if ( GXutil.strcmp(AV9que, httpContext.getMessage( "Localidades", "")) == 0 )
      {
         AV8SVGId = httpContext.getMessage( "localidades", "") ;
      }
      else if ( GXutil.strcmp(AV9que, httpContext.getMessage( "Ajuste de sueldos por inflación", "")) == 0 )
      {
         AV8SVGId = httpContext.getMessage( "ajuste_sueldos", "") ;
      }
      else if ( GXutil.strcmp(AV9que, httpContext.getMessage( "Cuenta corriente de vacaciones", "")) == 0 )
      {
         AV8SVGId = httpContext.getMessage( "cc_licencias", "") ;
      }
      else if ( GXutil.strcmp(AV9que, httpContext.getMessage( "Egresos / Permanencias", "")) == 0 )
      {
         AV8SVGId = httpContext.getMessage( "antiguedad_permanen", "") ;
      }
      else
      {
         AV8SVGId = httpContext.getMessage( "cog", "") ;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP1[0] = svgid_homeiconos.this.AV8SVGId;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV8SVGId = "" ;
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private String AV8SVGId ;
   private String AV9que ;
   private String[] aP1 ;
}

