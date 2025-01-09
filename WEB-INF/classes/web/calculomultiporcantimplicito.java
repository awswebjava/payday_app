package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class calculomultiporcantimplicito extends GXProcedure
{
   public calculomultiporcantimplicito( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( calculomultiporcantimplicito.class ), "" );
   }

   public calculomultiporcantimplicito( int remoteHandle ,
                                        ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 ,
                             String aP1 ,
                             byte aP2 ,
                             java.math.BigDecimal aP3 ,
                             java.math.BigDecimal aP4 ,
                             java.math.BigDecimal[] aP5 ,
                             java.math.BigDecimal[] aP6 ,
                             boolean[] aP7 )
   {
      calculomultiporcantimplicito.this.aP8 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8);
      return aP8[0];
   }

   public void execute( int aP0 ,
                        String aP1 ,
                        byte aP2 ,
                        java.math.BigDecimal aP3 ,
                        java.math.BigDecimal aP4 ,
                        java.math.BigDecimal[] aP5 ,
                        java.math.BigDecimal[] aP6 ,
                        boolean[] aP7 ,
                        String[] aP8 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8);
   }

   private void execute_int( int aP0 ,
                             String aP1 ,
                             byte aP2 ,
                             java.math.BigDecimal aP3 ,
                             java.math.BigDecimal aP4 ,
                             java.math.BigDecimal[] aP5 ,
                             java.math.BigDecimal[] aP6 ,
                             boolean[] aP7 ,
                             String[] aP8 )
   {
      calculomultiporcantimplicito.this.AV14CliCod = aP0;
      calculomultiporcantimplicito.this.AV10ConFormula = aP1;
      calculomultiporcantimplicito.this.AV19ConVigencia = aP2;
      calculomultiporcantimplicito.this.AV13LiqDCanti = aP3;
      calculomultiporcantimplicito.this.AV11LiqDImporte = aP4;
      calculomultiporcantimplicito.this.AV15LiqDImpCalcu = aP5[0];
      this.aP5 = aP5;
      calculomultiporcantimplicito.this.AV16LiqDImpReCalcu = aP6[0];
      this.aP6 = aP6;
      calculomultiporcantimplicito.this.aP7 = aP7;
      calculomultiporcantimplicito.this.aP8 = aP8;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      returnInSub = true;
      cleanup();
      if (true) return;
      if ( AV19ConVigencia == 1 )
      {
         GXv_char1[0] = AV8novedadCantidadPalabra ;
         new web.codigoopeformula(remoteHandle, context).execute( AV14CliCod, "[novedad_cantidad]", false, false, GXv_char1) ;
         calculomultiporcantimplicito.this.AV8novedadCantidadPalabra = GXv_char1[0] ;
         AV9encuentraNovedadCantidad = (short)(GXutil.strSearch( GXutil.trim( GXutil.upper( AV10ConFormula)), GXutil.trim( GXutil.upper( AV8novedadCantidadPalabra)), 1)) ;
         if ( ( AV9encuentraNovedadCantidad == 0 ) && (DecimalUtil.compareTo(DecimalUtil.ZERO, AV11LiqDImporte)==0) && ( GXutil.strSearch( AV10ConFormula, "*", 1) != 0 ) )
         {
            AV15LiqDImpCalcu = AV15LiqDImpCalcu.multiply(AV13LiqDCanti) ;
            AV16LiqDImpReCalcu = AV16LiqDImpReCalcu.multiply(AV13LiqDCanti) ;
            AV17multiplico = true ;
            AV18LiqDLog = httpContext.getMessage( ". Se multiplica por ", "") + GXutil.trim( GXutil.str( AV13LiqDCanti, 14, 2)) ;
         }
      }
      new web.msgdebug_prod(remoteHandle, context).execute( AV22Pgmname, httpContext.getMessage( "&ConVigencia: ", "")+GXutil.trim( GXutil.str( AV19ConVigencia, 1, 0))) ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV22Pgmname, httpContext.getMessage( "&CliCod: ", "")+GXutil.trim( GXutil.str( AV14CliCod, 6, 0))) ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV22Pgmname, httpContext.getMessage( "&novedadCantidadPalabra: ", "")+GXutil.trim( AV8novedadCantidadPalabra)) ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV22Pgmname, httpContext.getMessage( "&ConFormula: ", "")+GXutil.trim( AV10ConFormula)) ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV22Pgmname, httpContext.getMessage( "&LiqDImporte: ", "")+GXutil.trim( GXutil.str( AV11LiqDImporte, 14, 2))) ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV22Pgmname, httpContext.getMessage( "&LiqDImpCalcu: ", "")+GXutil.trim( GXutil.str( AV15LiqDImpCalcu, 14, 2))) ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV22Pgmname, httpContext.getMessage( "&LiqDCanti: ", "")+GXutil.trim( GXutil.str( AV13LiqDCanti, 14, 2))) ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV22Pgmname, httpContext.getMessage( "&LiqDImpReCalcu: ", "")+GXutil.trim( GXutil.str( AV16LiqDImpReCalcu, 14, 2))) ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV22Pgmname, httpContext.getMessage( "&multiplico: ", "")+GXutil.trim( GXutil.booltostr( AV17multiplico))) ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV22Pgmname, httpContext.getMessage( "&LiqDLog: ", "")+GXutil.trim( AV18LiqDLog)) ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP5[0] = calculomultiporcantimplicito.this.AV15LiqDImpCalcu;
      this.aP6[0] = calculomultiporcantimplicito.this.AV16LiqDImpReCalcu;
      this.aP7[0] = calculomultiporcantimplicito.this.AV17multiplico;
      this.aP8[0] = calculomultiporcantimplicito.this.AV18LiqDLog;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV18LiqDLog = "" ;
      AV8novedadCantidadPalabra = "" ;
      GXv_char1 = new String[1] ;
      AV22Pgmname = "" ;
      AV22Pgmname = "CalculoMultiPorCantImplicito" ;
      /* GeneXus formulas. */
      AV22Pgmname = "CalculoMultiPorCantImplicito" ;
      Gx_err = (short)(0) ;
   }

   private byte AV19ConVigencia ;
   private short AV9encuentraNovedadCantidad ;
   private short Gx_err ;
   private int AV14CliCod ;
   private java.math.BigDecimal AV13LiqDCanti ;
   private java.math.BigDecimal AV11LiqDImporte ;
   private java.math.BigDecimal AV15LiqDImpCalcu ;
   private java.math.BigDecimal AV16LiqDImpReCalcu ;
   private String AV8novedadCantidadPalabra ;
   private String GXv_char1[] ;
   private String AV22Pgmname ;
   private boolean AV17multiplico ;
   private boolean returnInSub ;
   private String AV10ConFormula ;
   private String AV18LiqDLog ;
   private String[] aP8 ;
   private java.math.BigDecimal[] aP5 ;
   private java.math.BigDecimal[] aP6 ;
   private boolean[] aP7 ;
}

