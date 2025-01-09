package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class planoadecimales extends GXProcedure
{
   public planoadecimales( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( planoadecimales.class ), "" );
   }

   public planoadecimales( int remoteHandle ,
                           ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public java.math.BigDecimal executeUdp( String aP0 )
   {
      planoadecimales.this.aP1 = new java.math.BigDecimal[] {DecimalUtil.ZERO};
      execute_int(aP0, aP1);
      return aP1[0];
   }

   public void execute( String aP0 ,
                        java.math.BigDecimal[] aP1 )
   {
      execute_int(aP0, aP1);
   }

   private void execute_int( String aP0 ,
                             java.math.BigDecimal[] aP1 )
   {
      planoadecimales.this.AV9numeroStr = aP0;
      planoadecimales.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV12desde = (short)(GXutil.len( GXutil.trim( AV9numeroStr))-1) ;
      AV10decimales = CommonUtil.decimalVal( GXutil.substring( AV9numeroStr, AV12desde, 2), ".") ;
      AV10decimales = AV10decimales.divide(DecimalUtil.doubleToDec(100), 18, java.math.RoundingMode.DOWN) ;
      AV14cuantos = (short)(GXutil.len( GXutil.trim( AV9numeroStr))-2) ;
      AV11entero = GXutil.lval( GXutil.substring( AV9numeroStr, 1, AV14cuantos)) ;
      AV8numero = DecimalUtil.doubleToDec(AV11entero).add(AV10decimales) ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP1[0] = planoadecimales.this.AV8numero;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV8numero = DecimalUtil.ZERO ;
      AV10decimales = DecimalUtil.ZERO ;
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV12desde ;
   private short AV14cuantos ;
   private short Gx_err ;
   private long AV11entero ;
   private java.math.BigDecimal AV8numero ;
   private java.math.BigDecimal AV10decimales ;
   private String AV9numeroStr ;
   private java.math.BigDecimal[] aP1 ;
}

