package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class defaultcentrocostoporcentaje extends GXProcedure
{
   public defaultcentrocostoporcentaje( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( defaultcentrocostoporcentaje.class ), "" );
   }

   public defaultcentrocostoporcentaje( int remoteHandle ,
                                        ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public java.math.BigDecimal executeUdp( int aP0 ,
                                           short aP1 ,
                                           int aP2 )
   {
      defaultcentrocostoporcentaje.this.aP3 = new java.math.BigDecimal[] {DecimalUtil.ZERO};
      execute_int(aP0, aP1, aP2, aP3);
      return aP3[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        java.math.BigDecimal[] aP3 )
   {
      execute_int(aP0, aP1, aP2, aP3);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             java.math.BigDecimal[] aP3 )
   {
      defaultcentrocostoporcentaje.this.AV10clicod = aP0;
      defaultcentrocostoporcentaje.this.AV9empcod = aP1;
      defaultcentrocostoporcentaje.this.AV8legnumero = aP2;
      defaultcentrocostoporcentaje.this.aP3 = aP3;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXv_decimal1[0] = AV11LegCenPrc ;
      new web.legcentrostotleg(remoteHandle, context).execute( (short)(0), AV10clicod, AV9empcod, AV8legnumero, GXv_decimal1) ;
      defaultcentrocostoporcentaje.this.AV11LegCenPrc = GXv_decimal1[0] ;
      if ( AV11LegCenPrc.doubleValue() == 0 )
      {
         AV11LegCenPrc = DecimalUtil.doubleToDec(100) ;
      }
      else
      {
         if ( AV11LegCenPrc.doubleValue() < 100 )
         {
            AV11LegCenPrc = DecimalUtil.doubleToDec(100).subtract(AV11LegCenPrc) ;
         }
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP3[0] = defaultcentrocostoporcentaje.this.AV11LegCenPrc;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV11LegCenPrc = DecimalUtil.ZERO ;
      GXv_decimal1 = new java.math.BigDecimal[1] ;
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV9empcod ;
   private short Gx_err ;
   private int AV10clicod ;
   private int AV8legnumero ;
   private java.math.BigDecimal AV11LegCenPrc ;
   private java.math.BigDecimal GXv_decimal1[] ;
   private java.math.BigDecimal[] aP3 ;
}

