package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getliqdcantidad extends GXProcedure
{
   public getliqdcantidad( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getliqdcantidad.class ), "" );
   }

   public getliqdcantidad( int remoteHandle ,
                           ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public byte executeUdp( int aP0 ,
                           short aP1 ,
                           int aP2 ,
                           int aP3 ,
                           String aP4 ,
                           java.math.BigDecimal[] aP5 ,
                           boolean[] aP6 )
   {
      getliqdcantidad.this.aP7 = new byte[] {0};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7);
      return aP7[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        int aP3 ,
                        String aP4 ,
                        java.math.BigDecimal[] aP5 ,
                        boolean[] aP6 ,
                        byte[] aP7 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             int aP3 ,
                             String aP4 ,
                             java.math.BigDecimal[] aP5 ,
                             boolean[] aP6 ,
                             byte[] aP7 )
   {
      getliqdcantidad.this.AV13CliCod = aP0;
      getliqdcantidad.this.AV8EmpCod = aP1;
      getliqdcantidad.this.AV9LiqNro = aP2;
      getliqdcantidad.this.AV10LegNumero = aP3;
      getliqdcantidad.this.AV11ConCodigo = aP4;
      getliqdcantidad.this.aP5 = aP5;
      getliqdcantidad.this.aP6 = aP6;
      getliqdcantidad.this.aP7 = aP7;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P00CM2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV13CliCod), Short.valueOf(AV8EmpCod), Integer.valueOf(AV9LiqNro), Integer.valueOf(AV10LegNumero), AV11ConCodigo});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A394DConCodigo = P00CM2_A394DConCodigo[0] ;
         A6LegNumero = P00CM2_A6LegNumero[0] ;
         A31LiqNro = P00CM2_A31LiqNro[0] ;
         A1EmpCod = P00CM2_A1EmpCod[0] ;
         A3CliCod = P00CM2_A3CliCod[0] ;
         A269LiqDCanti = P00CM2_A269LiqDCanti[0] ;
         n269LiqDCanti = P00CM2_n269LiqDCanti[0] ;
         A507LiqDCalculado = P00CM2_A507LiqDCalculado[0] ;
         A81LiqDSecuencial = P00CM2_A81LiqDSecuencial[0] ;
         AV15LiqDCanti = A269LiqDCanti ;
         AV14existe = true ;
         AV16LiqDCalculado = A507LiqDCalculado ;
         pr_default.readNext(0);
      }
      pr_default.close(0);
      new web.dependenciasesion(remoteHandle, context).execute( AV11ConCodigo) ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP5[0] = getliqdcantidad.this.AV15LiqDCanti;
      this.aP6[0] = getliqdcantidad.this.AV14existe;
      this.aP7[0] = getliqdcantidad.this.AV16LiqDCalculado;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV15LiqDCanti = DecimalUtil.ZERO ;
      scmdbuf = "" ;
      P00CM2_A394DConCodigo = new String[] {""} ;
      P00CM2_A6LegNumero = new int[1] ;
      P00CM2_A31LiqNro = new int[1] ;
      P00CM2_A1EmpCod = new short[1] ;
      P00CM2_A3CliCod = new int[1] ;
      P00CM2_A269LiqDCanti = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P00CM2_n269LiqDCanti = new boolean[] {false} ;
      P00CM2_A507LiqDCalculado = new byte[1] ;
      P00CM2_A81LiqDSecuencial = new int[1] ;
      A394DConCodigo = "" ;
      A269LiqDCanti = DecimalUtil.ZERO ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getliqdcantidad__default(),
         new Object[] {
             new Object[] {
            P00CM2_A394DConCodigo, P00CM2_A6LegNumero, P00CM2_A31LiqNro, P00CM2_A1EmpCod, P00CM2_A3CliCod, P00CM2_A269LiqDCanti, P00CM2_n269LiqDCanti, P00CM2_A507LiqDCalculado, P00CM2_A81LiqDSecuencial
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte AV16LiqDCalculado ;
   private byte A507LiqDCalculado ;
   private short AV8EmpCod ;
   private short A1EmpCod ;
   private short Gx_err ;
   private int AV13CliCod ;
   private int AV9LiqNro ;
   private int AV10LegNumero ;
   private int A6LegNumero ;
   private int A31LiqNro ;
   private int A3CliCod ;
   private int A81LiqDSecuencial ;
   private java.math.BigDecimal AV15LiqDCanti ;
   private java.math.BigDecimal A269LiqDCanti ;
   private String AV11ConCodigo ;
   private String scmdbuf ;
   private String A394DConCodigo ;
   private boolean AV14existe ;
   private boolean n269LiqDCanti ;
   private byte[] aP7 ;
   private java.math.BigDecimal[] aP5 ;
   private boolean[] aP6 ;
   private IDataStoreProvider pr_default ;
   private String[] P00CM2_A394DConCodigo ;
   private int[] P00CM2_A6LegNumero ;
   private int[] P00CM2_A31LiqNro ;
   private short[] P00CM2_A1EmpCod ;
   private int[] P00CM2_A3CliCod ;
   private java.math.BigDecimal[] P00CM2_A269LiqDCanti ;
   private boolean[] P00CM2_n269LiqDCanti ;
   private byte[] P00CM2_A507LiqDCalculado ;
   private int[] P00CM2_A81LiqDSecuencial ;
}

final  class getliqdcantidad__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00CM2", "SELECT DConCodigo, LegNumero, LiqNro, EmpCod, CliCod, LiqDCanti, LiqDCalculado, LiqDSecuencial FROM LiquidacionDetalle WHERE CliCod = ? and EmpCod = ? and LiqNro = ? and LegNumero = ? and DConCodigo = ( ?) ORDER BY CliCod, EmpCod, LiqNro, LegNumero, DConCodigo ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getString(1, 10);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((int[]) buf[4])[0] = rslt.getInt(5);
               ((java.math.BigDecimal[]) buf[5])[0] = rslt.getBigDecimal(6,2);
               ((boolean[]) buf[6])[0] = rslt.wasNull();
               ((byte[]) buf[7])[0] = rslt.getByte(7);
               ((int[]) buf[8])[0] = rslt.getInt(8);
               return;
      }
   }

   public void setParameters( int cursor ,
                              IFieldSetter stmt ,
                              Object[] parms ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               stmt.setString(5, (String)parms[4], 10);
               return;
      }
   }

}

