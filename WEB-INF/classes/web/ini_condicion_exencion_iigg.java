package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class ini_condicion_exencion_iigg extends GXProcedure
{
   public ini_condicion_exencion_iigg( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( ini_condicion_exencion_iigg.class ), "" );
   }

   public ini_condicion_exencion_iigg( int remoteHandle ,
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
      ini_condicion_exencion_iigg.this.AV8CliCod = aP0;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_char1 = AV9RembrutaConCodigo ;
      GXt_char2 = AV9RembrutaConCodigo ;
      GXv_char3[0] = GXt_char2 ;
      new web.concepto_sueldobruto_codigoparam(remoteHandle, context).execute( GXv_char3) ;
      ini_condicion_exencion_iigg.this.GXt_char2 = GXv_char3[0] ;
      GXv_char4[0] = GXt_char1 ;
      new web.getparametro(remoteHandle, context).execute( AV8CliCod, GXt_char2, GXv_char4) ;
      ini_condicion_exencion_iigg.this.GXt_char1 = GXv_char4[0] ;
      AV9RembrutaConCodigo = GXt_char1 ;
      AV10palabra = "[tope_bonos]" ;
      new web.new_condicion_exencion_iigg(remoteHandle, context).execute( AV8CliCod, httpContext.getMessage( "TOPEBONOS", ""), AV9RembrutaConCodigo, true, true, AV10palabra, httpContext.getMessage( "Exención de bonos por productividad:Promedio del sueldo bruto acumulado no supera al tope establecido", ""), DecimalUtil.doubleToDec(0), "menorOIgual") ;
      GXt_char2 = AV12perPozoConCodigo ;
      GXt_char1 = AV12perPozoConCodigo ;
      GXv_char4[0] = GXt_char1 ;
      new web.concepto_espersonaldepozo_codigoparam(remoteHandle, context).execute( GXv_char4) ;
      ini_condicion_exencion_iigg.this.GXt_char1 = GXv_char4[0] ;
      GXv_char3[0] = GXt_char2 ;
      new web.getparametro(remoteHandle, context).execute( AV8CliCod, GXt_char1, GXv_char3) ;
      ini_condicion_exencion_iigg.this.GXt_char2 = GXv_char3[0] ;
      AV12perPozoConCodigo = GXt_char2 ;
      AV10palabra = "" ;
      AV11CondExenIIGGVFi = DecimalUtil.doubleToDec(0) ;
      new web.new_condicion_exencion_iigg(remoteHandle, context).execute( AV8CliCod, httpContext.getMessage( "PERSONALPOZO", ""), AV12perPozoConCodigo, false, false, AV10palabra, httpContext.getMessage( "Exención para personal de Pozo", ""), DecimalUtil.doubleToDec(1), "igual") ;
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
      AV9RembrutaConCodigo = "" ;
      AV10palabra = "" ;
      AV12perPozoConCodigo = "" ;
      GXt_char2 = "" ;
      GXt_char1 = "" ;
      GXv_char4 = new String[1] ;
      GXv_char3 = new String[1] ;
      AV11CondExenIIGGVFi = DecimalUtil.ZERO ;
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private int AV8CliCod ;
   private java.math.BigDecimal AV11CondExenIIGGVFi ;
   private String AV9RembrutaConCodigo ;
   private String AV10palabra ;
   private String AV12perPozoConCodigo ;
   private String GXt_char2 ;
   private String GXt_char1 ;
   private String GXv_char4[] ;
   private String GXv_char3[] ;
}

