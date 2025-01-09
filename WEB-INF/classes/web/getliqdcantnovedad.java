package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getliqdcantnovedad extends GXProcedure
{
   public getliqdcantnovedad( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getliqdcantnovedad.class ), "" );
   }

   public getliqdcantnovedad( int remoteHandle ,
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
      getliqdcantnovedad.this.aP7 = new byte[] {0};
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
      getliqdcantnovedad.this.AV13CliCod = aP0;
      getliqdcantnovedad.this.AV8EmpCod = aP1;
      getliqdcantnovedad.this.AV9LiqNro = aP2;
      getliqdcantnovedad.this.AV10LegNumero = aP3;
      getliqdcantnovedad.this.AV11ConCodigo = aP4;
      getliqdcantnovedad.this.aP5 = aP5;
      getliqdcantnovedad.this.aP6 = aP6;
      getliqdcantnovedad.this.aP7 = aP7;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P01PO2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV13CliCod), Short.valueOf(AV8EmpCod), Integer.valueOf(AV9LiqNro), Integer.valueOf(AV10LegNumero), AV11ConCodigo});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A1073LiqDNovedad = P01PO2_A1073LiqDNovedad[0] ;
         A394DConCodigo = P01PO2_A394DConCodigo[0] ;
         A6LegNumero = P01PO2_A6LegNumero[0] ;
         A31LiqNro = P01PO2_A31LiqNro[0] ;
         A1EmpCod = P01PO2_A1EmpCod[0] ;
         A3CliCod = P01PO2_A3CliCod[0] ;
         A269LiqDCanti = P01PO2_A269LiqDCanti[0] ;
         n269LiqDCanti = P01PO2_n269LiqDCanti[0] ;
         A507LiqDCalculado = P01PO2_A507LiqDCalculado[0] ;
         A81LiqDSecuencial = P01PO2_A81LiqDSecuencial[0] ;
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
      this.aP5[0] = getliqdcantnovedad.this.AV15LiqDCanti;
      this.aP6[0] = getliqdcantnovedad.this.AV14existe;
      this.aP7[0] = getliqdcantnovedad.this.AV16LiqDCalculado;
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
      P01PO2_A1073LiqDNovedad = new boolean[] {false} ;
      P01PO2_A394DConCodigo = new String[] {""} ;
      P01PO2_A6LegNumero = new int[1] ;
      P01PO2_A31LiqNro = new int[1] ;
      P01PO2_A1EmpCod = new short[1] ;
      P01PO2_A3CliCod = new int[1] ;
      P01PO2_A269LiqDCanti = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01PO2_n269LiqDCanti = new boolean[] {false} ;
      P01PO2_A507LiqDCalculado = new byte[1] ;
      P01PO2_A81LiqDSecuencial = new int[1] ;
      A394DConCodigo = "" ;
      A269LiqDCanti = DecimalUtil.ZERO ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getliqdcantnovedad__default(),
         new Object[] {
             new Object[] {
            P01PO2_A1073LiqDNovedad, P01PO2_A394DConCodigo, P01PO2_A6LegNumero, P01PO2_A31LiqNro, P01PO2_A1EmpCod, P01PO2_A3CliCod, P01PO2_A269LiqDCanti, P01PO2_n269LiqDCanti, P01PO2_A507LiqDCalculado, P01PO2_A81LiqDSecuencial
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
   private boolean A1073LiqDNovedad ;
   private boolean n269LiqDCanti ;
   private byte[] aP7 ;
   private java.math.BigDecimal[] aP5 ;
   private boolean[] aP6 ;
   private IDataStoreProvider pr_default ;
   private boolean[] P01PO2_A1073LiqDNovedad ;
   private String[] P01PO2_A394DConCodigo ;
   private int[] P01PO2_A6LegNumero ;
   private int[] P01PO2_A31LiqNro ;
   private short[] P01PO2_A1EmpCod ;
   private int[] P01PO2_A3CliCod ;
   private java.math.BigDecimal[] P01PO2_A269LiqDCanti ;
   private boolean[] P01PO2_n269LiqDCanti ;
   private byte[] P01PO2_A507LiqDCalculado ;
   private int[] P01PO2_A81LiqDSecuencial ;
}

final  class getliqdcantnovedad__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01PO2", "SELECT LiqDNovedad, DConCodigo, LegNumero, LiqNro, EmpCod, CliCod, LiqDCanti, LiqDCalculado, LiqDSecuencial FROM LiquidacionDetalle WHERE (CliCod = ? and EmpCod = ? and LiqNro = ? and LegNumero = ? and DConCodigo = ( ?)) AND (LiqDNovedad = TRUE) ORDER BY CliCod, EmpCod, LiqNro, LegNumero, DConCodigo ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((boolean[]) buf[0])[0] = rslt.getBoolean(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 10);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((short[]) buf[4])[0] = rslt.getShort(5);
               ((int[]) buf[5])[0] = rslt.getInt(6);
               ((java.math.BigDecimal[]) buf[6])[0] = rslt.getBigDecimal(7,2);
               ((boolean[]) buf[7])[0] = rslt.wasNull();
               ((byte[]) buf[8])[0] = rslt.getByte(8);
               ((int[]) buf[9])[0] = rslt.getInt(9);
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

