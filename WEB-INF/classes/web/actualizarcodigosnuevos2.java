package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class actualizarcodigosnuevos2 extends GXProcedure
{
   public actualizarcodigosnuevos2( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( actualizarcodigosnuevos2.class ), "" );
   }

   public actualizarcodigosnuevos2( int remoteHandle ,
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
      actualizarcodigosnuevos2.this.AV10CliCod = aP0;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_char1 = AV8sueldoNetoAnualConCodigo ;
      GXt_char2 = AV8sueldoNetoAnualConCodigo ;
      GXv_char3[0] = GXt_char2 ;
      new web.concepto_sueldonetoanual_codigoparam(remoteHandle, context).execute( GXv_char3) ;
      actualizarcodigosnuevos2.this.GXt_char2 = GXv_char3[0] ;
      GXv_char4[0] = GXt_char1 ;
      new web.getparametro(remoteHandle, context).execute( AV10CliCod, GXt_char2, GXv_char4) ;
      actualizarcodigosnuevos2.this.GXt_char1 = GXv_char4[0] ;
      AV8sueldoNetoAnualConCodigo = GXt_char1 ;
      GXt_char2 = AV11liquidaSACConCodigo ;
      GXt_char1 = AV11liquidaSACConCodigo ;
      GXv_char4[0] = GXt_char1 ;
      new web.concepto_liquidasac_codigoparam(remoteHandle, context).execute( GXv_char4) ;
      actualizarcodigosnuevos2.this.GXt_char1 = GXv_char4[0] ;
      GXv_char3[0] = GXt_char2 ;
      new web.getparametro(remoteHandle, context).execute( AV10CliCod, GXt_char1, GXv_char3) ;
      actualizarcodigosnuevos2.this.GXt_char2 = GXv_char3[0] ;
      AV11liquidaSACConCodigo = GXt_char2 ;
      GXt_char2 = AV17topeDonacionesConCodigo ;
      GXt_char1 = AV17topeDonacionesConCodigo ;
      GXv_char4[0] = GXt_char1 ;
      new web.concepto_topedonaciones_codigoparam(remoteHandle, context).execute( GXv_char4) ;
      actualizarcodigosnuevos2.this.GXt_char1 = GXv_char4[0] ;
      GXv_char3[0] = GXt_char2 ;
      new web.getparametro(remoteHandle, context).execute( AV10CliCod, GXt_char1, GXv_char3) ;
      actualizarcodigosnuevos2.this.GXt_char2 = GXv_char3[0] ;
      AV17topeDonacionesConCodigo = GXt_char2 ;
      GXt_char2 = AV22topeMedicosConCodigo ;
      GXt_char1 = AV22topeMedicosConCodigo ;
      GXv_char4[0] = GXt_char1 ;
      new web.concepto_topemedicos_codigoparam(remoteHandle, context).execute( GXv_char4) ;
      actualizarcodigosnuevos2.this.GXt_char1 = GXv_char4[0] ;
      GXv_char3[0] = GXt_char2 ;
      new web.getparametro(remoteHandle, context).execute( AV10CliCod, GXt_char1, GXv_char3) ;
      actualizarcodigosnuevos2.this.GXt_char2 = GXv_char3[0] ;
      AV22topeMedicosConCodigo = GXt_char2 ;
      GXt_char2 = AV19topePrepagaConCodigo ;
      GXt_char1 = AV19topePrepagaConCodigo ;
      GXv_char4[0] = GXt_char1 ;
      new web.concepto_topeprepaga_codigoparam(remoteHandle, context).execute( GXv_char4) ;
      actualizarcodigosnuevos2.this.GXt_char1 = GXv_char4[0] ;
      GXv_char3[0] = GXt_char2 ;
      new web.getparametro(remoteHandle, context).execute( AV10CliCod, GXt_char1, GXv_char3) ;
      actualizarcodigosnuevos2.this.GXt_char2 = GXv_char3[0] ;
      AV19topePrepagaConCodigo = GXt_char2 ;
      GXt_char2 = AV20retencionBrutaConCodigo ;
      GXt_char1 = AV20retencionBrutaConCodigo ;
      GXv_char4[0] = GXt_char1 ;
      new web.retencionbruta_codigoparam(remoteHandle, context).execute( GXv_char4) ;
      actualizarcodigosnuevos2.this.GXt_char1 = GXv_char4[0] ;
      GXv_char3[0] = GXt_char2 ;
      new web.getparametro(remoteHandle, context).execute( AV10CliCod, GXt_char1, GXv_char3) ;
      actualizarcodigosnuevos2.this.GXt_char2 = GXv_char3[0] ;
      AV20retencionBrutaConCodigo = GXt_char2 ;
      GXt_char2 = AV21sacLiquidadoPeriodoConCodigo ;
      GXt_char1 = AV21sacLiquidadoPeriodoConCodigo ;
      GXv_char4[0] = GXt_char1 ;
      new web.concepto_sacliquidadoperiodo_codigoparam(remoteHandle, context).execute( GXv_char4) ;
      actualizarcodigosnuevos2.this.GXt_char1 = GXv_char4[0] ;
      GXv_char3[0] = GXt_char2 ;
      new web.getparametro(remoteHandle, context).execute( AV10CliCod, GXt_char1, GXv_char3) ;
      actualizarcodigosnuevos2.this.GXt_char2 = GXv_char3[0] ;
      AV21sacLiquidadoPeriodoConCodigo = GXt_char2 ;
      GXt_char2 = AV23sueldobrutoSinSacGravadoConCodigo ;
      GXt_char1 = AV23sueldobrutoSinSacGravadoConCodigo ;
      GXv_char4[0] = GXt_char1 ;
      new web.concepto_sueldobrutoalcanzadosinsac_codigoparam(remoteHandle, context).execute( GXv_char4) ;
      actualizarcodigosnuevos2.this.GXt_char1 = GXv_char4[0] ;
      GXv_char3[0] = GXt_char2 ;
      new web.getparametro(remoteHandle, context).execute( AV10CliCod, GXt_char1, GXv_char3) ;
      actualizarcodigosnuevos2.this.GXt_char2 = GXv_char3[0] ;
      AV23sueldobrutoSinSacGravadoConCodigo = GXt_char2 ;
      GXt_char2 = AV27baseDifApoOSConCodigo ;
      GXt_char1 = AV27baseDifApoOSConCodigo ;
      GXv_char4[0] = GXt_char1 ;
      new web.parametro_concepto_lsd_basedifapoosfsr(remoteHandle, context).execute( GXv_char4) ;
      actualizarcodigosnuevos2.this.GXt_char1 = GXv_char4[0] ;
      GXv_char3[0] = GXt_char2 ;
      new web.getparametro(remoteHandle, context).execute( AV10CliCod, GXt_char1, GXv_char3) ;
      actualizarcodigosnuevos2.this.GXt_char2 = GXv_char3[0] ;
      AV27baseDifApoOSConCodigo = GXt_char2 ;
      GXv_char4[0] = AV12conceptoPalabra ;
      new web.codigoopeformula(remoteHandle, context).execute( AV10CliCod, "{concepto}", false, true, GXv_char4) ;
      actualizarcodigosnuevos2.this.AV12conceptoPalabra = GXv_char4[0] ;
      AV14deMesesAnterioresPalabra = "deMesesAnteriores" ;
      AV15mismoPeriodoPalabra = "mismoPeriodo" ;
      GXt_char2 = AV31baseImp2ConCodigo ;
      GXt_char1 = AV31baseImp2ConCodigo ;
      GXv_char4[0] = GXt_char1 ;
      new web.parametro_concepto_lsd_baseimponible2(remoteHandle, context).execute( GXv_char4) ;
      actualizarcodigosnuevos2.this.GXt_char1 = GXv_char4[0] ;
      GXv_char3[0] = GXt_char2 ;
      new web.getparametro(remoteHandle, context).execute( AV10CliCod, GXt_char1, GXv_char3) ;
      actualizarcodigosnuevos2.this.GXt_char2 = GXv_char3[0] ;
      AV31baseImp2ConCodigo = GXt_char2 ;
      GXt_char2 = AV32baseImp3ConCodigo ;
      GXt_char1 = AV32baseImp3ConCodigo ;
      GXv_char4[0] = GXt_char1 ;
      new web.parametro_concepto_lsd_baseimponible3(remoteHandle, context).execute( GXv_char4) ;
      actualizarcodigosnuevos2.this.GXt_char1 = GXv_char4[0] ;
      GXv_char3[0] = GXt_char2 ;
      new web.getparametro(remoteHandle, context).execute( AV10CliCod, GXt_char1, GXv_char3) ;
      actualizarcodigosnuevos2.this.GXt_char2 = GXv_char3[0] ;
      AV32baseImp3ConCodigo = GXt_char2 ;
      GXt_char2 = AV33baseImp8ConCodigo ;
      GXt_char1 = AV33baseImp8ConCodigo ;
      GXv_char4[0] = GXt_char1 ;
      new web.parametro_concepto_lsd_baseimponible8(remoteHandle, context).execute( GXv_char4) ;
      actualizarcodigosnuevos2.this.GXt_char1 = GXv_char4[0] ;
      GXv_char3[0] = GXt_char2 ;
      new web.getparametro(remoteHandle, context).execute( AV10CliCod, GXt_char1, GXv_char3) ;
      actualizarcodigosnuevos2.this.GXt_char2 = GXv_char3[0] ;
      AV33baseImp8ConCodigo = GXt_char2 ;
      GXt_char2 = AV28importeADetraerConCodigo ;
      GXt_char1 = AV28importeADetraerConCodigo ;
      GXv_char4[0] = GXt_char1 ;
      new web.parametro_concepto_lsd_importeadetraer(remoteHandle, context).execute( GXv_char4) ;
      actualizarcodigosnuevos2.this.GXt_char1 = GXv_char4[0] ;
      GXv_char3[0] = GXt_char2 ;
      new web.getparametro(remoteHandle, context).execute( AV10CliCod, GXt_char1, GXv_char3) ;
      actualizarcodigosnuevos2.this.GXt_char2 = GXv_char3[0] ;
      AV28importeADetraerConCodigo = GXt_char2 ;
      GXt_char2 = AV29diferencialOSFSRConCodigo ;
      GXt_char1 = AV29diferencialOSFSRConCodigo ;
      GXv_char4[0] = GXt_char1 ;
      new web.parametro_concepto_lsd_basedifcontrosfsr(remoteHandle, context).execute( GXv_char4) ;
      actualizarcodigosnuevos2.this.GXt_char1 = GXv_char4[0] ;
      GXv_char3[0] = GXt_char2 ;
      new web.getparametro(remoteHandle, context).execute( AV10CliCod, GXt_char1, GXv_char3) ;
      actualizarcodigosnuevos2.this.GXt_char2 = GXv_char3[0] ;
      AV29diferencialOSFSRConCodigo = GXt_char2 ;
      GXt_char2 = AV30obraSocialAnssalConCodigo ;
      GXt_char1 = AV30obraSocialAnssalConCodigo ;
      GXv_char4[0] = GXt_char1 ;
      new web.concepto_osfsr_codigoparam(remoteHandle, context).execute( GXv_char4) ;
      actualizarcodigosnuevos2.this.GXt_char1 = GXv_char4[0] ;
      GXv_char3[0] = GXt_char2 ;
      new web.getparametro(remoteHandle, context).execute( AV10CliCod, GXt_char1, GXv_char3) ;
      actualizarcodigosnuevos2.this.GXt_char2 = GXv_char3[0] ;
      AV30obraSocialAnssalConCodigo = GXt_char2 ;
      GXt_char2 = AV24perDoCMaterialExentoConCodigo ;
      GXt_char1 = AV24perDoCMaterialExentoConCodigo ;
      GXv_char4[0] = GXt_char1 ;
      new web.concepto_perdocmatexentos_codigoparam(remoteHandle, context).execute( GXv_char4) ;
      actualizarcodigosnuevos2.this.GXt_char1 = GXv_char4[0] ;
      GXv_char3[0] = GXt_char2 ;
      new web.getparametro(remoteHandle, context).execute( AV10CliCod, GXt_char1, GXv_char3) ;
      actualizarcodigosnuevos2.this.GXt_char2 = GXv_char3[0] ;
      AV24perDoCMaterialExentoConCodigo = GXt_char2 ;
      GXt_char2 = AV25movViaExentoConCodigo ;
      GXt_char1 = AV25movViaExentoConCodigo ;
      GXv_char4[0] = GXt_char1 ;
      new web.concepto_movviaexentos_codigoparam(remoteHandle, context).execute( GXv_char4) ;
      actualizarcodigosnuevos2.this.GXt_char1 = GXv_char4[0] ;
      GXv_char3[0] = GXt_char2 ;
      new web.getparametro(remoteHandle, context).execute( AV10CliCod, GXt_char1, GXv_char3) ;
      actualizarcodigosnuevos2.this.GXt_char2 = GXv_char3[0] ;
      AV25movViaExentoConCodigo = GXt_char2 ;
      /* Using cursor P00QO2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV10CliCod)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A3CliCod = P00QO2_A3CliCod[0] ;
         A148ConFormula = P00QO2_A148ConFormula[0] ;
         n148ConFormula = P00QO2_n148ConFormula[0] ;
         A26ConCodigo = P00QO2_A26ConCodigo[0] ;
         A148ConFormula = GXutil.strReplace( A148ConFormula, httpContext.getMessage( "{baseImp2}", ""), GXutil.trim( AV31baseImp2ConCodigo)) ;
         n148ConFormula = false ;
         A148ConFormula = GXutil.strReplace( A148ConFormula, httpContext.getMessage( "{baseImp3}", ""), GXutil.trim( AV32baseImp3ConCodigo)) ;
         n148ConFormula = false ;
         A148ConFormula = GXutil.strReplace( A148ConFormula, httpContext.getMessage( "{baseImp8}", ""), GXutil.trim( AV33baseImp8ConCodigo)) ;
         n148ConFormula = false ;
         A148ConFormula = GXutil.strReplace( A148ConFormula, httpContext.getMessage( "{importeADetraer}", ""), GXutil.trim( AV28importeADetraerConCodigo)) ;
         n148ConFormula = false ;
         A148ConFormula = GXutil.strReplace( A148ConFormula, httpContext.getMessage( "{diferencialOSFSR}", ""), GXutil.trim( AV29diferencialOSFSRConCodigo)) ;
         n148ConFormula = false ;
         A148ConFormula = GXutil.strReplace( A148ConFormula, httpContext.getMessage( "{obraSocialAnssal}", ""), GXutil.trim( AV30obraSocialAnssalConCodigo)) ;
         n148ConFormula = false ;
         A148ConFormula = GXutil.strReplace( A148ConFormula, httpContext.getMessage( "{baseDifApoOS}", ""), "["+GXutil.trim( AV12conceptoPalabra)+" "+GXutil.trim( AV27baseDifApoOSConCodigo)+"]") ;
         n148ConFormula = false ;
         A148ConFormula = GXutil.strReplace( A148ConFormula, httpContext.getMessage( "{conceptoDiasTrabajadosMes}", ""), "["+GXutil.trim( AV12conceptoPalabra)+" "+GXutil.trim( AV26diasTrabajadosMesConCodigo)+"]") ;
         n148ConFormula = false ;
         A148ConFormula = GXutil.strReplace( A148ConFormula, httpContext.getMessage( "&perDoCMaterialExentoConCodigo", ""), AV24perDoCMaterialExentoConCodigo) ;
         n148ConFormula = false ;
         A148ConFormula = GXutil.strReplace( A148ConFormula, httpContext.getMessage( "&movViaExentoConCodigo", ""), AV25movViaExentoConCodigo) ;
         n148ConFormula = false ;
         A148ConFormula = GXutil.strReplace( A148ConFormula, httpContext.getMessage( "{sueldobrutoSinSacGravadoConCodigo}", ""), AV23sueldobrutoSinSacGravadoConCodigo) ;
         n148ConFormula = false ;
         A148ConFormula = GXutil.strReplace( A148ConFormula, httpContext.getMessage( "{conc_sac_liquidado_periodo}", ""), "["+GXutil.trim( AV12conceptoPalabra)+" "+GXutil.trim( AV21sacLiquidadoPeriodoConCodigo)+"]") ;
         n148ConFormula = false ;
         A148ConFormula = GXutil.strReplace( A148ConFormula, httpContext.getMessage( "{retencion_bruta}", ""), "["+GXutil.trim( AV12conceptoPalabra)+" "+GXutil.trim( AV20retencionBrutaConCodigo)+"]") ;
         n148ConFormula = false ;
         A148ConFormula = GXutil.strReplace( A148ConFormula, httpContext.getMessage( "{tope_prepaga}", ""), "["+GXutil.trim( AV12conceptoPalabra)+" "+GXutil.trim( AV19topePrepagaConCodigo)+"]") ;
         n148ConFormula = false ;
         A148ConFormula = GXutil.strReplace( A148ConFormula, httpContext.getMessage( "{tope_donaciones}", ""), "["+GXutil.trim( AV12conceptoPalabra)+" "+GXutil.trim( AV17topeDonacionesConCodigo)+"]") ;
         n148ConFormula = false ;
         A148ConFormula = GXutil.strReplace( A148ConFormula, httpContext.getMessage( "{tope_medicos}", ""), "["+GXutil.trim( AV12conceptoPalabra)+" "+GXutil.trim( AV22topeMedicosConCodigo)+"]") ;
         n148ConFormula = false ;
         A148ConFormula = GXutil.strReplace( A148ConFormula, httpContext.getMessage( "{conceptoSueldoNetoAnual}", ""), "["+GXutil.trim( AV12conceptoPalabra)+" "+GXutil.trim( AV8sueldoNetoAnualConCodigo)+"]") ;
         n148ConFormula = false ;
         A148ConFormula = GXutil.strReplace( A148ConFormula, httpContext.getMessage( "{liquidaSAC}", ""), "["+GXutil.trim( AV12conceptoPalabra)+" "+GXutil.trim( AV11liquidaSACConCodigo)+"]") ;
         n148ConFormula = false ;
         A148ConFormula = GXutil.strReplace( A148ConFormula, GXutil.trim( AV14deMesesAnterioresPalabra)+" 0", GXutil.trim( AV15mismoPeriodoPalabra)) ;
         n148ConFormula = false ;
         A148ConFormula = GXutil.strReplace( A148ConFormula, httpContext.getMessage( "T 1 mismoPeriodo", ""), httpContext.getMessage( "mismoPeriodo", "")) ;
         n148ConFormula = false ;
         A148ConFormula = GXutil.strReplace( A148ConFormula, httpContext.getMessage( "T 1 deMesesAnteriores 5 mejor", ""), httpContext.getMessage( "deMesesAnteriores mejor", "")) ;
         n148ConFormula = false ;
         A148ConFormula = GXutil.strReplace( A148ConFormula, httpContext.getMessage( " T]", ""), "]") ;
         n148ConFormula = false ;
         GXv_char4[0] = A148ConFormula ;
         new web.corregirespaciosformula(remoteHandle, context).execute( A3CliCod, GXv_char4) ;
         actualizarcodigosnuevos2.this.A148ConFormula = GXv_char4[0] ;
         n148ConFormula = ((GXutil.strcmp("", A148ConFormula)==0) ? true : false) ;
         /* Using cursor P00QO3 */
         pr_default.execute(1, new Object[] {Boolean.valueOf(n148ConFormula), A148ConFormula, Integer.valueOf(A3CliCod), A26ConCodigo});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("Concepto");
         pr_default.readNext(0);
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      Application.commitDataStores(context, remoteHandle, pr_default, "actualizarcodigosnuevos2");
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV8sueldoNetoAnualConCodigo = "" ;
      AV11liquidaSACConCodigo = "" ;
      AV17topeDonacionesConCodigo = "" ;
      AV22topeMedicosConCodigo = "" ;
      AV19topePrepagaConCodigo = "" ;
      AV20retencionBrutaConCodigo = "" ;
      AV21sacLiquidadoPeriodoConCodigo = "" ;
      AV23sueldobrutoSinSacGravadoConCodigo = "" ;
      AV27baseDifApoOSConCodigo = "" ;
      AV12conceptoPalabra = "" ;
      AV14deMesesAnterioresPalabra = "" ;
      AV15mismoPeriodoPalabra = "" ;
      AV31baseImp2ConCodigo = "" ;
      AV32baseImp3ConCodigo = "" ;
      AV33baseImp8ConCodigo = "" ;
      AV28importeADetraerConCodigo = "" ;
      AV29diferencialOSFSRConCodigo = "" ;
      AV30obraSocialAnssalConCodigo = "" ;
      AV24perDoCMaterialExentoConCodigo = "" ;
      AV25movViaExentoConCodigo = "" ;
      GXt_char2 = "" ;
      GXt_char1 = "" ;
      GXv_char3 = new String[1] ;
      scmdbuf = "" ;
      P00QO2_A3CliCod = new int[1] ;
      P00QO2_A148ConFormula = new String[] {""} ;
      P00QO2_n148ConFormula = new boolean[] {false} ;
      P00QO2_A26ConCodigo = new String[] {""} ;
      A148ConFormula = "" ;
      A26ConCodigo = "" ;
      AV26diasTrabajadosMesConCodigo = "" ;
      GXv_char4 = new String[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.actualizarcodigosnuevos2__default(),
         new Object[] {
             new Object[] {
            P00QO2_A3CliCod, P00QO2_A148ConFormula, P00QO2_n148ConFormula, P00QO2_A26ConCodigo
            }
            , new Object[] {
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private int AV10CliCod ;
   private int A3CliCod ;
   private String AV8sueldoNetoAnualConCodigo ;
   private String AV11liquidaSACConCodigo ;
   private String AV17topeDonacionesConCodigo ;
   private String AV22topeMedicosConCodigo ;
   private String AV19topePrepagaConCodigo ;
   private String AV20retencionBrutaConCodigo ;
   private String AV21sacLiquidadoPeriodoConCodigo ;
   private String AV23sueldobrutoSinSacGravadoConCodigo ;
   private String AV27baseDifApoOSConCodigo ;
   private String AV12conceptoPalabra ;
   private String AV14deMesesAnterioresPalabra ;
   private String AV15mismoPeriodoPalabra ;
   private String AV31baseImp2ConCodigo ;
   private String AV32baseImp3ConCodigo ;
   private String AV33baseImp8ConCodigo ;
   private String AV28importeADetraerConCodigo ;
   private String AV29diferencialOSFSRConCodigo ;
   private String AV30obraSocialAnssalConCodigo ;
   private String AV24perDoCMaterialExentoConCodigo ;
   private String AV25movViaExentoConCodigo ;
   private String GXt_char2 ;
   private String GXt_char1 ;
   private String GXv_char3[] ;
   private String scmdbuf ;
   private String A26ConCodigo ;
   private String AV26diasTrabajadosMesConCodigo ;
   private String GXv_char4[] ;
   private boolean n148ConFormula ;
   private String A148ConFormula ;
   private IDataStoreProvider pr_default ;
   private int[] P00QO2_A3CliCod ;
   private String[] P00QO2_A148ConFormula ;
   private boolean[] P00QO2_n148ConFormula ;
   private String[] P00QO2_A26ConCodigo ;
}

final  class actualizarcodigosnuevos2__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00QO2", "SELECT CliCod, ConFormula, ConCodigo FROM Concepto WHERE CliCod = ? ORDER BY CliCod  FOR UPDATE OF Concepto",true, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("P00QO3", "SAVEPOINT gxupdate;UPDATE Concepto SET ConFormula=?  WHERE CliCod = ? AND ConCodigo = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getLongVarchar(2);
               ((boolean[]) buf[2])[0] = rslt.wasNull();
               ((String[]) buf[3])[0] = rslt.getString(3, 10);
               return;
      }
   }

   public void setParameters( int cursor ,
                              IFieldSetter stmt ,
                              Object[] parms ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 1 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.LONGVARCHAR );
               }
               else
               {
                  stmt.setNLongVarchar(1, (String)parms[1]);
               }
               stmt.setInt(2, ((Number) parms[2]).intValue());
               stmt.setString(3, (String)parms[3], 10);
               return;
      }
   }

}

