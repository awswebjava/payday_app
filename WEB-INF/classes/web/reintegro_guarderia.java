package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class reintegro_guarderia extends GXProcedure
{
   public reintegro_guarderia( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( reintegro_guarderia.class ), "" );
   }

   public reintegro_guarderia( int remoteHandle ,
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
      reintegro_guarderia.this.aP8 = new byte[] {0};
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
      reintegro_guarderia.this.AV16CliCod = aP0;
      reintegro_guarderia.this.AV15EmpCod = aP1;
      reintegro_guarderia.this.AV8LiqNro = aP2;
      reintegro_guarderia.this.AV14LegNumero = aP3;
      reintegro_guarderia.this.AV9LiqPeriodo = aP4;
      reintegro_guarderia.this.aP5 = aP5;
      reintegro_guarderia.this.aP6 = aP6;
      reintegro_guarderia.this.aP7 = aP7;
      reintegro_guarderia.this.aP8 = aP8;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV11LiqDCalculado = (byte)(1) ;
      AV10LiqDLog = httpContext.getMessage( "Tiene que hacer el cálculo de reintegro teniendo en cuenta el atributo ConveGuarderia en caso de tener valor en convenio y la empresa tener valor en EmpConveGuar. Si no, tiene que devolver, por comprobante (en caso de ingresar un comprobante por hijo), el mínimo comparando el importe de la factura y el tope que está en la variable constantes_default.TopeMinGuarderia. También tener en cuenta EmpGuarEdadMin y EmpGuarEdadMax y agregar los campos en convenio y pais", "") ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP5[0] = reintegro_guarderia.this.AV13Importes;
      this.aP6[0] = reintegro_guarderia.this.AV12error;
      this.aP7[0] = reintegro_guarderia.this.AV10LiqDLog;
      this.aP8[0] = reintegro_guarderia.this.AV11LiqDCalculado;
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

