package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class inicializarparametros extends GXProcedure
{
   public inicializarparametros( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( inicializarparametros.class ), "" );
   }

   public inicializarparametros( int remoteHandle ,
                                 ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( int aP0 )
   {
      execute_int(aP0);
   }

   private void execute_int( int aP0 )
   {
      inicializarparametros.this.AV8CliCod = aP0;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      new web.msgdebug(remoteHandle, context).execute( AV30Pgmname, httpContext.getMessage( " &CliCod ", "")+GXutil.trim( GXutil.str( AV8CliCod, 6, 0))) ;
      GXt_char1 = AV22ConCodigo ;
      GXv_char2[0] = GXt_char1 ;
      new web.getconceptopordesc(remoteHandle, context).execute( AV8CliCod, httpContext.getMessage( "REDONDEO", ""), GXv_char2) ;
      inicializarparametros.this.GXt_char1 = GXv_char2[0] ;
      AV22ConCodigo = GXt_char1 ;
      new web.grabaparametro(remoteHandle, context).execute( AV8CliCod, new web.concepto_redondeo_codigoparam(remoteHandle, context).executeUdp( ), GXutil.trim( AV22ConCodigo), "") ;
      GXt_char1 = AV22ConCodigo ;
      GXv_char2[0] = GXt_char1 ;
      new web.getconceptopordesc(remoteHandle, context).execute( AV8CliCod, httpContext.getMessage( "SOBREGIRO", ""), GXv_char2) ;
      inicializarparametros.this.GXt_char1 = GXv_char2[0] ;
      AV22ConCodigo = GXt_char1 ;
      new web.grabaparametro(remoteHandle, context).execute( AV8CliCod, new web.concepto_sobregiro_codigoparam(remoteHandle, context).executeUdp( ), GXutil.trim( AV22ConCodigo), "") ;
      GXt_char1 = AV22ConCodigo ;
      GXv_char2[0] = GXt_char1 ;
      new web.getconceptopordesc(remoteHandle, context).execute( AV8CliCod, httpContext.getMessage( "OBRA SOCIAL", ""), GXv_char2) ;
      inicializarparametros.this.GXt_char1 = GXv_char2[0] ;
      AV22ConCodigo = GXt_char1 ;
      new web.grabaparametro(remoteHandle, context).execute( AV8CliCod, new web.concepto_obrasocial_codigoparam(remoteHandle, context).executeUdp( ), GXutil.trim( AV22ConCodigo), "") ;
      GXt_char1 = AV22ConCodigo ;
      GXt_char3 = AV22ConCodigo ;
      GXv_char2[0] = GXt_char3 ;
      new web.descripcionhorasextrasal50(remoteHandle, context).execute( GXv_char2) ;
      inicializarparametros.this.GXt_char3 = GXv_char2[0] ;
      GXv_char4[0] = GXt_char1 ;
      new web.getconceptopordesc(remoteHandle, context).execute( AV8CliCod, GXt_char3, GXv_char4) ;
      inicializarparametros.this.GXt_char1 = GXv_char4[0] ;
      AV22ConCodigo = GXt_char1 ;
      new web.grabaparametro(remoteHandle, context).execute( AV8CliCod, new web.conceptohorasextras50_codigoparam(remoteHandle, context).executeUdp( ), GXutil.trim( AV22ConCodigo), "") ;
      GXt_char3 = AV22ConCodigo ;
      GXt_char1 = AV22ConCodigo ;
      GXv_char4[0] = GXt_char1 ;
      new web.descripcionhorasal100(remoteHandle, context).execute( GXv_char4) ;
      inicializarparametros.this.GXt_char1 = GXv_char4[0] ;
      GXv_char2[0] = GXt_char3 ;
      new web.getconceptopordesc(remoteHandle, context).execute( AV8CliCod, GXt_char1, GXv_char2) ;
      inicializarparametros.this.GXt_char3 = GXv_char2[0] ;
      AV22ConCodigo = GXt_char3 ;
      new web.grabaparametro(remoteHandle, context).execute( AV8CliCod, new web.conceptohorasextras100_codigoparam(remoteHandle, context).executeUdp( ), GXutil.trim( AV22ConCodigo), "") ;
      GXt_char3 = AV22ConCodigo ;
      GXv_char4[0] = GXt_char3 ;
      new web.getconceptopordesc(remoteHandle, context).execute( AV8CliCod, httpContext.getMessage( "OBRA SOCIAL - FSR (ex ANSSAL)", ""), GXv_char4) ;
      inicializarparametros.this.GXt_char3 = GXv_char4[0] ;
      AV22ConCodigo = GXt_char3 ;
      new web.grabaparametro(remoteHandle, context).execute( AV8CliCod, new web.concepto_osfsr_codigoparam(remoteHandle, context).executeUdp( ), GXutil.trim( AV22ConCodigo), "") ;
      GXt_char3 = AV22ConCodigo ;
      GXv_char4[0] = GXt_char3 ;
      new web.getconceptopordesc(remoteHandle, context).execute( AV8CliCod, httpContext.getMessage( "VACACIONES NO GOZADAS", ""), GXv_char4) ;
      inicializarparametros.this.GXt_char3 = GXv_char4[0] ;
      AV22ConCodigo = GXt_char3 ;
      new web.grabaparametro(remoteHandle, context).execute( AV8CliCod, new web.concepto_vacacionesnogozadas_codigoparam(remoteHandle, context).executeUdp( ), GXutil.trim( AV22ConCodigo), "") ;
      GXt_char3 = AV22ConCodigo ;
      GXv_char4[0] = GXt_char3 ;
      new web.getconceptopordesc(remoteHandle, context).execute( AV8CliCod, httpContext.getMessage( "SEGURO COLECTIVO DE VIDA OBLIGATORIO", ""), GXv_char4) ;
      inicializarparametros.this.GXt_char3 = GXv_char4[0] ;
      AV22ConCodigo = GXt_char3 ;
      new web.grabaparametro(remoteHandle, context).execute( AV8CliCod, new web.concepto_scvo_codigoparam(remoteHandle, context).executeUdp( ), GXutil.trim( AV22ConCodigo), "") ;
      GXt_char3 = AV22ConCodigo ;
      GXv_char4[0] = GXt_char3 ;
      new web.getconceptopordesc(remoteHandle, context).execute( AV8CliCod, httpContext.getMessage( "FERIADOS TRABAJADOS", ""), GXv_char4) ;
      inicializarparametros.this.GXt_char3 = GXv_char4[0] ;
      AV22ConCodigo = GXt_char3 ;
      new web.grabaparametro(remoteHandle, context).execute( AV8CliCod, new web.feriadostrabajados_codigoparam(remoteHandle, context).executeUdp( ), GXutil.trim( AV22ConCodigo), "") ;
      GXt_char3 = AV22ConCodigo ;
      GXv_char4[0] = GXt_char3 ;
      new web.getconceptopordesc(remoteHandle, context).execute( AV8CliCod, httpContext.getMessage( "ADELANTO RETENCIÓN GANANCIAS", ""), GXv_char4) ;
      inicializarparametros.this.GXt_char3 = GXv_char4[0] ;
      AV22ConCodigo = GXt_char3 ;
      new web.grabaparametro(remoteHandle, context).execute( AV8CliCod, new web.adelantoretencionganancias_codigoparam(remoteHandle, context).executeUdp( ), GXutil.trim( AV22ConCodigo), "") ;
      GXt_char3 = AV22ConCodigo ;
      GXv_char4[0] = GXt_char3 ;
      new web.getconceptopordesc(remoteHandle, context).execute( AV8CliCod, httpContext.getMessage( "CÁLCULO SAC", ""), GXv_char4) ;
      inicializarparametros.this.GXt_char3 = GXv_char4[0] ;
      AV22ConCodigo = GXt_char3 ;
      new web.grabaparametro(remoteHandle, context).execute( AV8CliCod, new web.concepto_calculosac_codigoparam(remoteHandle, context).executeUdp( ), GXutil.trim( AV22ConCodigo), "") ;
      GXt_char3 = AV22ConCodigo ;
      GXv_char4[0] = GXt_char3 ;
      new web.getconceptopordesc(remoteHandle, context).execute( AV8CliCod, httpContext.getMessage( "CÁLCULO SAC PRÓXIMO ESTIMADO", ""), GXv_char4) ;
      inicializarparametros.this.GXt_char3 = GXv_char4[0] ;
      AV22ConCodigo = GXt_char3 ;
      new web.grabaparametro(remoteHandle, context).execute( AV8CliCod, new web.concepto_sacproximo_codigoparam(remoteHandle, context).executeUdp( ), GXutil.trim( AV22ConCodigo), "") ;
      GXt_char3 = AV20SACConCodigo ;
      GXt_char1 = AV20SACConCodigo ;
      GXv_char4[0] = GXt_char1 ;
      new web.sac_descripcion_fija(remoteHandle, context).execute( GXv_char4) ;
      inicializarparametros.this.GXt_char1 = GXv_char4[0] ;
      GXv_char2[0] = GXt_char3 ;
      new web.getconceptopordesc(remoteHandle, context).execute( AV8CliCod, GXt_char1, GXv_char2) ;
      inicializarparametros.this.GXt_char3 = GXv_char2[0] ;
      AV20SACConCodigo = GXt_char3 ;
      new web.grabaparametro(remoteHandle, context).execute( AV8CliCod, new web.concepto_sac_codigoparam(remoteHandle, context).executeUdp( ), GXutil.trim( AV20SACConCodigo), "") ;
      GXt_char3 = AV21SACProporConCodigo ;
      GXt_char1 = AV21SACProporConCodigo ;
      GXv_char4[0] = GXt_char1 ;
      new web.sac_propor_descripcion_fija(remoteHandle, context).execute( GXv_char4) ;
      inicializarparametros.this.GXt_char1 = GXv_char4[0] ;
      GXv_char2[0] = GXt_char3 ;
      new web.getconceptopordesc(remoteHandle, context).execute( AV8CliCod, GXt_char1, GXv_char2) ;
      inicializarparametros.this.GXt_char3 = GXv_char2[0] ;
      AV21SACProporConCodigo = GXt_char3 ;
      new web.grabaparametro(remoteHandle, context).execute( AV8CliCod, new web.concepto_sacpropor_codigoparam(remoteHandle, context).executeUdp( ), GXutil.trim( AV21SACProporConCodigo), "") ;
      GXt_char3 = AV22ConCodigo ;
      GXv_char4[0] = GXt_char3 ;
      new web.getconceptopordesc(remoteHandle, context).execute( AV8CliCod, httpContext.getMessage( "VACACIONES", ""), GXv_char4) ;
      inicializarparametros.this.GXt_char3 = GXv_char4[0] ;
      AV22ConCodigo = GXt_char3 ;
      new web.grabaparametro(remoteHandle, context).execute( AV8CliCod, new web.concepto_vacacioneslibres_codigoparam(remoteHandle, context).executeUdp( ), GXutil.trim( AV22ConCodigo), "") ;
      GXt_char3 = AV22ConCodigo ;
      GXv_char4[0] = GXt_char3 ;
      new web.getconceptopordesc(remoteHandle, context).execute( AV8CliCod, httpContext.getMessage( "ADELANTO DE VACACIONES MES PRÓXIMO", ""), GXv_char4) ;
      inicializarparametros.this.GXt_char3 = GXv_char4[0] ;
      AV22ConCodigo = GXt_char3 ;
      new web.grabaparametro(remoteHandle, context).execute( AV8CliCod, new web.concepto_adelantovacaciones_codigoparam(remoteHandle, context).executeUdp( ), GXutil.trim( AV22ConCodigo), "") ;
      GXt_char3 = AV22ConCodigo ;
      GXv_char4[0] = GXt_char3 ;
      new web.getconceptopordesc(remoteHandle, context).execute( AV8CliCod, httpContext.getMessage( "ADELANTO DE VACACIONES", ""), GXv_char4) ;
      inicializarparametros.this.GXt_char3 = GXv_char4[0] ;
      AV22ConCodigo = GXt_char3 ;
      new web.grabaparametro(remoteHandle, context).execute( AV8CliCod, new web.concepto_adelantovacamesactual_codigoparam(remoteHandle, context).executeUdp( ), GXutil.trim( AV22ConCodigo), "") ;
      GXt_char3 = AV23descuentoAdelantoVacConDescrip ;
      GXv_char4[0] = GXt_char3 ;
      new web.descripdescuentoadelantovacaciones(remoteHandle, context).execute( GXv_char4) ;
      inicializarparametros.this.GXt_char3 = GXv_char4[0] ;
      AV23descuentoAdelantoVacConDescrip = GXt_char3 ;
      GXt_char3 = AV22ConCodigo ;
      GXv_char4[0] = GXt_char3 ;
      new web.getconceptopordesc(remoteHandle, context).execute( AV8CliCod, AV23descuentoAdelantoVacConDescrip, GXv_char4) ;
      inicializarparametros.this.GXt_char3 = GXv_char4[0] ;
      AV22ConCodigo = GXt_char3 ;
      new web.grabaparametro(remoteHandle, context).execute( AV8CliCod, new web.concepto_vacaciones_descu_codigoparam(remoteHandle, context).executeUdp( ), GXutil.trim( AV22ConCodigo), "") ;
      GXt_char3 = AV19totalHaberesRemunerativosConCodigo ;
      GXv_char4[0] = GXt_char3 ;
      new web.getconceptopordesc(remoteHandle, context).execute( AV8CliCod, httpContext.getMessage( "HABERES SAC", ""), GXv_char4) ;
      inicializarparametros.this.GXt_char3 = GXv_char4[0] ;
      AV19totalHaberesRemunerativosConCodigo = GXt_char3 ;
      new web.grabaparametro(remoteHandle, context).execute( AV8CliCod, new web.concepto_haberessac_codigoparam(remoteHandle, context).executeUdp( ), GXutil.trim( AV19totalHaberesRemunerativosConCodigo), "") ;
      GXt_char3 = AV12AdicConCodigo ;
      GXv_char4[0] = GXt_char3 ;
      new web.getconceptopordesc(remoteHandle, context).execute( AV8CliCod, httpContext.getMessage( "OBRA SOCIAL ADHERENTE", ""), GXv_char4) ;
      inicializarparametros.this.GXt_char3 = GXv_char4[0] ;
      AV12AdicConCodigo = GXt_char3 ;
      new web.grabaparametro(remoteHandle, context).execute( AV8CliCod, new web.concepto_obrasocialfamadicional_codigoparam(remoteHandle, context).executeUdp( ), GXutil.trim( AV12AdicConCodigo), "") ;
      GXt_char3 = AV13ApoAdicConCodigo ;
      GXv_char4[0] = GXt_char3 ;
      new web.getconceptopordesc(remoteHandle, context).execute( AV8CliCod, httpContext.getMessage( "APORTE ADICIONAL OBRA SOCIAL", ""), GXv_char4) ;
      inicializarparametros.this.GXt_char3 = GXv_char4[0] ;
      AV13ApoAdicConCodigo = GXt_char3 ;
      new web.grabaparametro(remoteHandle, context).execute( AV8CliCod, new web.concepto_apoadicos_codigoparam(remoteHandle, context).executeUdp( ), GXutil.trim( AV13ApoAdicConCodigo), "") ;
      GXt_char3 = AV15LicMatConCodigo ;
      GXv_char4[0] = GXt_char3 ;
      new web.getconceptopordesc(remoteHandle, context).execute( AV8CliCod, httpContext.getMessage( "LICENCIA POR MATERNIDAD", ""), GXv_char4) ;
      inicializarparametros.this.GXt_char3 = GXv_char4[0] ;
      AV15LicMatConCodigo = GXt_char3 ;
      new web.grabaparametro(remoteHandle, context).execute( AV8CliCod, new web.concepto_licenciapormaternidad_codigoparam(remoteHandle, context).executeUdp( ), AV15LicMatConCodigo, "") ;
      GXt_char3 = AV22ConCodigo ;
      GXv_char4[0] = GXt_char3 ;
      new web.getconceptopordesc(remoteHandle, context).execute( AV8CliCod, httpContext.getMessage( "LICENCIA POR MATERNIDAD (DESCUENTO)", ""), GXv_char4) ;
      inicializarparametros.this.GXt_char3 = GXv_char4[0] ;
      AV22ConCodigo = GXt_char3 ;
      new web.grabaparametro(remoteHandle, context).execute( AV8CliCod, new web.concepto_licenciapormaterdescu_codigoparam(remoteHandle, context).executeUdp( ), AV22ConCodigo, "") ;
      GXt_char3 = AV17sueldoConCodigo ;
      GXt_char1 = AV17sueldoConCodigo ;
      GXv_char4[0] = GXt_char1 ;
      new web.horas_normales_descripcion_fija(remoteHandle, context).execute( GXv_char4) ;
      inicializarparametros.this.GXt_char1 = GXv_char4[0] ;
      GXv_char2[0] = GXt_char3 ;
      new web.getconceptopordesc(remoteHandle, context).execute( AV8CliCod, GXt_char1, GXv_char2) ;
      inicializarparametros.this.GXt_char3 = GXv_char2[0] ;
      AV17sueldoConCodigo = GXt_char3 ;
      new web.grabaparametro(remoteHandle, context).execute( AV8CliCod, new web.concepto_sueldojornal_codigoparam(remoteHandle, context).executeUdp( ), AV17sueldoConCodigo, "") ;
      GXt_char3 = AV17sueldoConCodigo ;
      GXt_char1 = AV17sueldoConCodigo ;
      GXv_char4[0] = GXt_char1 ;
      new web.getsueldodescripconcepto(remoteHandle, context).execute( AV8CliCod, GXv_char4) ;
      inicializarparametros.this.GXt_char1 = GXv_char4[0] ;
      GXv_char2[0] = GXt_char3 ;
      new web.getconceptopordesc(remoteHandle, context).execute( AV8CliCod, GXt_char1, GXv_char2) ;
      inicializarparametros.this.GXt_char3 = GXv_char2[0] ;
      AV17sueldoConCodigo = GXt_char3 ;
      new web.grabaparametro(remoteHandle, context).execute( AV8CliCod, new web.concepto_sueldomensual_codigoparam(remoteHandle, context).executeUdp( ), AV17sueldoConCodigo, "") ;
      GXt_char3 = AV24descuAdeVacConCodigo ;
      GXt_char1 = AV24descuAdeVacConCodigo ;
      GXv_char4[0] = GXt_char1 ;
      new web.descu_ade_vac_descripcion_fija(remoteHandle, context).execute( GXv_char4) ;
      inicializarparametros.this.GXt_char1 = GXv_char4[0] ;
      GXv_char2[0] = GXt_char3 ;
      new web.getconceptopordesc(remoteHandle, context).execute( AV8CliCod, GXt_char1, GXv_char2) ;
      inicializarparametros.this.GXt_char3 = GXv_char2[0] ;
      AV24descuAdeVacConCodigo = GXt_char3 ;
      GXt_char3 = AV25vacacionesConCodigo ;
      GXt_char1 = AV25vacacionesConCodigo ;
      GXv_char4[0] = GXt_char1 ;
      new web.vacaciones_descripcion_fija(remoteHandle, context).execute( GXv_char4) ;
      inicializarparametros.this.GXt_char1 = GXv_char4[0] ;
      GXv_char2[0] = GXt_char3 ;
      new web.getconceptopordesc(remoteHandle, context).execute( AV8CliCod, GXt_char1, GXv_char2) ;
      inicializarparametros.this.GXt_char3 = GXv_char2[0] ;
      AV25vacacionesConCodigo = GXt_char3 ;
      AV26conceptos.add(AV21SACProporConCodigo, 0);
      AV26conceptos.add(AV20SACConCodigo, 0);
      AV26conceptos.add(AV24descuAdeVacConCodigo, 0);
      AV26conceptos.add(AV25vacacionesConCodigo, 0);
      AV27ParmValue = AV26conceptos.toJSonString(false) ;
      new web.grabaparametro(remoteHandle, context).execute( AV8CliCod, new web.forzados_habitual_param(remoteHandle, context).executeUdp( ), AV27ParmValue, httpContext.getMessage( "Conceptos a forzar como habituales", "")) ;
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
      AV30Pgmname = "" ;
      AV22ConCodigo = "" ;
      AV20SACConCodigo = "" ;
      AV21SACProporConCodigo = "" ;
      AV23descuentoAdelantoVacConDescrip = "" ;
      AV19totalHaberesRemunerativosConCodigo = "" ;
      AV12AdicConCodigo = "" ;
      AV13ApoAdicConCodigo = "" ;
      AV15LicMatConCodigo = "" ;
      AV17sueldoConCodigo = "" ;
      AV24descuAdeVacConCodigo = "" ;
      AV25vacacionesConCodigo = "" ;
      GXt_char3 = "" ;
      GXt_char1 = "" ;
      GXv_char4 = new String[1] ;
      GXv_char2 = new String[1] ;
      AV26conceptos = new GXSimpleCollection<String>(String.class, "internal", "");
      AV27ParmValue = "" ;
      AV30Pgmname = "inicializarParametros" ;
      /* GeneXus formulas. */
      AV30Pgmname = "inicializarParametros" ;
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private int AV8CliCod ;
   private String AV30Pgmname ;
   private String AV22ConCodigo ;
   private String AV20SACConCodigo ;
   private String AV21SACProporConCodigo ;
   private String AV19totalHaberesRemunerativosConCodigo ;
   private String AV12AdicConCodigo ;
   private String AV13ApoAdicConCodigo ;
   private String AV15LicMatConCodigo ;
   private String AV17sueldoConCodigo ;
   private String AV24descuAdeVacConCodigo ;
   private String AV25vacacionesConCodigo ;
   private String GXt_char3 ;
   private String GXt_char1 ;
   private String GXv_char4[] ;
   private String GXv_char2[] ;
   private String AV27ParmValue ;
   private String AV23descuentoAdelantoVacConDescrip ;
   private GXSimpleCollection<String> AV26conceptos ;
}

