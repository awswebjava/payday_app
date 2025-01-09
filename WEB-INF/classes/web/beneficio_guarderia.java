package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class beneficio_guarderia extends GXProcedure
{
   public beneficio_guarderia( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( beneficio_guarderia.class ), "" );
   }

   public beneficio_guarderia( int remoteHandle ,
                               ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public byte executeUdp( int aP0 ,
                           short aP1 ,
                           int aP2 ,
                           int aP3 ,
                           java.util.Date aP4 ,
                           java.math.BigDecimal[] aP5 ,
                           String[] aP6 ,
                           String[] aP7 )
   {
      beneficio_guarderia.this.aP8 = new byte[] {0};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8);
      return aP8[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        int aP3 ,
                        java.util.Date aP4 ,
                        java.math.BigDecimal[] aP5 ,
                        String[] aP6 ,
                        String[] aP7 ,
                        byte[] aP8 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             int aP3 ,
                             java.util.Date aP4 ,
                             java.math.BigDecimal[] aP5 ,
                             String[] aP6 ,
                             String[] aP7 ,
                             byte[] aP8 )
   {
      beneficio_guarderia.this.AV16CliCod = aP0;
      beneficio_guarderia.this.AV15EmpCod = aP1;
      beneficio_guarderia.this.AV8LiqNro = aP2;
      beneficio_guarderia.this.AV14LegNumero = aP3;
      beneficio_guarderia.this.AV9LiqPeriodo = aP4;
      beneficio_guarderia.this.aP5 = aP5;
      beneficio_guarderia.this.aP6 = aP6;
      beneficio_guarderia.this.aP7 = aP7;
      beneficio_guarderia.this.aP8 = aP8;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV11LiqDCalculado = (byte)(1) ;
      AV10LiqDLog = httpContext.getMessage( "Tiene que hacer el cálculo de del pago en especies recorriendo los hijos que tienen guardería de empresa asignada, y teniendo en cuenta  También tener en cuenta EmpGuarEdadMin y EmpGuarEdadMax y agregar los campos en convenio y pais", "") ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP5[0] = beneficio_guarderia.this.AV13Importes;
      this.aP6[0] = beneficio_guarderia.this.AV12error;
      this.aP7[0] = beneficio_guarderia.this.AV10LiqDLog;
      this.aP8[0] = beneficio_guarderia.this.AV11LiqDCalculado;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV13Importes = DecimalUtil.ZERO ;
      AV12error = "" ;
      AV10LiqDLog = "" ;
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte AV11LiqDCalculado ;
   private short AV15EmpCod ;
   private short Gx_err ;
   private int AV16CliCod ;
   private int AV8LiqNro ;
   private int AV14LegNumero ;
   private java.math.BigDecimal AV13Importes ;
   private java.util.Date AV9LiqPeriodo ;
   private String AV10LiqDLog ;
   private String AV12error ;
   private byte[] aP8 ;
   private java.math.BigDecimal[] aP5 ;
   private String[] aP6 ;
   private String[] aP7 ;
}

