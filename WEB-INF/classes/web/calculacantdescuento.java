package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class calculacantdescuento extends GXProcedure
{
   public calculacantdescuento( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( calculacantdescuento.class ), "" );
   }

   public calculacantdescuento( int remoteHandle ,
                                ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public short executeUdp( java.math.BigDecimal aP0 ,
                            java.math.BigDecimal aP1 )
   {
      calculacantdescuento.this.aP2 = new short[] {0};
      execute_int(aP0, aP1, aP2);
      return aP2[0];
   }

   public void execute( java.math.BigDecimal aP0 ,
                        java.math.BigDecimal aP1 ,
                        short[] aP2 )
   {
      execute_int(aP0, aP1, aP2);
   }

   private void execute_int( java.math.BigDecimal aP0 ,
                             java.math.BigDecimal aP1 ,
                             short[] aP2 )
   {
      calculacantdescuento.this.AV8LiqDImpCalcu = aP0;
      calculacantdescuento.this.AV10sueldoImportes = aP1;
      calculacantdescuento.this.aP2 = aP2;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      new web.msgdebug_prod(remoteHandle, context).execute( AV14Pgmname, httpContext.getMessage( "&LiqDImpCalcu ", "")+GXutil.trim( GXutil.str( AV8LiqDImpCalcu, 14, 2))+httpContext.getMessage( " sueldo ", "")+GXutil.trim( GXutil.str( AV10sueldoImportes, 14, 2))) ;
      if ( AV8LiqDImpCalcu.doubleValue() < 0 )
      {
         AV8LiqDImpCalcu = AV8LiqDImpCalcu.multiply(DecimalUtil.doubleToDec(-1)) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV10sueldoImportes)==0) )
      {
         AV9porUnaje = AV8LiqDImpCalcu.divide(AV10sueldoImportes, 18, java.math.RoundingMode.DOWN) ;
         new web.msgdebug_prod(remoteHandle, context).execute( AV14Pgmname, httpContext.getMessage( "&porUnaje ", "")+GXutil.trim( GXutil.str( AV9porUnaje, 6, 4))) ;
         AV11cantidad = (short)(DecimalUtil.decToDouble(GXutil.roundDecimal( AV9porUnaje.multiply(DecimalUtil.doubleToDec(30)), 0))) ;
         new web.msgdebug_prod(remoteHandle, context).execute( AV14Pgmname, httpContext.getMessage( "&cantidad ", "")+GXutil.trim( GXutil.str( AV11cantidad, 4, 0))) ;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP2[0] = calculacantdescuento.this.AV11cantidad;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV14Pgmname = "" ;
      AV9porUnaje = DecimalUtil.ZERO ;
      AV14Pgmname = "calculaCantDescuento" ;
      /* GeneXus formulas. */
      AV14Pgmname = "calculaCantDescuento" ;
      Gx_err = (short)(0) ;
   }

   private short AV11cantidad ;
   private short Gx_err ;
   private java.math.BigDecimal AV8LiqDImpCalcu ;
   private java.math.BigDecimal AV10sueldoImportes ;
   private java.math.BigDecimal AV9porUnaje ;
   private String AV14Pgmname ;
   private short[] aP2 ;
}

