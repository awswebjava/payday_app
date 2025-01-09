package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class descuentosobreimponible extends GXProcedure
{
   public descuentosobreimponible( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( descuentosobreimponible.class ), "" );
   }

   public descuentosobreimponible( int remoteHandle ,
                                   ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 ,
                             short aP1 ,
                             java.util.Date aP2 ,
                             int aP3 ,
                             boolean aP4 ,
                             java.math.BigDecimal aP5 ,
                             java.math.BigDecimal aP6 ,
                             java.math.BigDecimal aP7 ,
                             java.math.BigDecimal aP8 ,
                             java.math.BigDecimal aP9 ,
                             String aP10 ,
                             java.math.BigDecimal[] aP11 )
   {
      descuentosobreimponible.this.aP12 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11, aP12);
      return aP12[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        java.util.Date aP2 ,
                        int aP3 ,
                        boolean aP4 ,
                        java.math.BigDecimal aP5 ,
                        java.math.BigDecimal aP6 ,
                        java.math.BigDecimal aP7 ,
                        java.math.BigDecimal aP8 ,
                        java.math.BigDecimal aP9 ,
                        String aP10 ,
                        java.math.BigDecimal[] aP11 ,
                        String[] aP12 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11, aP12);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             java.util.Date aP2 ,
                             int aP3 ,
                             boolean aP4 ,
                             java.math.BigDecimal aP5 ,
                             java.math.BigDecimal aP6 ,
                             java.math.BigDecimal aP7 ,
                             java.math.BigDecimal aP8 ,
                             java.math.BigDecimal aP9 ,
                             String aP10 ,
                             java.math.BigDecimal[] aP11 ,
                             String[] aP12 )
   {
      descuentosobreimponible.this.AV9CliCod = aP0;
      descuentosobreimponible.this.AV10EmpCod = aP1;
      descuentosobreimponible.this.AV11LiqPeriodo = aP2;
      descuentosobreimponible.this.AV12LegNumero = aP3;
      descuentosobreimponible.this.AV16contemplarAnticipoDeSac = aP4;
      descuentosobreimponible.this.AV17liquidaSacLiqDImpCalcu = aP5;
      descuentosobreimponible.this.AV18Importes = aP6;
      descuentosobreimponible.this.AV23parmBaseImpMaxLiqDImpCalcu = aP7;
      descuentosobreimponible.this.AV19anticipoDeSacLiqDImpCalcu = aP8;
      descuentosobreimponible.this.AV22descuentos = aP9;
      descuentosobreimponible.this.AV27alicuotasLiqDLog = aP10;
      descuentosobreimponible.this.aP11 = aP11;
      descuentosobreimponible.this.aP12 = aP12;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV13baseImpMaxLiqDImpCalcu = AV23parmBaseImpMaxLiqDImpCalcu ;
      AV24LiqDLog = httpContext.getMessage( "Base imponible es ", "") + GXutil.trim( GXutil.str( AV13baseImpMaxLiqDImpCalcu, 14, 2)) ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV30Pgmname, httpContext.getMessage( "&baseImpMaxLiqDImpCalcu ", "")+GXutil.trim( GXutil.str( AV13baseImpMaxLiqDImpCalcu, 14, 2))) ;
      if ( ( AV16contemplarAnticipoDeSac ) && ( AV17liquidaSacLiqDImpCalcu.doubleValue() == 0 ) && ( DecimalUtil.compareTo(AV13baseImpMaxLiqDImpCalcu, AV18Importes) < 0 ) )
      {
         AV25agregadoDeSacImportes = (AV13baseImpMaxLiqDImpCalcu.divide(DecimalUtil.doubleToDec(12), 18, java.math.RoundingMode.DOWN)) ;
         AV24LiqDLog += httpContext.getMessage( " más ", "") + GXutil.trim( GXutil.str( AV25agregadoDeSacImportes, 14, 2)) + httpContext.getMessage( " correspondientes a estimativo de SAC", "") ;
         AV13baseImpMaxLiqDImpCalcu = AV13baseImpMaxLiqDImpCalcu.add(AV25agregadoDeSacImportes) ;
         new web.msgdebug_prod(remoteHandle, context).execute( AV30Pgmname, httpContext.getMessage( "&baseImpMaxLiqDImpCalcu ", "")+GXutil.trim( GXutil.str( AV13baseImpMaxLiqDImpCalcu, 14, 2))) ;
      }
      if ( ! (GXutil.strcmp("", AV24LiqDLog)==0) )
      {
         AV24LiqDLog += ". " ;
      }
      if ( DecimalUtil.compareTo(AV13baseImpMaxLiqDImpCalcu, AV18Importes) < 0 )
      {
         AV20minimoLiqDImpCalcu = AV13baseImpMaxLiqDImpCalcu ;
         AV24LiqDLog += httpContext.getMessage( "Inicializa el cálculo de descuento con ", "") + GXutil.trim( GXutil.str( AV20minimoLiqDImpCalcu, 14, 2)) + httpContext.getMessage( " correspondiente a la base imponible, al ser esta menor al monto gravado ", "") + GXutil.trim( GXutil.str( AV18Importes, 14, 2)) ;
         new web.msgdebug_prod(remoteHandle, context).execute( AV30Pgmname, "2") ;
      }
      else
      {
         AV20minimoLiqDImpCalcu = AV18Importes ;
         AV24LiqDLog += httpContext.getMessage( "Inicializa el cálculo de descuento con ", "") + GXutil.trim( GXutil.str( AV20minimoLiqDImpCalcu, 14, 2)) + httpContext.getMessage( " correspondiente al monto gravado ", "") + GXutil.trim( GXutil.str( AV18Importes, 14, 2)) + httpContext.getMessage( " al ser mayor o igual a la base imponible ", "") + GXutil.trim( GXutil.str( AV13baseImpMaxLiqDImpCalcu, 14, 2)) ;
         new web.msgdebug_prod(remoteHandle, context).execute( AV30Pgmname, "3") ;
      }
      AV21descuentosSobreGravadoLiqDImpCalcu = AV20minimoLiqDImpCalcu ;
      AV21descuentosSobreGravadoLiqDImpCalcu = AV21descuentosSobreGravadoLiqDImpCalcu.multiply(AV22descuentos) ;
      if ( ! (GXutil.strcmp("", AV27alicuotasLiqDLog)==0) )
      {
         GXv_char1[0] = AV26tooltip ;
         new web.armatooltip(remoteHandle, context).execute( AV9CliCod, AV22descuentos, AV27alicuotasLiqDLog, false, GXv_char1) ;
         descuentosobreimponible.this.AV26tooltip = GXv_char1[0] ;
      }
      else
      {
         AV26tooltip = GXutil.trim( GXutil.str( AV22descuentos, 6, 4)) ;
      }
      AV24LiqDLog += httpContext.getMessage( ". Lo multiplica por ", "") + GXutil.trim( AV26tooltip) + httpContext.getMessage( ", valor que representa las alícuotas de descuentos de ley aplicadas", "") ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV30Pgmname, httpContext.getMessage( "&minimoLiqDImpCalcu ", "")+GXutil.trim( GXutil.str( AV20minimoLiqDImpCalcu, 14, 2))+httpContext.getMessage( " &descuentos ", "")+GXutil.trim( GXutil.str( AV22descuentos, 6, 4))+httpContext.getMessage( " &descuentosSobreGravadoLiqDImpCalcu ", "")+GXutil.trim( GXutil.str( AV21descuentosSobreGravadoLiqDImpCalcu, 14, 2))) ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP11[0] = descuentosobreimponible.this.AV21descuentosSobreGravadoLiqDImpCalcu;
      this.aP12[0] = descuentosobreimponible.this.AV24LiqDLog;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV21descuentosSobreGravadoLiqDImpCalcu = DecimalUtil.ZERO ;
      AV24LiqDLog = "" ;
      AV13baseImpMaxLiqDImpCalcu = DecimalUtil.ZERO ;
      AV30Pgmname = "" ;
      AV25agregadoDeSacImportes = DecimalUtil.ZERO ;
      AV20minimoLiqDImpCalcu = DecimalUtil.ZERO ;
      AV26tooltip = "" ;
      GXv_char1 = new String[1] ;
      AV30Pgmname = "DescuentoSobreImponible" ;
      /* GeneXus formulas. */
      AV30Pgmname = "DescuentoSobreImponible" ;
      Gx_err = (short)(0) ;
   }

   private short AV10EmpCod ;
   private short Gx_err ;
   private int AV9CliCod ;
   private int AV12LegNumero ;
   private java.math.BigDecimal AV17liquidaSacLiqDImpCalcu ;
   private java.math.BigDecimal AV18Importes ;
   private java.math.BigDecimal AV23parmBaseImpMaxLiqDImpCalcu ;
   private java.math.BigDecimal AV19anticipoDeSacLiqDImpCalcu ;
   private java.math.BigDecimal AV22descuentos ;
   private java.math.BigDecimal AV21descuentosSobreGravadoLiqDImpCalcu ;
   private java.math.BigDecimal AV13baseImpMaxLiqDImpCalcu ;
   private java.math.BigDecimal AV25agregadoDeSacImportes ;
   private java.math.BigDecimal AV20minimoLiqDImpCalcu ;
   private String AV30Pgmname ;
   private String GXv_char1[] ;
   private java.util.Date AV11LiqPeriodo ;
   private boolean AV16contemplarAnticipoDeSac ;
   private String AV27alicuotasLiqDLog ;
   private String AV24LiqDLog ;
   private String AV26tooltip ;
   private String[] aP12 ;
   private java.math.BigDecimal[] aP11 ;
}

