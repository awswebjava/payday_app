package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getliqdimpcalcuycanti extends GXProcedure
{
   public getliqdimpcalcuycanti( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getliqdimpcalcuycanti.class ), "" );
   }

   public getliqdimpcalcuycanti( int remoteHandle ,
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
                           String aP5 ,
                           java.math.BigDecimal[] aP6 ,
                           java.math.BigDecimal[] aP7 ,
                           boolean[] aP8 )
   {
      getliqdimpcalcuycanti.this.aP9 = new byte[] {0};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9);
      return aP9[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        int aP3 ,
                        String aP4 ,
                        String aP5 ,
                        java.math.BigDecimal[] aP6 ,
                        java.math.BigDecimal[] aP7 ,
                        boolean[] aP8 ,
                        byte[] aP9 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             int aP3 ,
                             String aP4 ,
                             String aP5 ,
                             java.math.BigDecimal[] aP6 ,
                             java.math.BigDecimal[] aP7 ,
                             boolean[] aP8 ,
                             byte[] aP9 )
   {
      getliqdimpcalcuycanti.this.AV13CliCod = aP0;
      getliqdimpcalcuycanti.this.AV8EmpCod = aP1;
      getliqdimpcalcuycanti.this.AV9LiqNro = aP2;
      getliqdimpcalcuycanti.this.AV10LegNumero = aP3;
      getliqdimpcalcuycanti.this.AV11ConCodigo = aP4;
      getliqdimpcalcuycanti.this.AV19ProcesoLiquidacion = aP5;
      getliqdimpcalcuycanti.this.aP6 = aP6;
      getliqdimpcalcuycanti.this.aP7 = aP7;
      getliqdimpcalcuycanti.this.aP8 = aP8;
      getliqdimpcalcuycanti.this.aP9 = aP9;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV15LiqDCalculado = (byte)(1) ;
      /* Using cursor P014P2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV13CliCod), Short.valueOf(AV8EmpCod), Integer.valueOf(AV9LiqNro), Integer.valueOf(AV10LegNumero), AV11ConCodigo});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A394DConCodigo = P014P2_A394DConCodigo[0] ;
         A6LegNumero = P014P2_A6LegNumero[0] ;
         A31LiqNro = P014P2_A31LiqNro[0] ;
         A1EmpCod = P014P2_A1EmpCod[0] ;
         A3CliCod = P014P2_A3CliCod[0] ;
         A764LiqDImpReCalcu = P014P2_A764LiqDImpReCalcu[0] ;
         A269LiqDCanti = P014P2_A269LiqDCanti[0] ;
         n269LiqDCanti = P014P2_n269LiqDCanti[0] ;
         A507LiqDCalculado = P014P2_A507LiqDCalculado[0] ;
         A763LiqDRecalculado = P014P2_A763LiqDRecalculado[0] ;
         A81LiqDSecuencial = P014P2_A81LiqDSecuencial[0] ;
         AV14existe = true ;
         AV12LiqDImpCalcu = A764LiqDImpReCalcu ;
         AV18LiqDCanti = A269LiqDCanti ;
         GXv_int1[0] = AV15LiqDCalculado ;
         new web.dependenciaresuelta2(remoteHandle, context).execute( AV13CliCod, A394DConCodigo, AV19ProcesoLiquidacion, A507LiqDCalculado, A763LiqDRecalculado, GXv_int1) ;
         getliqdimpcalcuycanti.this.AV15LiqDCalculado = GXv_int1[0] ;
         new web.msgdebug_prod(remoteHandle, context).execute( AV23Pgmname, httpContext.getMessage( "encuentra ... &LiqDCalculado ", "")+GXutil.trim( GXutil.str( AV15LiqDCalculado, 1, 0))+httpContext.getMessage( " LiqDCalculado ", "")+GXutil.trim( GXutil.str( A507LiqDCalculado, 1, 0))+httpContext.getMessage( " &ProcesoLiquidacion ", "")+GXutil.trim( AV19ProcesoLiquidacion)+httpContext.getMessage( " LiqDImpReCalcu ", "")+GXutil.trim( GXutil.str( A764LiqDImpReCalcu, 14, 2))) ;
         /* Exit For each command. Update data (if necessary), close cursors & exit. */
         if (true) break;
         pr_default.readNext(0);
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP6[0] = getliqdimpcalcuycanti.this.AV12LiqDImpCalcu;
      this.aP7[0] = getliqdimpcalcuycanti.this.AV18LiqDCanti;
      this.aP8[0] = getliqdimpcalcuycanti.this.AV14existe;
      this.aP9[0] = getliqdimpcalcuycanti.this.AV15LiqDCalculado;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV12LiqDImpCalcu = DecimalUtil.ZERO ;
      AV18LiqDCanti = DecimalUtil.ZERO ;
      scmdbuf = "" ;
      P014P2_A394DConCodigo = new String[] {""} ;
      P014P2_A6LegNumero = new int[1] ;
      P014P2_A31LiqNro = new int[1] ;
      P014P2_A1EmpCod = new short[1] ;
      P014P2_A3CliCod = new int[1] ;
      P014P2_A764LiqDImpReCalcu = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P014P2_A269LiqDCanti = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P014P2_n269LiqDCanti = new boolean[] {false} ;
      P014P2_A507LiqDCalculado = new byte[1] ;
      P014P2_A763LiqDRecalculado = new short[1] ;
      P014P2_A81LiqDSecuencial = new int[1] ;
      A394DConCodigo = "" ;
      A764LiqDImpReCalcu = DecimalUtil.ZERO ;
      A269LiqDCanti = DecimalUtil.ZERO ;
      GXv_int1 = new byte[1] ;
      AV23Pgmname = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getliqdimpcalcuycanti__default(),
         new Object[] {
             new Object[] {
            P014P2_A394DConCodigo, P014P2_A6LegNumero, P014P2_A31LiqNro, P014P2_A1EmpCod, P014P2_A3CliCod, P014P2_A764LiqDImpReCalcu, P014P2_A269LiqDCanti, P014P2_n269LiqDCanti, P014P2_A507LiqDCalculado, P014P2_A763LiqDRecalculado,
            P014P2_A81LiqDSecuencial
            }
         }
      );
      AV23Pgmname = "getLiqDImpCalcuYCanti" ;
      /* GeneXus formulas. */
      AV23Pgmname = "getLiqDImpCalcuYCanti" ;
      Gx_err = (short)(0) ;
   }

   private byte AV15LiqDCalculado ;
   private byte A507LiqDCalculado ;
   private byte GXv_int1[] ;
   private short AV8EmpCod ;
   private short A1EmpCod ;
   private short A763LiqDRecalculado ;
   private short Gx_err ;
   private int AV13CliCod ;
   private int AV9LiqNro ;
   private int AV10LegNumero ;
   private int A6LegNumero ;
   private int A31LiqNro ;
   private int A3CliCod ;
   private int A81LiqDSecuencial ;
   private java.math.BigDecimal AV12LiqDImpCalcu ;
   private java.math.BigDecimal AV18LiqDCanti ;
   private java.math.BigDecimal A764LiqDImpReCalcu ;
   private java.math.BigDecimal A269LiqDCanti ;
   private String AV11ConCodigo ;
   private String AV19ProcesoLiquidacion ;
   private String scmdbuf ;
   private String A394DConCodigo ;
   private String AV23Pgmname ;
   private boolean AV14existe ;
   private boolean n269LiqDCanti ;
   private byte[] aP9 ;
   private java.math.BigDecimal[] aP6 ;
   private java.math.BigDecimal[] aP7 ;
   private boolean[] aP8 ;
   private IDataStoreProvider pr_default ;
   private String[] P014P2_A394DConCodigo ;
   private int[] P014P2_A6LegNumero ;
   private int[] P014P2_A31LiqNro ;
   private short[] P014P2_A1EmpCod ;
   private int[] P014P2_A3CliCod ;
   private java.math.BigDecimal[] P014P2_A764LiqDImpReCalcu ;
   private java.math.BigDecimal[] P014P2_A269LiqDCanti ;
   private boolean[] P014P2_n269LiqDCanti ;
   private byte[] P014P2_A507LiqDCalculado ;
   private short[] P014P2_A763LiqDRecalculado ;
   private int[] P014P2_A81LiqDSecuencial ;
}

final  class getliqdimpcalcuycanti__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P014P2", "SELECT DConCodigo, LegNumero, LiqNro, EmpCod, CliCod, LiqDImpReCalcu, LiqDCanti, LiqDCalculado, LiqDRecalculado, LiqDSecuencial FROM LiquidacionDetalle WHERE CliCod = ? and EmpCod = ? and LiqNro = ? and LegNumero = ? and DConCodigo = ( ?) ORDER BY CliCod, EmpCod, LiqNro, LegNumero, DConCodigo  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((java.math.BigDecimal[]) buf[6])[0] = rslt.getBigDecimal(7,2);
               ((boolean[]) buf[7])[0] = rslt.wasNull();
               ((byte[]) buf[8])[0] = rslt.getByte(8);
               ((short[]) buf[9])[0] = rslt.getShort(9);
               ((int[]) buf[10])[0] = rslt.getInt(10);
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

