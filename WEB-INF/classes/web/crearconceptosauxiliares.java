package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class crearconceptosauxiliares extends GXProcedure
{
   public crearconceptosauxiliares( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( crearconceptosauxiliares.class ), "" );
   }

   public crearconceptosauxiliares( int remoteHandle ,
                                    ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( int aP0 ,
                        boolean aP1 ,
                        boolean aP2 )
   {
      execute_int(aP0, aP1, aP2);
   }

   private void execute_int( int aP0 ,
                             boolean aP1 ,
                             boolean aP2 )
   {
      crearconceptosauxiliares.this.AV8CliCod = aP0;
      crearconceptosauxiliares.this.AV13ConForExportar = aP1;
      crearconceptosauxiliares.this.AV12ConForEditable = aP2;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXv_char1[0] = AV9auxConCodigo ;
      new web.getconceptopordesc(remoteHandle, context).execute( AV8CliCod, httpContext.getMessage( "APORTE EXTRAORDINARIO SOLIDARIO", ""), GXv_char1) ;
      crearconceptosauxiliares.this.AV9auxConCodigo = GXv_char1[0] ;
      GXt_char2 = AV10mensualTLiqCod ;
      GXt_char3 = AV10mensualTLiqCod ;
      GXv_char1[0] = GXt_char3 ;
      new web.tipoliqmensual_codigoparam(remoteHandle, context).execute( GXv_char1) ;
      crearconceptosauxiliares.this.GXt_char3 = GXv_char1[0] ;
      GXv_char4[0] = GXt_char2 ;
      new web.getparametro(remoteHandle, context).execute( AV8CliCod, GXt_char3, GXv_char4) ;
      crearconceptosauxiliares.this.GXt_char2 = GXv_char4[0] ;
      AV10mensualTLiqCod = GXt_char2 ;
      GXt_char3 = AV11quincenaTLiqCod ;
      GXt_char2 = AV11quincenaTLiqCod ;
      GXv_char4[0] = GXt_char2 ;
      new web.tipoliqquincena_codigoparam(remoteHandle, context).execute( GXv_char4) ;
      crearconceptosauxiliares.this.GXt_char2 = GXv_char4[0] ;
      GXv_char1[0] = GXt_char3 ;
      new web.getparametro(remoteHandle, context).execute( AV8CliCod, GXt_char2, GXv_char1) ;
      crearconceptosauxiliares.this.GXt_char3 = GXv_char1[0] ;
      AV11quincenaTLiqCod = GXt_char3 ;
      if ( (GXutil.strcmp("", AV9auxConCodigo)==0) )
      {
         GXv_char4[0] = AV9auxConCodigo ;
         new web.proximoconcodigo(remoteHandle, context).execute( AV8CliCod, "DES_ARG", GXv_char4) ;
         crearconceptosauxiliares.this.AV9auxConCodigo = GXv_char4[0] ;
         GXv_char4[0] = AV14conceptosPalabra ;
         new web.palabraconceptos(remoteHandle, context).execute( AV8CliCod, GXv_char4) ;
         crearconceptosauxiliares.this.AV14conceptosPalabra = GXv_char4[0] ;
         new web.newconcepto(remoteHandle, context).execute( AV8CliCod, AV9auxConCodigo, httpContext.getMessage( "APORTE EXTRAORDINARIO SOLIDARIO", ""), (byte)(2), false, (byte)(1), false, "{"+GXutil.trim( AV14conceptosPalabra)+httpContext.getMessage( " remunerativos} * 0.015", ""), DecimalUtil.doubleToDec(0), "", true, AV13ConForExportar, "DES_ARG", new web.subtipocuotasindical(remoteHandle, context).executeUdp( ), "", "", AV9auxConCodigo, 0, AV12ConForEditable, "N", GXutil.toBoolean( 0), false, false) ;
         new web.newconceptotipoliq(remoteHandle, context).execute( AV8CliCod, AV9auxConCodigo, AV10mensualTLiqCod) ;
         new web.newconceptotipoliq(remoteHandle, context).execute( AV8CliCod, AV9auxConCodigo, AV11quincenaTLiqCod) ;
         new web.grabatipoliqaux(remoteHandle, context).execute( AV8CliCod, AV9auxConCodigo) ;
         new web.ajustartiposliq(remoteHandle, context).execute( AV8CliCod, (short)(0), AV9auxConCodigo, "") ;
      }
      GXv_char4[0] = AV9auxConCodigo ;
      new web.getconceptopordesc(remoteHandle, context).execute( AV8CliCod, httpContext.getMessage( "ASIG. NO REM. DECRETO 438/23", ""), GXv_char4) ;
      crearconceptosauxiliares.this.AV9auxConCodigo = GXv_char4[0] ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV17Pgmname, httpContext.getMessage( "decreto &auxConCodigo ", "")+AV9auxConCodigo) ;
      if ( (GXutil.strcmp("", AV9auxConCodigo)==0) )
      {
         GXv_char4[0] = AV9auxConCodigo ;
         new web.proximoconcodigo(remoteHandle, context).execute( AV8CliCod, "NRE_ARG", GXv_char4) ;
         crearconceptosauxiliares.this.AV9auxConCodigo = GXv_char4[0] ;
         new web.msgdebug_prod(remoteHandle, context).execute( AV17Pgmname, httpContext.getMessage( "crea decreto", "")) ;
         new web.newconcepto(remoteHandle, context).execute( AV8CliCod, AV9auxConCodigo, httpContext.getMessage( "ASIG. NO REM. DEC 438/23", ""), (byte)(1), false, (byte)(1), false, "", DecimalUtil.doubleToDec(0), "", true, AV13ConForExportar, "NRE_ARG", new web.subtiponre_especiales(remoteHandle, context).executeUdp( ), "", "", AV9auxConCodigo, 0, AV12ConForEditable, "N", GXutil.toBoolean( 0), false, false) ;
         new web.msgdebug_prod(remoteHandle, context).execute( AV17Pgmname, "1") ;
         new web.newconceptotipoliq(remoteHandle, context).execute( AV8CliCod, AV9auxConCodigo, AV10mensualTLiqCod) ;
         new web.msgdebug_prod(remoteHandle, context).execute( AV17Pgmname, "2") ;
         new web.newconceptotipoliq(remoteHandle, context).execute( AV8CliCod, AV9auxConCodigo, AV11quincenaTLiqCod) ;
         new web.msgdebug_prod(remoteHandle, context).execute( AV17Pgmname, "3") ;
         new web.grabatipoliqaux(remoteHandle, context).execute( AV8CliCod, AV9auxConCodigo) ;
         new web.msgdebug_prod(remoteHandle, context).execute( AV17Pgmname, "4") ;
         new web.ajustartiposliq(remoteHandle, context).execute( AV8CliCod, (short)(0), AV9auxConCodigo, "") ;
         new web.msgdebug_prod(remoteHandle, context).execute( AV17Pgmname, "5") ;
      }
      new web.msgdebug_prod(remoteHandle, context).execute( AV17Pgmname, "6") ;
      GXv_char4[0] = AV9auxConCodigo ;
      new web.getconceptopordesc(remoteHandle, context).execute( AV8CliCod, httpContext.getMessage( "GRATIFICACIÓN POR CESE LABORAL (ART. 7 LEY 24.241 Y MODIF.)", ""), GXv_char4) ;
      crearconceptosauxiliares.this.AV9auxConCodigo = GXv_char4[0] ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV17Pgmname, "7") ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV17Pgmname, httpContext.getMessage( "GRAT &auxConCodigo ", "")+AV9auxConCodigo) ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV17Pgmname, "8") ;
      if ( (GXutil.strcmp("", AV9auxConCodigo)==0) )
      {
         new web.msgdebug_prod(remoteHandle, context).execute( AV17Pgmname, "9") ;
         GXv_char4[0] = AV9auxConCodigo ;
         new web.proximoconcodigo(remoteHandle, context).execute( AV8CliCod, "NRE_ARG", GXv_char4) ;
         crearconceptosauxiliares.this.AV9auxConCodigo = GXv_char4[0] ;
         new web.msgdebug_prod(remoteHandle, context).execute( AV17Pgmname, httpContext.getMessage( "crea GRAT", "")) ;
         new web.newconcepto(remoteHandle, context).execute( AV8CliCod, AV9auxConCodigo, httpContext.getMessage( "GRATIFICACIÓN POR CESE LABORAL (ART. 7 LEY 24.241 Y MODIF.)", ""), (byte)(1), false, (byte)(1), false, "", DecimalUtil.doubleToDec(0), "", true, AV13ConForExportar, "NRE_ARG", new web.subtipobeneficio(remoteHandle, context).executeUdp( ), new web.subtipo2gratificaciondesempleo(remoteHandle, context).executeUdp( ), "", AV9auxConCodigo, 0, AV12ConForEditable, "N", GXutil.toBoolean( 0), false, false) ;
         new web.newconceptotipoliq(remoteHandle, context).execute( AV8CliCod, AV9auxConCodigo, AV10mensualTLiqCod) ;
         new web.newconceptotipoliq(remoteHandle, context).execute( AV8CliCod, AV9auxConCodigo, AV11quincenaTLiqCod) ;
         new web.grabatipoliqaux(remoteHandle, context).execute( AV8CliCod, AV9auxConCodigo) ;
         new web.ajustartiposliq(remoteHandle, context).execute( AV8CliCod, (short)(0), AV9auxConCodigo, "") ;
      }
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
      AV9auxConCodigo = "" ;
      AV10mensualTLiqCod = "" ;
      AV11quincenaTLiqCod = "" ;
      GXt_char3 = "" ;
      GXt_char2 = "" ;
      GXv_char1 = new String[1] ;
      AV14conceptosPalabra = "" ;
      AV17Pgmname = "" ;
      GXv_char4 = new String[1] ;
      AV17Pgmname = "crearConceptosAuxiliares" ;
      /* GeneXus formulas. */
      AV17Pgmname = "crearConceptosAuxiliares" ;
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private int AV8CliCod ;
   private String AV9auxConCodigo ;
   private String AV10mensualTLiqCod ;
   private String AV11quincenaTLiqCod ;
   private String GXt_char3 ;
   private String GXt_char2 ;
   private String GXv_char1[] ;
   private String AV14conceptosPalabra ;
   private String AV17Pgmname ;
   private String GXv_char4[] ;
   private boolean AV13ConForExportar ;
   private boolean AV12ConForEditable ;
}

