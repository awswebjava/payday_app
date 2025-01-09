package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class tope_indemnizatorio extends GXProcedure
{
   public tope_indemnizatorio( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( tope_indemnizatorio.class ), "" );
   }

   public tope_indemnizatorio( int remoteHandle ,
                               ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             java.util.Date aP3 ,
                             java.math.BigDecimal[] aP4 )
   {
      tope_indemnizatorio.this.aP5 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5);
      return aP5[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        java.util.Date aP3 ,
                        java.math.BigDecimal[] aP4 ,
                        String[] aP5 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             java.util.Date aP3 ,
                             java.math.BigDecimal[] aP4 ,
                             String[] aP5 )
   {
      tope_indemnizatorio.this.AV8CliCod = aP0;
      tope_indemnizatorio.this.AV9EmpCod = aP1;
      tope_indemnizatorio.this.AV10LegNumero = aP2;
      tope_indemnizatorio.this.AV18LiqPeriodo = aP3;
      tope_indemnizatorio.this.aP4 = aP4;
      tope_indemnizatorio.this.aP5 = aP5;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXv_char1[0] = AV11ConveCodigo ;
      new web.empleadogetconvenio(remoteHandle, context).execute( AV8CliCod, AV9EmpCod, AV10LegNumero, GXv_char1) ;
      tope_indemnizatorio.this.AV11ConveCodigo = GXv_char1[0] ;
      if ( (GXutil.strcmp("", AV11ConveCodigo)==0) )
      {
         GXv_char1[0] = AV11ConveCodigo ;
         GXv_decimal2[0] = AV12Importe ;
         new web.getempresaconvetope(remoteHandle, context).execute( AV8CliCod, AV9EmpCod, AV10LegNumero, AV18LiqPeriodo, GXv_char1, GXv_decimal2) ;
         tope_indemnizatorio.this.AV11ConveCodigo = GXv_char1[0] ;
         tope_indemnizatorio.this.AV12Importe = GXv_decimal2[0] ;
      }
      new web.msgdebug_prod(remoteHandle, context).execute( AV21Pgmname, httpContext.getMessage( "&ConveCodigo ", "")+AV11ConveCodigo) ;
      if ( ! (GXutil.strcmp("", AV11ConveCodigo)==0) )
      {
         AV13LiqDLog = httpContext.getMessage( "El tope indemnizatorio del convenio ", "") + GXutil.trim( AV11ConveCodigo) + httpContext.getMessage( " es ", "") + GXutil.trim( GXutil.str( AV12Importe, 14, 2)) ;
         new web.msgdebug_prod(remoteHandle, context).execute( AV21Pgmname, httpContext.getMessage( "&LiqDLog ", "")+AV13LiqDLog) ;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP4[0] = tope_indemnizatorio.this.AV12Importe;
      this.aP5[0] = tope_indemnizatorio.this.AV13LiqDLog;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV12Importe = DecimalUtil.ZERO ;
      AV13LiqDLog = "" ;
      AV11ConveCodigo = "" ;
      GXv_char1 = new String[1] ;
      GXv_decimal2 = new java.math.BigDecimal[1] ;
      AV21Pgmname = "" ;
      AV21Pgmname = "tope_indemnizatorio" ;
      /* GeneXus formulas. */
      AV21Pgmname = "tope_indemnizatorio" ;
      Gx_err = (short)(0) ;
   }

   private short AV9EmpCod ;
   private short Gx_err ;
   private int AV8CliCod ;
   private int AV10LegNumero ;
   private java.math.BigDecimal AV12Importe ;
   private java.math.BigDecimal GXv_decimal2[] ;
   private String AV11ConveCodigo ;
   private String GXv_char1[] ;
   private String AV21Pgmname ;
   private java.util.Date AV18LiqPeriodo ;
   private String AV13LiqDLog ;
   private String[] aP5 ;
   private java.math.BigDecimal[] aP4 ;
}

